package bj.powernode.advance.Charpter04.test5;

public class Main {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 在创建子类对象的时候,系统一定会先去创建一个父类的对象
		// 这是为类继承

		Student stu = new Student( "张一", 21, "清华" );

		stu.setAge( 23 );
		stu.setName( "张三" );

//		stu.name = "张一";
//		stu.age = 23;

	}

}
