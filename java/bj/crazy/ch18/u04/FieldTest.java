package bj.crazy.ch18.u04;

import java.lang.reflect.*;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */

class Person {

	private String name;
	private int    age;

	public String toString() {

		return "Person [ name:" + name +
		       " , age:" + age + " ]";
	}
}

public class FieldTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 创建一个Person对象
		Person p = new Person();






		// 获取Person类对应的Class对象
		Class< Person > personClazz = Person.class;






		// 获取Person类名为name的属性
		// 使用getDeclaredField，表明可获取各种访问控制符的field
		Field nameField = personClazz.getDeclaredField( "name" );






		// 设置通过反射访问该Field时取消访问权限检查
		nameField.setAccessible( true );
		// 调用set方法为p对象的指定Field设置值
		nameField.set( p, "Yeeku.H.Lee" );






		// 获取Person类名为age的属性
		Field ageField = personClazz.getDeclaredField( "age" );
		// 设置通过反射访问该Field时取消访问权限检查
		ageField.setAccessible( true );
		// 调用setInt方法为p对象的指定Field设置值
		ageField.setInt( p, 30 );






		System.out.println( p );




	}

}
