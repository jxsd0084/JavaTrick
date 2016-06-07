package bj.mldn.javase01.no83.Class.demo.classdemo04;

import java.lang.reflect.Constructor;

public class GetConstructorDemo01 {

	public static void main(String[] args) throws Exception {

		Class<?>       c     = Class.forName("org.lxh.demo.classdemo04.Person");
		Constructor<?> con[] = c.getConstructors(); // 得到全部构造
		for (int i = 0; i < con.length; i++) {
			System.out.println(con[i]); // 输出内容
		}
	}
}
