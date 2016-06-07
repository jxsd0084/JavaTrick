package bj.bigData.Storm.ex03;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.drpc.LinearDRPCTopologyBuilder;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.AuthorizationException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.Map;

public class ClusterDrpcServer {
	
	public static class MyBolt extends BaseRichBolt {

		private OutputCollector collector;
		
		@Override
		public void prepare( Map stormConf, TopologyContext context,
		                     OutputCollector collector ) {

			this.collector = collector;
		}
		
		/**
		 * tuple封装了两个参数
		 * 第一个参数是ID
		 * 第二个参数是具体的数据
		 */
		@Override
		public void execute( Tuple input ) {

			String value = input.getString( 1 );
			value = "hello " + value;
			this.collector.emit( new Values( input.getValue( 0 ), value ) );
		}

		@Override
		public void declareOutputFields( OutputFieldsDeclarer declarer ) {

			declarer.declare( new Fields( "id", "param" ) );
		}
		
	}


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		LinearDRPCTopologyBuilder linearDRPCTopologyBuilder = new LinearDRPCTopologyBuilder( "hello" );
		linearDRPCTopologyBuilder.addBolt( new MyBolt() );
		
		try {
			StormSubmitter.submitTopology( "drpc", new Config(), linearDRPCTopologyBuilder.createRemoteTopology() );
		} catch ( AlreadyAliveException e ) {
			e.printStackTrace();
		} catch ( InvalidTopologyException e ) {
			e.printStackTrace();
		} catch ( AuthorizationException e ) {
			e.printStackTrace();
		}
	}
	
}
