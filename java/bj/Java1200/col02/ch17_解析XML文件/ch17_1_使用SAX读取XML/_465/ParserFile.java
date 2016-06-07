package bj.Java1200.col02.ch17_解析XML文件.ch17_1_使用SAX读取XML._465;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * 从文件中读取XML
 */
public class ParserFile {

	/**
	 * 通过文件读取XML
	 *
	 * @param pathname 文件路径
	 */
	public void parseReadFile( String pathname ) {

		SAXParser        parser;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			parser = factory.newSAXParser();
			File file = new File( pathname );
			parser.parse( file, new DefaultHandler() );
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

		String pathname = "xmldemo/books.xml";
		new ParserFile().parseReadFile( pathname );
	}

}
