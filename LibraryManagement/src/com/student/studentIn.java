package com.student;

import java.sql.*;
<<<<<<< HEAD
import java.util.Scanner;

import com.main.*;
=======
>>>>>>> 4a9fef8ca8d69f45a67197aa4ffd99e8b450c359
/**
 * 学生注册 
 * @author dell
 *
 */
public class studentIn{
	/*
	 * 1.连接驱动
	 * 2.创建连接
	 * 3.sql语句 创建state 
	 * 添加      
	 */
<<<<<<< HEAD
	 	public void studentIn(student stu) throws Exception{
	 		JdbcDriver jd=new JdbcDriver();
    	    Class.forName(jd.driver);
    	    Connection studentTable=DriverManager.getConnection(jd.url, jd.user,jd.password);
    	    String sql="insert into student(id,passwd,name,money) values(?,?,?,?)";
    	    PreparedStatement ps=studentTable.prepareStatement(sql);
    	    ps.setInt(1, stu.id);
    	    ps.setString(2, stu.passwd);
    	    ps.setString(3, stu.name);
    	    ps.setFloat(4, stu.money);
    	    ps.executeUpdate();
    	    System.out.println("注册成功！");
=======
	public String driver="com.mysql.jdbc.Driver";
      public String url="jdbc:mysql://localhost:3306/Library";  
      public String user="root";
      public String password="root";
      
	 	void studentIn(student stu) throws Exception{
    	    Class.forName(driver);
    	    Connection studentTable=DriverManager.getConnection(url, user, password);
    	    String sql="insert into student(id,name,money) values(?,?,?)";
    	    PreparedStatement ps=studentTable.prepareStatement(sql);
    	    ps.setInt(1, stu.id);
    	    ps.setString(2, stu.name);
    	    ps.setInt(3, stu.money);
    	    ps.executeUpdate();
>>>>>>> 4a9fef8ca8d69f45a67197aa4ffd99e8b450c359
    	    studentTable.close();
    	    ps.close();
      }
}
