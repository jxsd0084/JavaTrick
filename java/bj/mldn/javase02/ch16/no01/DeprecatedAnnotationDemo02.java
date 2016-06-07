package bj.mldn.javase02.ch16.no01;

@Deprecated
// 声明不建议使用的操作
class Demo2 {

	public String getInfo() {

		return "这是一个Person类。";
	}
}

public class DeprecatedAnnotationDemo02 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) {

		Demo2 d = new Demo2();
		System.out.println( d.getInfo() );
	}
}
