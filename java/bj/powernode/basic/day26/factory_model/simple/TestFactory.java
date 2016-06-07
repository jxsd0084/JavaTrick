package bj.powernode.basic.day26.factory_model.simple;

public class TestFactory {

	public static void main( String[] args ) {

		/**
		 * 通过某类型的工厂生产某一个类型的对象
		 *
		 * 1.工厂最基本的作用:隐藏构造方法实现细节
		 */
		Person p1 = PersonFactory.getPerson();
		Person p2 = PersonFactory.getPerson();
		Person p3 = PersonFactory.getPerson();
		Person p4 = PersonFactory.getPerson();
		Person p5 = PersonFactory.getPerson();

		System.out.println( p1 );
		System.out.println( p2 );
		System.out.println( p3 );
		System.out.println( p4 );
		System.out.println( p5 );

	}

}
