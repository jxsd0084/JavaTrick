package bj.powernode.basic.day05;

public class _04_Lab {

	//  在java代码中还有一部分代码叫做 "静态语句块"

	//  静态语句块什么时候执行？ 类被装在到JVM中的时刻,static语句块执行.

	//  静态语句块在整个程序中执行几次？ 有且仅有一次。(因为类只加载一次)
	static {

		System.out.println( "static executing." );
	}


	//  在java代码中还有一部分代码叫做 "实例语句块"

	//  实例语句块什么时候执行? 构造方法被调用的时刻执行.

	//  每执行一次构造方法,实例语句块必然执行一次.
	{
		System.out.println( "实例语句块执行." );
	}

	//  无参构造方法
	public _04_Lab() {

		System.out.println( "_04_Lab 类型的对象被创建." );
	}


	//  主方法
	public static void main( String[] args ) {

		_04_Lab lab1 = new _04_Lab();  //   执行缺省构造器

		_04_Lab lab2 = new _04_Lab();

	}

}
