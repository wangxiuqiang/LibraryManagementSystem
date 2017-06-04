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
		boolean m;
		boolean n;
		int  a=1,b=2,c=2,d=4;
		m=a>b;
		n=c>d;
		System.out.println(m+"  "+n);
	}
	
}
