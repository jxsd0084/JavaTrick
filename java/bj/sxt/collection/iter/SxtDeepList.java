package bj.sxt.collection.iter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 目标:深入迭代器的原理  -->一个容器 可以 创建多个迭代对象
 * 途径: 使用了 内部类  |匿名内部类
 * <p>
 * 深入
 * 1、使用内部类  实现迭代器
 * 2、使用Iterable 实现foreach迭代
 * 3、加入末尾添加元素的方法
 *
 * @author com.bj.com.bj
 */
public class SxtDeepList implements Iterable {

	private String[] elem = new String[ 5 ]; // 数组 存储值
	private int      size = 0;             // 实际大小

	public int size() {
		return this.size;
	}

	/**
	 * 在末尾添加元素
	 *
	 * @param ele
	 */
	public void add( String ele ) {
		if ( this.size == elem.length ) { // 容量不够 --> 扩容
			elem = Arrays.copyOf( elem, elem.length + 5 );
		}

		elem[ size ] = ele; // 数组中加入元素 最后
		size++;           // 实际大小+1
	}

	// 内部类
	private class MyIter implements Iterator {

		// 计数器 --> 指针  游标
		private int coursor = -1;

		// 判断是否存在下一个
		public boolean hasNext() {
			return coursor + 1 < size;
		}

		// 获取下一个
		public String next() {
			coursor++;
			return elem[ coursor ];
		}

		// 删除下一个
		public void remove() {
			// 移动数组元素
			System.arraycopy( elem,
					coursor + 1, elem, coursor,
					/*SxtDeepList.this.*/size - ( coursor + 1 ) );
			// 实际大小 - 1
			/*SxtDeepList.this.*/
			size--;
			// 回退
			this.coursor--;
		}

	}

	public Iterator iterator1() {
		return new MyIter();
	}

	public Iterator iterator2() {
		class MyIter implements Iterator {

			// 计数器 -->指针  游标
			private int coursor = -1;

			// 判断是否存在下一个
			public boolean hasNext() {
				return coursor + 1 < size;
			}

			// 获取下一个
			public String next() {
				coursor++;
				return elem[ coursor ];
			}

			// 删除下一个
			public void remove() {
				// 移动数组元素
				System.arraycopy( elem,
						coursor + 1, elem, coursor,
						/*SxtDeepList.this.*/size - ( coursor + 1 ) );
				// 实际大小-1
				/*SxtDeepList.this.*/
				size--;
				//回退
				this.coursor--;
			}

		}
		return new MyIter();
	}


	public Iterator iterator() {
		return new Iterator() { // 创建Iterator迭代器接口 实现类(没有名称)的对象
			// 计数器 --> 指针  游标
			private int coursor = -1;

			// 判断是否存在下一个
			public boolean hasNext() {
				return coursor + 1 < size;
			}

			// 获取下一个
			public String next() {
				coursor++;
				return elem[ coursor ];
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
		SxtDeepList list = new SxtDeepList();
		list.add( "a" );
		list.add( "b" );
		list.add( "c1" );
		list.add( "c2" );
		list.add( "c3" );
		list.add( "c4" );
		list.add( "c5" );
		Iterator it = list.iterator();
		while ( it.hasNext() ) { // 先判断 后获取
			System.out.println( it.next() );
			// it.remove();
		}
		System.out.println( list.size() );
		for ( Object str : list ) {
			System.out.println( str );
		}

		ArrayList list2 = new ArrayList();
		list2.add( "a" );
		list2.add( "a" );
		list2.add( "a" );
		for ( Object obj : list2 ) { // foreach
			System.out.println( obj );
		}
	}

}
