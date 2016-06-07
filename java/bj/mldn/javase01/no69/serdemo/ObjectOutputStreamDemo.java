package bj.mldn.javase01.no69.serdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		File               file = new File( "d:" + File.separator + "person.ser" );
		ObjectOutputStream oos  = null;
		oos = new ObjectOutputStream( new FileOutputStream( file ) );
		Person per = new Person( "张三", 30 );
		oos.writeObject( per );
		oos.close();
	}

}
