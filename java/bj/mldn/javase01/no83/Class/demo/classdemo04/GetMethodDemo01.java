package bj.mldn.javase01.no83.Class.demo.classdemo04;

import java.lang.reflect.Method;

public class GetMethodDemo01 {

	public static void main(String[] args) throws Exception {

		Class<?> c   = Class.forName("org.lxh.demo.classdemo04.Person");
		Method   m[] = c.getMethods(); // 取得全部的方法
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i]); // 输出内容
		}
	}
}
