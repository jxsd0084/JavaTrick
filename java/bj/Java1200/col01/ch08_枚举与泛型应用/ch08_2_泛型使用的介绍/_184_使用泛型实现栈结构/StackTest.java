package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._184_使用泛型实现栈结构;

/**
 * 使用泛型实现栈结构
 */
public class StackTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Stack< String > stack = new Stack< String >();

		System.out.println( "向栈中增加字符串：" );
		System.out.println( "视频学Java" );
		System.out.println( "细说Java" );
		System.out.println( "Java从入门到精通(第2版)" );

		stack.push( "视频学Java" );  //向栈中增加字符串
		stack.push( "细说Java" );   //向栈中增加字符串
		stack.push( "Java从入门到精通(第2版)" ); //向栈中增加字符串

		System.out.println( "从栈中取出字符串：" );
		while ( ! stack.empty() ) {
			System.out.println( (String) stack.pop() );//删除栈中全部元素并进行输出
		}

	}

}

