package com.main;

public class Show {
       public void ShowIn(){// 开始进入系统时的输出
    	   System.out.println("------------------------------------------");
  	     System.out.println("----------------欢迎来到校图书馆-------------");
  	     System.out.println("-------------------------------------------");
  	     System.out.println("----------------请选择登录方式---------------");
  	     System.out.println("     1.管理员登录    2.学生登录     3.学生注册   0.退出");
       }
       public void ShowStuInNow(){//学生登录时的输出
    	   System.out.print("请输入学生编号：");
       }
       public void ShowStuInNowInit(String nameD){//学生登录成功的输出
    	   System.out.println("欢迎"+nameD+"登录图书馆！");
    	   System.out.println("请选择需要的操作:");
    	   System.out.println("1.查询库存图书   2.查询已经借阅的图书   3.借阅书籍   4.归还书籍   5.充值   0.退出到主页面");
       }
}
