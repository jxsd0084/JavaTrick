package bj.powernode.advance.Charpter07;

// Person类
public class Person {

	// 属性int类型 age
	private int    age;
	// 属性String类型 name
	private String name;

	// setter and getter
	public int getAge() {

		return age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	// 重写toString方法
	public String toString() {

		return "Person的信息:name=" + name + " age=" + age;
	}

	// 有参构造,参数(int age, String name)
	public Person( int age, String name ) {

		super();
		this.age = age;
		this.name = name;
	}

	// 无参构造
	public Person() {

	}

}
