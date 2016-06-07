package bj.mldn.javase02.ch13.no17;

import java.util.ArrayList;
import java.util.List;

public class School {

	private String          name;
	private List< Student > allStudents;

	public School() {

		this.allStudents = new ArrayList< Student >();
	}

	public School( String name ) {

		this();
		this.setName( name );
	}

	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return this.name;
	}

	public List< Student > getAllStudents() {

		return this.allStudents;
	}

	public String toString() {

		return "学校名称：" + this.name;
	}
};
