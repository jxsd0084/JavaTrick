package bj.mldn.javase01.no77.Collection.collectiondemo.setdemo;

import java.util.HashSet;
import java.util.Set;

public class HashSetPersonAddDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Set< Person > allSet = new HashSet< Person >();
		allSet.add( new Person( "张三", 30 ) ); // 增加重复元素
		allSet.add( new Person( "李四", 30 ) ); // 增加重复元素
		allSet.add( new Person( "王五", 31 ) ); // 增加重复元素
		allSet.add( new Person( "赵六", 32 ) ); // 增加重复元素
		allSet.add( new Person( "孙七", 32 ) ); // 增加重复元素
		allSet.add( new Person( "孙七", 32 ) ); // 增加重复元素
		System.out.println( allSet );
	}

}
