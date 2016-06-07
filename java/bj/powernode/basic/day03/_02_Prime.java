package bj.powernode.basic.day03;

/*
  java中的类
  public 是修饰符
  class 定义一个类

  _02_Prime 类名(标识符)

  类是.java文件的基本单元.
*/
public class _02_Prime {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		int sum = 0;

		//  101-200的质数(155)

		for ( int i = 101; i <= 200; i += 2 ) {

			boolean flag = true;

			//  每循环一次,获取一个值,判断该值是否是质数,如果是质数,把该质数打印到控制台.
			for ( int j = 2; j < i; j++ ) {

				if ( i % j == 0 ) { //不是质数.

					flag = false;

					break;
				}
			}

			if ( flag ) {

				sum += i;

				System.out.println( "质数是：" + i );  //代码执行到此代表i是质数吗？有可能不是.
			}

		}

		System.out.println( "所有质数的和是:" + sum );

	}

}
