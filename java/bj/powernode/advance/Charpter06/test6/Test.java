package bj.powernode.advance.Charpter06.test6;

/**
 * String类型/Integer类型/int类型三者的互相转换
 * 关键字:valueOf();intValue();parseInt();new Integer();toString();自动装箱/自动拆箱
 *
 * @author Administrator
 */
public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {


		// ----------------------------------------------
		// 1 int --> Integer
		int i = 100; // 调用构造方法 //Integer I = new Integer(i);

		// 自动装箱 Integer I = i;
		Integer I = Integer.valueOf( i );


		// ----------------------------------------------
		// Integer-->int
		Integer I1 = 100;
		int     i2 = I1.intValue();
		int     i3 = I1;


		// ----------------------------------------------
		// int-->String
		int    i4 = 100;
		String s1 = i4 + "";
		String s2 = new Integer( i4 ).toString();


		// ----------------------------------------------
		// String-->Integer
		String  s3 = "100";
		Integer I2 = new Integer( s3 );
		Integer I3 = Integer.valueOf( s3 );


		// ----------------------------------------------
		// Integer-->String
		Integer I4 = 100;
		String  s4 = I4.toString();
		int     i5 = I4;
		String  s5 = i5 + "";


		// ----------------------------------------------
		// String-->int
		String  s6 = "100";
		int     i6 = Integer.parseInt( s6 );
		Integer I5 = Integer.valueOf( s6 );
		int     i7 = I5;

		System.out.println( "==========" );


	}

}
