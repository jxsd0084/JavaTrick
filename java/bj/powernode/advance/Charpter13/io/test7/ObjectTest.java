package bj.powernode.advance.Charpter13.io.test7;

import java.io.*;

/**
 * 对象序列化的实质是:把对象的一些相关信息写入到文件中 读取对象的时候,读取是对象的这些信息,并且根据这些信息重新创建了一个新对象
 * 相当于克隆(深克隆)了一个对象
 *
 * @author Administrator
 */
public class ObjectTest {

	/**
	 * 写一个对象到文件中
	 */
	public static void writeObjectToFile() {

		Person  p    = new Person( 21, "张一" );
		Address addr = new Address( "河北省", "石家庄市", "中山路11号富华大厦" );
		p.setAddr( addr );

		FileOutputStream   fout = null;
		ObjectOutputStream oout = null;

		try {
			fout = new FileOutputStream( "Person.data" );
			oout = new ObjectOutputStream( fout );

			oout.writeObject( p );

			System.out.println( "写入的时候:==================" + p.hashCode() );

		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( fout != null ) {
				try {
					fout.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void readObjectFromFile() {

		FileInputStream   fin = null;
		ObjectInputStream oin = null;

		try {
			fin = new FileInputStream( "Person.data" );
			oin = new ObjectInputStream( fin );

			Person p = (Person) oin.readObject();

			System.out.println( p );
			System.out.println( "读取的时候:==================" + p.hashCode() );
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {
		// writeObjectToFile();
		readObjectFromFile();
	}
}
