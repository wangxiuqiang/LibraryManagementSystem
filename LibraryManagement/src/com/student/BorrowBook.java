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

public class BorrowBook {
    private   int n=1;    
      public void borrowBook() throws Exception{
    	  FindBook fBook=new FindBook();
    	  while(n==1){
    	  System.out.println("请输入要借阅的图书编号:");
    	  Scanner input=new Scanner(System.in);
    	  int id=input.nextInt();
    	  System.out.println("请输入借阅的时间:");
    	  int day=input.nextInt();
    	  System.out.println("需要借阅的图书为:");
    	  fBook.findBook(id);
    	  Class.forName(fBook.driver);
          Connection connection=DriverManager.getConnection(fBook.url, fBook.user, fBook.password);
    	  Statement statement=connection.createStatement();
    	  String sql ="SELECT bookCount,dayMoney,flag FROM book where id="+id;
   // 	  String sql1="SELECT bookCount FROM student where id="+;//学生的bookCount 也需要修改
    	  ResultSet rSet=statement.executeQuery(sql);
    	 
    	  int bookCount=-1;
    	  int flag=1;
    	  float dayMoney=0;
    	  while(rSet.next()){
    		  bookCount=rSet.getInt(1);
    		  dayMoney=rSet.getFloat(2);
    		  flag=rSet.getInt(3);
    	  }
    	//  System.out.println(flag);
    	  if(bookCount==0){
    		  System.out.println("该书籍已经被借阅光了,请重新输入:");
    		  continue;
    	  }
    	  else {
    		 float money = 0;
    		  // 学生的id也要添加过来然后把他们的bookCount数加1  学生帐号里 的钱扣除
    		  String sql2="update  book set bookCount="+(bookCount-1)+",flag="+3+" where id="+id;
              Statement statement2=connection.createStatement();
              statement2.execute(sql2);
              String sqlStuMoney="SELECT money FROM student";
              rSet= statement2.executeQuery(sqlStuMoney);
              while(rSet.next()){
            	  money=rSet.getFloat(1);
              }
            //  System.out.println(money);
            String sqlMoney="UPDATE student SET money="+(money-dayMoney*day)+"WHERE id="+1;
               statement2.execute(sqlMoney);
              statement2.close();
    		  System.out.println("借阅成功,需要借阅其他图书请输入1;不再借阅按任意键退出");
    	      n=input.nextInt();
    	    }
          
    	  }
      }
}
