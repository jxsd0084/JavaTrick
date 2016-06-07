package bj.powernode.advance.Charpter05.test3;

public class Studnet {

	private String name;

	public Studnet( String name ) {

		super();
		this.name = name;
	}

	protected void finalize() throws Throwable {

		System.out.println( name + "===============的finalize被调用" );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Runtime r = Runtime.getRuntime();

		System.out.println( "=============初始内存:" + r.freeMemory() );

		Studnet s1  = new Studnet( "张1" );
		Studnet s2  = new Studnet( "张2" );
		Studnet s3  = new Studnet( "张3" );
		Studnet s4  = new Studnet( "张4" );
		Studnet s5  = new Studnet( "张5" );
		Studnet s6  = new Studnet( "张6" );
		Studnet s7  = new Studnet( "张7" );
		Studnet s8  = new Studnet( "张8" );
		Studnet s9  = new Studnet( "张9" );
		Studnet s10 = new Studnet( "张10" );

		System.out.println( "=============创建对象之后内存:" + r.freeMemory() );

		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		s5 = null;
		s6 = null;
		s7 = null;
		s8 = null;
		s9 = null;

		//r.gc();
		System.gc();


		System.out.println( "=============回收对象之后内存:" + r.freeMemory() );

		System.out.println( "" );

	}

}
