package bj.bigData.Storm.ex03;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import storm.trident.Stream;
import storm.trident.TridentTopology;
import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.testing.FixedBatchSpout;
import storm.trident.tuple.TridentTuple;

public class TridentMerge {

	public static class Print extends BaseFunction {

		@Override
		public void execute( TridentTuple tuple, TridentCollector collector ) {

			String value = tuple.getString( 0 );
			System.out.println( value );
		}
		
	}
	

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		FixedBatchSpout spout = new FixedBatchSpout( new Fields( "sentence" ), 1, new Values( "crxy" ) );
		//控制spout循环输出数据
		//spout.setCycle(true);

		TridentTopology tridentTopology = new TridentTopology();
		Stream          newStream       = tridentTopology.newStream( "1", spout );
		Stream          newStream1      = tridentTopology.newStream( "1", spout );
		tridentTopology.merge( newStream, newStream1 ).each( new Fields( "sentence" ), new Print(), new Fields( "aa" ) );

		LocalCluster localCluster = new LocalCluster();
		localCluster.submitTopology( "tridnet", new Config(), tridentTopology.build() );
	}

}
