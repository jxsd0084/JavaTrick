package bj.powernode.advance.Charpter03;

class TestStudent {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Student stu = new Student();

//		stu.age =1000;
//		stu.name = "狗剩";

		stu.setAge( 10000 );
		stu.setName( "张三" );
		stu.study( "Oracle" );

	}

}
