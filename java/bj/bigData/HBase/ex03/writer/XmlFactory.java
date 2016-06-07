package bj.bigData.HBase.ex03.writer;

import com.boco.DataPlatform.etl.tools.Base64;
import com.boco.DataPlatform.hbase.writer.XmlNode.LogNode;
import com.boco.DataPlatform.hbase.writer.XmlNode.ResultNode;
import com.boco.DataPlatform.hbase.writer.bean.FileCache;
import com.boco.DataPlatform.hbase.writer.bean.FileInfo;
import com.boco.DataPlatform.hbase.writer.constant.XmlConstants;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class XmlFactory implements Runnable {

	private static final String BASE_PATH        = XmlConstants.XMl_BASE_PATH;
	public static final  int    MAX_LOGNODE_SIZE = XmlConstants.XML_MAX_LOGNODE_SIZE;
	
	private static final String SUCCEED_FLAG = "0";
	private static final String FAILED_FLAG  = "1";
	private File file;
	
	private XMLExportResult rs;
	private int             n;
	private boolean         endFlag;
	private CountDownLatch  latch;

	public XmlFactory( XMLExportResult rs, int n, boolean endFlag, CountDownLatch latch ) {

		this.rs = rs;
		this.n = n;
		this.endFlag = endFlag;
		this.latch = latch;
	}
	
	@Override
	public void run() {
		//生成 node
		XmlNode node = makeNode();
		//添加xml文件
		appendXml( node );
		FileCache.put( new FileInfo( file ) );
		latch.countDown();
	}

	public XmlNode makeNode() {

		ResultNode rnod;
		if ( !rs.isSucceed() ) {
			rnod = new ResultNode( 0, 0, FAILED_FLAG );
			XmlNode node = new XmlNode( rs.getCommanId(), rs.getIdc_id(), rnod );
			return node;
		}
		int fromIndex = n * MAX_LOGNODE_SIZE;
		int toIndex;
		if ( endFlag ) {
			rnod = new ResultNode( rs.getSize(), 0, SUCCEED_FLAG );
			toIndex = rs.getSize();
		} else {
			rnod = new ResultNode( rs.getSize(), 1, SUCCEED_FLAG );
			toIndex = ( n + 1 ) * MAX_LOGNODE_SIZE;
		}
		List< List< String > > datas = rs.getDatas().subList( fromIndex, toIndex );
		List< LogNode >        lnods = new ArrayList< LogNode >();
		for ( List< String > s : datas ) {
			String[]        sArray = s.toArray( new String[ s.size() ] );
			String[]        data   = fillData( sArray );
			XmlNode.LogNode lnod   = new XmlNode.LogNode( data );
			lnods.add( lnod );
		}
		XmlNode node = new XmlNode( rs.getCommanId(), rs.getIdc_id(), rnod, lnods );
		return node;
	}
	
	/**
	 * 将结果中的数据 对应到log中的字段
	 *
	 * @param in
	 * @return
	 */
	private String[] fillData( String[] in ) {

		String[]       log_metadata = XmlNode.LogNode.getMetaData();
		List< String > rs_metadata  = rs.getMetadata();
		String[] rs_metadata_to_array = rs_metadata
				.toArray( new String[ rs_metadata.size() ] );
		String[] out = new String[ log_metadata.length ];
		for ( int i = 0; i < out.length; i++ ) {
			if ( log_metadata[ i ].equals( "logId" ) ) {
				int index = rs_metadata.indexOf( "ACCESS_LOGID" );
				out[ i ] = in[ index ];
			}
			for ( int j = 0; j < in.length; j++ ) {
				if ( log_metadata[ i ].equalsIgnoreCase( rs_metadata_to_array[ j ].replace( "_", "" ) ) ) {
					if ( log_metadata[ i ].equals( "url" ) ) {
						//對url进行base64编码
						out[ i ] = Base64.getBASE64( in[ j ] );
					} else {
						out[ i ] = in[ j ];
					}
					break;
				}
			}
		}
		return out;
	}
	
	private String getRandomStr() {

		Random        random = new Random( System.currentTimeMillis() );
		int           n      = random.nextInt( 10000 );
		StringBuilder sb     = new StringBuilder();
		for ( int i = 0; i < 4; i++ ) {
			sb.append( ( char ) ( n % 10 + '0' ) );
			n /= 10;
		}
		return sb.toString();
	}
	
	/**
	 * 添加xml 文件
	 *
	 * @param node
	 */
	private void appendXml( XmlNode node ) {

		long         timeStamp = System.currentTimeMillis();
		StringBuffer sb        = new StringBuffer();
		sb.append( BASE_PATH );
		sb.append( File.separator );
		sb.append( String.valueOf( timeStamp / 1000 ) );
		sb.append( "_" );
		sb.append( rs.getIdc_id() );
		sb.append( "_" );
		sb.append( rs.getCommanId() );
		sb.append( "_" );
		sb.append( getRandomStr() );
		sb.append( ".xml" );
		file = new File( sb.toString() );
		System.out.println( "Thread" + n + "write " + sb.toString() );
		XmlWriter writer = new XmlWriter( file, node, timeStamp );
		writer.write();
	}
}
