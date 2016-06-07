package bj.bigData.HBase.ex03.query.endpoint;

import com.boco.DataPlatform.hbase.query.bean.QueryResult;
import org.apache.hadoop.hbase.client.Scan;

/**
 * @author ranhualin
 * @date 2013-7-19
 */
public interface ICoprocessor {

	public < R, S > QueryResult query( final byte[] tableName, final Scan scan ) throws Throwable;

	public < R, S > Long count( final byte[] tableName, final Scan scan ) throws Throwable;
}
