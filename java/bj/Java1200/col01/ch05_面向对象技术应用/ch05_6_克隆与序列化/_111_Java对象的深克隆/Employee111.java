package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._111_Java对象的深克隆;

public class Employee111 implements Cloneable {

	private String     name;
	private int        age;
	private Address111 address;

	public Employee111( String name, int age, Address111 address ) {

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

	public Address111 getAddress() {

		return address;
	}

	public void setAddress( Address111 address ) {

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
	public Employee111 clone() {

		Employee111 employee = null;
		try {
			employee = (Employee111) super.clone();
			employee.address = address.clone();
		} catch ( CloneNotSupportedException e ) {
			e.printStackTrace();
		}
		return employee;
	}
}
