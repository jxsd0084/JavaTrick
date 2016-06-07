package bj.jakeChen.DataStructure.HashTable.ex01;

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
public class TestHashTable {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		HashTable ht = new HashTable();

		ht.insert( new Info( "a", "张三" ) );
		ht.insert( new Info( "ct", "李四" ) );
		ht.insert( new Info( "wangwu", "王五" ) );

		System.out.println( ht.find( "a" ).getName() );
		System.out.println( ht.find( "ct" ).getName() );

	}

}

/*

URL:    http://kingschan.iteye.com/blog/1236793

*/
