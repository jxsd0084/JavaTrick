package bj.mldn.javase01.no77.Collection.execdemo02;

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
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public List< Student > getAllStudents() {

		return allStudents;
	}

	public String toString() {

		return "学校信息：" + this.name;
	}

}
