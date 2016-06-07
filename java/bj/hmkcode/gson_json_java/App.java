package bj.hmkcode.gson_json_java;

import bj.hmkcode.gson_json_java.vo.Article;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class App {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		Gson gson = new Gson();

		List< Article > articles = new LinkedList< Article >();
		articles.add( VoUtils.getArticle() );
//		articles.add( VoUtils.getArticle() );

		System.out.println( "Java --> JSON" );

		// Java --> JSON
		String json = gson.toJson( articles );
		System.out.println( "toJson -> " + json );

		System.out.println( "" );
		System.out.println( "JSON --> Java" );

		// JSON --> Java
		List list = gson.fromJson( json, List.class );
		System.out.println( "fromJson -> " + list );
		System.out.println( "Class Type -> " + list.get( 0 ).getClass() );

		System.out.println( "" );
		System.out.println( "JSON --> Java \"Get the actual type\"" );

		// JSON --> Java "Get the actual type"
		Type type = new TypeToken< List< Article > >() {

		}.getType();

		list = gson.fromJson( json, type );
		System.out.println( "fromJson: " + list );
		System.out.println( "Class Type: " + list.get( 0 ).getClass() );

	}

}
