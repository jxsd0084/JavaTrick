package bj.mldn.javase02.ch11.no11;

class Person implements Cloneable {    // 实现Cloneable接口表示可以被克隆

	private String name;

	public Person( String name ) {

		this.name = name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return this.name;
	}

	public String toString() {

		return "姓名：" + this.name;
	}

	public Object clone()
			throws CloneNotSupportedException {

		return super.clone();    // 具体的克隆操作由父类完成
	}
}

public class CloneDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {

		Person p1 = new Person( "张三" );
		Person p2 = (Person) p1.clone();
		p2.setName( "李四" );
		System.out.println( "原始对象：" + p1 );
		System.out.println( "克隆之后的对象：" + p2 );


	}
}
