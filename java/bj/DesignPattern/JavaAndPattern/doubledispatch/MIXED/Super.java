package bj.DesignPattern.JavaAndPattern.doubledispatch.MIXED;

public class Super {

	/**
	 * 测试
 	 * @param args
	 */
	public void operation( Super s ) {
		System.out.println( "This is Super.operation();" );
		s.operation( this );
	}

}

