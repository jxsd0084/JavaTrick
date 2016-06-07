package bj.powernode.advance.Charpter12.test3;

public class Person implements Comparable< Person > {

	private String name;
	private int    age;

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public int getAge() {

		return age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	@Override
	public String toString() {

		return "Person [age=" + age + ", name=" + name + "]";
	}

	public Person() {

	}

	public Person( String name, int age ) {

		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo( Person o ) {

		System.out.println( "===================compareTo" );
		// 如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数。
		if ( this.age < o.age ) {
			return 1;
		}

		if ( this.age > o.age ) {
			return - 1;
		}

		if ( name.compareTo( o.name ) > 0 ) {
			return - 1;
		}

		if ( name.compareTo( o.name ) < 0 ) {
			return 1;
		}

		return 0;
	}

}
