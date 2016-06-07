package bj.sxt.generic.gen02;

/**
 * 泛型的擦除: 使用时 |实现|继承 没有指定类型 ，
 * 类似于 Object ,不等同于 Object
 *
 * @author com.bj.com.bj
 */
public class MyStuApp {

	public static void main( String[] args ) {

		// 擦除 -->没有指定 泛型的具体类型
		MyStudent student = new MyStudent();
		student.setJavase( 100 ); // 100 -->int -->Integer -->Object
		Object obj = student.getJavase();


		test( student ); // 编译不会类型检查

		MyStudent< Object > student2 = new MyStudent< Object >();
		// 不等于 Object
		// test(student2);
	}

	public static void test( MyStudent< Integer > stu ) {

	}

}
