package bj.Java1200.col01.ch07_反射与异常处理.ch07_2_反射的进阶._158;

import java.io.File;
import java.lang.reflect.Constructor;

/**
 * 动态实例化类
 */
public class NewClassTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		try {

			Constructor< File > constructor = File.class.getDeclaredConstructor( String.class );
			System.out.println( "使用反射创建File对象" );
			File file = constructor.newInstance( "d://明日科技.txt" );
			System.out.println( "使用File对象在D盘创建文件：明日科技.txt" );
			file.createNewFile();
			System.out.println( "文件是否创建成功：" + file.exists() );

		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

}
