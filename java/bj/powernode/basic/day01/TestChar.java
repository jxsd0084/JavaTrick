package bj.powernode.basic.day01;

public class TestChar {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//  1.如何声明一个char类型的变量
		char c1 = 'a';
		
		/*

		  在计算机中为什么有不同的数据类型？

			byte,short,int,long,float,double,boolean,char
			
		  八种基本类型的本质区别：在内存中所占据的空间大小、结构不同。
		  
		  一个字节 8 位. (1 byte 8 bit)
		  
		  记忆:java中的字符采用了 Unicode编码方式.(Unicode是全球语言的统一编码方式.)
		  
		  常见的编码方式: GBK,GB2312,GB18030,UTF-8,UTF-16

		*/

		/*

		  char类型占用两个字节.(16位.)

		  char类型可以用来存储一个汉字

		  一个汉字是占有两个字节,为什么?   二进制:16
		*/
		char c2 = '中';

		System.out.println( c2 );

		char c = '\u0061';

	}

}
	
