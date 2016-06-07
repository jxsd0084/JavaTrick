package bj.Java1200.col01.ch05_面向对象技术应用.ch05_3_包装类的使用._097_Double类型比较;

public class DoubleTest {

	public static void main( String[] args ) {

		Double number1 = 12.3;
		Double number2 = 12.3;
		System.out.println( "number1：" + number1 );
		System.out.println( "number2：" + number2 );
		switch ( number1.compareTo( number2 ) ) {
			case - 1:
				System.out.println( "number1 < number2" );
				break;
			case 0:
				System.out.println( "number1 == number2" );
				break;
			case 1:
				System.out.println( "number1 > number2" );
				break;
		}
	}
}
