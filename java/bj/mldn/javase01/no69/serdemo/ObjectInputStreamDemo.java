package bj.mldn.javase01.no69.serdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		File              file = new File( "d:" + File.separator + "person.ser" );
		ObjectInputStream ois  = null;
		ois = new ObjectInputStream( new FileInputStream( file ) );
		Object obj = ois.readObject();
		Person per = (Person) obj;
		System.out.println( per );
	}

}
