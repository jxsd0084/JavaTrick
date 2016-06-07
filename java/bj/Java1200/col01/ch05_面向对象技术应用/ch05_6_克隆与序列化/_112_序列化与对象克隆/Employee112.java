package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._112_序列化与对象克隆;

import java.io.*;

public class Employee112 implements Cloneable, Serializable {

	private static final long serialVersionUID = 3049633059823371192L;

	private String     name;
	private int        age;
	private Address112 address;

	public Employee112( String name, int age, Address112 address ) {

		this.name = name;
		this.age = age;
		this.address = address;
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

	public Address112 getAddress() {

		return address;
	}

	public void setAddress( Address112 address ) {

		this.address = address;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append( "姓名：" + name + ", " );
		sb.append( "年龄：" + age + "\n" );
		sb.append( "地址：" + address );
		return sb.toString();
	}

	@Override
	public Employee112 clone() {

		Employee112           employee = null;
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
			employee = (Employee112) ois.readObject();
			ois.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return employee;
	}
}
