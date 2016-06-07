package bj.mldn.javase02.ch07.no02;

class Math3 {

	public int div( int i, int j ) throws Exception {    // 定义除法操作，如果有异常，则交给被调用处处理
		int temp = i / j;                                // 计算，但是此处有可能出现异常
		return temp;
	}
}

public class ThrowsDemo02 {

	// 在主方法中的所有异常都可以不使用try...catch进行处理
	public static void main( String args[] ) throws Exception {

		Math3 m = new Math3();        // 实例化Math类对象
		System.out.println( "除法操作：" + m.div( 10, 0 ) );
	}
}
