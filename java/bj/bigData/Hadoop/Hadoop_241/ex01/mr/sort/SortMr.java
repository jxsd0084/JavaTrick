package bj.bigData.Hadoop.Hadoop_241.ex01.mr.sort;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * 必须要在之前的处理结果上再进行MR才行
 * <p>
 * 否则，报错! <NumberFormatException>
 *
 * @author root
 */
public class SortMr {
	
	public static void main( String[] args ) throws IOException, ClassNotFoundException, InterruptedException {

		Job job = Job.getInstance( new Configuration() );
		
		job.setJarByClass( SortMr.class );
		job.setMapperClass( SortMapper.class );
		job.setReducerClass( SortReducer.class );
		
		job.setMapOutputKeyClass( FlowBean.class );
		job.setMapOutputValueClass( NullWritable.class );
		
		job.setOutputKeyClass( Text.class );
		job.setOutputValueClass( FlowBean.class );
		
		FileInputFormat.setInputPaths( job, new Path( args[ 0 ] ) );
		FileOutputFormat.setOutputPath( job, new Path( args[ 1 ] ) );
		
		System.exit( job.waitForCompletion( true ) ? 0 : 1 );
		
	}
	
	public static class SortMapper extends Mapper< LongWritable, Text, FlowBean, NullWritable > {

		@Override
		protected void map(
				LongWritable key,
				Text value,
				Context context )
				throws IOException, InterruptedException {

			String line = value.toString();

			String[] fields = StringUtils.split( line, "\t" );

			String phoneNB = fields[ 0 ];
			long   up_flow = Long.parseLong( fields[ 1 ] );
			long   d_flow  = Long.parseLong( fields[ 2 ] );

			context.write( new FlowBean( phoneNB, up_flow, d_flow ), NullWritable.get() );
		}
		
	}
	
	public static class SortReducer extends Reducer< FlowBean, NullWritable, Text, FlowBean > {

		@Override
		protected void reduce( FlowBean key, Iterable< NullWritable > values,
		                       Context content )
				throws IOException, InterruptedException {

			String phoneNB = key.getPhoneNB();
			content.write( new Text( phoneNB ), key );
		}
		
	}
}

