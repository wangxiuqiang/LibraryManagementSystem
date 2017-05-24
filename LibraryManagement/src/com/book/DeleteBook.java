package com.book;

import javax.tools.Diagnostic;

import java.sql.*;

public class DeleteBook {

	public String driver="com.mysql.jdbc.Driver";
    public String url="jdbc:mysql://localhost:3306/Library";  
    public String user="root";
    public String password="root";
    
    public int setid(int n) throws Exception{
    	Class.forName(driver);
    	ResultSet rs;
    	int flag=0;
  	    Connection Set=DriverManager.getConnection(url, user, password);
         String sql="SELECT flag FROM book WHERE id="+n;
         Statement statement=Set.createStatement();
         rs =statement.executeQuery(sql);
         while(rs.next()) {
        	   flag=rs.getInt(1);
//             System.out.print(" "+rs.getFloat(4)+" "+rs.getString(5)+" "+rs.getString(6));
//             System.out.println(" "+rs.getInt(7)+" "+rs.getFloat(8)+" "+rs.getInt(9));
         }	
        // System.out.println(id);
         statement.close();
         Set.close();
         if(flag!=1){
        	  return n;//当flag=1的时候该书并未借出
         }
         else{
        	 return -1;
         }
        
    }
    
	public void delete(int id) throws Exception{
		Class.forName(driver);
  	    Connection Check=DriverManager.getConnection(url, user, password);
	    String sql="delete from book where id="+id;
	    Statement statement=Check.createStatement();
	    statement.execute(sql);
	    statement.close();
	    Check.close();
	    
	}

}
