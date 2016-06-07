package bj.mldn.javase01.no83.Class.demo.classdemo04;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class GetConstructorDemo03 {

	public static void main(String[] args) throws Exception {

		Class<?>       c     = Class.forName("org.lxh.demo.classdemo04.Person");
		Constructor<?> con[] = c.getConstructors();     // 得到全部构造
		for (int i = 0; i < con.length; i++) {
			int      mod     = con[i].getModifiers();   // 得到修饰符
			String   str     = Modifier.toString(mod);  // 还原权限
			Class<?> param[] = con[i].getParameterTypes(); // 得到全部的参数
			System.out.print(str + " "); // 输出内容
			System.out.print(con[i].getName() + " (");
			for (int x = 0; x < param.length; x++) {
				System.out.print(param[x].getName() + " arg-" + x);
				if (x < param.length - 1) {
					System.out.print(",");
				}
			}
			System.out.println(")");
		}
	}
}
 
