package bj.bigData.Hadoop.Hadoop_241.ex01.mr.dc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.UUID;

public class FlowsumRunner extends Configuration implements Tool {

	@Override
	public Configuration getConf() {

		return new Configuration();
	}

	@Override
	public int run( String[] args ) throws Exception {

		Configuration conf = new Configuration();
		Job           job  = Job.getInstance( conf );
		
		job.setJarByClass( FlowsumRunner.class );
		job.setMapperClass( FlowsumMapper.class );
		job.setReducerClass( FlowSumRedcer.class );
		
		job.setMapOutputKeyClass( Text.class );
		job.setMapOutputValueClass( FlowBean.class );
		
		job.setOutputKeyClass( Text.class );
		job.setOutputValueClass( FlowBean.class );
		
		// 需要在运行jar包的时候手动输入input和output路径
//		FileInputFormat.setInputPaths(job, new Path(args[0]));
//		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		FileInputFormat.setInputPaths( job, new Path( "file:///cloud/data/http.dat" ) );
		FileOutputFormat.setOutputPath( job, new Path( "hdfs://master:9000/http_" + UUID.randomUUID() ) );
		
		return job.waitForCompletion( true ) ? 0 : 1;
	}

	public static void main( String[] args ) throws Exception {

		int res = ToolRunner.run( new Configuration(), new FlowsumRunner(), args );
		System.exit( res );
	}

	@Override
	public void setConf( Configuration conf ) {

		new Configuration();
	}
}
