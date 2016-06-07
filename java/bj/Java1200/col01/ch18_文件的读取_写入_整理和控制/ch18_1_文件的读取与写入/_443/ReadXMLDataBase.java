package bj.Java1200.col01.ch18_文件的读取_写入_整理和控制.ch18_1_文件的读取与写入._443;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXMLDataBase {

	private Document document;    //定义Document对象

	public String readXml( String passWord ) {

		File                   xml_file = new File( "users.xml" );  //根据XML文件地址
		DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();  //定义从XMl文档获取生成DOM对象的解析器
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse( xml_file ); //根据XML获取DOM文档实例
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		String subNodeTag = document.getElementsByTagName( passWord ).item( 0 )
		                            .getFirstChild().getNodeValue();    //获取指定节点保存的值
		return subNodeTag;           //返回读取的信息
	}

}
