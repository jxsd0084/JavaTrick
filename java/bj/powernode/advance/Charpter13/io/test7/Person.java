package bj.powernode.advance.Charpter13.io.test7;

import java.io.IOException;
import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = - 582373395192720901L;

	private int age;

	// 定制序列化的第二中方式:对于敏感数据,不要进行序列化
	private /* transient */ String name;

	private Address addr;

	/**
	 * 用transient修饰根本就无法序列化的字段,避免NotSerializableException
	 */
	private transient Object obj = new Object();

	public Address getAddr() {

		return addr;
	}

	public void setAddr( Address addr ) {

		this.addr = addr;
	}

	public int getAge() {

		return age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	@Override
	public String toString() {

		return "Person信息: name=" + name + " age=" + age + " addr=" + addr
		       + " obj=" + obj;
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
	public Person() {

	}

	public Person( int age, String name ) {

		super();
		this.age = age;
		this.name = name;
	}
}
