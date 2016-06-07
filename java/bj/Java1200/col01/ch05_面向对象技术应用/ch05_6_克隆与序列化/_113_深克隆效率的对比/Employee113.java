package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._113_深克隆效率的对比;

import java.io.*;

public class Employee113 implements Cloneable, Serializable {

	private static final long serialVersionUID = 3049633059823371192L;

	private String name;
	private int    age;

	public Employee113( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public int getAge() {

		return age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append( "姓名：" + name + ", " );
		sb.append( "年龄：" + age + "\n" );
		return sb.toString();
	}

	@Override
	public Employee113 clone() {

		Employee113           employee = null;
		ByteArrayOutputStream baos     = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream( baos );
			oos.writeObject( this );
			oos.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		ByteArrayInputStream bais = new ByteArrayInputStream( baos.toByteArray() );
		try {
			ObjectInputStream ois = new ObjectInputStream( bais );
			employee = (Employee113) ois.readObject();
			ois.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return employee;
	}
}
