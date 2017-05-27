package com.student;

import java.sql.*;
import java.util.Scanner;

import com.main.*;
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
    	    studentTable.close();
    	    ps.close();
      }
}
