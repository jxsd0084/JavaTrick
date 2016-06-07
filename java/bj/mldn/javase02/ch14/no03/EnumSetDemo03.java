package bj.mldn.javase02.ch14.no03;

import java.util.EnumSet;

enum Color4 {
	RED, GREEN, BLUE;
}

public class EnumSetDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		EnumSet< Color4 > es = null;            // 声明一个EnumSet对象
		System.out.println( "======== EnumSet.noneOf(Color.class) =====" );
		es = EnumSet.noneOf( Color4.class );    // 将枚举的全部类型设置到EnumSet对象之中
		es.add( Color4.RED );    // 增加内容
		es.add( Color4.GREEN );    // 增加内容
		print( es );
	}

	public static void print( EnumSet< Color4 > temp ) {    // 专门的输出操作
		for ( Color4 c : temp ) {        //  循环输出EnumSet中的内容
			System.out.print( c + "、" );
		}
		System.out.println();
	}
}
