package bj.powernode.basic.day02;

public class _13_Lab_Method {

	//  程序的入口(主方法)

	/*
	
		方法的本质: 一个可以重复利用的代码块
		
	*/
	public static void main( String[] args ) {

		System.out.println( "A" );

		System.out.println( "B" );

		System.out.println( "C" );


		print( "A" );
		print( "B" );
		print( "C" );

	}

	public static void print( String content ) {

		System.out.println( content );
	}

}
