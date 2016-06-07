package bj.Java1200.col01.ch10_Commons组件.ch10_1_CommonsLang组件简介._219;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = - 8396517822004869094L;
	private int    id;
	private String name;

	public int getId() {

		return id;
	}

	public void setId( int id ) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	@Override
	public String toString() {

		return "学生id：" + id + "，学生姓名：" + name;
	}

}
