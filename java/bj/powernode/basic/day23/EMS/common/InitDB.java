package bj.powernode.basic.day23.EMS.common;

import bj.powernode.basic.day24.EMS.entity.Administrator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * 初始化DB(绝密类)
 *
 * @author Administrator
 */
public class InitDB {

	public static void main( String[] args ) {

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream( "c:/emsdb/admin.dll" ) );
			oos.writeObject( new Administrator( "admin", "admin" ) );
			oos.flush();
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			if ( oos != null ) {
				try {
					oos.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
	}

}
