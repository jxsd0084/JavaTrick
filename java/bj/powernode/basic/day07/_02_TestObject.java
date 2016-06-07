package bj.powernode.basic.day07;


/*

	java.lang.Object中的equals方法的讲解：
	
		1.SUN设计equals方法的目的：判断两个对象是否“相等” 
		
		2.Object对象中的equals方法是这样的实现的：
			如果两个对象的内存地址一样,就返回true.
			如果两个对象的内存地址不一样就返回false.
		
			但是：Object中的equals方法已经无法满足当前的业务需求.需要重写.
			
			Object中的equals方法的本质是 ==

	java.lang.Object中的finalize方法:
		1.finalize方法是我们程序员调用的吗？ 该方法在某个对象被释放之前自动调用。系统自动调用.
		2.如果我们希望某个对象在被销毁之前做一些工作，那么这段代码就可以到finalize方法中.

	
	java.lang.Object中的hashCode方法: 返回该对象的哈希码值.(对象的内存地址经过哈希算法之后得到的值).
		public int hashCode(){}

*/
public class _02_TestObject {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		User u1 = new User( "jack" );
		User u2 = new User( "jack" );

		// 判断u1和u2 是否 “相等”
		boolean b = u1.equals( u2 );    // 没有重写equals方法,调用的是Object的equals方法.

		System.out.println( b );


		boolean b1 = u1.equals( u1 );

		System.out.println( b1 );


		System.out.println( u1 == u2 ); // false
		System.out.println( u1 == u1 ); // true

		String s1 = new String( "hello" );
		String s2 = new String( "hello" );

		System.out.println( s1.equals( s2 ) ); // true  java.lang.String类已经重写了equals方法.
	}

}


class User extends Object {

	// 属性
	private String name;

	// 构造方法
	public User() {

	}

	public User( String name ) {

		this.name = name;
	}

	// setter and getter
	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	// 重写toString方法.
	public String toString() {

		return "用户名:" + name;
	}


	// 重写equals方法.
	// 根据不同业务需求equals方法实现不同.
	// 例如：1.身份证号一样的认为是同一个人.  2.姓名+身份证号一样的我们认为是同一个人. ........
	// 如果用户名一样的我们就认为这两个人是同一个人。
	public boolean equals( Object obj ) {

		// Object是这样实现的.
		// return this==obj;


		// 什么情况下两个用户相等呢？ 名字一致我们就认为是同一个人.
		/*
			u1.equals(u2);
			u1是this
			u2是obj
		*/

		if ( obj == null ) {

			return false;
		}

		if ( obj instanceof User ) {

			User u = (User) obj;

			if ( this.getName().equals( u.getName() ) ) {  // 这里的equals方法是String重写以后的equals方法.

				return true;
			}
		}

		return false;

	}

}


