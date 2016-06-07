package bj.DesignPattern.JavaPattern._13_原型模式.section4;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		// 产生一个对象
		Thing thing = new Thing();
		// 设置一个值
		thing.setValue( "张三" );

		// 拷贝一个对象
		Thing cloneThing = thing.clone();
		cloneThing.setValue( "李四" );
		System.out.println( thing == cloneThing );

		System.out.println( thing.getValue() );
	}

}
