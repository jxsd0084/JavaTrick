package bj.mldn.javase02.ch16.no01;

class Demo {

	@Deprecated
	// 声明不建议使用的操作
	public String getInfo() {

		return "这是一个Person类。";
	}
}

public class DeprecatedAnnotationDemo01 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) {

		Demo d = new Demo();
		System.out.println( d.getInfo() );
	}
}
