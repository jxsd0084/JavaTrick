package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._184_使用泛型实现栈结构;

import java.util.LinkedList;

public class Stack < T > {

	private LinkedList< T > container = new LinkedList< T >();

	public void push( T t ) {

		container.addFirst( t );
	}

	public T pop() {

		return container.removeFirst();
	}

	public boolean empty() {

		return container.isEmpty();
	}

}
