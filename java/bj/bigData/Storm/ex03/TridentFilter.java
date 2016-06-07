package bj.bigData.Storm.ex03;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import storm.trident.TridentTopology;
import storm.trident.operation.BaseFilter;
import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.testing.FixedBatchSpout;
import storm.trident.tuple.TridentTuple;

public class TridentFilter {

	public static class Print extends BaseFunction {

		@Override
		public void execute( TridentTuple tuple, TridentCollector collector ) {

			Integer value = tuple.getInteger( 0 );
			System.out.println( value );
		}
		
	}
	
	
	public static class MyFilter extends BaseFilter {

		@Override
		public boolean isKeep( TridentTuple tuple ) {

			Integer value = tuple.getInteger( 0 );
			return value % 2 == 0 ? true : false;
		}
		
	}
	

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		FixedBatchSpout spout = new FixedBatchSpout( new Fields( "sentence" ), 1, new Values( 1 ), new Values( 2 ) );
		//控制spout循环输出数据
		//spout.setCycle(true);

		TridentTopology tridentTopology = new TridentTopology();
		tridentTopology.newStream( "1", spout )
				.each( new Fields( "sentence" ), new MyFilter() )
				.each( new Fields( "sentence" ), new Print(), new Fields( "aa" ) );

		LocalCluster localCluster = new LocalCluster();
		localCluster.submitTopology( "tridnet", new Config(), tridentTopology.build() );
	}

}
