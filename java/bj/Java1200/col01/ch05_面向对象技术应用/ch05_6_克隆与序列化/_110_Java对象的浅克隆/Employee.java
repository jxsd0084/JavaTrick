package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._110_Java对象的浅克隆;

public class Employee implements Cloneable {

	private String  name;
	private int     age;
	private Address address;

	public Employee( String name, int age, Address address ) {

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

	public Address getAddress() {

		return address;
	}

	public void setAddress( Address address ) {

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
	public Employee clone() {

		Employee employee = null;
		try {
			employee = (Employee) super.clone();
		} catch ( CloneNotSupportedException e ) {
			e.printStackTrace();
		}
		return employee;
	}
}
