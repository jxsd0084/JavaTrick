package bj.bigData.HBase.ex02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HBaseImport {
	
	private static final String tableName = "logs";
	
	public static void main( String[] args ) throws Exception {
		
		Configuration conf = new Configuration();
		conf.set( "hbase.rootdir", "hdfs://master:9000/hbase" );
		conf.set( "hbase.zookeeper.quorum", "master:2181" );
		conf.set( TableOutputFormat.OUTPUT_TABLE, tableName );

		Job job = Job.getInstance( conf, HBaseImport.class.getSimpleName() );

		TableMapReduceUtil.addDependencyJars( job );
		job.setJarByClass( HBaseImport.class );

		job.setMapperClass( BatchImportMapper.class );
		job.setReducerClass( BatchImportReducer.class );

		job.setMapOutputKeyClass( LongWritable.class );
		job.setMapOutputValueClass( Text.class );

		job.setInputFormatClass( TextInputFormat.class );
		job.setOutputFormatClass( TableOutputFormat.class );

		FileInputFormat.setInputPaths( job, "hdfs://192.168.1.176:9000/data" );

		job.waitForCompletion( true );
	}
	
	static class BatchImportMapper extends
			Mapper< LongWritable, Text, LongWritable, Text > {

		@Override
		protected void map( LongWritable key, Text value,
		                    Context context )
				throws IOException, InterruptedException {

			String           line    = value.toString();
			String[]         splited = line.split( "\t" );
			SimpleDateFormat sdf     = new SimpleDateFormat( "yyyyMMddHHmmss" );
			String           time    = sdf.format( new Date( Long.parseLong( splited[ 0 ].trim() ) ) );
			String           rowKey  = splited[ 1 ] + "_" + time;
			Text             v2s     = new Text();
			v2s.set( rowKey + "\t" + line );
			context.write( key, v2s );
		}
	}

	static class BatchImportReducer extends
			TableReducer< LongWritable, Text, NullWritable > {

		private byte[] family = "cf".getBytes();

		@Override
		protected void reduce(
				LongWritable arg0,
				Iterable< Text > v2s,
				Context context )
				throws IOException, InterruptedException {

			for ( Text v2 : v2s ) {
				String[] splited = v2.toString().split( "\t" );
				String   rowKey  = splited[ 0 ];
				Put      put     = new Put( rowKey.getBytes() );
				put.add( family, "raw".getBytes(), v2.toString().getBytes() );
				put.add( family, "reportTime".getBytes(), splited[ 1 ].getBytes() );
				put.add( family, "msisdn".getBytes(), splited[ 2 ].getBytes() );
				put.add( family, "apmac".getBytes(), splited[ 3 ].getBytes() );
				put.add( family, "acmac".getBytes(), splited[ 4 ].getBytes() );
				put.add( family, "host".getBytes(), splited[ 5 ].getBytes() );
				put.add( family, "siteType".getBytes(), splited[ 6 ].getBytes() );
				put.add( family, "upPackNum".getBytes(), splited[ 7 ].getBytes() );
				put.add( family, "downPackNum".getBytes(), splited[ 8 ].getBytes() );
				put.add( family, "upPayLoad".getBytes(), splited[ 9 ].getBytes() );
				put.add( family, "downPayLoad".getBytes(), splited[ 10 ].getBytes() );
				put.add( family, "httpStatus".getBytes(), splited[ 11 ].getBytes() );
			}
		}
	}

}
