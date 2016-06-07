package bj.bigData.Hadoop.Hadoop_260.ex02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 分区
 *
 * @author Administrator
 */
public class MyPartitionerTest {

	public static void main( String[] args ) throws Exception {

		Job job = Job.getInstance( new Configuration(), MyPartitionerTest.class.getSimpleName() );
		job.setJarByClass( MyPartitionerTest.class );
		
		FileInputFormat.setInputPaths( job, new Path( args[ 1 ] ) );
		//job.setInputFormatClass(TextInputFormat.class);
		job.setMapperClass( MyMapper.class );
		//job.setMapOutputKeyClass(Text.class);
		//job.setMapOutputValueClass(TrafficWritable.class);
		
		job.setPartitionerClass( MyPartitioner.class );
		job.setNumReduceTasks( Integer.parseInt( args[ 0 ] ) );
		
		job.setReducerClass( MyReducer.class );
		job.setOutputKeyClass( Text.class );
		job.setOutputValueClass( TrafficWritable.class );
		
		FileOutputFormat.setOutputPath( job, new Path( args[ 2 ] ) );
		//job.setOutputFormatClass(TextOutputFormat.class);
		
		job.waitForCompletion( true );
	}

	private static class MyPartitioner extends Partitioner< Text, TrafficWritable > {

		@Override
		public int getPartition( Text key, TrafficWritable value, int numPartitions ) {

			return key.toString().length() == 11 ? 0 : 1;
		}
	}
	
	private static class MyMapper extends Mapper< LongWritable, Text, Text, TrafficWritable > {

		Text            k2 = new Text();
		TrafficWritable v2 = new TrafficWritable();

		@Override
		protected void map( LongWritable key, Text value,
		                    Context context )
				throws IOException, InterruptedException {

			String   line    = value.toString();
			String[] splited = line.split( "\t" );
			
			k2.set( splited[ 1 ] );
			v2.set( splited[ 6 ], splited[ 7 ], splited[ 8 ], splited[ 9 ] );
			
			context.write( k2, v2 );
		}
	}
	
	private static class MyReducer extends Reducer< Text, TrafficWritable, Text, TrafficWritable > {

		TrafficWritable v3 = new TrafficWritable();

		@Override
		protected void reduce( Text k2, Iterable< TrafficWritable > v2s,
		                       Context context )
				throws IOException, InterruptedException {

			long t1 = 0L;
			long t2 = 0L;
			long t3 = 0L;
			long t4 = 0L;
			
			for ( TrafficWritable v2 : v2s ) {
				t1 += v2.t1;
				t2 += v2.t2;
				t3 += v2.t3;
				t4 += v2.t4;
			}
			
			v3.set( t1, t2, t3, t4 );
			
			context.write( k2, v3 );
			
		}
	}
	
	private static class TrafficWritable implements Writable {

		public long t1;
		public long t2;
		public long t3;
		public long t4;
		
		public void write( DataOutput out ) throws IOException {

			out.writeLong( t1 );
			out.writeLong( t2 );
			out.writeLong( t3 );
			out.writeLong( t4 );
		}

		public void set( long t1, long t2, long t3, long t4 ) {

			this.t1 = t1;
			this.t2 = t2;
			this.t3 = t3;
			this.t4 = t4;
		}

		public void set( String t1, String t2, String t3, String t4 ) {

			this.t1 = Long.parseLong( t1 );
			this.t2 = Long.parseLong( t2 );
			this.t3 = Long.parseLong( t3 );
			this.t4 = Long.parseLong( t4 );
		}

		public void readFields( DataInput in ) throws IOException {

			this.t1 = in.readLong();
			this.t2 = in.readLong();
			this.t3 = in.readLong();
			this.t4 = in.readLong();
		}
		
		@Override
		public String toString() {

			return Long.toString( t1 ) + "\t" + Long.toString( t2 ) + "\t" + Long.toString( t3 ) + "\t" + Long.toString( t4 );
		}
	}
}
