package bj.Java1200.col02.ch17_解析XML文件.ch17_5_使用DOM操作XML._482;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * 创建简单的XML文件
 */
public class BulidFile {

	/**
	 * 创建XML文件
	 *
	 * @param node DOM节点
	 * @param url  XML文件路径
	 */
	public void writeFile( Node node, String url ) {

		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		DOMSource    domSource    = new DOMSource( node );
		StreamResult streamResult = new StreamResult( new File( url ) );
		try {
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform( domSource, streamResult );
		} catch ( TransformerConfigurationException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( TransformerException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 建立XML文件
	 *
	 * @return
	 */
	public Document bulid() {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dombuilder = null;
		try {
			dombuilder = documentBuilderFactory.newDocumentBuilder();
		} catch ( ParserConfigurationException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Document document = dombuilder.newDocument();
		Element  book     = document.createElement( "book:book" );
		book.setAttribute( "xmlns:book", "http://www.mingrisoft.com" );
		document.appendChild( book );

		return document;
	}

	/**
	 * 测试
	 *
	 * @param arg
	 */
	public static void main( String[] arg ) {

		String    pathname = "xmldemo/BulidFile.xml";
		BulidFile bulid    = new BulidFile();
		bulid.writeFile( bulid.bulid(), pathname );

	}

}
