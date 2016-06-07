/**
 * second
 */
package bj.Java1200.col02.ch17_解析XML文件.ch17_4_使用DOM解析XML._479;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析XML元素属性和属性值
 */
public class AttriburteDOMParserFile {

	private List< String > elementList = new ArrayList< String >();

	/**
	 * 读取XML文件
	 *
	 * @param path
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public Document parseReadFile( String path )
			throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dombuilder = documentBuilderFactory
				.newDocumentBuilder();
		File file = new File( path );
		return dombuilder.parse( file );
	}

	/**
	 * 获取{@link Node}的name，和value
	 *
	 * @param parentNode
	 */
	public void getElementName( Node parentNode ) {

		if ( parentNode.hasChildNodes() ) {
			NodeList nodeList = parentNode.getChildNodes();
			for ( int i = 0; i < nodeList.getLength(); i++ ) {
				Node node = nodeList.item( i );
				if ( node.hasChildNodes() ) {
					getElementName( node );
					NamedNodeMap namedNodeMap = node.getAttributes();
					for ( int j = 0; j < namedNodeMap.getLength(); j++ ) {
						Node node2 = namedNodeMap.item( j );
						elementList.add( node.getNodeName() + " = "
						                 + node2.getNodeName() + " > "
						                 + node2.getNodeValue() );
					}
				}
			}
		}
	}

	public List< String > getElementList() {

		return this.elementList;
	}

	/**
	 * 测试
	 *
	 * @param arg
	 */
	public static void main( String[] arg ) {

		AttriburteDOMParserFile parserFile = new AttriburteDOMParserFile();
		String                  path       = "xmldemo/books.xml";
		try {

			Document document = parserFile.parseReadFile( path );
			parserFile.getElementName( document );
			List< String > list = parserFile.getElementList();
			System.out.println( "属性名称和属性值" );
			System.out.println( list );
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
