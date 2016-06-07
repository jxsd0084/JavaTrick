package bj.powernode.advance.Charpter04.test1;

public class Student {

	private int    age;
	private String name;

	public void setAge( int _age ) {

		age = _age;
	}

	public int getAge() {

		return age;
	}

	public void setName( String _name ) {

		name = _name;
	}

	public String toString() {

		return "学生的信息:name=" + name + " age=" + age;
	}

	public String getName() {

		return name;
	}

	public Student() {

	}

	public Student( String _name, int _age ) {

		name = _name;
		age = _age;
	}

}
