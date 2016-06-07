package bj.Java1200.col02.ch17_解析XML文件.ch17_2_使用SAX解析XML._473;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * 使用SAX验证DTD
 */
public class ErrorSAXParsing extends DefaultHandler {

	public void warning( SAXParseException exception ) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println( "warning" );
		System.out.println( "错误位置：" + exception.getLineNumber() + "行"
		                    + exception.getColumnNumber() + "列" );
		System.out.println( "错误信息：" + exception.getMessage() );
	}

	public void error( SAXParseException exception ) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println( "error" );
		System.out.println( "错误位置：" + exception.getLineNumber() + "行"
		                    + exception.getColumnNumber() + "列" );
		System.out.println( "错误信息：" + exception.getMessage() );
	}

	public void fatalError( SAXParseException exception ) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println( "fdatalError" );
		System.out.println( "错误位置：" + exception.getLineNumber() + "行"
		                    + exception.getColumnNumber() + "列" );
		System.out.println( "错误信息：" + exception.getMessage() );

	}

	/**
	 * 通过文件读取XML
	 *
	 * @param pathname 文件路径
	 */
	public void parseReadFile( String pathname ) {

		SAXParser        parser;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			factory.setValidating( true );
			factory.setNamespaceAware( true );
			parser = factory.newSAXParser();
			File file = new File( pathname );
			parser.parse( file, this );
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

		String          pathname          = "xmldemo/books.xml";
		ErrorSAXParsing elementSAXParsing = new ErrorSAXParsing();
		elementSAXParsing.parseReadFile( pathname );
	}

}
