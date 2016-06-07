package bj.powernode.advance.Charpter15.homework;

/*

 【程序1】

 已存在config.txt文件，内容如下：
 className:Student
 constructorParameter:String
 methodName:printName
 methodParameter:String
 编写程序，使用Properties读取config.txt文件的内容,
 并根据读到的参数生成一个对象，并调用相应的方法。

 */

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class Main {

	// 准备好一大堆静态属性,在类加载的时候初始化
	// className; constructorParameter; methodName; methodParameter; constructorString;
	private static String className, constructorParameter, methodName,
			methodParameter, constructorString;

	// 静态初始化块--在类加载的是初始化
	static {

		// getClassLoader()--返回该类的类加载器,返回 ClassLoader
		// getResourceAsStream(String name)-- 查找具有给定名称的资源 ,返回 InputStream
		// InputStream in = Main.class.getClassLoader().getResourceAsStream(
		// "config.properties");

		FileReader reader = null;

		// Properties 可保存在流中或从流中加载
		Properties pro = new Properties();
		try {

			// FileReader 用于读取字符流
			// FileReader(File file)--在给定从中读取数据的 File 的情况下创建一个新 FileReader
			reader = new FileReader( "config.txt" );

			// load(Reader reader)--按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）,无返回值.
			pro.load( reader );

			// getProperty(String key)--用指定的键在此属性列表中搜索属性 ,返回String类型
			className = pro.getProperty( "className" );

			// getProperty(String key)--用指定的键在此属性列表中搜索属性 ,返回String类型
			constructorParameter = pro.getProperty( "constructorParameter" );

			// getProperty(String key)--用指定的键在此属性列表中搜索属性 ,返回String类型
			methodName = pro.getProperty( "methodName" );

			// getProperty(String key)--用指定的键在此属性列表中搜索属性 ,返回String类型
			methodParameter = pro.getProperty( "methodParameter" );

			// getProperty(String key)--用指定的键在此属性列表中搜索属性 ,返回String类型
			constructorString = pro.getProperty( "constructorString" );
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {

			// 如果流还在
			if ( reader != null ) {
				try {

					// 要注意关闭流
					reader.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 通过反射机制动态的创建一个类的对象,并且调用私有的方法
	 */
	public static void invoke() {

		try {

			// 第一步,通过String 获取 Class
			// forName(String className)--返回与带有给定字符串名的类或接口相关联的 Class 对象,返回static
			// Class<?>
			Class cls = Class.forName( className );

			// -------------获取指定的构造方法----------------
			// 获取参数的Class
			// 准备构造方法的参数
			// forName(String className)--返回与带有给定字符串名的类或接口相关联的 Class 对象,返回static
			// Class<?>
			// Class param = Class.forName(constructorParameter);
			// Class[] params = { param };

			Class[] consParams = null;

			// 判断参数是一个还是多个
			if ( constructorParameter.indexOf( "," ) != - 1 ) {
				String arr[] = constructorParameter.split( "," );
				consParams = new Class[ arr.length ];

				consParams[ 0 ] = Class.forName( arr[ 0 ] );
				if ( arr[ 1 ].equals( "int" ) ) {
					consParams[ 1 ] = int.class;
				}
			}

			// 取得指定参数的构造方法,并且通过构造方法和指定的string对象创出一个Studnet类的对象
			// getDeclaredConstructor(Class<?>... parameterTypes)--返回一个
			// Constructor 对象，该对象反映此 Class 对象所表示的类或接口的指定构造方法,返回 Constructor<T>
			Constructor cons = cls.getDeclaredConstructor( consParams );

			cons.setAccessible( true );
			Student stu = (Student) cons.newInstance( constructorString, 23 );

			System.out.println( stu );
			// // 获取指定名称的方法
			// // 要准备方法的参数
			// Class methodParam = Class.forName(methodParameter);
			//
			// // 通过反射得到指定名称的方法
			// Method method = cls.getDeclaredMethod(methodName, methodParam);
			// method.setAccessible(true);
			//
			// // 调用私有的方法
			// method.invoke(stu, constructorString);

		} catch ( ClassNotFoundException e ) {
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

	public static void main( String[] args ) {

		invoke();
	}

}
