package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.book.*;
import com.main.JdbcDriver;

public class adminUse {
	Scanner input=new Scanner(System.in);
	adminMain ad=new adminMain();
	/**
	 * 0.登录
     * 1.增
     * 2.删
     * 3.改
     * 4.查
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
  * @throws Exception 
     */
	  public void Join() throws Exception{
		  JdbcDriver jd=new JdbcDriver();
		  System.out.println("请输入管理员姓名：");
		  String name=input.next();
		  System.out.println("请输入管理员密码：");
		  String passwd=input.next();
		  Class.forName(jd.driver);
		  Connection connection=DriverManager.getConnection(jd.url, jd.user, jd.password);
	      String sql="select name,passwd from admin where id=1";
	      Statement statement=connection.createStatement();
	      ResultSet rSet=statement.executeQuery(sql);
	      String name1="";
	      String passwd1="";
	      while(rSet.next()){
	    	  name1=rSet.getString(1);
	    	  passwd1=rSet.getString(2);
	      }
	      if(name.equals(name1)&&passwd.equals(passwd1)){
	    	  System.out.println("登录成功");
	    	  adminMain adminMain=new adminMain();
	    	  adminMain.go();
	      }
	      else{
	    	  System.out.println("用户名和密码不匹配，请重新输入：");
	    	  Join();
	      }
	  }
       public void add() throws Exception{
 	       System.out.println("请输入书籍编号：");
    	   int id=input.nextInt();
    	   System.out.println("请输入书籍名称：");
    	   String name=input.next();
    	   System.out.println("请输入书籍种类：");
    	   String type=input.next();
    	   System.out.println("请输入书籍单价");
    	   float price =input.nextFloat();
    	   System.out.println("请输入出版社：");
    	   String publishingHouse=input.next();
    	   System.out.println("请输入书籍作者：");
    	   String author=input.next();
    	   System.out.println("请输入库存数量：" );
    	   int bookCount=input.nextInt();
    	   System.out.println("请输入日租金：");
    	   float dayMoney=input.nextFloat();
 	       bookMysql bm=new bookMysql();
 	       Book book =new Book(id,name,type,price,publishingHouse,author,bookCount,dayMoney);
 	       bm.BookIn(book);
       }
       
       public void DeleteBook() throws Exception{
    	   DeleteBook db=new DeleteBook();
    	    System.out.println("请输入要删除的书籍编号：");
         	int id=input.nextInt();
         	int n=db.setid(id);
    	    if(n==-1){
    	    	db.delete(id);
    	    	System.out.println("删除成功，正在返回");
    	    	ad.go();
    	    }
    	    else{
    	    	System.out.println("该书籍尚未归还完全或不存在，输入0返回主页面，输入1继续执行删除操作:");
    	    	int linshi=input.nextInt();
    	    	if(linshi==1){
    	    		DeleteBook();
    	    	}
    	    	if(linshi==0){
    	    		ad.go();
    	    	}
    	    }	
       }
       public void Check() throws Exception{
    	   AllSee allSee=new AllSee();
			 allSee.allSee();
			 System.out.println("输入1返回上一页：");
			 int linshi=input.nextInt();
			 if(linshi==1){
				 ad.go();
			 }
       }
}
