package bj.mldn.javase01.no83.Class.demo.classdemo01;

public class ClassInstanceDemo03 {

	public static void main(String[] args) {

		Class<?> c = null;
		try {
			c = Class.forName("org.lxh.demo.classdemo01.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c.getName());
	}

}
