package bj.hmkcode.jackson_json_java;


import bj.hmkcode.jackson_json_java.vo.Article;

/**
 * Created by Administrator on 2016/6/1.
 */
public final class VoUtils {

	public static Article getArticle() {

		return createArticle();
	}

	public static Article createArticle() {

		Article article = new Article();

		article.setTitle( "Castor - Java Object to XML & XML to Object Mapping" );
		article.setUrl( "http://hmkcode.com/castor-java-object-xml" );
		article.addCategory( "Java" );
		article.addTag( "Java" );
		article.addTag( "Castor" );
		article.addTag( "XML" );
		article.addTag( "Marshalling" );
		article.addTag( "Unmarshalling" );

		return article;
	}

}
