package bj.bigData.Kafka.TestKafka;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Kafka消费者
 */
public class ConsumerDemo {
	
	private static final String  topic   = "order";
	private static final Integer threads = 1;

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Properties props = new Properties();
		props.put( "zookeeper.connect", "zookeeperServer1:2181, zookeeperServer2:2181, zookeeperServer3:2181" );
		props.put( "group.id", "1111" );
		props.put( "auto.offset.reset", "smallest" );

		ConsumerConfig    config   = new ConsumerConfig( props );
		ConsumerConnector consumer = Consumer.createJavaConsumerConnector( config );

		Map< String, Integer > topicCountMap = new HashMap< String, Integer >();
		topicCountMap.put( topic, threads );
		topicCountMap.put( "order", 1 );

		Map< String, List< KafkaStream< byte[], byte[] > > > consumerMap = consumer.createMessageStreams( topicCountMap );
		List< KafkaStream< byte[], byte[] > >                streams     = consumerMap.get( "order" );

		for ( final KafkaStream< byte[], byte[] > kafkaStream : streams ) {
			new Thread( new Runnable() {
				@Override
				public void run() {

					for ( MessageAndMetadata< byte[], byte[] > mm : kafkaStream ) {

						String msg = new String( mm.message() );
						System.out.println( msg );
					}
				}

			} ).start();

		}

	}

}
