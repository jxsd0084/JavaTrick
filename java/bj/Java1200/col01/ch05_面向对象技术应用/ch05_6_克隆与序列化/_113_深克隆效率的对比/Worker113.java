package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._113_深克隆效率的对比;

public class Worker113 implements Cloneable {

	private String name;
	private int    age;

	public Worker113( String name, int age ) {

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
	protected Worker113 clone() {

		Worker113 worker = null;
		try {
			worker = (Worker113) super.clone();
		} catch ( CloneNotSupportedException e ) {
			e.printStackTrace();
		}
		return worker;
	}
}
