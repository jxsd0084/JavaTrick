package bj.sxt.generic.gen03;

import java.util.ArrayList;
import java.util.List;

/**
 * ? -->通配符，类型不确定，用于声明变量|形参上
 * 不能用在
 * 1、创建对象
 * 2、创建泛型类 泛型方法 泛型接口上
 *
 * @author com.bj.com.bj
 */
public class WildcardsTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 声明
		List< ? > list = new ArrayList< Integer >();
		list = new ArrayList< String >();
		list = new ArrayList< Object >();
		test( list );

		// 编译错误 不能创建对象
		// list =new ArrayList<?>();

	}

	public static void test( List< ? > list ) {

	}

	/*
	// 不能用在泛型方法上
	public static <?> void test2(List<?> list){

	}
	*/
	class Test < T > {

	}
	/*
	 // 不能用在创建泛型类
	class Test2<?>{

	}
	*/

}

