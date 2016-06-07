package bj.powernode.basic.day07.exercise.exercise02;

public abstract class Weapon implements Assaultable {

	// 属性
	private String name;

	// 构造方法
	public Weapon() {

	}

	public Weapon( String name ) {

		this.name = name;
	}

	// setter and getter
	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	
	/*
	
		一个实体类实现一个接口，必须实现接口中的所有方法吗？ 是的。
		一个抽象类实现一个接口，必须实现接口中的所有方法吗？ 不是的。
	
	*/

	// public abstract void attack();

}
