package com.main;

import java.util.*;
import java.util.concurrent.CountDownLatch;

import com.book.*;
import com.student.*;

public class Main {

	public static void main(String[] args) throws Exception {
	     Scanner input=new Scanner(System.in);
	     Show show=new Show();//定义输出对象，用于各种输出 简化住函数
	     show.ShowIn();//输出进入界面
	     //输入要进入的系统 学生or 管理员
	        
	     Maining maining=new Maining();//定义主函数执行的类的对象
	     StudentInNow sin=new StudentInNow(); //定义学生登录对象
	     while(true){
	    	 int n;
		    	n=input.nextInt();
	    	 if(n==0){
	    		 break;
	    	 }
	    	 else if(n==1){
	    		// System.out.println("欢迎"+nameD+"登录图书馆！");
	    		 break;
	    	 }
	    	 else if(n==2){     	    
	         	 maining.stuInMain();
	         	 break;
	    	 }
	    	 else if(n==3){
	    		student stu=InputStuIn.In();
	 			studentIn stuIn=new studentIn();
	 			stuIn.studentIn(stu);
	 			int n1=InputStuIn.Inover();
	 			if(n1==0){
	 				break;
	 			}
	    	 }
	     }
	}

}
