package bj.bigData.Hadoop.Hadoop_241.ex01.mr.dc;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * FlowBean 我们自定义的一种数据类型，必须实现序列化接口
 *
 * @author root
 */
public class FlowsumMapper extends Mapper< LongWritable, Text, Text, FlowBean > {

	@Override
	protected void map( LongWritable key, Text value,
	                    Context context )
			throws IOException, InterruptedException {
		//拿到一行数据
		String line = value.toString();
		//分字段
		String[] fields = StringUtils.split( line, "\t" );
		//拿到我们要的字段信息
		String phoneNB = fields[ 1 ];
		long   up_flow = Long.parseLong( fields[ 7 ] );
		long   d_flow  = Long.parseLong( fields[ 8 ] );
		//封装数据k v 并输出
		context.write( new Text( phoneNB ), new FlowBean( phoneNB, up_flow, d_flow ) );
		
	}
}
