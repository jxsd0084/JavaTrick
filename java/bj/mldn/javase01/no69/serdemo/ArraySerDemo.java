package bj.mldn.javase01.no69.serdemo;

import java.io.*;

public class ArraySerDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		Person per[] = {
				new Person( "张三", 30 ), new Person( "李四", 31 ),
				new Person( "王五", 32 )
		};
		ser( per );
		Person p[] = (Person[]) dser();
		print( p );
	}

	public static void ser( Object obj ) throws Exception {

		File               file = new File( "d:" + File.separator + "person.ser" );
		ObjectOutputStream oos  = null;
		oos = new ObjectOutputStream( new FileOutputStream( file ) );
		oos.writeObject( obj );
		oos.close();
	}

	public static Object dser() throws Exception {

		Object            temp = null;
		File              file = new File( "d:" + File.separator + "person.ser" );
		ObjectInputStream ois  = null;
		ois = new ObjectInputStream( new FileInputStream( file ) );
		temp = ois.readObject();
		return temp;
	}

	public static void print( Person per[] ) {

		for ( Person p : per ) {
			System.out.println( p );
		}
	}
}
