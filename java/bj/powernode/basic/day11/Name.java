package bj.powernode.basic.day11;

public class Name { // 每一个员工的名字(first_name,last_name)

	// 属性
	private String firstName; // 名
	private String lastName;  // 姓


	// 构造方法
	public Name() {

	}

	public Name( String firstName, String lastName ) {

		this.firstName = firstName;
		this.lastName = lastName;
	}

	// setter and getter
	public void setFirstName( String firstName ) {

		this.firstName = firstName;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setLastName( String lastName ) {

		this.lastName = lastName;
	}

	public String getLastName() {

		return lastName;
	}

	// 重写equals方法

	public boolean equals( Object obj ) {

		if ( obj == null ) {

			return false;
		}

		if ( obj instanceof Name ) {

			Name n = (Name) obj;

			if ( n.getFirstName().equals( this.getFirstName() ) && n.getLastName().equals( this.getLastName() ) ) {

				return true;
			}
		}

		return false;
	}

	// 重写toString
	public String toString() {

		return firstName + "." + lastName;
	}


}
