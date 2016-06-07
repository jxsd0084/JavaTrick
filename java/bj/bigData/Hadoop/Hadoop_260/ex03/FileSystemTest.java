package bj.bigData.Hadoop.Hadoop_260.ex03;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;


public class FileSystemTest {

	public static void main( String[] args ) throws Exception {

		FileSystem fileSystem = FileSystem.newInstance( new URI( "hdfs://192.168.8.230:9000" ), new Configuration() );
		
		ls( fileSystem );

//		create(fileSystem);
		
		//open(fileSystem);

//		fileSystem.delete(new Path("/30x40.png"), false);
	}

	@SuppressWarnings( "unused" )
	private static void open( FileSystem fileSystem ) throws IOException, FileNotFoundException {

		FSDataInputStream in = fileSystem.open( new Path( "/test.txt" ) );
		IOUtils.copyBytes( in, new FileOutputStream( "C:\\Users\\Administrator\\Desktop\\test.txt" ), 1024, true );
	}

	private static void create( FileSystem fileSystem ) throws IOException, FileNotFoundException {

		FSDataOutputStream out = fileSystem.create( new Path( "/test.txt" ) );
		IOUtils.copyBytes( new FileInputStream( "C:\\Users\\Administrator\\Desktop\\test.txt" ), out, 1024, true );
	}

	@SuppressWarnings( "unused" )
	private static void ls( FileSystem fileSystem ) throws FileNotFoundException, IOException {
		//作业：递归显示所有文件(夹)的内容，显示形式如shell命令所示
		FileStatus[] listStatus = fileSystem.listStatus( new Path( "/" ) );
		for ( FileStatus fileStatus : listStatus ) {
			System.out.println( fileStatus );
		}
	}

}
