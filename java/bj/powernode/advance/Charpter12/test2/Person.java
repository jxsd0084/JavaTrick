package bj.powernode.advance.Charpter12.test2;

public class Person {

	private String name;
	private int    age;

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

		return "Person [age=" + age + ", name=" + name + "]";
	}

	public Person() {

	}

	public Person( String name, int age ) {

		super();
		this.name = name;
		this.age = age;
	}

}
