package bj.powernode.basic.day03;

public class Lab02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		java.util.Scanner s = new java.util.Scanner( System.in );

		//  接收用户输入的年份
		System.out.print( "请输入年份：" );

		// 等待用户输入年份(year)
		int year = s.nextInt();

		System.out.print( "请输入月份：" );

		// 等待用户输入月份(month)
		int month = s.nextInt();

		//  System.out.println("您输入的日期是："+year+"年"+month+"月");

		String strTime = ( year + "年" + month + "月" );


		//   闰年:
		//   年份可以同时被 4 和 100 整除.
		//   年份可以被 400 整除.
		if ( month == 2 ) {

			if ( ( year % 4 == 0 && year % 100 == 0 ) || year % 400 == 0 ) {
				//  闰年
				System.out.println( strTime + "29天" );

			} else {
				//  平年
				System.out.println( strTime + "28天" );

			}

		} else if ( month == 4 || month == 6 || month == 9 || month == 11 ) {
			System.out.println( strTime + "30天" );

		} else {
			System.out.println( strTime + "31天" );

		}

	}

}
