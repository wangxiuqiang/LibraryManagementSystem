package com.student;

import java.sql.*;
import java.sql.Statement;
import java.util.Scanner;
import com.main.JdbcDriver;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.*;

public class StudentInNow {
	JdbcDriver jd=new JdbcDriver();
	
        public String InNow() throws Exception{
        	Scanner input=new Scanner(System.in);
        	 int id= input.nextInt();
        	 System.out.println("请输入学生密码：");
        	 String passwd=input.next();
        	 Class.forName(jd.driver);
        	 Connection connection= (Connection) DriverManager.getConnection(jd.url, jd.user, jd.password);
        	 String sql="select id,passwd,name from student where id="+id;
        	 Statement statement=connection.createStatement();
        	 ResultSet rSet=statement.executeQuery(sql);
        	 int idTest=-1;
        	 String passwdTest = null;
        	 String name = null;
        	 while(rSet.next()){
        		 idTest=rSet.getInt(1);
        		 passwdTest=rSet.getString(2);
        		 name=rSet.getString(3);
        	}
            if((id==idTest) &&(passwd.equals(passwdTest))){
            	return name;
            }
            else {
            		return null;
            }
		
			
        }
}
