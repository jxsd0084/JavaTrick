package bj.mldn.javase02.ch05.no06;

public class StringDemo10 {

	public static void main( String args[] ) {

		String str1 = "LiXingHua";          // 声明字符串对象
		for ( int i = 0; i < 100; i++ ) {   // 循环修改内容
			str1 += i;                      // 字符串的引用不断改变
		}
		System.out.println( str1 );
	}

}
