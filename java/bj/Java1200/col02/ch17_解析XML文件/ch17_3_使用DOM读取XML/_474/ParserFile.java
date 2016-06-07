/**
 * second
 */
package bj.Java1200.col02.ch17_解析XML文件.ch17_3_使用DOM读取XML._474;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * 从文件中读取XML
 */
public class ParserFile {

	/**
	 * 读取XML文件
	 *
	 * @param path
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void parseReadFile( String path ) throws ParserConfigurationException,
			SAXException, IOException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dombuilder = documentBuilderFactory
				.newDocumentBuilder();
		File file = new File( path );
		dombuilder.parse( file );

	}

	/**
	 * 测试
	 *
	 * @param arg
	 */
	public static void main( String[] arg ) {

		ParserFile parserFile = new ParserFile();
		String     path       = "xmldemo/books.xml";
		try {

			parserFile.parseReadFile( path );

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
