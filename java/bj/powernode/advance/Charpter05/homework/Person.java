package bj.powernode.advance.Charpter05.homework;

/*
 【程序2】
 写一个类Person,包含以下属性：String name; int age; 
 boolean  gender ;Person partner(配偶)。为Person类写一
 个marry(Person  p)方法,代表当前对象和p结婚，如若可以结
 婚，则输出恭贺信息，否则输出不能结婚原因。要求在另外一
 个类中写一个主方法，来测试以上程序。

 下列情况不能结婚：

 1，同性；
 2，未达到结婚年龄，男<24，女<22；
 3，某一方已婚


 */

/**
 * 用于测试一个类如何设置属性
 */
public class Person {

	private String  name;
	private int     age;
	private boolean gender;  // 性别
	private Person  partner; // 爱人

	/**
	 * 取得Person的姓名
	 *
	 * @return 人的姓名
	 */
	public String getName() {

		return name;
	}

	/**
	 * 设置人的名字的方法
	 *
	 * @param name 要设置的人的名字
	 */
	public void setName( String name ) {

		this.name = name;
	}

	public int getAge() {

		return age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public boolean isGender() {

		return gender;
	}

	public void setGender( boolean gender ) {

		this.gender = gender;
	}

	public Person getPartner() {

		return partner;
	}

	/**
	 * 人结婚的方法 不能结婚的理由 1，同性； 2，未达到结婚年龄，男<24，女<22； 3，某一方已婚
	 *
	 * @param p 要结婚的对象
	 * @return 是否可以结婚
	 */
	public boolean marry( Person p ) {

		// 1，同性不能结婚；
		if ( this.gender == p.gender ) {

			System.out.println( "同性不能结婚" );
			return false;
		}

		// 2，未达到结婚年龄，男<24，女<22；

		// 当前对象是男的,并且年龄< 24
		if ( this.gender && this.age < 24 ) {

			System.out.println( "当前对象 " + this.name +
			                    " 是男的,年龄:" + this.age +
			                    " 没有达到结婚年龄!" );
			return false;
		}

		// 当前对象是男的,并且年龄< 24
		if ( ! this.gender && this.age < 22 ) {
			System.out.println( "当前对象 " + this.name +
			                    " 是女的,年龄:" + this.age +
			                    " 没有达到结婚年龄!" );
			return false;
		}

		// 判读爱人的年龄
		if ( p.gender && p.age < 24 ) {
			System.out.println( "爱人对象 " + p.name +
			                    " 是男的,年龄:" + p.age +
			                    " 没有达到结婚年龄!" );
			return false;
		}

		// 当前对象是男的,并且年龄< 24
		if ( ! p.gender && p.age < 22 ) {
			System.out.println( "爱人对象 " + p.name +
			                    " 是女的,年龄:" + p.age +
			                    " 没有达到结婚年龄!" );
			return false;
		}

		// 3，某一方已婚,不能结婚
		if ( this.partner != null ) {
			System.out.println( "当前对象 " + this.name + " 已婚" );

			return false;
		}

		if ( p.partner != null ) {
			System.out.println( "爱人对象 " + p.name + " 已婚" );

			return false;
		}

		this.partner = p;
		p.partner = this;

		System.out.println( "恭喜," + this.name + " 和" + p.name + " 你们可以结婚了!" );

		return true;
	}

	public Person( String name, int age, boolean gender ) {

		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Person p2 = new Person( "芙蓉姐姐", 15, false );


		System.out.println( p2.toString() );


		Person p1 = new Person( "李飞", 25, true );
		Person p3 = new Person( "凤姐", 25, false );

		if ( p1.marry( p2 ) ) {
			System.out.println( "ok" );

		} else {
			System.out.println( "not ok" );
		}

		if ( p1.marry( p3 ) ) {
			System.out.println( "ok" );

		} else {
			System.out.println( "not ok" );
		}
	}
}
