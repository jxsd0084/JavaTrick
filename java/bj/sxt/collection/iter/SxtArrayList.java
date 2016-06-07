package bj.sxt.collection.iter;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 目标:使用泛型 ，可以操纵多个类型
 *
 * @author com.bj.com.bj
 */
public class SxtArrayList < E > implements Iterable< E > {

	private Object[] elem = new Object[ 5 ];  // 数组 存储值
	private int      size = 0;              // 实际大小

	public int size() {
		return this.size;
	}

	/**
	 * 在末尾添加元素
	 *
	 * @param ele
	 */
	public void add( E ele ) {
		if ( this.size == elem.length ) { // 容量不够 --> 扩容
			elem = Arrays.copyOf( elem, elem.length + 5 );
		}
		elem[ size ] = ele; // 数组中加入元素 最后
		size++;           // 实际大小+1
	}

	public Iterator< E > iterator() {
		return new Iterator< E >() { // 创建Iterator迭代器接口 实现类(没有名称)的对象
			// 计数器 --> 指针  游标
			private int coursor = -1;

			// 判断是否存在下一个
			public boolean hasNext() {
				return coursor + 1 < size;
			}

			// 获取下一个
			public E next() {
				coursor++;
				return (E) elem[ coursor ];
			}

			// 删除下一个
			public void remove() {
				// 移动数组元素
				System.arraycopy( elem,
						coursor + 1, elem, coursor,
						size - ( coursor + 1 ) );
				// 实际大小-1
				size--;
				// 回退
				this.coursor--;
			}

		};
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		SxtArrayList< Integer > list = new SxtArrayList< Integer >();
		list.add( 1 ); // int --> Integer
		list.add( 2 );
		for ( Integer e : list ) {
			System.out.println( e );
		}

		System.out.println( "----------------" );
		SxtArrayList< String > list2 = new SxtArrayList< String >();
		list2.add( "马云" );
		list2.add( "马化腾" );
		list2.add( "马士兵" );
		list2.add( "弼马温" );

		Iterator< String > it = list2.iterator();
		while ( it.hasNext() ) {
			String e = it.next();
			System.out.println( e );
		}
	}

}
