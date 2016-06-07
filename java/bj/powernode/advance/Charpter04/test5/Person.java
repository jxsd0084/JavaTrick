package bj.powernode.advance.Charpter04.test5;

public class Person {

	private int    age;
	private String name;

	// 实例方法(只有创建好一个实例(对象)之后,才能调用的方法)

	public void setAge( int age ) {

		this.age = age;
	}

	public int getAge() {

		return age;
	}

	// this被当做执行当前对象的一个引用,可以用来区分作用域
	// this 只能在本类中使用

	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public String printInfo() {

		return "person的信息: name=" + name + " age=" + age;
	}

	public Person() {

		System.out.println( "父类无参数的构造方法被调用" );
	}

	public Person( String name ) {

		this.name = name;
		System.out.println( "父类一个参数的构造方法被调用" );
	}

	// this的另一种用法,去调用其他的已经存在的构造方法

	// 注意:this当做构造方法来使用的时候:

	// 1.只能在构造方法中使用
	// 2.只能放在构造方法的第一行
	public Person( String name, int age ) {

		this( name );
		// setName(name);
		this.age = age;
		System.out.println( "父类二个参数的构造方法被调用" );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Person p = new Person( "张一", 21 );
		p.setAge( 23 );
		p.setName( "张三" );

		System.out.println( p.printInfo() );
	}

}
