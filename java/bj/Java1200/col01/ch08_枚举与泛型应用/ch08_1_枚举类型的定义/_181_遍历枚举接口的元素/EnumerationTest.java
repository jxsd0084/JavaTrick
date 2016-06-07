package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_1_枚举类型的定义._181_遍历枚举接口的元素;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 遍历枚举接口的元素
 */
public class EnumerationTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Vector< Integer > vector = new Vector< Integer >();
		for ( int i = 0; i < 3; i++ ) {
			vector.add( i );
			System.out.println( "在向量中增加元素：" + i );
		}

		Enumeration< Integer > e = vector.elements();
		while ( e.hasMoreElements() ) {
			System.out.println( "获得向量中的元素：" + e.nextElement() );
		}
	}

}
