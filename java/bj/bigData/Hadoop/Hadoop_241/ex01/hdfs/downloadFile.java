package bj.bigData.Hadoop.Hadoop_241.ex01.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.hadoop.hdfs.server.namenode.status_jsp;

/**
 * 从HDFS下载文件打本地
 *
 * @author root
 */
public class downloadFile {
	
	private static String src = "hdfs://master:9000/jdk-7u79-linux-i586.tar.gz";
	private static String dst = "/cloud/jdk.tar.gz";
	
	FileSystem fs = null;
	
	@Before
	public void init() throws IOException {

		fs = FileSystem.get( new Configuration() );
	}

	// 比较底层的写法
	public static void main( String[] args ) throws Exception {
		// Configuration conf = new Configuration(); 
		// 实例对象FileSystem
		FileSystem fs = FileSystem.get( new Configuration() );
		// 输入流
		FSDataInputStream in = fs.open( new Path( src ) );
		// 输出流
		FileOutputStream out = new FileOutputStream( new File( dst ) );
		// 调用ioutils进行copy
		IOUtils.copyBytes( in, out, new Configuration() );
	}

	// 调用系统封装好的方法
	@Test
	public void download() throws IllegalArgumentException, IOException {

		fs.copyToLocalFile( new Path( src ), new Path( dst ) );
	}
	
}
