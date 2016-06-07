package bj.hmkcode.castor_xml_object;

import bj.hmkcode.castor_xml_object.vo.Article;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.XMLContext;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by Administrator on 2016/6/1.
 */
public class App {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		try {

			XMLContext context    = new XMLContext();
			Marshaller marshaller = context.createMarshaller();

			// ( 1 ) OBJECT --> XML
			FileWriter writer = new FileWriter( "article.xml" );
			marshaller.marshal( VoUtils.getArticle(), writer );

			// ( 2 ) XML --> OBJECT
			FileReader reader  = new FileReader( "article.xml" );
			Article    article = (Article) Unmarshaller.unmarshal( Article.class, reader );

			System.out.println( "00 -> " + article );

		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

}
