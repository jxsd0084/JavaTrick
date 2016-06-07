package bj.powernode.basic.day08.homework;


// 将日期类型的数组按照日期的先后顺序输出
public class HomeWork02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 0.准备日期
		Date d1 = new Date( 2010, 10, 1 );
		Date d2 = new Date( 2010, 9, 1 );
		Date d3 = new Date( 2010, 10, 11 );
		Date d4 = new Date( 2009, 10, 1 );
		Date d5 = new Date( 2011, 10, 1 );
		Date d6 = new Date( 2011, 10, 1 );

		// 1.初始化一个Date类型的数组
		Date[] dates = new Date[ 6 ];

		// 2.赋值
		dates[ 0 ] = d1;
		dates[ 1 ] = d2;
		dates[ 2 ] = d3;
		dates[ 3 ] = d4;
		dates[ 4 ] = d5;
		dates[ 5 ] = d6;

		// 3.排序.(选择排序)
		Date temp;
		for ( int i = 0; i < dates.length - 1; i++ ) {

			for ( int j = i + 1; j < dates.length; j++ ) {

				if ( Date.compare( dates[ i ], dates[ j ] ) ) {

					//交换位置
					temp = dates[ i ];
					dates[ i ] = dates[ j ];
					dates[ j ] = temp;
				}
			}
		}

		// 4.输出
		for ( int i = 0; i < dates.length; i++ ) {

			System.out.print( dates[ i ].toString() + "\t" );
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

	// setter and getter
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

	// 比较方法
	// 如果d1>d2 返回true,否之返回false
	public static boolean compare( Date d1, Date d2 ) {
		int year1  = d1.getYear();
		int year2  = d2.getYear();
		int month1 = d1.getMonth();
		int month2 = d2.getMonth();
		int day1   = d1.getDay();
		int day2   = d2.getDay();

		if ( year1 > year2 ) {

			return true;
		}

		//year1 <= year2
		if ( year1 == year2 ) {

			if ( month1 > month2 ) {

				return true;
			}

			//month1 <= month2
			if ( month1 == month2 ) {

				if ( day1 > day2 ) {

					return true;
				}

			}

		}

		return false;
	}


}
