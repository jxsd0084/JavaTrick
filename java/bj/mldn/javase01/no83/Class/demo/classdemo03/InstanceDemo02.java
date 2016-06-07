package bj.mldn.javase01.no83.Class.demo.classdemo03;

import java.lang.reflect.Constructor;

public class InstanceDemo02 {

	public static void main(String[] args) throws Exception { // 所有异常抛出
		Class<?> c   = null;
		Person   per = null;
		c = Class.forName("org.lxh.demo.classdemo03.Person");
		Constructor<?> cons[] = c.getConstructors();    // 得到全部的构造
		per = (Person) cons[0].newInstance("MLDN", 30); // 实例化对象
		System.out.println(per);
	}

} 
