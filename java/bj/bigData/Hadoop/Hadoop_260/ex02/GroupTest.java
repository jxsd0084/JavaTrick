package bj.bigData.Hadoop.Hadoop_260.ex02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * 分组1
 *
 * @author Administrator
 */
public class GroupTest {

	public static void main( String[] args ) throws Exception {

		Job job = Job.getInstance( new Configuration(), GroupTest.class.getSimpleName() );
		job.setJarByClass( GroupTest.class );
		
		FileInputFormat.setInputPaths( job, new Path( args[ 1 ] ) );
		job.setMapperClass( MyMapper.class );
		
		job.setReducerClass( MyReducer.class );
		job.setOutputKeyClass( IntWritable.class );
		job.setOutputValueClass( IntWritable.class );
		
		FileOutputFormat.setOutputPath( job, new Path( args[ 2 ] ) );
		
		job.waitForCompletion( true );
	}

	private static class MyMapper extends Mapper< LongWritable, Text, IntWritable, IntWritable > {

		IntWritable k2 = new IntWritable();
		IntWritable v2 = new IntWritable();

		@Override
		protected void map( LongWritable key, Text value,
		                    Context context )
				throws IOException, InterruptedException {

			String[] splited = value.toString().split( "\t" );
			k2.set( Integer.parseInt( splited[ 0 ] ) );
			v2.set( Integer.parseInt( splited[ 1 ] ) );
			context.write( k2, v2 );
		}
	}
	
	
	private static class MyReducer extends Reducer< IntWritable, IntWritable, IntWritable, IntWritable > {

		IntWritable v3 = new IntWritable();

		@Override
		protected void reduce( IntWritable k2, Iterable< IntWritable > v2s,
		                       Context context )
				throws IOException, InterruptedException {
			
			int max = Integer.MIN_VALUE;
			for ( IntWritable v2 : v2s ) {
				if ( v2.get() > max ) {
					max = v2.get();
				}
			}
			v3.set( max );
			context.write( k2, v3 );
		}
	}
	
	
}
