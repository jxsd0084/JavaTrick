package bj.jakeChen.DataStructure.HashTable.ex02;

/**
 * Created by chenlong on 2016/5/26.
 */
public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		MyMap< String, String > mm         = new MyMap< String, String >();
		Long                    aBeginTime = System.currentTimeMillis();    // 记录BeginTime
		for ( int i = 0; i < 1000000; i++ ) {
			mm.put( "" + i, "" + i * 100 );
		}

		Long aEndTime = System.currentTimeMillis();                         // 记录EndTime
		System.out.println( "insert time -> " + ( aEndTime - aBeginTime ) );

		Long lBeginTime = System.currentTimeMillis();                       // 记录BeginTime
		mm.get( "" + 100000 );

		Long lEndTime = System.currentTimeMillis();                         // 记录EndTime
		System.out.println( "seach time -> " + ( lEndTime - lBeginTime ) );

	}

}

/*

URL:    http://blog.csdn.net/jzhf2012/article/details/8560307



 探讨Hash表中的一些原理/概念，及根据这些原理/概念，自己设计一个用来存放/查找数据的Hash表，并且与JDK中的HashMap类进行比较。

我们分一下七个步骤来进行。
一. Hash表概念
二. Hash构造函数的方法，及适用范围
三. Hash处理冲突方法，各自特征
四. Hash查找过程
五. 实现一个使用Hash存数据的场景--Hash查找算法，插入算法
六. JDK中HashMap的实现
七. Hash表与HashMap的对比，性能分析

一. Hash表概念
   在Hash表中，记录在表中的位置和其关键字之间存在着一种确定的关系。这样 我们就能预先知道所查关键字在表中的位置，从而直接通过下标找到记录。

1) 哈希(Hash)函数是一个映象，即： 将关键字的集合映射到某个地址集合上，它的设置很灵活，
只要这个地址集合的大小不超出允许范围即可；
2) 由于哈希函数是一个压缩映象，因此，在一般情况下，很容易产生“冲突”现象，
即： key1!=key2，而 f (key1) = f(key2)。
3). 只能尽量减少冲突而不能完全避免冲突，这是因为通常关键字集合比较大，其元素包括所有可能的关键字，
而地址集合的元素仅为哈希表中的地址值.在构造这种特殊的“查找表” 时，除了需要选择一个“好”(尽可能少产生冲突)
的哈希函数之外；还需要找到一 种“处理冲突” 的方法。

二. Hash构造函数的方法，及适用范围
直接定址法
数字分析法
平方取中法
折叠法
除留余数法
随机数法

（1）直接定址法：
    哈希函数为关键字的线性函数，H(key) = key 或者 H(key) = a * key + b

（2）数字分析法：
    假设关键字集合中的每个关键字都是由 s 位数字组成 (u1, u2, …, us)，分析关键字集中的全体，
并从中提取分布均匀的若干位或它们的组合作为地址。
此法适于:能预先估计出全体关键字的每一位上各种数字出现的频度。

（3）平方取中法：
    以关键字的平方值的中间几位作为存储地址。求“关键字的平方值” 的目的是“扩大差别” ，
同 时平方值的中间各位又能受到整个关键字中各位的影响。

（4）折叠法：
    将关键字分割成若干部分，然后取它们的叠加和为哈希地址。两种叠加处理的方法：移位叠加:
将分割后的几部分低位对齐相加；间界叠加:从一端沿分割界来回折叠，然后对齐相加。
此法适于：关键字的数字位数特别多。

（5）除留余数法：
    设定哈希函数为:H(key) = key MOD p ( p≤m )，其中， m为表长，p 为不大于 m 的素数，或 是不含 20 以下的质因子

（6）随机数法：
    设定哈希函数为:H(key) = Random(key)其中，Random 为伪随机函数
    实际造表时，采用何种构造哈希函数的方法取决于建表的关键字集合的情况(包括关键字的范围和形态)，
以及哈希表长度（哈希地址范围），总的原则是使产生冲突的可能性降到尽可能地小。

*/
