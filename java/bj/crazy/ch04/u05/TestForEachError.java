package bj.crazy.ch04.u05;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestForEachError {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		String[] books = {
				"轻量级J2EE企业应用实战",
				"Struts2权威指南",
				"基于J2EE的Ajax宝典"
		};


		// 使用 foreach 循环来遍历数组元素，其中book将会 自动迭代 每个数组元素
		for ( String book : books ) {

			book = "Ruby On Rails敏捷开发最佳实践";

			System.out.println( book );
		}

		System.out.println( books[ 0 ] );




	}

}

