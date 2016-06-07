package bj.bigData.Hadoop.Hadoop_241.ex01.mr.wc;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WcReducer extends Reducer< Text, LongWritable, Text, LongWritable > {
	
	@Override
	protected void reduce( Text key, Iterable< LongWritable > v2s,
	                       Context context )
			throws IOException, InterruptedException {
		//定义一个计算器
		long counter = 0;
		//循环v2s
		for ( LongWritable v : v2s ) {
			counter += v.get();
		}
		//输出
		context.write( key, new LongWritable( counter ) );
	}
}
