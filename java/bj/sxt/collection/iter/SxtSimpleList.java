package bj.sxt.collection.iter;

/**
 * 目标:理解迭代器的原理
 * 迭代器: 遍历使用
 *
 * @author com.bj.com.bj
 */
public class SxtSimpleList {

	//数组 存储值
	private String[] elem = { "a", "b", "c" };
	//大小
	private int      size = elem.length;


	public int size() {
		return this.size;
	}

	//计数器 -->指针  游标
	private int coursor = -1;

	//判断是否存在下一个
	public boolean hasNext() {
		return coursor + 1 < size;
	}

	//获取下一个
	public String next() {
		coursor++;
		return elem[ coursor ];
	}

	//删除下一个
	public void remove() {
		//移动数组元素
		System.arraycopy( elem,
				coursor + 1, elem, coursor,
				this.size - ( coursor + 1 ) );
		//实际大小-1
		this.size--;
		//回退
		this.coursor--;
	}


	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		SxtSimpleList list = new SxtSimpleList();
		if ( list.hasNext() ) {
			System.out.println( list.next() );
			list.remove();
		}
		if ( list.hasNext() ) {
			System.out.println( list.next() );
			list.remove();
		}
		if ( list.hasNext() ) {
			System.out.println( list.next() );
			list.remove();
		}
		//先判断后获取
		if ( list.hasNext() ) { //不会获取值
			System.out.println( list.next() );
			list.remove();
		}
		System.out.println( list.size() );

		list = new SxtSimpleList();
		while ( list.hasNext() ) {
			System.out.println( list.next() );
		}

	}

}
