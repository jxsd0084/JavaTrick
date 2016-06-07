package bj.bigData.HBase.ex02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;

import java.io.IOException;

public class HBaseTest {
	
	HBaseAdmin    admin = null;
	Configuration conf  = null;

	/**
	 * 构造函数初始化连接配置信息
	 *
	 * @throws Exception
	 */
	public HBaseTest() {

		conf = new Configuration();
		conf.set( "hbase.rootdir", "hdfs://master:9000/hbase" );
		conf.set( "hbase.zookeeper.quorum", "master:2181" );
		try {
			admin = new HBaseAdmin( conf );
			System.out.println( "hbase连接成功！" );
		} catch ( Exception e ) {
			e.printStackTrace();
			System.out.println( "hbase连接失败！" );
		}
	}

	/**
	 * 主函数测试方法
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		HBaseTest hbase = new HBaseTest();
		// 创建一张表
		hbase.createTable( "stu", "cf" );
		// 获取所有的列表
		hbase.getAllTable();
		// 往表中添加一条数据
		hbase.addOneData( "stu", "key1", "cf", "name", "zhangsan" );
		// 查询一条记录
		hbase.getOneRcord( "stu", "key1" );
		// 查询所有记录
		hbase.getAllData( "stu" );
		// 删除一条记录
//		hbase.deleteAllOnedata("stu", "key1");
		// 删除一条记录的一个值
		hbase.deleteOneRcord( "stu", "rowkey", "cf", "name" );
		// 查询所有记录
		hbase.getAllData( "stu" );
//		// 删除一张表
//		hbase.deleteTable("stu");
		// 查询所有记录
//		hbase.getAllData("stu");		
	}

	/**
	 * 删除一张表
	 *
	 * @param tableName
	 */
	private void deleteTable( String tableName ) {

		if ( admin != null ) {
			try {
				admin.disableTable( tableName );
				admin.deleteTable( tableName );
				System.out.println( tableName + "表删除成功！" );
			} catch ( IOException e ) {
				e.printStackTrace();
				System.out.println( tableName + "表删除失败！" );
			}
		}
	}

	/**
	 * 删除一条记录的一个值
	 *
	 * @param tableName
	 * @param rowkey
	 * @param family
	 * @param qualifier
	 */
	private void deleteOneRcord( String tableName, String rowkey, String family,
	                             String qualifier ) {

		System.out.println( "删除目标表中一条记录的一个值..." );
		HTablePool      hTablePool = new HTablePool( conf, 1000 );
		HTableInterface table      = hTablePool.getTable( tableName );
		Delete          delete     = new Delete( rowkey.getBytes() );
		delete.deleteColumn( family.getBytes(), qualifier.getBytes() );
		try {
			table.delete( delete );
			System.out.println( tableName + " " + rowkey + ", " + family + ":"
			                    + qualifier + " 值删除成功！" );
		} catch ( IOException e ) {
			e.printStackTrace();
			System.out.println( tableName + " " + rowkey + ", " + family + ":"
			                    + qualifier + " 值删除失败！" );
		}

	}

	/**
	 * 删除一条记录
	 *
	 * @param tableName
	 * @param rowkey
	 */
	private void deleteAllOnedata( String tableName, String rowkey ) {

		System.out.println( "删除目标表中的一条记录..." );
		HTablePool      hTablePool = new HTablePool( conf, 1000 );
		HTableInterface table      = hTablePool.getTable( tableName );
		Delete          delete     = new Delete( rowkey.getBytes() );
		try {
			table.delete( delete );
			System.out.println( rowkey + " 记录删除成功！" );
		} catch ( IOException e ) {
			e.printStackTrace();
			System.out.println( rowkey + " 记录删除失败！" );
		}
	}

	/**
	 * 查询所有记录
	 *
	 * @param tableName
	 */
	private void getAllData( String tableName ) {

		System.out.println( "查询目标表中所有记录..." );
		try {
			HTable        hTable  = new HTable( conf, tableName );
			Scan          scan    = new Scan();
			ResultScanner scanner = hTable.getScanner( scan );
			for ( Result result : scanner ) {
				if ( result.raw().length > 0 ) {
					for ( KeyValue kv : result.raw() ) {
						System.out.println( new String( kv.getRow() ) + "\t"
						                    + new String( kv.getValue() ) );
					}
				}
			}
		} catch ( IOException e ) {
			e.printStackTrace();
		}

	}

	/**
	 * 查询一条记录
	 *
	 * @param tableName
	 * @param rowkey
	 */
	private void getOneRcord( String tableName, String rowkey ) {

		System.out.println( "查询一条记录..." );
		HTablePool      hTablePool = new HTablePool( conf, 1000 );
		HTableInterface table      = hTablePool.getTable( tableName );
		Get             get        = new Get( rowkey.getBytes() );
		try {
			Result result = table.get( get );
			if ( result.raw().length > 0 ) {
				for ( KeyValue kv : result.raw() ) {
					System.out.println( new String( kv.getRow() ) + "\t"
					                    + new String( kv.getValue() ) );
//					System.out.println(new String(kv.getKey()) + "\t"
//							+ new String(kv.getValue())); // 乱码
				}
			}
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	/**
	 * 往表中添加一条数据
	 *
	 * @param tableName
	 * @param rowkey
	 * @param family
	 * @param qualifier
	 * @param value
	 */
	private void addOneData( String tableName, String rowkey, String family,
	                         String qualifier, String value ) {

		System.out.println( "向表中添加一条数据..." );
		HTablePool      hTablePool = new HTablePool( conf, 1000 );
		HTableInterface table      = hTablePool.getTable( tableName );
		Put             put        = new Put( rowkey.getBytes() );
		put.add( family.getBytes(), qualifier.getBytes(), value.getBytes() );
		try {
			table.put( put );
			System.out.println( "记录" + rowkey + "添加成功！" );
		} catch ( IOException e ) {
			e.printStackTrace();
			System.out.println( "记录" + rowkey + "添加失败！" );
		}
	}

	/**
	 * 获取所有的列表
	 */
	private void getAllTable() {

		System.out.println( "获取所有的表..." );
		if ( admin != null ) {
			try {
				HTableDescriptor[] listTables = admin.listTables();
				if ( listTables.length > 0 ) {
					for ( HTableDescriptor hTableDescriptor : listTables ) {
						System.out.println( hTableDescriptor.getNameAsString() );
					}
				}
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 创建一张表
	 *
	 * @param tableName
	 * @param family
	 * @throws Exception
	 */
	private void createTable( String tableName, String family ) throws Exception {

		System.out.println( "创建目标表..." + tableName );
		if ( admin.tableExists( tableName ) ) {
			System.out.println( tableName + " 表已经存在" );
		} else {
			HTableDescriptor desc = new HTableDescriptor();
			desc.setName( tableName.getBytes() );
			desc.addFamily( new HColumnDescriptor( family ) );
			admin.createTable( desc );
			System.out.println( tableName + "表创建成功！" );
		}
	}
	
}
