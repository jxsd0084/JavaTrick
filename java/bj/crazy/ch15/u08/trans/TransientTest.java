package bj.crazy.ch15.u08.trans;

import java.io.*;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TransientTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		ObjectOutputStream oos = null;
		ObjectInputStream  ois = null;

		try {

			// 创建一个ObjectOutputStream输入流
			oos = new ObjectOutputStream(
					new FileOutputStream( "transient.txt" ) );

			Person per = new Person( "孙悟空", 500 );

			// 系统会per对象转换字节序列并输出
			oos.writeObject( per );





			// 创建一个ObjectInputStream输入流
			ois = new ObjectInputStream(
					new FileInputStream( "transient.txt" ) );

			Person p = (Person) ois.readObject();

			System.out.println( p.getAge() );


		} catch ( Exception ex ) {

			ex.printStackTrace();
		} finally {
			try {

				if ( ois != null ) {
					ois.close();
				}

				if ( oos != null ) {
					oos.close();
				}

			} catch ( IOException ex ) {

				ex.printStackTrace();
			}
		}
	}
}
