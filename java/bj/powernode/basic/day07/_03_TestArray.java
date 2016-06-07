
package bj.powernode.basic.day07;

/*

	java语言中的数组: 一维数组、二维数组、三维数组、四维数组.....

	1.数组是什么类型？ 在java语言中引用类型
		数组有toString,equals方法吗？有.
	
	2.数组：存储多个数据的引用类型,数组中每一个元素我们可以看做这个对象的成员变量.
		在数组中有很多小格子,每一个格子都有编号,注意：编号从0开始,这个编号我们称作 数组的下标.
		一个数组中有N个元素,那么下标就是 0 - (N-1)
	
	3.如何创建一个数组: 静态创建  +  动态创建.
	
		3.1 静态创建.

			int[] datas        = {1,2,4,5,9,100}; 或者 int datas[] = {1,2,4,5,9,100};
			double[] doubles   = {1.0,2.0,10.0};
			float[] floats     = {1.0f,2.0f,3.0f};
			byte[] bytes       = {2,3,75};
			char[] chars       = {'a','b','z'};
			boolean[] booleans = {true,false,false,true,false,true,true};
			
			*****************************
			Person p1 = new Person();
			Person p2 = new Person();
			Person p3 = new Person();
			Person[] persons = {p1,p2,p3};
			*****************************
			
			******************************
			Person p1 = new Person();
			Animal a1 = new Animal();
			Cat c = new Cat();
			Object[] os = {p1,a1,c};
			*******************************
			
			
			Object[] os = {new Person(),new Animal(),new Cat()};
			
			注意：A类型的数组中只能存储A类型的数据.
			
	
	4. 每一个数组都有一个 length 属性,length属性的值就是数组的长度.	
	
	5.如何获取数组中的第N个元素 :  语法-->数组名[下标]  例如: ints[0],ints[2]

*/

public class _03_TestArray {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] agrs ) {

		// 静态创建
		int[] ints = { 0, 3, 2, 1, 9, 6, 8, 7, 5, 4 }; // 10

		System.out.println( "ints数组中有" + ints.length + "个元素." );

		System.out.println( "ints数组的第四个元素是" + ints[ 3 ] );




		// 循环取数据(遍历)
		for ( int i = 0; i < ints.length; i++ ) {

			System.out.print( ints[ i ] + " " );
		}
		System.out.print( "\n" );  // 换行




		// 创建一个Date类型的数组,专门用来存储日期.
		Date d1 = new Date( 2010, 10, 1 );
		Date d2 = new Date( 1999, 8, 1 );
		Date d3 = new Date( 2010, 5, 10 );
		Date d4 = new Date( 2011, 10, 1 );
		Date d5 = new Date( 2012, 12, 25 );

		Date[] dates = { d1, d2, d3, d4, d5 };

		// 遍历数组
		for ( int i = 0; i < dates.length; i++ ) {

			System.out.print( dates[ i ] + " " );
		}

	}

}

// 日期类
class Date {

	// 属性
	private int year;
	private int month;
	private int day;

	// 构造方法
	public Date() {

		super();
	}

	public Date( int year, int month, int day ) {

		this.year = year;
		this.month = month;
		this.day = day;
	}


	//s etter and getter
	public void setYear( int year ) {

		this.year = year;
	}

	public int getYear() {

		return year;
	}

	public void setMonth( int month ) {

		this.month = month;
	}

	public int getMonth() {

		return month;
	}

	public void setDay( int day ) {

		this.day = day;
	}

	public int getDay() {

		return day;
	}


	// 重写toString方法
	public String toString() {

		return year + "年" + month + "月" + day + "日";
	}

}
