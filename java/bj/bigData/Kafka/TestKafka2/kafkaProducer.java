package bj.bigData.Kafka.TestKafka2;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

import java.util.Properties;

/**
 * Kafka生产者
 */
public class kafkaProducer extends Thread {
	
	private static String topic = "test";

	public kafkaProducer( String topic ) {

		super();
		this.topic = topic;
	}
	
	@Override
	public void run() {

		Producer< Integer, String > producer = createProducer();

		for ( int i = 1; i <= 1000000; i++ ) {

			try {

				String message = "message:" + i;
				producer.send( new KeyedMessage< Integer, String >( topic, message ) );
				System.out.println( "发送：" + message );

				Thread.currentThread().sleep( 1000 );

			} catch ( InterruptedException e ) {
				e.printStackTrace();

			}
		}
	}
	
	private Producer< Integer, String > createProducer() {

		Properties props = new Properties();
		props.setProperty( "metadata.broker.list", "192.168.3.243:9092" );
		props.setProperty( "serializer.class", StringEncoder.class.getName() );
		return new Producer< Integer, String >( new ProducerConfig( props ) );
	}
	
	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		new kafkaProducer( topic ).start();
	}
	
}
