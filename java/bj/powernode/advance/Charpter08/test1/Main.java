package bj.powernode.advance.Charpter08.test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 对于未检查异常,可用通过编程的方式进行避免
		// 当程序中出现异常,而又没有采取处理措施的情况下,程序会异常中断
		int i = 10, j = 0;

		if ( j != 0 ) {
			int k = i / j;

		} else {
			System.out.println( "0不能做除数" );
		}


		int[] arr   = { 1, 2, 3 };
		int   index = 3;

		if ( index >= arr.length ) {
			System.out.println( "数组索引越界" );

		} else {
			int k = arr[ index ];
		}


		// 当obj这个引用指向的对象确确实实就是一个Person类型的对象的时候,在这种情况下可以还原
		Object obj = new Object();

		if ( obj instanceof Person ) {
			Person p = (Person) obj;

		} else {
			System.out.println( "类型不对,不能进行转换" );
		}

		Person p = new Person( 21, "张一" );
		p = null;

		if ( p != null ) {
			int m = p.getAge();

		} else {
			System.out.println( "空引用不能调用方法" );
		}


		try {
			FileInputStream fin = new FileInputStream( "c:\\aa.txt" );
		} catch ( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// 对于未检查异常,除了可以用编程的方式进行避免之外,也可以采用java中提供的异常处理措施进行处理
		int i2 = 10, j2 = 0;

		try {

			int k = i2 / j2;

			if ( j2 == 0 ) {

				ArithmeticException ex = new ArithmeticException( "除0异常" );
				throw ex;
			}

		} catch ( ArithmeticException ex ) {

			ex.printStackTrace();
		}

		System.out.println( "=========OK============" );

	}

}
