package bj.powernode.basic.day03;

public class Lab03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		java.util.Scanner s = new java.util.Scanner( System.in );

		//  接收用户输入性别
		System.out.print( "请输入性别：" );
		int sex = s.nextInt();


		//  接收用户输入的身高
		System.out.print( "请输入身高：" );
		double height = s.nextDouble();


		//  接收用户输入的体重
		System.out.print( "请输入体重：" );
		double weight = s.nextDouble();

		//  System.out.println("性别："+ (sex==1?"男":"女"));
		//  System.out.println("身高："+height+"cm");
		//  System.out.println("体重："+weight+"kg");

		String result = "";

		if ( sex == 1 ) {
			result = Lab03.compare( weight, height, 105 );

		} else {
			result = Lab03.compare( weight, height, 115 );

		}

		System.out.println( result );

	}

	//  定义方法
	public static String compare( double weight, double height, int i ) {

		double standWeight = height - i;

		if ( ( weight >= standWeight && weight - standWeight < 5 )
		     || ( weight <= standWeight && standWeight - weight < 5 ) ) {

			return "标准";

		} else if ( weight > standWeight ) {
			return "肥胖";

		} else {
			return "偏瘦";

		}

	}

}
