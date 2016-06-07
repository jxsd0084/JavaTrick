package bj.mldn.javase01.no83.Class.demo.classdemo05;

import java.lang.reflect.Method;


public class InvokeMethodDemo02 {

	public static void main(String[] args) throws Exception {

		Class<?> c = Class.forName("org.lxh.demo.classdemo05.Person");
		// 本程序中将调用Person类中的getInfo()方法
		Method met = c.getMethod("getInfo");
		String val = (String) met.invoke(c.newInstance());
		System.out.println(val);
	}
}
