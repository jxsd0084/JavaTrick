package bj.powernode.basic.day12.comparator;

public class User {

	private int    age;
	private String username;

	public User() {

		super();
	}

	public User( String username, int age ) {

		super();
		this.username = username;
		this.age = age;
	}

	public int getAge() {

		return age;
	}

	public String getUsername() {

		return username;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public void setUsername( String username ) {

		this.username = username;
	}

	public String toString() {

		return username + ":" + age;
	}


	public boolean equals( Object obj ) {

		if ( obj == null ) {

			return false;
		}

		if ( this == obj ) {

			return true;
		}
		if ( obj instanceof User ) {

			User u = (User) obj;

			if ( u.getUsername().equals( this.getUsername() ) ) {

				return true;
			}
		}

		return false;
	}

	public int hashCode() {

		return username.hashCode();
	}


}
