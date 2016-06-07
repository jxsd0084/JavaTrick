package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._114_transient关键字的作用;

public class Test114 {

	public static void main( String[] args ) {

		Login114 login1 = new Login114( "mingrisoft", "mr" );
		System.out.println( "输出原始对象的信息：" );
		System.out.println( login1 );
		System.out.println( "输出克隆对象的信息：" );
		Login114 login2 = login1.clone();
		System.out.println( login2 );
	}

}
