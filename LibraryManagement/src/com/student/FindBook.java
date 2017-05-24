package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//此函数用在BorrowBook中借书    请输入要借阅的书籍编号然后输出确认
public class FindBook {

	public String driver="com.mysql.jdbc.Driver";
    public String url="jdbc:mysql://localhost:3306/Library";  
    public String user="root";
    public String password="root";
    public void findBook(int id) throws Exception{
    	Class.forName(driver);
    	Connection connection=DriverManager.getConnection(url, user, password);
        String sql="SELECT id,name,bookCount,dayMoney FROM book WHERE id="+id;
        Statement statement=connection.createStatement();
        ResultSet rSet=statement.executeQuery(sql);
        System.out.println("图书编号\t书籍名称\t书库数量\t日租金");
         while(rSet.next()){	
        	 System.out.println(rSet.getInt(1)+"\t"+rSet.getString(2)+"\t"+rSet.getFloat(3)+"\t"
        			 +rSet.getInt(4));
         }
    }
}
