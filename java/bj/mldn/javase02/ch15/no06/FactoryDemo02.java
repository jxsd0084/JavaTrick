package bj.mldn.javase02.ch15.no06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

interface Fruit2 {

	public void eat();    // 吃水果
}

class Apple2 implements Fruit2 {

	public void eat() {            // 覆写eat()方法
		System.out.println( "** 吃苹果" );
	}
}

class Orange2 implements Fruit2 {

	public void eat() {

		System.out.println( "** 吃橘子" );
	}
}

class Init2 {

	public static Properties getPro() {

		Properties pro = new Properties();
		File       f   = new File( "d:\\fruit.properties" );    // 找到属性文件
		try {
			if ( f.exists() ) {    // 文件存在
				pro.load( new FileInputStream( f ) );    // 读取属性
			} else {
				pro.setProperty( "apple", "org.lxh.demo15.factorydemo02.Apple" );
				pro.setProperty( "orange", "org.lxh.demo15.factorydemo02.Orange" );
				pro.store( new FileOutputStream( f ), "FRUIT CLASS" );
			}
		} catch ( Exception e ) {
		}
		return pro;
	}
}

class Factory2 {

	public static Fruit2 getInstance( String className ) {

		Fruit2 fruit = null;
		try {
			fruit = (Fruit2) Class.forName( className ).newInstance();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return fruit;
	}
}

public class FactoryDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Properties pro = Init2.getPro();
		Fruit2     f   = Factory2.getInstance( pro.getProperty( "apple" ) );
		if ( f != null ) {
			f.eat();
		}
	}
}
