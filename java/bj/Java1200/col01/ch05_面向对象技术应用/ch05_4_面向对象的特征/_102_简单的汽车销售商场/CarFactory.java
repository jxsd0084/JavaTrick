package bj.Java1200.col01.ch05_面向对象技术应用.ch05_4_面向对象的特征._102_简单的汽车销售商场;

public class CarFactory {

	public static Car getCar( String name ) {

		if ( name.equalsIgnoreCase( "BMW" ) ) {
			return new BMW();
		} else if ( name.equalsIgnoreCase( "Benz" ) ) {
			return new Benz();
		} else {
			return null;
		}
	}
}
