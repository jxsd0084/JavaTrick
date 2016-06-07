package bj.powernode.advance.Charpter04.test6;

// 当我们没有指定一个类的直接基类的时候,这个类一定是继承自java.lang.Object
public class Person {

	private int    age;
	private String name;

	public int getAge() {

		return age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	// 在覆盖equals的时候,可以不覆盖hashCode(但是通常都覆盖)
	// 但是在覆盖hashCode()的时候,则必须要覆盖equals
	@Override
	public int hashCode() {

		return ( this.age + this.name.hashCode() ) * 31;
	}

	// equals比较的是两个对象的内容是否相同,也就是对象里面的属性是否相同
	@Override
	public boolean equals( Object obj ) {

		boolean result = false;

		System.out.println( obj.getClass().getName() );
		// 引用类型的强制类型转换实际上就是一个还原的过程
		if ( this.getClass().getName().equals( obj.getClass().getName() ) ) {
			Person p = (Person) obj;
			if ( p.age == this.age && name.equals( p.getName() ) ) {
				result = true;
			}
		}

		return result;
	}

	public Person() {

	}

	public Person( String name, int age ) {

		this.name = name;
		this.age = age;
	}

}
