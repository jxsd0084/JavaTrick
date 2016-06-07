package bj.powernode.advance.Charpter06.test5.test5;

public class Office {

	// 静态方法,返回值ICar接口,参数:String类型 job
	public static ICar getCar( String job ) {

		if ( "CEO".equals( job ) ) {

			// 创建了一个实现了ICar接口的类的对象,并且当做方法的返回值
			// return 了一个 new ICar
			return new ICar() {

				// 实现ICar接口中的run方法和stop方法
				@Override
				public void run() {

					System.out.println( "Benz在run" );
				}

				@Override
				public void stop() {

					System.out.println( "Benz在stop" );
				}
			};

		} else if ( "经理".equals( job ) ) {
			// return 了一个 new ICar
			return new ICar() {

				// 实现ICar接口中的run方法和stop方法
				@Override
				public void run() {

					System.out.println( "PST在run" );
				}

				@Override
				public void stop() {

					System.out.println( "PST在stop" );
				}
			};

		} else {

			// 如输入值无法满足条件,返回null
			return null;
		}
	}
}
