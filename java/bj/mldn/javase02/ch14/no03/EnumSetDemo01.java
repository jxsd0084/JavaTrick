package bj.mldn.javase02.ch14.no03;

import java.util.EnumSet;

enum Color2 {
	RED, GREEN, BLUE;
}

public class EnumSetDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		EnumSet< Color2 > es = null;            // 声明一个EnumSet对象
		System.out.println( "======== EnumSet.allOf(Color.class) =====" );
		es = EnumSet.allOf( Color2.class );    // 将枚举的全部类型设置到EnumSet对象之中
		print( es );
	}

	public static void print( EnumSet< Color2 > temp ) {    // 专门的输出操作
		for ( Color2 c : temp ) {        //  循环输出EnumSet中的内容
			System.out.print( c + "、" );
		}
		System.out.println();
	}
}
