package bj.DesignPattern.ym_pattern.iterator.example3;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 用来实现访问Collection集合的迭代接口，为了外部统一访问方式
 */
public class CollectionIteratorImpl implements Iterator {

	/**
	 * 用来存放被迭代的聚合对象
	 */
	private PayManager aggregate = null;
	/**
	 * 用来记录当前迭代到的位置索引
	 * -1表示刚开始的时候，迭代器指向聚合对象第一个对象之前
	 */
	private int        index     = -1;

	public CollectionIteratorImpl( PayManager aggregate ) {
		this.aggregate = aggregate;
	}

	public void first() {
		index = 0;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		return null;
	}

/*	public void next(){
		if(index < this.aggregate.size()){
			index = index + 1;
		}
	}*/

	@Override
	public void remove() {

	}

	@Override
	public void forEachRemaining( Consumer action ) {

	}

	public boolean isDone() {
		if ( index == this.aggregate.size() ) {
			return true;
		}
		return false;
	}

	public Object currentItem() {
		return this.aggregate.get( index );
	}

}
