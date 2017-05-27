package com.student;

import java.util.Scanner;

/**
 * 余额不足   充值
 * @author wxq
 *
 */
public class MoneyIn {
        public float moneyIn(){
        	Scanner input=new Scanner(System.in);
        	System.out.println("请输入要充值的金额：");
        	float moneyin=input.nextFloat();
        	return moneyin;
        }
}
