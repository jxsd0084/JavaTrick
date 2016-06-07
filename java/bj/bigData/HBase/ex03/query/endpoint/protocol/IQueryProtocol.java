package bj.bigData.HBase.ex03.query.endpoint.protocol;

import com.boco.DataPlatform.hbase.query.bean.QueryResult;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.coprocessor.ColumnInterpreter;
import org.apache.hadoop.hbase.ipc.CoprocessorProtocol;

import java.io.IOException;

/**
 * 查询解释器接口
 *
 * @author ranhualin
 * @date 2013-7-19
 */
public interface IQueryProtocol extends CoprocessorProtocol {

	public < T, S > Long count( ColumnInterpreter< T, S > ci, Scan scan ) throws IOException;

	public < T, S > QueryResult query( ColumnInterpreter< T, S > ci, Scan scan ) throws IOException;
}
