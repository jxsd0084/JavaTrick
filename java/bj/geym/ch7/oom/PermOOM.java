package bj.geym.ch7.oom;


import bj.geym.ch2.perm.CglibBean;

import java.util.HashMap;

/**
 * refs to geym.jvm.ch3.perm
 *
 * @author Geym
 */
public class PermOOM {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		try {
			for ( int i = 0; i < 100000; i++ ) {
				CglibBean bean = new CglibBean( "geym.jvm.ch3.perm.bean" + i, new HashMap() );
			}
		} catch ( Error e ) {
			e.printStackTrace();
		}
	}
}
