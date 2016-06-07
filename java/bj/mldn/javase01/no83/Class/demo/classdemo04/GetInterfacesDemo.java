package bj.mldn.javase01.no83.Class.demo.classdemo04;

public class GetInterfacesDemo {

	public static void main(String[] args) throws Exception {

		Class<?> c       = Class.forName("org.lxh.demo.classdemo04.Person");
		Class<?> inter[] = c.getInterfaces(); // 得到全部的接口
		for (int i = 0; i < inter.length; i++) {
			System.out.println(inter[i].getName()); // 输出内容
		}
	}

}
