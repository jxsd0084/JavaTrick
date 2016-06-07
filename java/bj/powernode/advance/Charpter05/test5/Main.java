package bj.powernode.advance.Charpter05.test5;

public class Main {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

//		Car car  = new Car(); // 注意: Car是抽象类, 不能实例化

		QQ  car2 = new QQ();
		car2.setName( "大奔" );

		// 抽象类虽然不能直接实例化,但是可以用来声明引用,指向一个子类的对象
		// 用基类的引用指向子类的对象,就是运行时多态
		// 运行时多态,主要出现在方法的参数中,方法的返回值当中
		Car car3 = new QQ();

	}

}
