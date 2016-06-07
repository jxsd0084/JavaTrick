package bj.jakeChen.DataStructure.HashTable.ex02;

/**
 * Created by chenlong on 2016/5/26.
 */
public class MyMap < K, V > {

	private int size;                               // 当前容量
	private static int INIT_CAPACITY = 16;          // 默认容量
	private Entry< K, V >[] container;              // 实际存储数据的数组对象
	private static float LOAD_FACTOR = 0.75f;       // 装载因子
	private int max;                                // 能存的最大的数=capacity*factor

	// 自己设置容量和装载因子的构造器
	public MyMap( int init_Capaticy, float load_factor ) {
		if ( init_Capaticy < 0 ) {
			throw new IllegalArgumentException( "Illegal initial capacity: "
			                                    + init_Capaticy );
		}
		if ( load_factor <= 0 || Float.isNaN( load_factor ) ) {
			throw new IllegalArgumentException( "Illegal load factor: " + load_factor );
		}
		this.LOAD_FACTOR = load_factor;
		max = (int) ( init_Capaticy * load_factor );
		container = new Entry[ init_Capaticy ];
	}

	// 使用默认参数的构造器
	public MyMap() {
		this( INIT_CAPACITY, LOAD_FACTOR );
	}

	/**
	 * 存
	 *
	 * @param k
	 * @param v
	 * @return
	 */
	public boolean put( K k, V v ) {
		// 1.计算K的hash值
		// 因为自己很难写出对不同的类型都适用的Hash算法，故调用JDK给出的hashCode()方法来计算hash值
		int hash = k.hashCode();
		// 将所有信息封装为一个Entry
		Entry< K, V > temp = new Entry( k, v, hash );
		if ( setEntry( temp, container ) ) {
			// 大小加一
			size++;
			return true;
		}
		return false;
	}


	/**
	 * 扩容的方法
	 *
	 * @param newSize 新的容器大小
	 */
	private void reSize( int newSize ) {
		// 1.声明新数组
		Entry< K, V >[] newTable = new Entry[ newSize ];
		max = (int) ( newSize * LOAD_FACTOR );
		// 2.复制已有元素,即遍历所有元素，每个元素再存一遍
		for ( int j = 0; j < container.length; j++ ) {
			Entry< K, V > entry = container[ j ];
			// 因为每个数组元素其实为链表，所以…………
			while ( null != entry ) {
				setEntry( entry, newTable );
				entry = entry.next;
			}
		}
		// 3.改变指向
		container = newTable;

	}

	/**
	 * 将指定的结点temp添加到指定的hash表table当中
	 * 添加时判断该结点是否已经存在
	 * 如果已经存在，返回false
	 * 添加成功返回true
	 *
	 * @param temp
	 * @param table
	 * @return
	 */
	private boolean setEntry( Entry< K, V > temp, Entry[] table ) {
		// 根据hash值找到下标
		int index = indexFor( temp.hash, table.length );
		// 根据下标找到对应元素
		Entry< K, V > entry = table[ index ];
		// 3.若存在
		if ( null != entry ) {
			// 3.1遍历整个链表，判断是否相等
			while ( null != entry ) {
				// 判断相等的条件时应该注意，除了比较地址相同外，引用传递的相等用equals()方法比较
				// 相等则不存，返回false
				if ( ( temp.key == entry.key || temp.key.equals( entry.key ) ) &&
				     temp.hash == entry.hash && ( temp.value == entry.value || temp.value.equals( entry.value ) ) ) {
					return false;
				} else if ( temp.key == entry.key && temp.value != entry.value ) {
					entry.value = temp.value;
					return true;
				}

				// 不相等则比较下一个元素
				else if ( temp.key != entry.key ) {
					// 到达队尾，中断循环
					if ( null == entry.next ) {
						break;
					}
					// 没有到达队尾，继续遍历下一个元素
					entry = entry.next;
				}
			}
			// 3.2当遍历到了队尾，如果都没有相同的元素，则将该元素挂在队尾
			addEntry2Last( entry, temp );
			return true;
		}
		// 4.若不存在,直接设置初始化元素
		setFirstEntry( temp, index, table );
		return true;
	}

	private void addEntry2Last( Entry< K, V > entry, Entry< K, V > temp ) {
		if ( size > max ) {
			reSize( container.length * 4 );
		}
		entry.next = temp;

	}

	/**
	 * 将指定结点temp，添加到指定的hash表table的指定下标index中
	 *
	 * @param temp
	 * @param index
	 * @param table
	 */
	private void setFirstEntry( Entry< K, V > temp, int index, Entry[] table ) {
		// 1.判断当前容量是否超标，如果超标，调用扩容方法
		if ( size > max ) {
			reSize( table.length * 4 );
		}
		// 2.不超标，或者扩容以后，设置元素
		table[ index ] = temp;
		// ！！！！！！！！！！！！！！！
		// 因为每次设置后都是新的链表，需要将其后接的结点都去掉
		// NND，少这一行代码卡了哥哥7个小时（代码重构）
		temp.next = null;
	}

	/**
	 * 取
	 *
	 * @param k
	 * @return
	 */
	public V get( K k ) {
		Entry< K, V > entry = null;
		// 1.计算K的hash值
		int hash = k.hashCode();
		// 2.根据hash值找到下标
		int index = indexFor( hash, container.length );
		// 3。根据index找到链表
		entry = container[ index ];
		// 3。若链表为空，返回null
		if ( null == entry ) {
			return null;
		}
		// 4。若不为空，遍历链表，比较k是否相等,如果k相等，则返回该value
		while ( null != entry ) {
			if ( k == entry.key || entry.key.equals( k ) ) {
				return entry.value;
			}
			entry = entry.next;
		}
		// 如果遍历完了不相等，则返回空
		return null;

	}

	/**
	 * 根据hash码，容器数组的长度,计算该哈希码在容器数组中的下标值
	 *
	 * @param hashcode
	 * @param containerLength
	 * @return
	 */
	public int indexFor( int hashcode, int containerLength ) {
		return hashcode & ( containerLength - 1 );

	}

	/**
	 * 用来实际保存数据的内部类,因为采用挂链法解决冲突，此内部类设计为链表形式
	 *
	 * @param < K>key
	 * @param < V>
	 *          value
	 */
	class Entry < K, V > {

		Entry< K, V > next;// 下一个结点
		K             key;// key
		V             value;// value
		int           hash;// 这个key对应的hash码，作为一个成员变量，当下次需要用的时候可以不用重新计算

		// 构造方法
		Entry( K k, V v, int hash ) {
			this.key = k;
			this.value = v;
			this.hash = hash;

		}

		//相应的getter()方法

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