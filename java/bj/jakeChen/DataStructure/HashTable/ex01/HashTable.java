package bj.jakeChen.DataStructure.HashTable.ex01;

import java.math.BigInteger;

/**
 * Created by chenlong on 2016/5/26.
 */

/*

哈希表

1.什么是哈希表？
    哈希表是一种数据结构，它提供了快速的插入操作和查找操作。其基于数组来实现。

2.哈希化
    1)直接将关键字作为索引。
    2)将单词转换成索引。
        <1>将字母转换成ASCII码，然后进行相加
        <2>幂的连乘
        <3>压缩可选值

3.压缩后仍然可能出现的问题。
    冲突：不能保证每个单词都映射到数组的空白单元。
    解决办法：
        <1>开放地址法
        <2>链地址法

*/
public class HashTable {

	private Info[] arr;

	/**
	 * 默认的构造方法
	 */
	public HashTable() {
		arr = new Info[ 100 ];
	}

	/**
	 * 指定数组初始化大小
	 */
	public HashTable( int maxSize ) {
		arr = new Info[ maxSize ];
	}

	/**
	 * 插入数据
	 */
	public void insert( Info info ) {
		arr[ hashCode( info.getKey() ) ] = info;
	}

	/**
	 * 查找数据
	 */
	public Info find( String key ) {
		return arr[ hashCode( key ) ];
	}

	public int hashCode( String key ) {
		// int hashVal = 0;
		// for(int i = key.length() - 1; i >= 0; i--) {
		//     int letter = key.charAt(i) - 96;
		//     hashVal += letter;
		// }
		// return hashVal;

		BigInteger hashVal = new BigInteger( "0" );
		BigInteger pow27   = new BigInteger( "1" );

		for ( int i = key.length() - 1; i >= 0; i-- ) {
			int        letter  = key.charAt( i ) - 96;
			BigInteger letterB = new BigInteger( String.valueOf( letter ) );
			hashVal = hashVal.add( letterB.multiply( pow27 ) );
			pow27 = pow27.multiply( new BigInteger( String.valueOf( 27 ) ) );
		}
		return hashVal.mod( new BigInteger( String.valueOf( arr.length ) ) ).intValue();
	}

}

/*

URL:    http://kingschan.iteye.com/blog/1236793

*/
