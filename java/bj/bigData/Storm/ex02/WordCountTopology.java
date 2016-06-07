package bj.bigData.Storm.ex02;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
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
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCountTopology {
	
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
		 */
		@Override
		public void nextTuple() {
			//获取指定目录下下所有的文件
			Collection< File > files = FileUtils.listFiles( new File( "d:\\test1" ), new String[]{ "txt" }, true );
			for ( File file : files ) {
				try {
					//获取文件的所有行
					List< String > lines = FileUtils.readLines( file );
					for ( String line : lines ) {
						//把每一行都发射出去
						this.collector.emit( new Values( line ) );
					}
					FileUtils.moveFile( file, new File( file.getAbsolutePath() + System.currentTimeMillis() ) );
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
			
		}

		/**
		 * 表示对发射出去的数据使用字段进行对应
		 */
		@Override
		public void declareOutputFields( OutputFieldsDeclarer declarer ) {
			//声明输出字段
			declarer.declare( new Fields( "line" ) );
		}
	}
	
	public static class Splitbolt extends BaseRichBolt {

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

		@Override
		public void execute( Tuple input ) {
			//从tuple中获取每一行数据
			String line = input.getStringByField( "line" );
			//切分每一行数据
			String[] words = line.split( "\t" );
			for ( String word : words ) {
				//把每一个单词发射出去
				this.collector.emit( new Values( word ) );
			}
		}

		@Override
		public void declareOutputFields( OutputFieldsDeclarer declarer ) {

			declarer.declare( new Fields( "word" ) );
		}
	}
	
	
	public static class Countbolt extends BaseRichBolt {
		
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

		HashMap< String, Integer > hashMap = new HashMap< String, Integer >();

		@Override
		public void execute( Tuple input ) {
			//从tuple中获取单词
			String word = input.getStringByField( "word" );
			//对单词进行统计
			Integer count = hashMap.get( word );
			if ( count == null ) {
				count = 0;
			}
			count++;
			hashMap.put( word, count );
			Utils.sleep( 1000 );
			//把统计的结果打印出来
			System.out.println( "=======================================" );
			for ( Entry< String, Integer > entry : hashMap.entrySet() ) {
				System.out.println( entry );
			}
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
		topologyBuilder.setBolt( "bolt_id", new Splitbolt() ).shuffleGrouping( "spout_id" );
		topologyBuilder.setBolt( "bolt_id2", new Countbolt() ).shuffleGrouping( "bolt_id" );
		
		LocalCluster localCluster = new LocalCluster();
		localCluster.submitTopology( "sumtopology", new Config(), topologyBuilder.createTopology() );
	}
	
	
}
