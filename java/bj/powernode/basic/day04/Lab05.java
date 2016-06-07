package bj.powernode.basic.day04;

// 创建类
public class Lab05 {

	//  在主方法外创建m1方法
	void m1( User u ) {

		u.age++;   //   m1方法的内容.
	}


	public static void main( String[] args ) {

		//  创建Lab05类型的对象
		Lab05 lab05 = new Lab05();         //  主方法中创建对象Lab05().

		//  创建User类型的对象
		User user = new User();            //  主方法中创建对象User().

		//  调用m1方法.
		lab05.m1( user );                  //  在主方法中调用m1方法.

		//  访问user对象的age属性.
		System.out.println( user.age );    //  19

	}

}

//  在方法外创建类User,类/User属于类/public class Lab05中.
class User {

	//  在类/User中创建成员变量.
	int age = 18;

}
