package bj.Java1200.col01.ch02_Java基础应用.ch02_3_条件语句._28_判断某一年是否为闰年;

import java.util.Scanner;

public class LeapYear {

	public static void main( String[] args ) {

		Scanner scan = new Scanner( System.in );
		System.out.println( "请输入一个年份：" );
		long year = scan.nextLong();// 接收用户输入
		if ( year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) { // 是闰年
			System.out.print( year + "是闰年！" );
		} else { // 不是闰年
			System.out.print( year + "不是闰年！" );
		}
	}

}
