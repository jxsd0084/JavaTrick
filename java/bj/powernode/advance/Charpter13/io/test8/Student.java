package bj.powernode.advance.Charpter13.io.test8;

public class Student implements Cloneable {

	private String  name;
	private Teacher teacher;

	public Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public Teacher getTeacher() {

		return teacher;
	}

	public void setTeacher( Teacher teacher ) {

		this.teacher = teacher;
	}

	@Override
	public String toString() {

		return "Student [name=" + name + ", teacher=" + teacher + "]";
	}

	public Student( String name, Teacher teacher ) {

		super();
		this.name = name;
		this.teacher = teacher;
	}
}
