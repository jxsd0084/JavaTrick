package bj.mldn.javase01.no55.systemdemo;

class Person {

	private String name;
	private int    age;

	public Person( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String toString() {

		return "姓名：" + this.name + "，年龄：" + this.age;
	}

	public void finalize() throws Throwable {

		System.out.println( "我被回收了，我完蛋了。。。（" + this + "）" );
	}

}

public class SystemDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Person per = new Person( "张三", 99 );
		per = null;     // 取消引用
		System.gc();    // 强制进行垃圾收集
	}
}
