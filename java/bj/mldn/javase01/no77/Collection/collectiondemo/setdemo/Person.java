package bj.mldn.javase01.no77.Collection.collectiondemo.setdemo;

public class Person implements Comparable< Person > {

	private String name;
	private int    age;

	public Person( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String toString() { // 覆写toString()
		return "姓名：" + this.name + "；年龄：" + this.age;
	}

	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}
		if ( ! ( obj instanceof Person ) ) {
			return false;
		}
		Person p = (Person) obj;
		if ( this.name.equals( p.name ) && this.age == p.age ) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() { // 这个方法的返回值都是通过一个公式计算的
		// 此时的公式：名字的hashCode * age
		return this.name.hashCode() * this.age;
	}

	public int compareTo( Person o ) {

		if ( this.age > o.age ) {
			return 1;
		} else if ( this.age < o.age ) {
			return - 1;
		} else {
			return this.name.compareTo( o.name ); // 比较name
		}
	}
}
