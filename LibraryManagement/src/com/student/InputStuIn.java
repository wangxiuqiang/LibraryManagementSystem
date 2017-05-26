package com.student;

import java.util.Scanner;

import com.main.*;

public class InputStuIn {
     static Scanner input=new Scanner(System.in);
	public static student In(){
		  
		   System.out.println("欢迎注册，请按照提示信息进行注册！");
			System.out.println("请输入学号:");
			int id=input.nextInt();
			System.out.println("请输入密码：");
			String passwd=input.next();
			System.out.println("请输入姓名:");
			String name=input.next();
			System.out.println("请输入充值金额:");
			float money=input.nextFloat();
			student stu=new student(id,passwd,name,money);
			return stu;
	}
	public static int Inover() throws Exception{
		System.out.print("提示：返回登录界面请输入1");
			System.out.println("，退出系统请输入0.");
			 int n1=3;
			while(n1!=1&&n1!=0){
			   n1=input.nextInt();
			if(n1==1){
				Main.main(null);
			}
			else if(n1==0){
				break;
			}
			else {
				System.out.println("输入无效，请重新输入：");
			}	
		}
			return n1;
	}
}
