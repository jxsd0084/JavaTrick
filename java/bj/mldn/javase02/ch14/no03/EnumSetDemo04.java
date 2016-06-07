package bj.mldn.javase02.ch14.no03;

import java.util.EnumSet;

enum Color5 {
	RED, GREEN, BLUE;
}

public class EnumSetDemo04 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		EnumSet< Color5 > esOld = null;            // 声明一个EnumSet对象
		EnumSet< Color5 > esNew = null;
		System.out.println( "======== EnumSet.complementOf(Color.class) =====" );
		esOld = EnumSet.noneOf( Color5.class );    // 将枚举的全部类型设置到EnumSet对象之中
		esOld.add( Color5.RED );    // 增加内容
		esOld.add( Color5.GREEN );    // 增加内容
		esNew = EnumSet.complementOf( esOld );    // 不包含指定内容
		print( esNew );
	}

	public static void print( EnumSet< Color5 > temp ) {    // 专门的输出操作
		for ( Color5 c : temp ) {        //  循环输出EnumSet中的内容
			System.out.print( c + "、" );
		}
		System.out.println();
	}
}
