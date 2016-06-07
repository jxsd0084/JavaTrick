package bj.bigData.Zookeeper.ex01.main;

import java.io.IOException;

public class TestZnode {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws IOException
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) throws IOException, KeeperException, InterruptedException {

		// 获取zookeeper对象
		String connectString = "192.168.1.213:2181,192.168.1.212:2181,192.168.1.211:2181";
		Watcher watcher = new Watcher() {
			public void process( WatchedEvent event ) {

				System.out.println( event );
			}
		};

		ZooKeeper zooKeeper = new ZooKeeper( connectString, 99999, watcher );

		// 持久的(以下代码只能执行一次)
		// zooKeeper.create("/pp", " ".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

		// 持久有序的（在/pp/下面增加一个节点，可以重复执行，父节点必须以/结尾）
		// zooKeeper.create("/pp/", " ".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);

		// 临时的(临时的下面不能有孩子)
		zooKeeper.create( "/ee", " ".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL );

		// 临时有序的
		// zooKeeper.create("/pp/", " ".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		
		// http://www.mvnrepository.com/
	}

}
