package bj.bigData.Hadoop.Hadoop_260.ex02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 分组2
 *
 * @author Administrator
 */
public class Group2Test {

	public static void main( String[] args ) throws Exception {

		Job job = Job.getInstance( new Configuration(), Group2Test.class.getSimpleName() );
		job.setJarByClass( Group2Test.class );
		
		FileInputFormat.setInputPaths( job, new Path( args[ 0 ] ) );
		job.setMapperClass( MyMapper.class );
		job.setMapOutputKeyClass( TwoInt.class );
		job.setMapOutputValueClass( IntWritable.class );
		
		job.setGroupingComparatorClass( MyGroupingComparator.class );
		
		job.setReducerClass( MyReducer.class );
		job.setOutputKeyClass( IntWritable.class );
		job.setOutputValueClass( IntWritable.class );
		
		FileOutputFormat.setOutputPath( job, new Path( args[ 1 ] ) );
		
		job.waitForCompletion( true );
	}
	
	private static class MyGroupingComparator implements RawComparator {

		public int compare( Object o1, Object o2 ) {

			return 0;
		}

		public int compare( byte[] b1, int s1, int l1, byte[] b2, int s2, int l2 ) {

			return WritableComparator.compareBytes( b1, s1, l1 - 4, b2, s2, l2 - 4 );
		}
		
	}

	private static class MyMapper extends Mapper< LongWritable, Text, TwoInt, IntWritable > {

		TwoInt      k2 = new TwoInt();
		IntWritable v2 = new IntWritable();

		@Override
		protected void map( LongWritable key, Text value,
		                    Context context )
				throws IOException, InterruptedException {

			String[] splited = value.toString().split( "\t" );
			k2.set( Integer.parseInt( splited[ 0 ] ), Integer.parseInt( splited[ 1 ] ) );
			v2.set( Integer.parseInt( splited[ 1 ] ) );
			context.write( k2, v2 );
		}
	}
	
	
	private static class MyReducer extends Reducer< TwoInt, IntWritable, IntWritable, IntWritable > {

		IntWritable k3 = new IntWritable();
		IntWritable v3 = new IntWritable();

		@Override
		protected void reduce( TwoInt k2, Iterable< IntWritable > v2s,
		                       Context context )
				throws IOException, InterruptedException {

			int max = Integer.MIN_VALUE;
			for ( IntWritable v2 : v2s ) {
				if ( v2.get() > max ) {
					max = v2.get();
				}
			}
			k3.set( k2.t1 );
			v3.set( max );
			context.write( k3, v3 );
		}
	}
	
	private static class TwoInt implements WritableComparable< TwoInt > {

		public int t1;
		public int t2;
		
		public void write( DataOutput out ) throws IOException {

			out.writeInt( t1 );
			out.writeInt( t2 );
		}

		public void set( int t1, int t2 ) {

			this.t1 = t1;
			this.t2 = t2;
		}

		public void readFields( DataInput in ) throws IOException {

			this.t1 = in.readInt();
			this.t2 = in.readInt();
		}

		public int compareTo( TwoInt o ) {

			if ( this.t1 == o.t1 ) {
				return this.t2 - o.t2;
			}
			
			return this.t1 - o.t1;
		}
		
		@Override
		public String toString() {

			return t1 + "\t" + t2;
		}
	}
}
