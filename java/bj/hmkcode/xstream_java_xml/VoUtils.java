package bj.hmkcode.xstream_java_xml;

import bj.hmkcode.xstream_java_xml.vo.Article;

/**
 * Created by Administrator on 2016/6/1.
 */
public class VoUtils {

	public static Article getArticle() {

		return createArticle();
	}

	private static Article createArticle() {

		Article article = new Article();

		article.setTitle( "XStream - Java Object to XML & XML to Object Mapping" );
		article.setUrl( "http://hmkcode.com/xstream-java-object-xml" );
		article.setPublished( true );

		article.addCategory( "Java" );
		article.addTag( "Java" );
		article.addTag( "Xstream" );
		article.addTag( "XML" );
		article.addTag( "Marshalling" );
		article.addTag( "Unmarshalling" );

		return article;
	}

}
