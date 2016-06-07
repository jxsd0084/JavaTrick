package bj.mldn.javase02.ch14.no01;

interface Color2 {

	public static final int RED = 1;    // 定义红色

	public static final int GREEN = 2;    // 定义绿色

	public static final int BLUE = 3;    // 定义蓝色
}

public class ColorDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		System.out.println( Color2.RED + Color2.GREEN );    // 颜色相加
	}
}
