package bj.mldn.javase01.no83.Class.demo.classdemo02;

public class InstanceDemo01 {

	public static void main(String[] args) {

		Class<?> c = null;
		try {
			c = Class.forName("org.lxh.demo.classdemo02.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Person p = (Person) c.newInstance();
			System.out.println(p);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
