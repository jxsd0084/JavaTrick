package bj.bigData.Hadoop.Hadoop_241.ex01.rpc;

public interface ClientProtocal {
	
	public static final long versionID = 123123l;
	
	public String findMetaDataByName( String filename );
}

