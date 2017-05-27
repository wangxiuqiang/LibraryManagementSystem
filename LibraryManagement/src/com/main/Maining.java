package com.main;

import java.io.BufferedWriter;
import java.util.Scanner;

import com.book.AllSee;
import com.book.DeleteBook;
import com.student.AgoBorrow;
import com.student.Backbook;
import com.student.BorrowBook;
import com.student.StudentInNow;
import com.main.*;

public class Maining {
	 Show show=new Show();//定义输出对象，用于各种输出 简化函数
	 Scanner input=new Scanner(System.in);
	 String nameD="";
	 StudentInNow sin=new StudentInNow(); //定义学生登录对象	 
	 /**
     * 当n==2 时的执行情况，即学生登录时要执行的步骤
     * @throws Exception 
     */
	 
	 public void stuInMain() throws Exception{
    	 int count=0;
    	 show.ShowStuInNow();//输出信息
		 while(count<3){
		 nameD=sin.InNow();//调用函数测试id和密码是否相等，相等返回用户名
		 if(nameD!=null){
			 break;
		  }
		 else{
			 System.out.println("用户名和密码不匹配，请重新输入：");
			 count++;
		   }
	     }
		 if(count==3){//如果密码输出三次 返回主页面
				Main.main(null);
		}
		 else{
             goon();
		 }
     }
	 public void goon() throws Exception{
			show.ShowStuInNowInit(nameD);//登录成功输出部分信息  
			int way;
            way=input.nextInt();//选择执行任务
			if(way==1){
					 AllSee allSee=new AllSee();
					 allSee.allSee();
					 int back=input.nextInt();
					 if(back==0){
						goon();
					 }	 
			}
			else if(way==2){
					AgoBorrow ago=new AgoBorrow();
					ago.ago(nameD);
					System.out.println("查询成功，输入0返回上一页");
					int back=input.nextInt();
					 if(back==0){
						goon();
					 }	
			}
			else if(way==3){
					BorrowBook bb=new BorrowBook();
					bb.borrowBook();
					System.out.println("借书成功，输入0返回上一页");
					 int back=input.nextInt();
					 if(back==0){
						goon();
					 }	
			}	
			else if(way==0){
				Main.main(null);
			}
			else if (way==4){
				Backbook backbook= new Backbook();
				backbook.backBook();
				System.out.println("还书成功，输入0返回上一页");
				 int back=input.nextInt();
				 if(back==0){
					goon();
				 }	
			}
			
	 }
}

