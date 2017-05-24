package com.student;

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
    	  System.out.println("需要借阅的图书为:");
    	  fBook.findBook(id);
    	  Class.forName(fBook.driver);
          Connection connection=DriverManager.getConnection(fBook.url, fBook.user, fBook.password);
    	  Statement statement=connection.createStatement();
    	  String sql ="SELECT bookCount FROM book where id="+id;
   // 	  String sql1="SELECT bookCount FROM student where id="+;//学生的bookCount 也需要修改
    	  ResultSet rSet=statement.executeQuery(sql);
    	 
    	  int bookCount=-1;
    	  while(rSet.next()){
    		  bookCount=rSet.getInt(1);
    	  }
    	  if(bookCount==0){
    		  System.out.println("该书籍已经被借阅光了,请重新输入:");
    		  continue;
    	  }
    	  else {
    		  String sql2="update  book set bookCount="+(bookCount-1)+" where id="+id;
              Statement statement2=connection.createStatement();
              statement2.execute(sql2);
              statement2.close();
    		  //    		  PreparedStatement preparedStatement=connection.prepareStatement(sql2);
//    		  preparedStatement.setInt(1, bookCount-1);
//    		  preparedStatement.executeUpdate();
//    		  preparedStatement.close();
    		  System.out.println("借阅成功,需要借阅其他图书请输入1;不再借阅按任意键退出");
    	      n=input.nextInt();
    	    }
          
    	  }
      }
}
