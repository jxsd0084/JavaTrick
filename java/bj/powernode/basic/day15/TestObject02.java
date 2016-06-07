package bj.powernode.basic.day15;

import java.io.*;


/*

	从存储对象的文件中恢复对象到内存

*/

public class TestObject02 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 1.创建ObjectInputStream对象
		FileInputStream   fis = new FileInputStream( "D:/course/JavaProjects/day15/users.dll" );
		ObjectInputStream ois = new ObjectInputStream( fis );



		// 2.读取对象
		Object obj = ois.readObject();

		if ( obj instanceof User ) {

			User u = (User) obj;

			System.out.println( u.getUsername() + "\t" + u.getPassword() );
		}


		ois.close();

	}

}
