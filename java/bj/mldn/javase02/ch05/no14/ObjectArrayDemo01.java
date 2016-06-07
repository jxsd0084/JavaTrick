package bj.mldn.javase02.ch05.no14;

class Person1 {

	private String name;               // 姓名属性

	public Person1( String name ) {    // 通过构造方法设置内容
		this.name = name;              // 为姓名赋值
	}

	public String getName() {

		return this.name;              // 取得姓名
	}
}

public class ObjectArrayDemo01 {

	public static void main( String args[] ) {

		// 类名称 数组名称[] = new 类名称[长度]
		Person1 per[] = new Person1[ 3 ];    // 开辟了三个空间大小的数组


		System.out.println( "============== 数组声明 =================" );
		// 对象数组初始化之前，每一个元素都是默认值
		for ( int x = 0; x < per.length; x++ ) {    // 循环输出
			System.out.print( per[ x ] + "、" );    // 因为只是开辟好了空间，所以都是默认值
		}


		// 分别为数组中的每个元素初始化，每一个都是对象，都需要单独实例化	
		per[ 0 ] = new Person1( "张三" );    // 实例化第一个元素
		per[ 1 ] = new Person1( "李四" );    // 实例化第二个元素
		per[ 2 ] = new Person1( "王五" );    // 实例化第三个元素


		System.out.println( "\n============== 对象实例化 =================" );
		for ( int x = 0; x < per.length; x++ ) {    // 循环输出
			System.out.print( per[ x ].getName() + "、" );    // 此时，已经实例化完成了，所以会直接打印出姓名
		}
	}

}
