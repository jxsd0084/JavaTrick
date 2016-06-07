package bj.mldn.javase01.no83.Class.demo.classdemo04;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GetFieldsDemo01 {

	public static void main(String[] args) throws Exception {

		Class<?> c = Class.forName("org.lxh.demo.classdemo04.Person");
		{
			Field f[] = c.getFields(); // 取得全部的变量
			for (int i = 0; i < f.length; i++) {
				String mod = Modifier.toString(f[i].getModifiers());
				System.out.print(mod + " ");
				System.out.println(f[i].getType().getName());
			}
		}
		{
			Field f[] = c.getDeclaredFields(); // 取得全部的变量
			for (int i = 0; i < f.length; i++) {
				String mod = Modifier.toString(f[i].getModifiers());
				System.out.print(mod + " ");
				System.out.println(f[i].getType().getName());
			}
		}
	}
}
 
