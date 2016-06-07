package bj.powernode.advance.Charpter03;

// package 必须要放在源代码的第一行,并且只能有一个package语句



// 在一个java源文件中,只能有一根package
// 但是可以有多个

// 下面的语句只能导入test1包里面所有的字节码

// 但是test1目录又有有子目录test2,test2里面的字节码无法导入

// 需要单独使用import另行导入
class TestPerson {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Car    car = new Car();
		Person p   = new Person();
		p.goHome( car );

		Student stu = new Student();
		stu.setAge( 23 );
		stu.setName( "张三" );
		stu.study( "CoreJava" );

	}

}
