package bj.bigData.Hadoop.Hadoop_260.ex02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


public class MyCounterTest {

	public static void main( String[] args ) throws Exception {

		Configuration conf    = new Configuration();
		String        jobName = MyCounterTest.class.getSimpleName();
		Job           job     = Job.getInstance( conf, jobName );
		
		//要把代码打包运行， 调用如下行
		job.setJarByClass( MyCounterTest.class );
		
		//指定输入路径
		FileInputFormat.setInputPaths( job, new Path( args[ 1 ] ) );
		//指定解析<k1,v1>的类
		//job.setInputFormatClass(TextInputFormat.class);
		//指定自定义的mapper类
		job.setMapperClass( MyMapper.class );
		//指定输出的<k2,v2>类型
		//当<k3,v3>的类型与<k2,v2>类型一致时，<k2,v2>类型可以不指定
		//job.setMapOutputKeyClass(Text.class);
		//job.setMapOutputValueClass(LongWritable.class);
		
		//指定自定义reducer类
		job.setReducerClass( MyReducer.class );
		//指定输出的<k3,v3>类型
		job.setOutputKeyClass( Text.class );
		job.setOutputValueClass( LongWritable.class );
		//指定输出<k3,v3>的类
		//job.setOutputFormatClass(TextOutputFormat.class);
		//指定输出的路径
		FileOutputFormat.setOutputPath( job, new Path( args[ 2 ] ) );
		
		job.waitForCompletion( true );
	}
	
	private static class MyMapper extends Mapper< LongWritable, Text, Text, LongWritable > {

		Text         k2 = new Text();
		LongWritable v2 = new LongWritable();
		
		@Override
		protected void map( LongWritable key, Text value, Context context )
				throws IOException, InterruptedException {

			Counter counterHello = context.getCounter( "Sensitive Words", "hello" );

			String line = value.toString();
			
			if ( line != null && line.contains( "hello" ) ) {
				counterHello.increment( 1L );
			}
			
			String[] splited = line.split( "\t" );
			//word表示每一行中的每个单词
			for ( String word : splited ) {
				k2.set( word );
				v2.set( 1L );
				context.write( k2, v2 );
			}
			
			
		}
	}
	
	private static class MyReducer extends Reducer< Text, LongWritable, Text, LongWritable > {

		LongWritable v3 = new LongWritable();

		@Override
		protected void reduce( Text k2, Iterable< LongWritable > v2s,
		                       Context context ) throws IOException, InterruptedException {
			
			long sum = 0L;
			for ( LongWritable v2 : v2s ) {
				sum += v2.get();
			}
			v3.set( sum );
			context.write( k2, v3 );
		}
	}
}
