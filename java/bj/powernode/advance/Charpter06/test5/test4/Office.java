package bj.powernode.advance.Charpter06.test5.test4;

public class Office {

	// 内部类的第二个作用:将接口公开,但是将接口的实现类作为局部内部类隐藏起来,强制用户使用接口编程
	// 返回ICar接口的静态方法,参数:String类型 job
	public static ICar接口 getCar( String job ) {

		// 成员内部类Benz实现ICar接口
		class Benz implements ICar接口 {

			// 实现Icar接口的run方法
			@Override
			public void run() {

				System.out.println( "奔驰在run" );
			}

			// 实现ICar接口的stop方法
			@Override
			public void stop() {

				System.out.println( "奔驰在stop" );
			}
		}

		// 成员内部类PST实现ICar接口
		class PST implements ICar接口 {

			// 实现ICar接口的run方法
			@Override
			public void run() {

				System.out.println( "PST在run" );
			}

			// 实现Icar接口的stop方法
			@Override
			public void stop() {

				System.out.println( "PST在stop" );
			}
		}

		// if条件判断,euqals比较
		if ( "部门经理".equals( job ) ) {
			return new PST();

		} else if ( "CEO".equals( job ) ) {
			return new Benz();

		} else {
			System.out.println( job + " 有误,不能提供车辆" );
			return null;

		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 用Office调用getCar方法,由一个ICar接口的car接收,再由car调用run()方法和stop()方法
		ICar接口 car = Office.getCar( "部门经理" );

		car.run();

		car.stop();

	}

}
