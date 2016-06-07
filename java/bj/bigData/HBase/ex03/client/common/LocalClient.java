package bj.bigData.HBase.ex03.client.common;

import com.boco.DataPlatform.hbase.query.thrift.QueryService.Client;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;


public class LocalClient extends Client {

	private TTransport transport;

	public LocalClient( TProtocol prot, int port, TTransport ftransport ) throws TTransportException {

		super( prot );
		this.transport = ftransport;
	}

	public void close() {

		this.transport.close();
	}
}