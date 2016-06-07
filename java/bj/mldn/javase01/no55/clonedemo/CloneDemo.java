package bj.mldn.javase01.no55.clonedemo;

class Person implements Cloneable { // 表示此类的对象可以被克隆

	private String name;

	public Person( String name ) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public String toString() {

		return "姓名：" + this.getName();
	}

	public Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

}

public class CloneDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws CloneNotSupportedException {

		Person per1 = new Person( "张三" );
		Person per2 = (Person) per1.clone();

		per2.setName( "李四" );

		System.out.println( per1 );
		System.out.println( per2 );

	}

}
