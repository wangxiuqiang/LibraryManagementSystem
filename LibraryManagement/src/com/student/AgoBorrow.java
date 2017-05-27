package com.student;

import java.sql.*;

import com.main.JdbcDriver;
import com.mysql.jdbc.Connection;

public class AgoBorrow {
       JdbcDriver jd=new JdbcDriver();
       /**
        * 查询已经借阅的书籍
     * @throws ClassNotFoundException 
        */
       public void ago(String nameD) throws Exception{
    	  Class.forName(jd.driver);
    	  Connection connection=(Connection) DriverManager.getConnection(jd.url, jd.user,jd.password);
    	  String sql="Select id from student where name='"+nameD+"'";
    	  Statement statement=connection.createStatement();
    	  ResultSet rSet=statement.executeQuery(sql);
    	  int id =0;
    	  while(rSet.next()){
    		  id=rSet.getInt(1);
    	  }
    	  String sql1="SELECT * from studentborrow where id="+id;
    	  ResultSet rSet2=statement.executeQuery(sql1);
    	  System.out.println("书籍编号\t书籍名称\t书籍种类\t出版社\t作者");
    	  while(rSet2.next()){
    		 int Id=rSet2.getInt(1);
    		 String name=rSet2.getString(2);
    		 String type=rSet2.getString(3);
    		 String publishingHourse=rSet2.getString(4);
    		 String author=rSet2.getString(5);
             System.out.println(Id+"\t"+name+"\t"+type+"\t"+publishingHourse+"\t"+author);
    	  }
    	  statement.close();
    	  connection.close();
       }
}
