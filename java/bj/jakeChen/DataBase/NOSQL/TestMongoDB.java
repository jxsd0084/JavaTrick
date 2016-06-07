package bj.jakeChen.DataBase.NOSQL;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Created by chenlong on 2016/4/27.
 */
public class TestMongoDB {

	private static MongoClient mongoClient = null;
	private static DB          db          = null;

	static {
		try {
			mongoClient = new MongoClient( "localhost", 27017 );
			db = mongoClient.getDB( "mydb" );
		} catch ( Exception e ) {

		}
	}

	public static void main( String[] args ) {

//		MongoCredential credential    = MongoCredential.createCredential( "user", "mydb", "password".toCharArray() );
//		ServerAddress   serverAddress = new ServerAddress( "localhost", 27017 );
//		MongoClient     mongoClient   = new MongoClient( serverAddress, Arrays.asList( credential ) );

	}

}
