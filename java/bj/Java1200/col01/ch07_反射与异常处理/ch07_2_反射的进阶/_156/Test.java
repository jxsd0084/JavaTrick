package bj.Java1200.col01.ch07_反射与异常处理.ch07_2_反射的进阶._156;

import java.lang.reflect.Field;

/**
 * 动态设置类的私有域
 */
public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Student    student = new Student();
		Class< ? > clazz   = student.getClass();// 获得代表student对象的Class对象

		System.out.println( "类的标准名称：" + clazz.getCanonicalName() );

		try {

			Field id = clazz.getDeclaredField( "id" );
			System.out.println( "设置前的id：" + student.getId() );
			id.setAccessible( true );
			id.setInt( student, 10 );// 设置Id值为10
			System.out.println( "设置后的id：" + student.getId() );


			Field name = clazz.getDeclaredField( "name" );
			System.out.println( "设置前的name：" + student.getName() );
			name.setAccessible( true );
			name.set( student, "明日科技" );// 设置name值为明日科技
			System.out.println( "设置后的name：" + student.getName() );


			Field male = clazz.getDeclaredField( "male" );
			System.out.println( "设置前的male：" + student.isMale() );
			male.setAccessible( true );
			male.setBoolean( student, true );// 设置male值为true
			System.out.println( "设置后的male：" + student.isMale() );


			Field account = clazz.getDeclaredField( "account" );
			System.out.println( "设置前的account：" + student.getAccount() );
			account.setAccessible( true );
			account.setDouble( student, 12.34 );// 设置account值为12.34
			System.out.println( "设置后的account：" + student.getAccount() );

		} catch ( SecurityException e ) {
			e.printStackTrace();
		} catch ( NoSuchFieldException e ) {
			e.printStackTrace();
		} catch ( IllegalArgumentException e ) {
			e.printStackTrace();
		} catch ( IllegalAccessException e ) {
			e.printStackTrace();
		}

	}

}
