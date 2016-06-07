package bj.mldn.javase02.ch06.no11;

interface A {

	public String getInfo();
}

class B implements A {

	public String getInfo() {    // 覆写方法
		return "Hello World!!!";
	}
}

public class ObjectDemo04 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		A      a   = new B();    // 向上转型，为接口实例化
		Object obj = a;    // 使用Object接收，向上转型
		A      x   = (A) obj;    // 向下转型
		System.out.println( x.getInfo() );
	}
}
