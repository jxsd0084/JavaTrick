package bj.powernode.basic.day26.factory_model.com.dlpowernode.factory;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 作用:生产实例对象的工厂类(通用): 解耦合
 *
 * @author Administrator
 */
public class InstanceFactory {

	public static Object getInstance( String key ) {

		try {

			Properties p = new Properties();

			p.load( new FileInputStream( "src/classInfo.properties" ) );

			String className = p.getProperty( key );

			return Class.forName( className ).newInstance();

		} catch ( Exception e ) {
			e.printStackTrace();
		}

		return null;
	}

}
