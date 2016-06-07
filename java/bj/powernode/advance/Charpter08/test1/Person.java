package bj.powernode.advance.Charpter08.test1;

public class Person {

	private int    age;
	private String name;

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

	public String toString() {

		return "Person的信息:name=" + name + " age=" + age;
	}

	public Person( int age, String name ) {

		super();
		this.age = age;
		this.name = name;
	}

	public Person() {

	}

}
