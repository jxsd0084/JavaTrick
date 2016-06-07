package bj.crazy.ch06.u006;

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

// 再次定义一个Product接口
interface Product {

	int getProduceTime();
}

// 让Printer类实现Output和Product接口
public class Printer implements Output, Product {

	private String[] printData = new String[ MAX_CACHE_LINE ];

	// 用以记录当前需打印的作业数
	private int      dataNum   = 0;

	public void out() {

		// 只要还有作业，继续打印
		while ( dataNum > 0 ) {

			System.out.println( "打印机打印：" + printData[ 0 ] );

			// 把作业队列整体前移一位，并将剩下的作业数减1
			System.arraycopy( printData, 1, printData, 0, -- dataNum );
		}
	}

	public void getData( String msg ) {

		if ( dataNum >= MAX_CACHE_LINE ) {

			System.out.println( "输出队列已满，添加失败" );

		} else {

			//把打印数据添加到队列里，已保存数据的数量加1。
			printData[ dataNum++ ] = msg;
		}
	}

	public int getProduceTime() {

		return 45;
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建一个Printer对象，当成Output使用
		Output o = new Printer();

		o.getData( "轻量级J2EE企业应用实战" );
		o.getData( "Struts2权威指南" );



		o.out();



		o.getData( "基于J2EE的Ajax宝典" );
		o.getData( "Ruby On Rails敏捷开发最佳实践" );

		o.out();



		// 创建一个Printer对象，当成Product使用
		Product p = new Printer();

		System.out.println( p.getProduceTime() );

		// 所有接口类型的引用变量都可直接赋给java.lang.Object类型的变量

		Object obj = p;

	}

}
