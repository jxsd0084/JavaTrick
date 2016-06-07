package bj.mldn.javase01.no83.Class.demo.classdemo04;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetMethodDemo02 {

	public static void main(String[] args) throws Exception {

		Class<?> c   = Class.forName("org.lxh.demo.classdemo04.Person");
		Method   m[] = c.getMethods();                   // 取得全部的方法
		for (int i = 0; i < m.length; i++) {
			String   mod     = Modifier.toString(m[i].getModifiers()); // 取得访问权限
			String   metName = m[i].getName();           // 取得方法名称
			Class<?> ret     = m[i].getReturnType();     // 取得返回值类型
			Class<?> param[] = m[i].getParameterTypes(); // 得到全部的参数类型
			Class<?> exc[]   = m[i].getExceptionTypes(); // 得到全部的异常
			System.out.print(mod + " ");
			System.out.print(ret + " ");
			System.out.print(metName + " (");
			for (int x = 0; x < param.length; x++) {
				System.out.print(param[x] + "arg-" + x);
				if (x < param.length - 1) {
					System.out.print(",");
				}
			}
			System.out.print(") ");
			if (exc.length > 0) {   // 有异常抛出
				System.out.print("throws ");
				for (int x = 0; x < exc.length; x++) {
					System.out.print(exc[x].getName());
					if (x < param.length - 1) {
						System.out.print(",");
					}
				}
			}
			System.out.println();
		}
	}
}
