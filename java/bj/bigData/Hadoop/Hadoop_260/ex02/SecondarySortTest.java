package bj.bigData.Hadoop.Hadoop_260.ex02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 排序
 *
 * @author Administrator
 */
public class SecondarySortTest {

	public static void main( String[] args ) throws Exception {

		Job job = Job.getInstance( new Configuration(), SecondarySortTest.class.getSimpleName() );
		job.setJarByClass( SecondarySortTest.class );
		
		FileInputFormat.setInputPaths( job, new Path( args[ 1 ] ) );
		job.setMapperClass( MyMapper.class );
		
		job.setReducerClass( MyReducer.class );
		job.setOutputKeyClass( TwoInt.class );
		job.setOutputValueClass( NullWritable.class );
		
		FileOutputFormat.setOutputPath( job, new Path( args[ 2 ] ) );
		
		job.waitForCompletion( true );
	}

	private static class MyMapper extends Mapper< LongWritable, Text, TwoInt, NullWritable > {

		TwoInt k2 = new TwoInt();

		@Override
		protected void map( LongWritable key, Text value,
		                    Context context )
				throws IOException, InterruptedException {

			String[] splited = value.toString().split( "\t" );
			k2.set( Integer.parseInt( splited[ 0 ] ), Integer.parseInt( splited[ 1 ] ) );
			context.write( k2, NullWritable.get() );
		}
	}
	
	
	private static class MyReducer extends Reducer< TwoInt, NullWritable, TwoInt, NullWritable > {

		@Override
		protected void reduce( TwoInt k2, Iterable< NullWritable > v2s,
		                       Context context )
				throws IOException, InterruptedException {

			context.write( k2, NullWritable.get() );
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
