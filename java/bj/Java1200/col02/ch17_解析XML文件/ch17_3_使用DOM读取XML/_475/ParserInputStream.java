/**
 * second
 */
package bj.Java1200.col02.ch17_解析XML文件.ch17_3_使用DOM读取XML._475;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 从数据流中读取XML
 */
public class ParserInputStream {

	/**
	 * 使用InputStream读取XML文件
	 *
	 * @param path
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void parseInputStream( String path )
			throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dombuilder = documentBuilderFactory
				.newDocumentBuilder();
		InputStream is = new FileInputStream( path );
		dombuilder.parse( is );
		is.close();

	}

	/**
	 * 测试
	 *
	 * @param arg
	 */
	public static void main( String[] arg ) {

		ParserInputStream parserFile = new ParserInputStream();
		String            path       = "xmldemo/books.xml";
		try {

			parserFile.parseInputStream( path );

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

}
