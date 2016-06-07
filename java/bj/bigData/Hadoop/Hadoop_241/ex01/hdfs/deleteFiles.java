package bj.bigData.Hadoop.Hadoop_241.ex01.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * 删除目标文件
 *
 * @author root
 */
public class deleteFiles {

	private static String src = "hdfs://master:9000/aa";
	
	FileSystem fs = null;
	
	@Before
	public void init() throws IOException {

		fs = FileSystem.get( new Configuration() );
	}

	// 调用系统封装好的方法
	@Test
	public void download() throws IllegalArgumentException, IOException {

		boolean flag = fs.delete( new Path( src ), true );
		if ( flag ) {
			System.out.println( "success !" );
		} else {
			System.out.println( "failed ?" );
		}
	}

}
