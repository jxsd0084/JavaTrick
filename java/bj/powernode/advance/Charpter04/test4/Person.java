package bj.powernode.advance.Charpter04.test4;

public class Person {

	// --------------------------------------------

	// private 修饰符可以修饰属性,方法,构造方法
	// 被private 修饰的代码只能在本类中访问
	private int age;

	private void xiaoHua( String food ) {

		System.out.println( "Person在消化" + food );
	}


	// --------------------------------------------

	// --------------------------------------------
	// default 修饰符 可以修饰类,属性,方法,构造方法
	String name;

	void setName( String _name ) {

		name = _name;
	}

	Person( String name ) {

	}

	// --------------------------------------------

	// --------------------------------------------
	// protected 修饰符 可以修饰属性,方法,构造方法
	protected String addr;

	protected void setAddr( String _addr ) {

		addr = _addr;
	}

	protected Person( String addr, int _age ) {

	}


	// --------------------------------------------

	// public 修饰符 可以修饰类, 属性,方法,构造方法
	public int weight;

	public void setWeight( int _weight ) {

		weight = _weight;
	}

	public Person() {

	}

	public Person( int _age, String addr ) {

	}

	public void eat( String food ) {

		System.out.println( "Person在吃" );
		xiaoHua( food );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Person p = new Person( "张一" );

		p.weight = 150;

		p.setWeight( 120 );

	}

}
