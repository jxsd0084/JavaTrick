package bj.mldn.javase01.no83.Class.demo.classdemo05;

import java.lang.reflect.Method;


public class InvokeMethodDemo01 {

	public static void main(String[] args) throws Exception {

		Class<?> c = Class.forName("org.lxh.demo.classdemo05.Person");
		// 本程序中将调用Person类中的sayHello()方法
		Method met = c.getMethod("sayHello");
		met.invoke(c.newInstance());
	}
}
