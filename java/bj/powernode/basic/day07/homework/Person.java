package bj.powernode.basic.day07.homework;


public class Person {


	// 属性(私有化)
	private String  id;     // 身份证号
	private String  name;   // 姓名
	private int     age;    // 年龄
	private boolean sex;    // 性别(默认值false) // true代表男,false代表女

	private Person person;  // 妻子/丈夫


	// 构造方法
	public Person() {

		super();
	}

	public Person( String id, String name, int age, boolean sex ) {

		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}


	// setter and getter
	public void setId( String id ) {

		this.id = id;
	}

	public String getId() {

		return id;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public int getAge() {

		return age;
	}

	public void setPerson( Person person ) {

		this.person = person;
	}

	public Person getPerson() {

		return person;
	}

	// 注意boolean类型的setter and getter
	public void setSex( boolean sex ) {

		this.sex = sex;
	}

	public boolean isSex() {  // 注意: boolean类型的属性的get方法名字规范要求    is + 属性名(第一个字母大写)
		return sex;
	}


	// 实例方法
	// 1.性别一样的不能结婚
	// 2.男年龄<23岁的不能结婚
	// 3.女年龄<21岁的不能结婚
	// 4.已婚不能结婚.
	public boolean marry( Person person ) {

		if ( ! ( this.isSex() ^ person.isSex() ) ) {

			return false;
		}

		if ( this.isSex() ) { //男

			if ( this.getAge() < 23 ) {

				return false;
			}

		} else { //女

			if ( this.getAge() < 21 ) {

				return false;
			}
		}

		if ( person.isSex() ) { // 男

			if ( person.getAge() < 23 ) {

				return false;
			}

		} else {                // 女

			if ( person.getAge() < 21 ) {

				return false;
			}
		}


		if ( this.getPerson() != null ) {

			return false;
		}

		if ( person.getPerson() != null ) {

			return false;
		}


		// 可以结婚
		this.setPerson( person );

		person.setPerson( this );

		return true;
	}


	// 程序的入口
	public static void main( String[] args ) {

		// 结婚

		// 需要两个人.
		Person p1 = new Person( "0000001", "A", 23, true );
		Person p2 = new Person( "0000002", "B", 21, false );

		boolean isSuccess = p1.marry( p2 );

		Person p3 = new Person( "000003", "C", 25, true );

		boolean isSuccess2 = p2.marry( p3 );

		System.out.println( isSuccess ? "结婚成功" : "结婚失败" );
		System.out.println( isSuccess2 ? "结婚成功" : "结婚失败" );

	}

}
