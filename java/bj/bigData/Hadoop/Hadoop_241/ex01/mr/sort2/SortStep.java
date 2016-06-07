package bj.bigData.Hadoop.Hadoop_241.ex01.mr.sort2;

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

public class SortStep {

	public static class SortMapper extends Mapper< LongWritable, Text, InfoBean, NullWritable > {

		private InfoBean bean = new InfoBean();
		
		@Override
		protected void map( LongWritable key, Text value, Context context )
				throws IOException, InterruptedException {

			String   line   = value.toString();
			String[] fields = line.split( "\t" );
			if ( fields.length < 4 ) { // 容错
				return;
			}
			String account  = fields[ 0 ];
			double income   = Double.parseDouble( fields[ 1 ] );
			double expenses = Double.parseDouble( fields[ 2 ] );
			bean.set( account, income, expenses );
			context.write( bean, NullWritable.get() );
		}
		
	}
	
	public static class SortReducer extends Reducer< InfoBean, NullWritable, Text, InfoBean > {

		private Text k = new Text();

		@Override
		protected void reduce( InfoBean bean, Iterable< NullWritable > v2s, Context context )
				throws IOException, InterruptedException {

			String account = bean.getAccount();
			k.set( account );
			context.write( k, bean );
		}
		
	}

	public static void main( String[] args ) throws IOException, ClassNotFoundException, InterruptedException {

		Configuration conf = new Configuration();
		Job           job  = Job.getInstance( conf );
		
		job.setJarByClass( SortStep.class );
		
		job.setMapperClass( SortMapper.class );
		job.setMapOutputKeyClass( InfoBean.class );
		job.setMapOutputValueClass( NullWritable.class );
//		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileInputFormat.setInputPaths( job, new Path( "file:///cloud/data/trade_info.txt" ) );
		
		job.setReducerClass( SortReducer.class );
		job.setOutputKeyClass( Text.class );
		job.setOutputValueClass( InfoBean.class );
//		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		FileOutputFormat.setOutputPath( job, new Path( "hdfs://master:9000/trade.o" ) );
		
		job.waitForCompletion( true );
	}
}
