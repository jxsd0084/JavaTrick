package bj.DesignPattern.JavaPattern._36_观察者模式和中介者模式.section3;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public enum EventCustomType {

	// 新建立事件
	NEW( 1 ),

	// 删除事件
	DEL( 2 ),

	// 修改事件
	EDIT( 3 ),

	// 克隆事件
	CLONE( 4 );

	private int value = 0;

	private EventCustomType( int _value ) {
		this.value = _value;
	}

	public int getValue() {
		return value;
	}

}
