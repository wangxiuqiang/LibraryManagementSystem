package com.student;

import java.sql.*;
import java.util.Scanner;

import java.sql.Connection;
import com.main.JdbcDriver;
import com.main.Maining;


/**
 * 余额不足   充值
 * @author wxq
 *
 */
public class MoneyIn {
    JdbcDriver jd=new JdbcDriver(); 
    Maining maining =new Maining();
	public float moneyIn() throws Exception{
        	Class.forName(jd.driver);
        	Scanner input=new Scanner(System.in);
        	Connection connection=DriverManager.getConnection(jd.url, jd.user, jd.password);
        	float money=input.nextFloat();
        	//String string="select * from student";
            
        	String sqlMoney="UPDATE student SET money="+money+"WHERE id="+maining.id;
        	Statement statement=connection.createStatement();	
        	//ResultSet rs=statement.executeQuery(string);
        	statement.execute(sqlMoney);
        	return 0;
        }
}
