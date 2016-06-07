package bj.mldn.javase02.ch14.no03;

import java.util.EnumSet;

enum Color6 {
	RED, GREEN, BLUE;
}

public class EnumSetDemo05 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		EnumSet< Color6 > esOld = null;            // 声明一个EnumSet对象
		EnumSet< Color6 > esNew = null;
		System.out.println( "======== EnumSet.copyOf(Color.class) =====" );
		esOld = EnumSet.noneOf( Color6.class );    // 将枚举的全部类型设置到EnumSet对象之中
		esOld.add( Color6.RED );    // 增加内容
		esOld.add( Color6.GREEN );    // 增加内容
		esNew = EnumSet.copyOf( esOld );    // 从已有的集合拷贝过来
		print( esNew );
	}

	public static void print( EnumSet< Color6 > temp ) {    // 专门的输出操作
		for ( Color6 c : temp ) {        //  循环输出EnumSet中的内容
			System.out.print( c + "、" );
		}
		System.out.println();
	}
}
