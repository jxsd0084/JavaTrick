package bj.powernode.advance.Charpter06.homework2;

/*
 (3)定义一个抽象类Weapon,实现Assaultable接口，但并没
 有给出方法的具体实现。
 */

// 抽象类Weapon实现Assaulttable接口
public abstract class Weapon implements Assaultable {

	// 属性String类型 name
	private String name;

	// setter and getter方法
	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	// 有参构造,参数:String类型 name
	public Weapon( String name ) {

		this.name = name;
	}

	// 抽象方法attack();
	public abstract void attack();
}
