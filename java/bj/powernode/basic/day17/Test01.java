package bj.powernode.basic.day17;

/*

	线程:程序中不同的执行路径.或者叫做不同的执行分支.

*/
public class Test01 {


	public static void m1() {

		m2();
		m3();
	}


	public static void m2() {

	}

	public static void m3() {

	}


	// 主线程
	public static void main( String[] args ) {

		m1();

	}

}
