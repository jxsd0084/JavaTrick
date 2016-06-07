package bj.bigData.Kafka.TestKafka2;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Kafka消费者
 */
public class kafkaConsumer extends Thread {
	
	private static String topic = "test";

	public kafkaConsumer( String topic ) {

		super();
		this.topic = topic;
	}
	
	@Override
	public void run() {

		ConsumerConnector      consumer      = createConsumer();
		Map< String, Integer > topicCountMap = new HashMap< String, Integer >();
		topicCountMap.put( topic, 1 );
		Map< String, List< KafkaStream< byte[], byte[] > > > messageStreams = consumer.createMessageStreams( topicCountMap );
		KafkaStream< byte[], byte[] >                        kafkaStream    = messageStreams.get( topic ).get( 0 );
		ConsumerIterator< byte[], byte[] >                   iterator       = kafkaStream.iterator();

		while ( iterator.hasNext() ) {

			byte[] message = iterator.next().message();
			System.out.println( "接收到：" + new String( message ) );
		}

	}
	
	private ConsumerConnector createConsumer() {

		Properties props = new Properties();
		props.setProperty( "zookeeper.connect", "192.168.3.243:2181" );
		props.setProperty( "group.id", "group1" );
		return Consumer.createJavaConsumerConnector( new ConsumerConfig( props ) );
	}
	
	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		new kafkaConsumer( topic ).start();
	}
	
}
