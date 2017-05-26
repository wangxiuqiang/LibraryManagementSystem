package com.student;

import java.nio.channels.GatheringByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 * 根据id 单个查找书
 */
//此函数用在BorrowBook中借书    请输入要借阅的书籍编号然后输出确认
public class FindBook {
	public String driver="com.mysql.jdbc.Driver";
    public String url="jdbc:mysql://localhost:3306/Library";  
    public String user="root";
    public String password="root";
    public void findBook(int id) throws Exception{
    	Class.forName(driver);
    	Connection connection=DriverManager.getConnection(url, user, password);
        String sql="SELECT * FROM book WHERE id="+id;
        Statement statement=connection.createStatement();
        ResultSet rSet=statement.executeQuery(sql);
        System.out.println("书籍编号\t书籍类型\t书籍名称\t书籍单价\t书籍出版社\t书籍作者\t书库数量\t日租金");
         while(rSet.next()){	
        	 System.out.println(rSet.getInt(1)+"\t"+rSet.getString(2)+"\t"+rSet.getString(3)+"\t"
        			 +rSet.getFloat(4)+"\t"+rSet.getString(5)+"\t"+rSet.getString(6)+"\t"+rSet.getInt(7)
        			 +"\t"+rSet.getFloat(8));
         }
    }
}
