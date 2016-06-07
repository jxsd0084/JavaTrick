package bj.powernode.basic.day05;


/*

	java代码中的 this 关键字.
	
	this 是 一个指向自身对象的一个引用.
	
	this都用在哪里？
		1.用在某个实例方法中.在该实例方法中的this代表调用该方法的对象.
		2.用在构造方法中,实现一个构造方法去调用另一个构造方法。语法: this(参数列表);
	
	注意: this不能用在static的方法中.为什么? static的方法执行不需要对象的存在.
	      静态方法在调用的时候,对象根本就不存在,this也就没有存在的意义了。


*/
public class Person {

	private int age;

	//  构造方法
	public Person() {

	}

	//  有参数的构造方法.
	public Person( int age ) {

		this.age = age;
	}

	//  setter
	public void setAge( int age ) {

		this.age = age;
	}

	//  getter
	public int getAge() {

		return this.age;
	}

	//  public static void m(){
	//  	this.age = 100;     //  在静态的上下文中无法使用非静态的变量.
	//  }


	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		Person p = new Person();

		p.setAge( 10 );

		System.out.println( p.getAge() );

	}

}

