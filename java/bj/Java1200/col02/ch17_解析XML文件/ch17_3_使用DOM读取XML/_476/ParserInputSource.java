/**
 * second
 */
package bj.Java1200.col02.ch17_解析XML文件.ch17_3_使用DOM读取XML._476;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * 从数据源中读取XML
 */
public class ParserInputSource {

	/**
	 * 使用InputSource读取XML文件
	 *
	 * @param path
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void parseInputSource( InputSource is )
			throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dombuilder = documentBuilderFactory
				.newDocumentBuilder();
		dombuilder.parse( is );

	}

	/**
	 * 测试
	 *
	 * @param arg
	 */
	public static void main( String[] arg ) {

		ParserInputSource parserFile = new ParserInputSource();
		String            systemId   = "xmldemo/books.xml";
		InputSource       is         = new InputSource( systemId );
		try {
			parserFile.parseInputSource( is );
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
