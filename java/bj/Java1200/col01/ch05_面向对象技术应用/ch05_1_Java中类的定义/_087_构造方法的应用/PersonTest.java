package bj.Java1200.col01.ch05_面向对象技术应用.ch05_1_Java中类的定义._087_构造方法的应用;

public class PersonTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Person person1 = new Person();
		Person person2 = new Person( "明日科技", "男", 11 );

		System.out.println( "员工1的信息" );
		System.out.println( "员工姓名：" + person1.getName() );
		System.out.println( "员工性别：" + person1.getGender() );
		System.out.println( "员工年龄：" + person1.getAge() );

		System.out.println( "员工2的信息" );
		System.out.println( "员工姓名：" + person2.getName() );
		System.out.println( "员工性别：" + person2.getGender() );
		System.out.println( "员工年龄：" + person2.getAge() );

	}

}
