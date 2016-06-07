package bj.powernode.advance.Charpter15.test1;

import java.io.*;
import java.sql.*;

public class Person implements Serializable {

	private static final long serialVersionUID = - 582373395192720901L;
	private              int  age              = 100;

	// 定制序列化的第二中方式:对于敏感数据,不要进行序列化
	private /* transient */ String name;

	/**
	 * 用transient修饰根本就无法序列化的字段,避免NotSerializableException
	 */
	private transient Object obj = new Object();

	private int getAge() {

		return age;
	}

	void setAge( int age ) {

		this.age = age;
	}

	protected String getName() {

		return name;
	}

	public void setName( int age, String name ) throws IOException {

		this.name = name;
	}

	private int fun1( String name, int age ) {

		System.out.println( "Person类私有的fun1方法被调用 name=" + name + " age=" + age );
		return 10;
	}

	@Override
	public String toString() {

		return "Person信息: name=" + name + " age=" + age;
	}

	private String reverse( String s ) {

		StringBuffer strb = new StringBuffer( s );
		return strb.reverse().toString();
	}

	/**
	 * 实现定制序列化的写方法
	 *
	 * @param out
	 * @throws IOException
	 */
	// private void writeObject(java.io.ObjectOutputStream out) throws
	// IOException {
	// out.writeInt(age);
	// name = this.reverse(name);
	// out.writeObject(name);
	// out.writeObject(addr);
	// }

	/**
	 * 实现定制序列化读取的方法
	 *
	 * @param in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	// private void readObject(java.io.ObjectInputStream in) throws IOException,
	// ClassNotFoundException {
	// age = in.readInt();
	// name = (String) in.readObject();
	// name = this.reverse(name);
	// addr = (Address) in.readObject();
	// }
	public Person() throws IOException {

	}

	private Person( String name, int age ) throws IOException, SQLException {

		super();
		this.age = age;
		this.name = name;
	}

	public Person( int age, String name )/* throws IOException, SQLException*/ {

		super();
		this.age = age;
		this.name = name;
	}
}
