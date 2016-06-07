package bj.powernode.advance.Charpter15.test1;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class Main {

	private static String className = null;
	private static String driver;

	static {

		// getClassLoader()--返回该类的类加载器,返回 ClassLoader;
		// getResourceAsStream(String name)--查找具有给定名称的资源,返回 InputStream

		// InputStream in = Main.class.getClassLoader().getResourceAsStream(
		// "info.properties");

		// getClassLoader()--返回该类的类加载器,返回 ClassLoader;
		// getResourceAsStream(String name)--查找具有给定名称的资源,返回 InputStream

		InputStream in = Main.class.getClassLoader().getResourceAsStream(
				"info.txt" );

		// Properties() 创建一个无默认值的空属性列表

		Properties pro = new Properties();
		try {

			// load(InputStream inStream)从输入流中读取属性列表（键和元素对）,无返回值.
			pro.load( in );

			// getProperty(String key) 用指定的键在此属性列表中搜索属性
			className = pro.getProperty( "className" );

			// getProperty(String key) 用指定的键在此属性列表中搜索属性
			driver = pro.getProperty( "driver" );
			System.out.println( className + " " + driver );
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			// 如果流还存在
			if ( in != null ) {
				try {

					// 要注意关闭流
					in.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main( String[] args ) {

		// 输出信息让JVM在类加载时完成信息的初始化
		System.out.println( "HelloWorld" );

		// test3();
		// int [] arr = {1,2,3,4,5,67,8};
		// test(1,2,3,5,6,5,87,9,5,6,87,8,9,0,0,9);
		// test8();
		// 调用静态方法readFromFile
		// readFromFile();
	}

	public static void test8() {

		Class cls = null;
		try {

			// forName(String className)--返回与带有给定字符串名的类或接口相关联的 Class 对象,返回static
			// Class<?>泛型吗?
			cls = Class.forName( "java.lang.String" );
		} catch ( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 创建了一个10个元素的String数则
		// newInstance(Class<?> componentType, int
		// length)--创建一个具有指定的组件类型和长度的新数组,返回static Object
		// Array 类提供了动态创建和访问 Java 数组的方法
		Object arr = Array.newInstance( cls, 10 );

		// 给数组的元素赋值
		// set(Object array, int index, Object
		// value)--将指定数组对象中索引组件的值设置为指定的新值,返回static void
		Array.set( arr, 0, "Wusz" );
		Array.set( arr, 5, "Hello" );
		Array.set( arr, 6, "World" );

		// 取出数组里的元素
		// get(Object array, int index)-- 返回指定数组对象中索引组件的值 ,返回static Object
		String s0 = (String) Array.get( arr, 0 );
		String s5 = (String) Array.get( arr, 5 );
		String s6 = (String) Array.get( arr, 6 );
		System.out.println( s0 + "  " + s5 + "  " + s6 );

	}

	/**
	 * 使用Class.isInstance()判断一个对象是否是该类的实例
	 */
	public static void test7() {

		Object obj = new Person( 21, "张一" );
		// if(obj instanceof Person){
		// System.out.println("ok");
		// }
		// String className = "com.bjpowernode.test1.Person";
		try {
			Class cla = Class.forName( className );

			if ( cla.isInstance( "Hello" ) ) {
				System.out.println( "obj是Person类的实例" );
			} else {
				System.out.println( "不是Person类的实例" );
			}

		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}

	}

	/**
	 * 通过反射设置类私有的属性
	 */
	public static void test6() {

		String className = "com.bjpowernode.test1.Person";

		try {
			Class cls = Class.forName( className );
			// 通过反射取得一个对象
			Class[]     parameterTypes = { String.class, int.class };
			Constructor con            = cls.getDeclaredConstructor( parameterTypes );
			con.setAccessible( true );

			Object pars[] = { "张一", 21 };
			Person p      = (Person) con.newInstance( pars );

			Field f1 = cls.getDeclaredField( "age" );
			f1.setAccessible( true );

			Field f2 = cls.getDeclaredField( "name" );
			f2.setAccessible( true );

			f1.setInt( p, 10000 );
			f2.set( p, "张一万" );
			System.out.println( p );

		} catch ( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( SecurityException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( NoSuchFieldException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( NoSuchMethodException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IllegalArgumentException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( InstantiationException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IllegalAccessException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( InvocationTargetException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 通过反射获取私有的构造方法,然后通过构造方法创建对象
	 */
	public static void test5() {

		String className = "com.bjpowernode.test1.Person";
		try {
			Class cls = Class.forName( className );

			Class[]     parameterTypes = { String.class, int.class };
			Constructor con            = cls.getDeclaredConstructor( parameterTypes );
			con.setAccessible( true );

			Object pars[] = { "张一", 21 };
			Person p      = (Person) con.newInstance( pars );

			Method m = cls.getDeclaredMethod( "fun1", String.class, int.class );
			m.setAccessible( true );

			Object[] args = { "王六", 26 };
			int      i    = (Integer) m.invoke( p, args );

		} catch ( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( SecurityException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( NoSuchMethodException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IllegalArgumentException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( InstantiationException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IllegalAccessException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( InvocationTargetException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test4() {

		String className = "com.bjpowernode.test1.Person";
		try {
			Class cls = Class.forName( className );

			// Class[] params = { String.class, int.class };
			Method m = cls.getDeclaredMethod( "fun1", String.class, int.class );
			m.setAccessible( true );
			Person p = new Person( 34, "张四" );

			Object[] args = { "王六", 26 };
			int      i    = (Integer) m.invoke( p, args );

			System.out.println( i );
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		} catch ( SecurityException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( NoSuchMethodException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		catch ( IllegalArgumentException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IllegalAccessException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( InvocationTargetException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test3() {

		String className = "com.bjpowernode.test1.Person";
		try {
			Class cls = Class.forName( className );

			Field f = cls.getDeclaredField( "age" );
			f.setAccessible( true );

			Person p = new Person( 34, "张四" );

			int age = f.getInt( p );
			System.out.println( age );

			Field nameF = cls.getDeclaredField( "name" );
			nameF.setAccessible( true );

			String name = (String) nameF.get( p );
			System.out.println( name );

			// // 获取字段信息
			// Field[] fields = cls.getDeclaredFields();
			//
			// if (fields.length > 0) {
			// for (Field f : fields) {
			// // 取得修饰符
			// int im = f.getModifiers();
			// String strM = Modifier.toString(im);
			// System.out.print(strM + " ");
			//
			// // 取得字段的类型
			// Class typCls = f.getType();
			// System.out.print(typCls.getName() + " ");
			//
			// // 字段的名称
			// String fName = f.getName();
			// System.out.print(fName + " ");
			// System.out.println("\n");
			// }
			// }
		} catch ( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( SecurityException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( NoSuchFieldException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		catch ( IllegalArgumentException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IllegalAccessException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void test2() {

		String className = "com.bjpowernode.test1.Person";

		try {
			Class cls = Class.forName( className );

			// ------------------取得类中的方法的信息-----------------------
			// 取得本类中声明的所有的方法
			// Method methods[] = cls.getDeclaredMethods();

			// 得到本类及其基类中所有的公开的方法
			// Method methods[] = cls.getMethods();

			// if (methods.length > 0) {
			// for (Method m : methods) {
			// // 取得方法的修饰符
			// int im = m.getModifiers();
			// String strM = Modifier.toString(im);
			// System.out.print(strM);
			//
			// // 取得方法的返回类型
			// Class returnCls = m.getReturnType();
			// System.out.print(" " + returnCls.getName() + " ");
			//
			// // 取得方法的名称
			// String methodName = m.getName();
			// System.out.print(" " + methodName + " (");
			//
			// // 取得方法的参数列表
			// Class[] paramsCls = m.getParameterTypes();
			// if (paramsCls.length > 0) {
			// for (Class paramCls : paramsCls) {
			// System.out.print(paramCls.getName() + ",");
			// }
			// }
			// System.out.print(") ");
			//
			// // 得到方法声明的异常
			// Class execptons[] = m.getExceptionTypes();
			// if (execptons.length > 0) {
			// System.out.print("  throws  ");
			// for (Class ecls : execptons) {
			// System.out.print(ecls + ",");
			// }
			// }
			//
			// System.out.println("\n-----------------------");
			// }
			// }

			// 获取一个指定的方法
			Class[] params = { int.class, String.class };
			Method  m      = cls.getDeclaredMethod( "setName", params );

			System.out.println( m );

		} catch ( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( SecurityException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( NoSuchMethodException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test1() {

		String className = "java.lang.String";
		try {
			Class       cls    = Class.forName( className );
			Constructor cons[] = cls.getConstructors();

			if ( cons.length > 0 ) {
				for ( Constructor c : cons ) {
					// 取得构造方法的修饰符
					int    modifier    = c.getModifiers();
					String strModifier = Modifier.toString( modifier );
					System.out.print( strModifier + "  " );

					// 取得构造方法的名称
					String name = c.getName();
					System.out.print( name + "( " );

					// 构造方法的参数列表
					Class pars[] = c.getParameterTypes();
					if ( pars.length > 0 ) {
						for ( Class ps : pars ) {
							System.out.print( ps + "," );
						}
					}
					System.out.print( ") " );

					// 得到方法声明的异常
					Class execptons[] = c.getExceptionTypes();
					if ( execptons.length > 0 ) {
						System.out.print( "  throws  " );
						for ( Class ecls : execptons ) {
							System.out.print( ecls + "," );
						}
					}
					System.out
							.println( "\n----------------------------------------" );
				}
			}

		} catch ( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test( int... params ) {
		// for(int i : params){
		// System.out.println(i);
		// }
		for ( int i = 0; i < params.length; i++ ) {
			System.out.println( "param[" + i + "]=" + params[ i ] );
		}
	}
}
