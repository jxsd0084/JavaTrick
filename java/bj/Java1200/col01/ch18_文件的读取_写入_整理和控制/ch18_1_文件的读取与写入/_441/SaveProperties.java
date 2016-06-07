package bj.Java1200.col01.ch18_文件的读取_写入_整理和控制.ch18_1_文件的读取与写入._441;

import java.io.FileOutputStream;
import java.util.Properties;

public class SaveProperties {

	/**
	 * @param args
	 */
	public void saveProperties( String key, String value ) {

		Properties properties = new Properties(); // 定义Properties对象
		properties.setProperty( key, value ); // 设置属性文件值
		try {
			FileOutputStream out = new FileOutputStream(
					"C://message.properties" );// 创建输出流对象
			properties.store( out, "test" ); // 将信息通过流写入到属性文件
			out.close(); // 关闭流
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}


}
