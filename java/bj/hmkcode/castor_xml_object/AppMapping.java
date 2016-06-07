package bj.hmkcode.castor_xml_object;

import bj.hmkcode.castor_xml_object.vo.Article;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.XMLContext;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by Administrator on 2016/6/1.
 */
public class AppMapping {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		try {

			// Load Mapping
			Mapping mapping = new Mapping();
			mapping.loadMapping( "mapping.xml" );
			XMLContext context = new XMLContext();
			context.addMapping( mapping );

			// ( 1 ) OBJECT --> XML

			// 1.1 Prepare file writer
			Writer writer = new FileWriter( "mapped_article.xml" );

			// 1.2 Create a new Marshaller
			Marshaller marshaller = context.createMarshaller();
			marshaller.setWriter( writer );

			// 1.3 Marshal "map" to xml
			marshaller.marshal( VoUtils.getArticle() );

			// 1.4 Close Stream
			writer.close();

			// ( 2 ) XML --> OBJECT

			// 2.1 Prepare file reader
			FileReader reader = new FileReader( "mapped_article.xml" );

			// 2.2 Create a new Unmarshaller
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.setClass( Article.class );

			// 2.3 Unmarshaller "map" to Object
			Article article = (Article) unmarshaller.unmarshal( reader );

			// 2.4
			reader.close();

			System.out.println( "01 -> " + article );

		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

}
