package bj.powernode.advance.Charpter04.test2;

public class Person {

	private String name;
	private int    age;

	public void setAge( int _age ) {

		age = _age;
	}

	public int getAge() {

		return age;
	}

	public void setName( String _name ) {

		name = _name;
	}

	public String getName() {

		return name;
	}

	public String print(/*int age*/ ) {

		return "Person的信息:name =" + name + " age=" + age;
	}

	public Person() {

	}

	public Person( String _name, int _age ) {

		name = _name;
		age = _age;
	}

}
