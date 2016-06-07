package bj.powernode.advance.Charpter13.io.test8;

public class Teacher {

	private String name;

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	@Override
	public String toString() {

		return "Teacher [name=" + name + "]";
	}

	public Teacher( String name ) {

		super();
		this.name = name;
	}

}
