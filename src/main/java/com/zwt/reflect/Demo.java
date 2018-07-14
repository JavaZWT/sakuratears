package com.zwt.reflect;

import java.util.List;
import java.util.Map;

/**
 * @Author: Little Fish
 * @Description: TODO
 * @Name: Demo.java
 * @Date: 2018年7月13日 下午3:44:01
 * @Version: 1.0
 */
public class Demo {
	public static String getName(String str) {
		String s="123";
		return str+s;
	}
	
	public Integer doSomething(String str,double a,Map<String, String> map,List<String> list) {
		//doSomething
		Integer i=0;
		return i;
	}
	
	private static final int NUM=1;
	
	private static String s="1234";
	
	static {
		s="5678";
	}
}
