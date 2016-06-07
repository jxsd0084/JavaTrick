package bj.mldn.javase01.no83.Class.demo.classdemo05;

import java.lang.reflect.Method;

public class InvokeMethodDemo04 {

	public static void main(String[] args) throws Exception {

		Class<?> c = Class.forName("org.lxh.demo.classdemo05.Person");
		Object   o = c.newInstance();
		set("name", "MLDN", o, String.class);
		set("age", 30, o, int.class);
		get("name", o);
		get("age", o);
	}

	/**
	 * @param name  属性名称
	 * @param value 属性值
	 * @param obj   要操作的对象
	 */
	public static void set(String name, Object value, Object obj, Class<?> type)
			throws Exception {

		Method met = obj.getClass().getMethod("set" + initStr(name),
		                                      type);
		met.invoke(obj, value); // 调用方法
	}

	public static void get(String name, Object obj) throws Exception {

		Method met   = obj.getClass().getMethod("get" + initStr(name));
		Object value = met.invoke(obj);
		System.out.println(value);
	}

	public static String initStr(String name) {

		StringBuffer buf = new StringBuffer();
		buf.append(name.substring(0, 1).toUpperCase())
		   .append(name.substring(1));
		return buf.toString();
	}
}
