package bj.bigData.Hadoop.Hadoop_241.ex01.rpc;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

import java.io.IOException;

public class RPCServer_NameNode implements ClientProtocal {

	public static void main( String[] args ) throws HadoopIllegalArgumentException, IOException {

		Server server = new RPC.Builder( new Configuration() )
				.setInstance( new RPCServer_NameNode() )
				.setProtocol( ClientProtocal.class )
				.setBindAddress( "192.168.8.242" )
				.setPort( 9123 ).build();
		server.start();
	}

	public String findMetaDataByName( String filename ) {

		System.out.println( "正在从内存中找" + filename + "的元数据信息" );
		return filename + "找到元数据信息";
	}
}