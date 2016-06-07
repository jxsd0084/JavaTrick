package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._122_静态内部类的简单应用;

public class Test {

	public static void main( String[] args ) {

		double[] array = new double[ 5 ];
		for ( int i = 0; i < array.length; i++ ) {
			array[ i ] = 100 * Math.random();
		}
		System.out.println( "源数组：" );
		for ( int i = 0; i < array.length; i++ ) {
			System.out.println( array[ i ] );
		}
		System.out.println( "最大值：" + MaxMin.getResult( array ).getMax() );
		System.out.println( "最小值：" + MaxMin.getResult( array ).getMin() );
	}
}
