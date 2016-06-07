package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._183_自定义非泛型栈结构;

public class Stack {

	private Object[] container = new Object[ 10 ];
	private int      index     = 0;

	public void push( Object o ) {

		if ( index != container.length ) {
			container[ index++ ] = o;
		}
	}

	public Object pop() {

		if ( index != - 1 ) {
			return container[ -- index ];
		}
		return null;
	}

	public boolean empty() {

		if ( index == 0 ) {
			return true;
		} else {
			return false;
		}
	}
}
