package bj.powernode.advance.Charpter08.test2;

import bj.powernode.advance.Charpter08.test1.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void readFile() {

		FileInputStream fin = null;

		try {

			fin = new FileInputStream( "c://aaa.txt" );

		} catch ( FileNotFoundException e ) {

			e.printStackTrace();
		}

		int i = 0;

		try {

			while ( ( i = fin.read() ) != - 1 ) {

				System.out.print( (char) i );
			}

		} catch ( IOException ex ) {

			ex.printStackTrace();
		}

		try {

			fin.close();

		} catch ( IOException e ) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readFile1() {

		FileInputStream fin = null;

		try {

			// 什么情况下和着写?前面的代码和后面的代码有联系的时候,应该和着写
			fin = new FileInputStream( "c://aaa.txt" );
			int i = 0;
			while ( ( i = fin.read() ) != - 1 ) {

				System.out.print( (char) i );
			}
		}

		// 一个try后面跟多个catch的时候,异常要按照从小到大的顺序排列
		catch ( FileNotFoundException e ) {
			e.printStackTrace();

		} catch ( IOException ex ) {
			ex.printStackTrace();

		} finally {
			System.out.println( "=======================" );

			try {
				if ( fin != null ) {

					fin.close();
				}
			} catch ( IOException e ) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void readFile2() throws IOException, FileNotFoundException {

		FileInputStream fin = null;

		try {

			// 什么情况下和着写?前面的代码和后面的代码有联系的时候,应该和着写
			fin = new FileInputStream( "c://aaa.txt" );
			int i = 0;
			while ( ( i = fin.read() ) != - 1 ) {

				System.out.print( (char) i );
			}

		} finally {
			System.out.println( "=======================" );

			try {
				if ( fin != null ) {

					fin.close();
				}
			} catch ( IOException e ) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		try {

			readFile2();

		} catch ( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void test2() {

		try {

			int    j   = 10 / 0;
			Person p   = null;
			int    age = p.getAge();
			//
			Object obj = new Object();
			Person p1  = (Person) obj;

		} catch ( Exception e ) {
			e.printStackTrace();
		}

		// 一个try后面跟多个catch的时候,异常要按照从小到大的顺序排列
/*		catch ( FileNotFoundException e ) {
			e.printStackTrace();

		} catch ( IOException ex ) {
			ex.printStackTrace();
		}*/
	}

}
