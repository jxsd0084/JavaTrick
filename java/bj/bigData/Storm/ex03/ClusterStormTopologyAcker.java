package bj.bigData.Storm.ex03;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.AuthorizationException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

import java.util.Map;

public class ClusterStormTopologyAcker {
	
	public static class DataSpout extends BaseRichSpout {
		
		private Map                  conf;
		private TopologyContext      context;
		private SpoutOutputCollector collector;
		
		/**
		 * 本实例运行的时，首先被执行一次，并且只能执行一次
		 */
		@Override
		public void open( Map conf, TopologyContext context,
		                  SpoutOutputCollector collector ) {

			this.conf = conf;
			this.context = context;
			this.collector = collector;
		}
		
		/**
		 * 死循环，可以认为是一个while循环
		 * id
		 * content
		 */
		int i = 0;

		@Override
		public void nextTuple() {

			System.out.println( "spout:" + i );
			this.collector.emit( new Values( i++ ), i - 1 );
			Utils.sleep( 1000 );
		}
		
		/**
		 * 表示对发射出去的数据使用字段进行对应
		 */
		@Override
		public void declareOutputFields( OutputFieldsDeclarer declarer ) {
			//声明输出字段
			declarer.declare( new Fields( "num" ) );
		}
		
		@Override
		public void ack( Object msgId ) {

			System.out.println( "执行成功:" + msgId );
		}

		@Override
		public void fail( Object msgId ) {

			System.out.println( "执行失败:" + msgId );
			//TODO--重新发送或者记录起来			
		}
	}
	
	public static class Sumbolt extends BaseRichBolt {
		
		private Map             stormConf;
		private TopologyContext context;
		private OutputCollector collector;
		
		@Override
		public void prepare( Map stormConf, TopologyContext context,
		                     OutputCollector collector ) {

			this.stormConf = stormConf;
			this.context = context;
			this.collector = collector;
		}
		
		int sum = 0;

		@Override
		public void execute( Tuple input ) {
			
			Integer value = input.getIntegerByField( "num" );
			sum += value;
			System.out.println( "sum：" + sum );
			if ( value >= 10 && value <= 20 ) {
				this.collector.ack( input );
			} else {
				this.collector.fail( input );
			}
			
			
			/*try{
				Integer value = input.getIntegerByField("num");
				sum+=value;
				System.out.println("sum："+sum);
				this.collector.ack(input);
			}catch(Exception e){
				this.collector.fail(input);
			}*/
		}

		@Override
		public void declareOutputFields( OutputFieldsDeclarer declarer ) {
			
		}
		
	}


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		TopologyBuilder topologyBuilder = new TopologyBuilder();
		topologyBuilder.setSpout( "spout_id", new DataSpout() );
		topologyBuilder.setBolt( "bolt_id", new Sumbolt() ).shuffleGrouping( "spout_id" );
		
		String simpleName = ClusterStormTopologyAcker.class.getSimpleName();
		try {
			Config stormConf = new Config();
			//设置worker进程使用的数量
			//stormConf.setNumWorkers(2);
			StormSubmitter.submitTopology( simpleName, stormConf, topologyBuilder.createTopology() );
		} catch ( AlreadyAliveException e ) {
			e.printStackTrace();
		} catch ( InvalidTopologyException e ) {
			e.printStackTrace();
		} catch ( AuthorizationException e ) {
			e.printStackTrace();
		}
	}

}
