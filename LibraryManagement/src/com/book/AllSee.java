package com.book;


//学生和管理员查看全部图书

import java.sql.*;

import com.main.JdbcDriver;

public class AllSee {
	  
    public void allSee() throws Exception{
    	JdbcDriver jd=new JdbcDriver();
    	 Class.forName(jd.driver);
   	    Connection See=DriverManager.getConnection(jd.url, jd.user, jd.password);
   	   String sql="SELECT * FROM book";
        Statement statement=See.createStatement();
        ResultSet rs =statement.executeQuery(sql);
        System.out.println("图书编号\t图书名称\t图书种类\t书籍单价\t书籍出版社\t作者\t数量\t日租金");
       while(rs.next()) {
    	  System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
         System.out.print("\t"+rs.getFloat(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
         System.out.println("\t"+rs.getInt(7)+"\t"+rs.getFloat(8));
     }	
      rs.close();
      statement.close();
      See.close();
      System.out.println("返回上一层请输入0");
    }
}
