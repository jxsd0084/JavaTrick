package bj.DesignPattern.JavaAndPattern.observersax;

import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;

public class MyReader {

	private static XMLReader      parser  = null;
	private static ContentHandler handler = null;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		try {
			parser = XMLReaderFactory.createXMLReader();

			Writer out = new OutputStreamWriter( System.out );
			handler = new MyHandler( out );
			parser.setContentHandler( handler );

			parser.parse( "myxml.xml" );

			out.flush();
		} catch ( Exception e ) {
			System.err.println( e );
		}
	}

}

