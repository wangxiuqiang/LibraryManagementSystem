package com.student;
/*
 * 借阅图书    更改flag值  借出就改掉(删除的时候用,归还的够全部的数量在改回来)
 * 借书还要扣除相应的租金
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.main.Maining;

public class BorrowBook {
      private   int n=1;    
      public void borrowBook() throws Exception{
    	  float money = 0;
    	  Maining maining=new Maining();
    	  FindBook fBook=new FindBook();
    	  while(n==1){
    	  System.out.println("请输入要借阅的图书编号:");
    	  Scanner input=new Scanner(System.in);
    	  int Bookid=input.nextInt();
    	  System.out.println("请输入借阅的时间:");
    	  int day=input.nextInt();
    	  Class.forName(fBook.driver);
    	  /**
    	   * sql   查找出来书籍的库存 日租金 满书状态
    	   * 其中   booCount--  日租金用来扣除学生卡里的钱   修改flag控制是不是可以删除
    	   */
          Connection connection=DriverManager.getConnection(fBook.url, fBook.user, fBook.password);
    	  Statement statement=connection.createStatement();
    	  Statement statement2=connection.createStatement();
    	  String sqlSelectBook="SELECT bookCount,dayMoney,flag FROM book where id="+Bookid;
    	  ResultSet rSet=statement.executeQuery(sqlSelectBook);
    	  int bookCount=-1;
    	  int flag=1;
    	  float dayMoney=0;
    	  while(rSet.next()){
    		  bookCount=rSet.getInt(1);
    		  dayMoney=rSet.getFloat(2);
    		  flag=rSet.getInt(3);
    	  }
          
    	//  System.out.println(flag);   //测试使用
    	  /**
    	   * 判断库存是不是有书
    	   */
    	  if(bookCount==0){
    		  System.out.println("该书籍已经被借阅光了,请重新输入:");
    		  continue;
    	  }
    	  else {
    		//   System.out.println(maining.id);
    		  /**
    		   * 如果有
        	   * 首先判断钱够不够  不够就冲
        	   */
    		  String sqlStuMoney="SELECT money FROM student where id="+maining.id;
        	  rSet= statement2.executeQuery(sqlStuMoney);
              while(rSet.next()){
            	  money=rSet.getFloat(1);
              }  
             // System.out.println(money);
              if(money<(dayMoney*day)){
            	  System.out.println("卡中余额不足，继续借阅请输入1充值，否则输入0 返回上一页");
            	  int linshi=input.nextInt();
            	  if(linshi==1){
            			  MoneyIn moneyIn=new MoneyIn();
            	          moneyIn.moneyIn();
            	  }
            	  else
            	  {
            		  maining.goon();
            	  }
              }
              
    		  // 学生的id也要添加过来然后把他们的bookCount数加1  学生帐号里 的钱扣除   并且学生借的书也放入数据库
    		  /*
    		   * sql2 表示更改书库的存量    修改flag  表示该书  尚有书未还
    		   * sqljoin表示 把学生借的书   按照学生的id 存放在studentborrow表中
    		   * sqlqu 表示把书籍的一部分字段   取出  以便放到 student borrow表中
    		   * sql1 修改学生的借书的数量
    		   */
              System.out.println("需要借阅的图书为:");
        	  fBook.findBook(Bookid);
              String sqlQueryStuId="SELECT bookCount FROM student where id="+maining.id;//学生的bookCount 也需要修改
              String sqlBookCount="update  book set bookCount="+(bookCount-1)+",flag="+3+" where id="+Bookid;
             
              ResultSet resultSet=statement.executeQuery(sqlQueryStuId);
              int bookCountStu=0;
              while(resultSet.next()){
            	 bookCountStu=resultSet.getInt(1);
              }
              int a=bookCountStu;
              String sqlstudentBookCount="update student set bookCount="+(bookCountStu+1)+" where id="+maining.id;
              statement2.execute(sqlBookCount);
              statement2.execute(sqlstudentBookCount);
              String sqljoin="insert studentborrow(bookid,id,name,type,publishingHouse,author) values(?,?,?,?,?,?)";
              String sqlqu="select id,name,type,publishingHouse,author from book where id="+Bookid;
              int bookid = 0;
              String name="",type="",publishingHouse="",author="";
              ResultSet rSet2=statement2.executeQuery(sqlqu);
             while(rSet2.next()){
            	 bookid=rSet2.getInt(1);
            	 name=rSet2.getString(2);
            	 type=rSet2.getString(3);
            	 publishingHouse=rSet2.getString(4);
            	 author=rSet2.getString(5);
             }
            
			  
            //  System.out.println(money);测试使用
          /** 
           * sqlmoney 用来更改学生的金额  借了书要减去租金    =   天数 * 日租金
           */
             rSet= statement2.executeQuery(sqlStuMoney);
             while(rSet.next()){
           	  money=rSet.getFloat(1);
             }  
             String sqlMoney="UPDATE student SET money="+(money-dayMoney*day)+"WHERE id="+maining.id;
             statement2.execute(sqlMoney);
             PreparedStatement statement3=connection.prepareStatement(sqljoin);
             statement3.setInt(1, bookid);
             statement3.setInt(2, maining.id);//
             statement3.setString(3,name);
             statement3.setString(4, type);
             statement3.setString(5, publishingHouse);
             statement3.setString(6, author);
             statement3.executeUpdate();
              statement2.close();
              statement.close();
              statement3.close();
              rSet.close();
              rSet2.close();
              connection.close();
    		  System.out.println("借阅成功,需要借阅其他图书请输入1;不再借阅按任意键退出");
    	      n=input.nextInt();
    	    }
            if(n!=1){
            	break;
            }
    	  }
      }
}
