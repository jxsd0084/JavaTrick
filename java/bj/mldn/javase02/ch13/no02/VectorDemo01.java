package bj.mldn.javase02.ch13.no02;

import java.util.List;
import java.util.Vector;

public class VectorDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		List< String > allList = null;
		allList = new Vector< String >();    // 指定操作的泛型为String
		allList.add( "Hello" );              // 此方法由Collection接口而来
		allList.add( "Hello" );              // 此方法由Collection接口而来
		allList.add( 0, "World" );           // 在第一个位置上添加新的内容
		allList.add( "MLDN" );               // 向Collection中加入内容
		allList.add( "www.mldn.cn" );
		for ( int i = 0; i < allList.size(); i++ ) {
			System.out.print( allList.get( i ) + "、" );
		}
	}
}
