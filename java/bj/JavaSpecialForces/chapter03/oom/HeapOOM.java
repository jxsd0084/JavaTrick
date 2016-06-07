package bj.JavaSpecialForces.chapter03.oom;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		List< String > list = new ArrayList< String >();
		while ( true ) {
			list.add( "内存溢出呀，内存溢出呀！" );
		}
	}

}
