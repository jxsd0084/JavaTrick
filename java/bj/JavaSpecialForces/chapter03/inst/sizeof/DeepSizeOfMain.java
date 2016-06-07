package bj.JavaSpecialForces.chapter03.inst.sizeof;

public class DeepSizeOfMain {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		DeepObjectSizeOf.deepSizeOf( new Integer( 1 ) );
		DeepObjectSizeOf.deepSizeOf( new String() );
		DeepObjectSizeOf.deepSizeOf( new char[ 1 ] );
	}
}

