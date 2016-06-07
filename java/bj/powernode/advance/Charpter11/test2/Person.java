package bj.powernode.advance.Charpter11.test2;


public class Person {

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

	@Override
	public int hashCode() {

		System.out.println( "============hashCode()" );
		return ( this.name.hashCode() + this.age ) * 31;
	}

	@Override
	public boolean equals( Object obj ) {

		System.out.println( "============equals()" );

		if ( this == obj ) {
			return true;
		}
		if ( obj instanceof Person ) {
			Person p = (Person) obj;
			if ( p.name.equals( this.name ) && this.age == p.age ) {
				return true;
			}
		}

		return false;
	}

	public Person() {

	}

	public Person( String name, int age ) {

		super();
		this.name = name;
		this.age = age;
	}

}
