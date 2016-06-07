package bj.bigData.HBase.ex03.creater;

import bj.bigData.HBase.ex03.common.utils.HbaseConfigUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.Coprocessor;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.io.encoding.DataBlockEncoding;
import org.apache.hadoop.hbase.io.hfile.Compression.Algorithm;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

/**
 * 表创建程序总父类
 *
 * @author ranhualin
 * @date 2013-7-19
 */
public abstract class BaseCreater {

	protected static final Log        logger     = LogFactory.getLog( BaseCreater.class );
	protected static       Properties prop       = HbaseConfigUtils.getConfigs();
	protected static       String     quorum     = prop.getProperty( "hbase.zookeeper.quorum" );
	protected static       String     clientPort = prop.getProperty( "hbase.zookeeper.property.clientPort" );
	
	private PropertiesInfo info;
	
	public abstract void initTableInfo( PropertiesInfo info );

	public abstract byte[][] buildRegionRange( String tableName );

	public abstract String getTable( String date ) throws ParseException;

	private HBaseAdmin admin;
	
	public BaseCreater() {

		info = new PropertiesInfo( quorum, clientPort );
		initTableInfo( info );
	}

	public void spliter( String table ) throws IOException, ParseException {
		//配置HBase参数
		Configuration conf = HBaseConfiguration.create();
		conf.set( "hbase.zookeeper.quorum", info.getQuorum() );
		conf.set( "hbase.zookeeper.property.clientPort", info.getClientPort() );
		admin = new HBaseAdmin( conf );
		if ( admin.tableExists( table ) ) {
			logger.info( "table [" + table + "] is exists before!!" );
			return;
		}
		try {
			//拆分表
			createPresplitTable( table, info.getFamliy(), conf );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		admin.close();
	}

	@SuppressWarnings( "deprecation" )
	private void createPresplitTable( String tableName, String[] columnFamilies,
	                                  Configuration conf ) throws IOException, InterruptedException, ParseException {
		//预分Region数量
		final int splitCount = info.getRegionSize();
		//输出建表日志
		logger.debug( "Creating table" + tableName + " with " + columnFamilies.length + " column families.  Presplitting to " + splitCount + "regions" );
		String[] coprocessor_path  = info.getCoprocessorPath();
		String[] coprocessor_class = info.getCoprocessorClass();
		String   compression       = info.getCompression();
		String   tableDescriptor   = info.getTableDescriptor();
		
		byte[][] splitrange = buildRegionRange( tableName );
		
		//定义HTableDescriptor对象，用来分发 coprocessor
		HTableDescriptor desc = new HTableDescriptor( tableName );
		if ( coprocessor_path != null && coprocessor_path.length > 0 ) {
			for ( int i = 0; i < coprocessor_path.length; i++ ) {
				Path path = new Path( coprocessor_path[ i ] );
				desc.addCoprocessor( coprocessor_class[ i ], path, Coprocessor.PRIORITY_USER, null );
			}
		}
		//遍历列族的列  实现压缩
		for ( String cf : columnFamilies ) {
			HColumnDescriptor hcd = new HColumnDescriptor( Bytes.toBytes( cf ) );
			if ( compression != null ) {
				if ( compression.toUpperCase().equals( "SNAPPY" ) ) {
					hcd.setCompressionType( Algorithm.SNAPPY );
				}
				if ( compression.toUpperCase().equals( "LZO" ) ) {
					hcd.setCompressionType( Algorithm.LZO );
				}
				if ( compression.toUpperCase().equals( "GZ" ) ) {
					hcd.setCompressionType( Algorithm.GZ );
				}
			}
			if ( tableDescriptor != null ) {
				if ( tableDescriptor.equalsIgnoreCase( "PREFIX" ) ) {
					logger.debug( "tableType = " + DataBlockEncoding.PREFIX.toString() );
					hcd.setDataBlockEncoding( DataBlockEncoding.PREFIX );
				} else if ( tableDescriptor.equalsIgnoreCase( "DIFF" ) ) {
					logger.debug( "tableType = " + DataBlockEncoding.DIFF.toString() );
					hcd.setDataBlockEncoding( DataBlockEncoding.DIFF );
				} else if ( tableDescriptor.equalsIgnoreCase( "FAST_DIFF" ) ) {
					logger.debug( "tableType = " + DataBlockEncoding.FAST_DIFF.toString() );
					hcd.setDataBlockEncoding( DataBlockEncoding.FAST_DIFF );
				}
			}
			//添加压缩后的列
			desc.addFamily( hcd );
		}
		//创建表
		if ( splitrange != null && splitrange.length > 0 ) {
			admin.createTable( desc, splitrange );
		} else {
			admin.createTable( desc );
		}
		//验证已创建的region总数，如果小于规定的region数量，继续等待region创建，直到创建完成为止
		if ( !conf.getBoolean( "split.verify", true ) ) {
			HTable table         = new HTable( conf, tableName );
			int    onlineRegions = 0;
			while ( onlineRegions < splitCount ) {
				//获取已创建的Region数量
				onlineRegions = table.getRegionsInfo().size();
				logger.debug( onlineRegions + " of " + splitCount + " regions online... " );
				if ( onlineRegions < splitCount ) {
					Thread.sleep( 10 * 1000 );  //等待10秒
				}
			}
		}
		logger.debug( "Finished creating table with " + splitCount + "regions" );
	}

	/**
	 * 返回keylength长度的字符串，
	 * 开始perfixLength位为basePerfix，如果basePerfix的长度小于perfixLength则前面添0
	 * 除开perfixLength后面的也是0
	 * 例如：formatKey(9527,10,6)-->0095270000
	 *
	 * @param basePerfix
	 * @param keyLength    key
	 * @param perfixLength
	 * @return
	 */
	protected byte[] formatKey( long basePerfix, int keyLength, int perfixLength ) {

		byte[] b = new byte[ perfixLength ];
		long   d = Math.abs( basePerfix );
		for ( int i = b.length - 1; i >= 0; i-- ) {
			b[ i ] = ( byte ) ( ( d % 10 ) + '0' );
			d /= 10;
		}
		String all = new String( b ) + fzero( "", keyLength - perfixLength );
		return all.getBytes();
	}

	private String fzero( String zz, int length ) {

		if ( zz.length() < length ) {
			return fzero( zz + "0", length );
		} else {
			return zz;
		}
	}
}
