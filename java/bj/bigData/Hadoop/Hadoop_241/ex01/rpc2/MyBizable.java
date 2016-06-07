package bj.bigData.Hadoop.Hadoop_241.ex01.rpc2;

public interface MyBizable {// extends VersionedProtocol


	public static final long versionID = 2345245L;
	
	public abstract String hello( String name );
	
}