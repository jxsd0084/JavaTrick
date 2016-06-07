package bj.mldn.javase02.ch05.no14;

class Person2 {

	private String name;               // 姓名属性

	public Person2( String name ) {    // 通过构造方法设置内容
		this.name = name;              // 为姓名赋值
	}

	public String getName() {

		return this.name;              // 取得姓名
	}
}

public class ObjectArrayDemo02 {

	public static void main( String args[] ) {

		// 声明一个对象数组，里面有三个对象，使用静态初始化方式完成
		Person2 per[] = { new Person2( "张三" ), new Person2( "李四" ), new Person2( "王五" ) };


		System.out.println( "\n============== 数组输出 =================" );
		for ( int x = 0; x < per.length; x++ ) {    // 循环输出
			System.out.print( per[ x ].getName() + "、" );    // 此时，已经实例化完成了，所以会直接打印出姓名
		}
	}

}
