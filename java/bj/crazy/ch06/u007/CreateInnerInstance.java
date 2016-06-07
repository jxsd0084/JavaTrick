package bj.crazy.ch06.u007;

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
class Out {

	// 定义一个非静态内部类，不使用访问控制符，即同一个包中其他类可访问该内部类
	class In {

		public In( String msg ) {

			System.out.println( msg );
		}
	}
}

public class CreateInnerInstance {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Out.In in = new Out().new In( "测试信息" );

		/*

			上面代码可改为如下三行代码：

			使用OutterClass.InnerClass的形式定义内部类变量
			Out.In in;

			创建外部类实例，非静态内部类实例将寄存在该实例中
			Out out = new Out();

			通过外部类实例和new来调用内部类构造器创建非静态内部类实例
			in = out.new In("测试信息");

		*/

	}
}
