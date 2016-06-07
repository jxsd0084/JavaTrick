package bj.powernode.advance.Charpter05.test6;

// 简单工厂模式
public class Office {

	public static Car getCar( String job ) {

		if ( "部门经理".equals( job ) ) {
			return new PST();

		} else if ( "CEO".equals( job ) ) {
			return new Benz();

		} else {
			System.out.println( "职务有误,不能提供车辆" );
			return null;

		}

	}

}
