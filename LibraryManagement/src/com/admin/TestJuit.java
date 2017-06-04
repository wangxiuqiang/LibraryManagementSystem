package com.admin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.book.AllSee;

public class TestJuit {
   AllSee aSee;
   @Before//执行testrun前执行  可用作初始化  每一个类运行都运行一遍  BeforeClass在测试类加载的时候运行, 只运行一次
    public void Before (){
    	 aSee=new AllSee();
    }
	@Test
	public void testrun() throws Exception{
		
		aSee.allSee();
	}
	@After
	//执行要测试的类之后执行 可用于清除内存
	public void After(){
		aSee=null;
	}
}
//Assert  断言  Assert.assertEquals(,);判断返回值是不是期望的值,是就通过