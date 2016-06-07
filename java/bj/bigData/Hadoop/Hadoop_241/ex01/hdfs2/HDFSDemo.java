package bj.bigData.Hadoop.Hadoop_241.ex01.hdfs2;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

public class HDFSDemo {
	
	FileSystem fs = null;
	
	@Before
	public void init() throws Exception {

		fs = FileSystem.get( new URI( "hdfs://master:9000" ), new Configuration(), "root" );
	}

//	@Test
//	public void testMkdir() throws IllegalArgumentException, IOException{
//		boolean  flag = fs.mkdirs(new Path("/testMkdir"));
//		System.out.println(flag);
//	}
	
	@Test
	public void testDel() throws IllegalArgumentException, IOException {

		boolean flag = fs.delete( new Path( "/testMkdir" ), true );
		System.out.println( flag );
	}
}
