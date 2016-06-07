package bj.mldn.javase01.no83.Class.demo.classdemo05;

import java.lang.reflect.Field;

public class InvokeFieldDemo {

	public static void main(String[] args) throws Exception {

		Class<?> c         = Class.forName("org.lxh.demo.classdemo05.Person");
		Object   obj       = c.newInstance();
		Field    nameField = c.getDeclaredField("name");
		nameField.setAccessible(true);  // 让属性可见
		nameField.set(obj, "MLDN");
		System.out.println(nameField.get(obj));
	}
}
 
