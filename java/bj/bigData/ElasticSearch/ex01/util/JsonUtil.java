package bj.bigData.ElasticSearch.ex01.util;

import bj.bigData.ElasticSearch.ex01.entity.Medicine;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

/**
 * @author ： 苏若年              <a href="mailto:DennisIT@163.com">发送邮件</a>
 * @version ： 1.0
 * @function： TODO
 * @since ： 1.0        创建时间:    2013-4-8    上午11:34:56
 */
public class JsonUtil {

	/**
	 * 实现将实体对象转换成json对象
	 *
	 * @param medicine Medicine对象
	 * @return
	 */
	public static String obj2JsonData( Medicine medicine ) {

		String jsonData = null;
		try {
			//使用XContentBuilder创建json数据
			XContentBuilder jsonBuild = XContentFactory.jsonBuilder();
			jsonBuild.startObject()
					.field( "id", medicine.getId() )
					.field( "name", medicine.getName() )
					.field( "funciton", medicine.getFunction() )
					.endObject();
			jsonData = jsonBuild.string();
			System.out.println( jsonData );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return jsonData;
	}

}
