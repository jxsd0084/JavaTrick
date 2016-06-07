package bj.bigData.Kafka.TestKafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Kafka生产者
 */
public class ProducerDemo {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) throws InterruptedException {

		Properties props = new Properties();
		props.put( "zk.connect",
				"zookeeperServer1:2181, zookeeperServer2:2181, zookeeperServer3:2181" );
		props.put( "metadata.broker.list",
				"zookeeperServer1:9092, zookeeperServer2:9092, zookeeperServer3:9092" );
		props.put( "serializer.class", "kafka.serializer.StringEncoder" );

		ProducerConfig             config   = new ProducerConfig( props );
		Producer< String, String > producer = new Producer< String, String >( config );

		// 发送业务消息
		// 读取文件 读取内存数据库 读socket端口
		for ( int i = 1; i <= 100; i++ ) {
			Thread.sleep( 500 );
			producer.send( new KeyedMessage< String, String >( "order", "我是第" + i
			                                                            + "次来买东本西！" ) );
		}

	}

}
