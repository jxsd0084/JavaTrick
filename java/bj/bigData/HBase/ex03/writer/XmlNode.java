package bj.bigData.HBase.ex03.writer;

import com.boco.DataPlatform.utils.ConfigUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class XmlNode {

	private String     commanId;
	private String     idcId;
	private ResultNode result;
	private List< LogNode > logs = new ArrayList< LogNode >();
	private static final Properties prop;

	static {
		prop = ConfigUtils.getConfig( "/config/AccessLogs_Xml.properties" );
	}

	public XmlNode() {
		
	}

	public List< LogNode > getLogs() {

		return logs;
	}

	public void setLogs( List< LogNode > logs ) {

		this.logs = logs;
	}

	public void setCommanId( String commanId ) {

		this.commanId = commanId;
	}

	public void setIdcId( String idcId ) {

		this.idcId = idcId;
	}

	public void setResult( ResultNode result ) {

		this.result = result;
	}

	public XmlNode( String commanId, String idcId, ResultNode result ) {

		this.commanId = commanId;
		this.idcId = idcId;
		this.result = result;
	}

	public XmlNode( String commanId, String idcId, ResultNode result, List< LogNode > log ) {

		this.commanId = commanId;
		this.idcId = idcId;
		this.result = result;
		this.logs = log;
	}

	public static class ResultNode {

		private static String[] metaData;

		static {
			String[] metadatas = prop.getProperty( "result.metadata" ).split( "," );
			setMetaData( metadatas );
		}

		private String[] datas = new String[ metaData.length ];

		public String[] getDatas() {

			return datas;
		}

		public static String[] getMetaData() {

			return metaData;
		}
		
		public static void setMetaData( String[] metaData ) {

			ResultNode.metaData = metaData;
		}

		public ResultNode( long logAmount, int endFlag, String msgInfo ) {

			datas[ 0 ] = String.valueOf( logAmount );
			datas[ 1 ] = String.valueOf( endFlag );
			datas[ 2 ] = msgInfo == null ? "" : msgInfo;
		}
		
	}

	public static class LogNode {

		private static String[] metaData;

		static {
			String[] metadatas = prop.getProperty( "log.metadata" ).split( "," );
			setMetaData( metadatas );
		}

		private String[] datas = new String[ metaData.length ];

		public LogNode( String[] datas ) {

			this.datas = datas;
		}

		public String[] getDatas() {

			return datas;
		}

		public static void setMetaData( String[] metaData ) {

			LogNode.metaData = metaData;
		}

		public static String[] getMetaData() {

			return metaData;
		}
	}
	
	public String getCommanId() {

		return this.commanId;
	}
	
	public String getIdcId() {

		if ( idcId == null ) {
			idcId = "";
		}
		return idcId;
	}

	public ResultNode getResult() {

		return result;
	}

	public List< LogNode > getLog() {

		return logs;
	}
}
