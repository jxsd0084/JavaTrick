package bj.powernode.basic.day15;

/*

	写数据到文件中

*/
import java.io.*;

public class TestDataOutputStream {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {



		// 1.创建数据输出流对象
		DataOutputStream dos = new DataOutputStream( new FileOutputStream( "D:/course/JavaProjects/day15/data" ) );



		// 2.定义数据
		long    l1 = 123456789L;
		double  d1 = 12.3;
		boolean b1 = false;




		// 3.将数据写入文件.
		dos.writeLong( l1 );
		dos.writeDouble( d1 );
		dos.writeBoolean( b1 );


		// 刷新关闭流
		dos.flush();
		dos.close();


	}

}
