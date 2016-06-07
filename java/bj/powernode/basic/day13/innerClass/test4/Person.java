package bj.powernode.basic.day13.innerClass.test4;

public class Person {

	private int age;

	public Person() {

		super();
	}

	public Person( int age ) {

		super();
		this.age = age;
	}

	@Override
	public boolean equals( Object obj ) {

		if ( this == obj ) {

			return true;
		}

		if ( obj == null ) {

			return false;
		}

		if ( getClass() != obj.getClass() ) {

			return false;
		}

		Person other = (Person) obj;

		if ( age != other.age ) {

			return false;
		}

		return true;
	}

	public int getAge() {

		return age;
	}

	@Override
	public int hashCode() {

		final int prime  = 31;
		int       result = 1;
		result = prime * result + age;
		return result;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	@Override
	public String toString() {

		return "Person [age=" + age + "]";
	}

}
