package com.student;

/**
 * 测试类
 * 用于测试函数成功否
 */
import java.util.Scanner;
import com.book.*;
public class test {

	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
        int xuanze=input.nextInt();
        /*
         * 学生注册   
         */
		if(xuanze==1){
			System.out.print("欢迎注册,");
			System.out.println("请输入学号:");
			int id=input.nextInt();
<<<<<<< HEAD
//			System.out.println("请输入姓名:");
//			String name=input.next();
//			System.out.println("请输入充值金额:");
//			int money=input.nextInt();
//			student stu=new student(id,name,money);
//			studentIn  stuIn=new studentIn();
//			stuIn.studentIn(stu);
=======
			System.out.println("请输入姓名:");
			String name=input.next();
			System.out.println("请输入充值金额:");
			int money=input.nextInt();
			student stu=new student(id,name,money);
			studentIn  stuIn=new studentIn();
			stuIn.studentIn(stu);
>>>>>>> 4a9fef8ca8d69f45a67197aa4ffd99e8b450c359
		}
		/*
		 * 书籍添加
		 */
		else if(xuanze==2){
			System.out.println("请输入id:");
			int id=input.nextInt();
			System.out.println("请输入书名:");
			String name=input.next();
			System.out.println("请输入类型:");
			String type=input.next();
			System.out.println("请输入单价:");
			float money=input.nextFloat();
			System.out.println("请输入出版社:");
			String publishingHouse=input.next();
			System.out.println("请输入作者:");
			String author=input.next();
			System.out.println("请输入库存:");
			int bookCount=input.nextInt();
			System.out.println("请输入日租金:");
			float dayMoney=input.nextFloat();
			Book book =new Book(id,name,type,money,publishingHouse,author,bookCount,dayMoney);
		    bookMysql bmMysql=new bookMysql();
		    bmMysql.BookIn(book);
		}
		/**
		 * 删除图书
		 */
		if(xuanze==3){
			DeleteBook dBook=new DeleteBook();
			int n=input.nextInt();
		int id	=dBook.setid(n);
			//System.out.println();
		if(id!=-1){
			dBook.delete(id);
		}
		else{
			System.out.println("不能删除");
		}
		}
		/*
		 * 查看全部图书
		 */
		if (xuanze==4){
			AllSee allSee=new AllSee();
			allSee.allSee();
		}
		/**
		 * 借书   ,单个查看图书
		 */
		if(xuanze ==5){
			BorrowBook book=new BorrowBook();
			book.borrowBook();
		}
		/*
		 * 还书
		 */
		if(xuanze==6){
			Backbook backbook=new Backbook();
			backbook.backBook();
		}
	}

}
