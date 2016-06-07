/**
 * @jdk版本:1.6
 * @编码时间:2010-3-20
 */
package bj.Java1200.col02.ch17_解析XML文件.ch17_1_使用SAX读取XML._467;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

/**
 * 从数据源中读取XML
 */
public class ParserInputSource {

	/**
	 * 从数据源读取XML
	 *
	 * @param inputSource 数据源
	 */
	public void parseInputSource( InputSource inputSource ) {

		SAXParser        parser;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			parser = factory.newSAXParser();
			parser.parse( inputSource, new DefaultHandler() );
		} catch ( ParserConfigurationException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( SAXException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 测试
	 *
	 * @param arg
	 */
	public static void main( String[] arg ) {

		String      pathname    = "xmldemo/books.xml";
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream( new File( pathname ) );
		} catch ( FileNotFoundException e1 ) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		InputSource inputSource = new InputSource( inputStream );
		new ParserInputSource().parseInputSource( inputSource );

		try {
			inputStream.close();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
