package bj.mldn.javase01.no83.Class.demo.classdemo04;

public class GetSuperClassDemo {

	public static void main(String[] args) throws Exception {

		Class<?> c  = Class.forName("org.lxh.demo.classdemo04.Person");
		Class<?> sc = c.getSuperclass();
		System.out.println(sc.getName());
	}

}
