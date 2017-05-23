package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.student.student;

public class bookMysql {

	public String driver="com.mysql.jdbc.Driver";
    public String url="jdbc:mysql://localhost:3306/Library";  
    public String user="root";
    public String password="root";
    public void BookIn(Book book) throws Exception{
  	    Class.forName(driver);
  	    Connection BookTable=DriverManager.getConnection(url, user, password);
  	    String sql1="insert book(id,name,type,price,publishingHouse,author,bookCount,dayMoney) values(?,?,?,?,?,?,?,?)";
  	    PreparedStatement ps1=BookTable.prepareStatement(sql1);
  	    ps1.setInt(1,book.id);
  	    ps1.setString(2,book.name);
  	    ps1.setString(3,book.type);
  	    ps1.setFloat(4,book.price);
	    ps1.setString(5,book.publishingHouse);
	    ps1.setString(6,book.author);
  	    ps1.setInt(7,book.bookCount);
  	    ps1.setFloat(8,book.dayMoney);
  	    ps1.executeUpdate();
  	    ps1.close();
  	    BookTable.close();
    }
}
