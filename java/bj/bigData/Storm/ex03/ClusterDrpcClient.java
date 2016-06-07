package bj.bigData.Storm.ex03;

import backtype.storm.utils.DRPCClient;
import org.apache.thrift7.TException;
import org.apache.thrift7.transport.TTransportException;

import java.util.HashMap;

public class ClusterDrpcClient {


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {
		// strom1.0.0版本之前的API
//		DRPCClient drpcClient = new DRPCClient("192.168.1.170", 3772);
		DRPCClient drpcClient = null;
		try {
			drpcClient = new DRPCClient( new HashMap(), "192.168.8.242", 3772 );
		} catch ( TTransportException e ) {
			e.printStackTrace();
		}
		String result;
		try {
			result = drpcClient.execute( "hello", "java111" );
			System.out.println( result );
		} catch ( TException e ) {
			e.printStackTrace();
		}
	}

}
