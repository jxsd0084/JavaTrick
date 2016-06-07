package bj.powernode.basic.day15;
/*

	将文件中的数据恢复到内存

*/

import java.io.*;

public class TestDataInputStream {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 1.创建数据输入流对象
		DataInputStream dis = new DataInputStream( new FileInputStream( "D:/course/JavaProjects/day15/data" ) );


		// 2.读数据.
		// 按照当时写的顺序来读取.
		long    l1 = dis.readLong();
		double  d1 = dis.readDouble();
		boolean b1 = dis.readBoolean();

		System.out.println( l1 );
		System.out.println( d1 );
		System.out.println( b1 );

		dis.close();

	}

}
