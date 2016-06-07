package bj.mldn.javase02.ch13.no02;

import java.util.Vector;

public class VectorDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Vector< String > allList = null;
		allList = new Vector< String >();    // 指定操作的泛型为String
		allList.addElement( "Hello" );       // 此方法由Collection接口而来
		allList.addElement( "MLDN" );        // 向Collection中加入内容
		allList.addElement( "www.mldn.cn" );
		for ( int i = 0; i < allList.size(); i++ ) {
			System.out.print( allList.get( i ) + "、" );
		}
	}
}
