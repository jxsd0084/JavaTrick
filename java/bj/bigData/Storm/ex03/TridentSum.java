package bj.bigData.Storm.ex03;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import storm.trident.TridentTopology;
import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.spout.IBatchSpout;
import storm.trident.tuple.TridentTuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TridentSum {

	public static class SumBolt extends BaseFunction {

		int sum = 0;

		@Override
		public void execute( TridentTuple tuple, TridentCollector collector ) {

			Integer value = tuple.getInteger( 0 );
			sum += value;
			System.out.println( "和为：" + sum );
		}
		
	}
	
	public static class DataSpout implements IBatchSpout {
		
		HashMap< Long, List< List< Object > > > batches = new HashMap< Long, List< List< Object > > >();
		
		@Override
		public void open( Map conf, TopologyContext context ) {
			
		}

		int i = 0;

		@Override
		public void emitBatch( long batchId, TridentCollector collector ) {

			List< List< Object > > batch = this.batches.get( batchId );
			if ( batch == null ) {
				batch = new ArrayList< List< Object > >();
				batch.add( new Values( i++ ) );
				this.batches.put( batchId, batch );
			}
			for ( List< Object > list : batch ) {
				collector.emit( list );
			}
		}

		@Override
		public void ack( long batchId ) {

			this.batches.remove( batchId );
		}

		@Override
		public void close() {
			
		}

		@Override
		public Map getComponentConfiguration() {

			Config conf = new Config();
			conf.setMaxTaskParallelism( 1 );
			return conf;
		}

		@Override
		public Fields getOutputFields() {

			return new Fields( "sentence" );
		}
		
	}
	

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		TridentTopology tridentTopology = new TridentTopology();
		tridentTopology.newStream( "1", new DataSpout() ).each( new Fields( "sentence" ), new SumBolt(), new Fields( "aa" ) );

		LocalCluster localCluster = new LocalCluster();
		localCluster.submitTopology( "tridnet", new Config(), tridentTopology.build() );
	}

}
