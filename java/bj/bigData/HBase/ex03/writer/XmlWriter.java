package bj.bigData.HBase.ex03.writer;

import com.boco.DataPlatform.hbase.query.bean.ConvertUtils;
import com.boco.DataPlatform.hbase.writer.XmlNode.LogNode;
import com.boco.DataPlatform.hbase.writer.XmlNode.ResultNode;
import com.boco.DataPlatform.hbase.writer.constant.XmlConstants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlWriter {

	private XmlNode node;
	private static final String HEAD = XmlConstants.XMl_HEAD;
	private static final String ROOT = XmlConstants.XML_ROOT;
	public  BufferedWriter writer;
	private long           timeStamp;

	public XmlWriter( File file, XmlNode node, long timeStamp ) {

		try {
			//创建 f的各级父目录
			file.getParentFile().mkdirs();
			writer = new BufferedWriter( new FileWriter( file ) );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		this.node = node;
		this.timeStamp = timeStamp;
	}

	public void writeHead() throws IOException {

		writer.write( HEAD + "\n" );
	}

	public void writeBodyStart() throws IOException {

		writer.write( "<" + ROOT + ">\n" );
	}

	public void wirteBodyEnd() throws IOException {

		writer.write( "</" + ROOT + ">\n" );
	}

	public void writeCommandId() throws IOException {

		writer.write( "\t<commandId>" + String.valueOf( node.getCommanId() )
		              + "</commandId>\n" );
	}

	public void writeIdcId() throws IOException {

		writer.write( "\t<idcId>" + node.getIdcId() + "</idcId>\n" );
	}

	public void writeResult() throws IOException {

		writer.write( "\t<result>\n" );
		String[] metadata = ResultNode.getMetaData();
		String[] datas    = node.getResult().getDatas();
		for ( int i = 0; i < metadata.length; i++ ) {
			writer.write( "\t\t" );
			writeElement( metadata[ i ], datas[ i ] );
		}
		writer.write( "\t</result>\n" );
	}

	private void writeElement( String key, String value ) throws IOException {

		if ( key == "url" && value == null ) {
			return;
		}
		writer.write( "<" + key + ">" + value + "</" + key + ">\n" );
	}

	private void writeLogs() throws IOException {

		List< LogNode > logs = node.getLog();
		if ( logs == null || logs.size() == 0 ) {
			return;
		}
		for ( LogNode log : logs ) {
			writeLog( log );
		}
	}

	private void writeLog( XmlNode.LogNode log ) throws IOException {

		writer.write( "\t<log>\n" );
		String[] metadata = LogNode.getMetaData();
		String[] datas    = log.getDatas();
		for ( int i = 0; i < metadata.length; i++ ) {
			writer.write( "\t\t" );
			writeElement( metadata[ i ], datas[ i ] );
		}
		writer.write( "\t</log>\n" );
	}

	private void writeBodyEnd() throws IOException {

		writer.write( "\n</logQueryResult>" );
	}

	private void writeTimestamp() throws IOException {

		String timeString = ConvertUtils.longToDateString( timeStamp );
		writer.write( "\t<timeStamp>" + timeString + "</timeStamp>\n" );
	}

	public void write() {

		try {
			writeHead();
			writeBodyStart();
			writeCommandId();
			writeIdcId();
			writeResult();
			writeLogs();
			writeTimestamp();
			writeBodyEnd();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	private void close() {

		if ( writer != null ) {
			try {
				writer.close();
			} catch ( IOException e ) {
				
				e.printStackTrace();
			}
		}
	}

	public static void main( String[] args ) {

	}
}
