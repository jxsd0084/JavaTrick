package bj.bigData.Hadoop.Hadoop_260.ex01.rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyBizable extends VersionedProtocol {

	long VERSION = 2345245L;

	public abstract String hello( String name );
}