package bj.bigData.Hadoop.Hadoop_241.ex01.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

/**
 * 遍历HDFS的根目录
 *
 * @author root
 */
public class listFiles {
	
	public static void listFiles( FileSystem fs ) throws Exception {

		RemoteIterator< LocatedFileStatus > listFiles = fs.listFiles( new Path( "/" ), true );
		while ( listFiles.hasNext() ) {
			System.out.println( listFiles.next().getPath() );
		}
	}
	
	public static void main( String[] args ) throws Exception {
		// 获取Filesystem对象
		Configuration conf = new Configuration();
		FileSystem    fs   = FileSystem.get( conf );
		listFiles( fs );
	}

}
