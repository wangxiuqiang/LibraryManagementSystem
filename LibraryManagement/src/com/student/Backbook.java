package com.student;

/*
 * 还书函数  首先在学生的位置输入还书编号,如果没有输出错误
 * 有的话   还这门书  然后使他的bookCount+1 并且比较和agoCount 的关系 相同的话将
 * flag置为1  表示该书籍全部在库  删除的时候也可以删除
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Backbook {
	 public String driver="com.mysql.jdbc.Driver";
	    public String url="jdbc:mysql://localhost:3306/Library";  
	    public String user="root";
	    public String password="root";
        public void backBook() throws Exception{
    	  Scanner input=new Scanner(System.in);
    	  System.out.println("请输入要还的书的编号:");
    	  int id =input.nextInt();//书的编号
    	/*
    	 * 连接数据库
    	 */
    	  Class.forName(driver);
    	  Connection connection=DriverManager.getConnection(url, user, password);
    	  Statement statement=connection.createStatement();
    	  if(false){
    		  System.out.println("输入的信息有误");//没有在自己借的书里
    	  }
    	 if(true){
    		 int bookCount=-1,agoCount=-1;
    		 String  sql="SELECT bookCount,agoCount FROM book WHERE id="+id;
    		 ResultSet rSet=statement.executeQuery(sql);
    		 while(rSet.next()){
    			 bookCount=rSet.getInt(1);
    			 agoCount=rSet.getInt(2);
    		 }
    		 String sql2="UPDATE book SET bookCount="+(bookCount+1)+" WHERE id="+id;
    	      statement.execute(sql2);
    	      if(bookCount+1==agoCount){
    	    	  String sql3="UPDATE book SET flag="+1+" WHERE id="+id;
    	    	  statement.execute(sql3);
    	      }
    	 }
      }
<<<<<<< HEAD
}
=======
}
>>>>>>> 4a9fef8ca8d69f45a67197aa4ffd99e8b450c359
