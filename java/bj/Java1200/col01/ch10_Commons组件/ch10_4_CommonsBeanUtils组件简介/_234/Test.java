package bj.Java1200.col01.ch10_Commons组件.ch10_4_CommonsBeanUtils组件简介._234;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 设置JavaBean级联属性
 */
public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Company company = new Company();

		try {

			PropertyUtils.setNestedProperty( company, "employee.name", "明日科技" );
			PropertyUtils.setNestedProperty( company, "employee.phoneNumber[0]", "1234567" );
			PropertyUtils.setNestedProperty( company, "employee.address(home)", "中国" );

			System.out.println( "获得设置的级联属性：" );
			String name        = (String) PropertyUtils.getNestedProperty( company, "employee.name" );
			String phoneNumber = (String) PropertyUtils.getNestedProperty( company, "employee.phoneNumber[0]" );
			String address     = (String) PropertyUtils.getNestedProperty( company, "employee.address(home)" );

			System.out.println( "employee.name = " + name );
			System.out.println( "employee.phoneNumber[0] = " + phoneNumber );
			System.out.println( "employee.address(home) = " + address );

		} catch ( IllegalAccessException e ) {
			e.printStackTrace();
		} catch ( InvocationTargetException e ) {
			e.printStackTrace();
		} catch ( NoSuchMethodException e ) {
			e.printStackTrace();
		}

	}

}
