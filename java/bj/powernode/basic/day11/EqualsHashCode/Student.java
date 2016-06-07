package bj.powernode.basic.day11.EqualsHashCode;

public class Student {

	private String name;

	public Student() {
	}

	public Student( String name ) {
		this.name = name;
	}


	public void setName( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 重写equals
	public boolean equals( Object obj ) {

		if ( obj == null ) {

			return false;
		}

		if ( obj instanceof Student ) {

			Student s = (Student) obj;

			if ( this.getName().equals( s.getName() ) ) {

				return true;
			}
		}

		return false;
	}

	// 重写hashCode
	// hashCode方法怎么重写？来源equals方法.
	public int hashCode() {

		return this.getName().hashCode();
	}

}
