package bj.bigData.HBase.ex03.creater;

/**
 * Properties文件内信息
 *
 * @author ranhualin
 * @date 2013-7-22
 */
public class PropertiesInfo {
	
	private static final String SPLITER = ",";
	
	private String quorum;
	private String clientPort;
	private String famliy           = "";
	private String coprocessorPath  = "";
	private String coprocessorClass = "";
	private String compression;
	private String tableDescriptor;
	private int    regionSize;
	private int    keyLength;
	
	public PropertiesInfo() {
		
	}

	public PropertiesInfo( String quorum, String clientPort ) {

		this.quorum = quorum;
		this.clientPort = clientPort;
	}
	
	public String getQuorum() {

		return quorum;
	}

	public void setQuorum( String quorum ) {

		this.quorum = quorum;
	}

	public String getClientPort() {

		return clientPort;
	}

	public void setClientPort( String clientPort ) {

		this.clientPort = clientPort;
	}

	public String[] getFamliy() {

		return famliy.split( SPLITER );
	}

	public void setFamliy( String famliy ) {

		this.famliy = famliy;
	}

	public String[] getCoprocessorPath() {

		return coprocessorPath.split( SPLITER );
	}

	public void setCoprocessorPath( String coprocessorPath ) {

		this.coprocessorPath = coprocessorPath;
	}

	public String[] getCoprocessorClass() {

		return coprocessorClass.split( SPLITER );
	}

	public void setCoprocessorClass( String coprocessorClass ) {

		this.coprocessorClass = coprocessorClass;
	}

	public String getCompression() {

		return compression;
	}

	public void setCompression( String compression ) {

		this.compression = compression;
	}

	public String getTableDescriptor() {

		return tableDescriptor;
	}

	public void setTableDescriptor( String tableDescriptor ) {

		this.tableDescriptor = tableDescriptor;
	}

	public int getRegionSize() {

		return regionSize;
	}

	public void setRegionSize( int regionSize ) {

		this.regionSize = regionSize;
	}

	public int getKeyLength() {

		return keyLength;
	}

	public void setKeyLength( int keyLength ) {

		this.keyLength = keyLength;
	}
}
