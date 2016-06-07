package bj.bigData.Hadoop.Hadoop_241.ex01.mr.wc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCount {
	
	public static void main( String[] args ) throws IOException, ClassNotFoundException, InterruptedException {

		Job job = Job.getInstance( new Configuration() );
		// 注意：加载main方法所在的类
		job.setJarByClass( WordCount.class );
		// 设置Mapper与Reducer的类
		job.setMapperClass( WcMapper.class );
		job.setReducerClass( WcReducer.class );

		FileInputFormat.setInputPaths( job, new Path( "hdfs://master:9000/words.txt" ) );
		FileOutputFormat.setOutputPath( job, new Path( "hdfs://master:9000/words_out" ) );
		
		//设置输入和输出的相关属性
		job.setOutputKeyClass( Text.class );
		job.setOutputValueClass( LongWritable.class );
		
		job.waitForCompletion( true );
	}

}

