package bj.powernode.advance.Charpter06.test5.test5;

/**
 * 本例主题:匿名内部类
 */
public class Main {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建Person类对象
		Person p = new Person();

		// 匿名内部类一定是实现一个接口或继承一个抽象类的

		// 该类只会使用一次,所以没有类的声明,称为匿名内部类

		// 匿名内部类有两种表现形式

		// 1.出现在方法的参数中
		// 2.出现在方法的返回值中

		// 注意:匿名内部类没有构造方法

		// 创建了一个实现了ICar接口的类的对象,当做参数传递给drive方法
		p.drive(

				// 在方法的参数列表中new了一个ICar并且实现了接口中的run方法和stop方法
				new ICar() {

					@Override
					public void run() {

						System.out.println( "Benz在run" );
					}

					@Override
					public void stop() {

						System.out.println( "Benz在stop" );
					}
				} );

	}

}
