package bj.bigData.Storm.ex03;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import storm.trident.TridentTopology;
import storm.trident.operation.BaseAggregator;
import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.spout.IBatchSpout;
import storm.trident.tuple.TridentTuple;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

/**
 * 单词计数
 *
 * @author Administrator
 */
public class TridentWords2 {
	
	
	public static class DataSpout implements IBatchSpout {
		
		HashMap< Long, List< List< Object > > > batches = new HashMap< Long, List< List< Object > > >();
		
		@Override
		public void open( Map conf, TopologyContext context ) {
			
		}

		@Override
		public void emitBatch( long batchId, TridentCollector collector ) {

			List< List< Object > > batch = this.batches.get( batchId );
			if ( batch == null ) {
				batch = new ArrayList< List< Object > >();
				Collection< File > listFiles = FileUtils.listFiles( new File( "d:\\test1" ), new String[]{ "txt" }, true );
				for ( File file : listFiles ) {
					List< String > lines;
					try {
						lines = FileUtils.readLines( file );
						for ( String line : lines ) {
							batch.add( new Values( line ) );
						}
						FileUtils.moveFile( file, new File( file.getAbsolutePath() + System.currentTimeMillis() ) );
					} catch ( IOException e ) {
						e.printStackTrace();
					}

				}
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

			return new Fields( "line" );
		}
		
	}
	
	
	public static class MySplit extends BaseFunction {

		@Override
		public void execute( TridentTuple tuple, TridentCollector collector ) {

			String   line  = tuple.getString( 0 );
			String[] words = line.split( "\t" );
			for ( String word : words ) {
				collector.emit( new Values( word ) );
			}
		}
	}
	
	
	public static class SumBolt extends BaseFunction {
		
		HashMap< String, Integer > hashMap = new HashMap< String, Integer >();

		@Override
		public void execute( TridentTuple tuple, TridentCollector collector ) {

			String  word  = tuple.getString( 0 );
			Integer count = hashMap.get( word );
			if ( count == null ) {
				count = 0;
			}
			count++;
			hashMap.put( word, count );
			
			Utils.sleep( 1000 );
			System.out.println( "=================================" );
			for ( Entry< String, Integer > entry : hashMap.entrySet() ) {
				System.out.println( entry );
			}
			
		}
		
	}
	
	public static class Arrregate extends BaseAggregator< Map< String, Integer > > {

		@Override
		public Map< String, Integer > init( Object batchId,
		                                    TridentCollector collector ) {

			return new HashMap< String, Integer >();
		}

		@Override
		public void aggregate( Map< String, Integer > val, TridentTuple tuple,
		                       TridentCollector collector ) {

			String word = tuple.getString( 0 );
			val.put( word, MapUtils.getInteger( val, word, 0 ) + 1 );
		}

		@Override
		public void complete( Map< String, Integer > val,
		                      TridentCollector collector ) {

			collector.emit( new Values( val ) );
		}
		
	}
	
	public static class PrintBolt extends BaseFunction {

		HashMap< String, Integer > hashMap = new HashMap< String, Integer >();

		@Override
		public void execute( TridentTuple tuple, TridentCollector collector ) {

			Map< String, Integer > map = ( Map< String, Integer > ) tuple.get( 0 );
			for ( Entry< String, Integer > entry : map.entrySet() ) {
				String  word  = entry.getKey();
				Integer value = entry.getValue();
				Integer count = hashMap.get( word );
				if ( count == null ) {
					count = 0;
				}
				hashMap.put( word, value + count );
			}
			Utils.sleep( 1000 );
			System.out.println( "======================" );
			
			for ( Entry< String, Integer > entry : hashMap.entrySet() ) {
				System.out.println( entry );
			}
		}
		
	}
	

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		TridentTopology tridentTopology = new TridentTopology();
		tridentTopology.newStream( "1", new DataSpout() )
				.each( new Fields( "line" ), new MySplit(), new Fields( "word" ) )
				.groupBy( new Fields( "word" ) )
				.aggregate( new Fields( "word" ), new Arrregate(), new Fields( "map" ) )
				.each( new Fields( "map" ), new PrintBolt(), new Fields( "aaa" ) );


		LocalCluster localCluster = new LocalCluster();
		localCluster.submitTopology( "tridnet", new Config(), tridentTopology.build() );
	}

}
