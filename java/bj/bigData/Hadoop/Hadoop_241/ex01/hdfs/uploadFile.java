package bj.bigData.Hadoop.Hadoop_241.ex01.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 上传文件
 *
 * @author root
 */
public class uploadFile {

	private static String src = "/cloud/words.txt";
	private static String dst = "hdfs://master:9000/words.txt";
//	private static String src = "/cloud/jdk-7u79-linux-i586.tar.gz";
//	private static String dst = "hdfs://master:9000/jdk";
	
	Configuration conf = null;
	FileSystem    fs   = null;
	
	@Before
	public void init() throws IOException {

		conf = new Configuration();
		fs = FileSystem.get( conf );
	}
	
	// 使用比较底层的写法上传文件
	public static void main( String[] args ) throws IOException {
		// 获取Filesystem对象
		Configuration conf = new Configuration();
		FileSystem    fs   = FileSystem.get( conf );
		// 设置输出流
		Path               path = new Path( dst );
		FSDataOutputStream out  = fs.create( path );
		// 设置输入流
		FileInputStream in = new FileInputStream( src );
		// 调用IOUtils的copy方法， 复制文件
		IOUtils.copy( in, out );
	}

	// 使用系统提供的封装方法
	@Test
	public void uploadFiles() throws IllegalArgumentException, IOException {

		fs.copyFromLocalFile( new Path( src ), new Path( dst ) );
	}
	
}
