package bj.powernode.advance.Charpter13.homework.test2;

/**
 * 1，定义一个Teacher类，包含3个属性：name,age,salary。
 * 并且定义若两个对象的name和age都相同，则认为这
 * 两个对象相等。要求该Teacher类对象能比较大小，
 * 按照age的大小来排序，如果age相同的则按salary大
 * 小来排。最后，生成一些Teacher对象，加入到
 * HashSet和TreeSet中验证以上程序的正确性。
 * (向TreeSet里面添加的时候用两种比较规则)
 */
public class Teacher {

	private String name;
	private int    age;
	private int    salary; // 薪水

	public Teacher() {

		super();
	}

	public Teacher( String name, int age, int salary ) {

		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * @return the name
	 */
	public String getName() {

		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName( String name ) {

		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {

		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge( int age ) {

		this.age = age;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {

		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary( int salary ) {

		this.salary = salary;
	}

	@Override
	public String toString() {

		return "Teacher [age=" + age + ", name=" + name + ", salary=" + salary
		       + "]";
	}

	@Override
	public int hashCode() {

		return ( this.name.hashCode() + this.age ) * 31;
	}

	@Override
	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}

		if ( obj instanceof Teacher ) {
			Teacher teacher = (Teacher) obj;
			if ( this.name.equals( teacher.name ) && this.age == teacher.age ) {
				return true;
			}
		}

		return false;
	}

}
