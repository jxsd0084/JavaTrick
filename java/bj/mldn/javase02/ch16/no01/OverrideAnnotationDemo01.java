package bj.mldn.javase02.ch16.no01;

class Person {

	public String getInfo() {        // 取得信息
		return "这是一个Person类。";
	}
}

class Student extends Person {    // 继承此类

	//	@Override
	public String getinfo() {    // 覆写方法
		return "这是一个Student类。";
	}
}

public class OverrideAnnotationDemo01 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) {

		Person per = new Student();
		System.out.println( per.getInfo() );    // 输出信息
	}
}
