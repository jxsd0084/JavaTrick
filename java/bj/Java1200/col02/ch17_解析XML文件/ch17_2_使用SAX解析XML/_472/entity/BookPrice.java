/**
 * @jdk版本:1.6
 * @编码时间:2010-3-20
 */
package bj.Java1200.col02.ch17_解析XML文件.ch17_2_使用SAX解析XML._472.entity;

import java.util.Map;

/**
 * 封装Java类, 解析XML元素和属性
 */
public class BookPrice {

	// 属性名称和属性值列表
	private Map< String, String > attributeMap;
	// 价格值
	private Double                value;

	public Map< String, String > getAttributeMap() {

		return this.attributeMap;
	}

	public void setAttributeMap( Map< String, String > attributeMap ) {

		this.attributeMap = attributeMap;
	}

	public Double getValue() {

		return this.value;
	}

	public void setValue( Double value ) {

		this.value = value;
	}

	@Override
	public String toString() {

		StringBuffer buffer = new StringBuffer();
		buffer.append( "[atrributes=" + this.attributeMap + "\n" );
		buffer.append( "vlaue=" + this.value + "\n]" );
		return buffer.toString();
	}
}
