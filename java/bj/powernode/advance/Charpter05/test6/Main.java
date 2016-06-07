package bj.powernode.advance.Charpter05.test6;

public class Main {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		QQ     car = new QQ();
		Person p   = new Person();
		p.drive( car );

		// 抽象类虽然不能直接实例化,但是可以用来声明引用,指向一个子类的对象
		// 用基类的引用指向子类的对象,就是运行时多态
		// 运行时多态,主要出现在方法的参数中,方法的返回值当中
		Car    car2 = new Benz();
		Person p2   = new Person();
		p2.drive( car2 );



		Person p3   = new Person();
		Car    car3 = Office.getCar( null );
		if ( car3 != null ) {

			p3.drive( car3 );
		}

	}

}
