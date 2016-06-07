package bj.bigData.Hadoop.Hadoop_241.ex01.rpc3;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

import java.io.IOException;


public class RPCServer implements Barty {
	
	@Override
	public String sayHi( String name ) {

		return "HI~" + name;
	}

	public static void main( String[] args ) throws HadoopIllegalArgumentException, IOException {

		Server server = new RPC.Builder( new Configuration() )
				.setInstance( new RPCServer() )
				.setBindAddress( "192.168.8.242" )
				.setPort( 9527 )
				.setProtocol( Barty.class )
				.build();
		server.start();
	}
	
}
