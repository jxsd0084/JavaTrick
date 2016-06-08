package bj.DesignPattern.JavaPattern._05_接口隔离原则.section1;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         场景类
 */
public class Client {

	// 搜索并展示美女信息
	public static void main( String[] args ) {

		// 定义一个美女
		IPrettyGirl yanYan = new PrettyGirl( "嫣嫣" );

//		AbstractSearcher searcher = new Searcher(yanYan);

		ISearcher searcher = new Searcher2( yanYan );

		searcher.show();

	}

}

/*

接口分为两种：

● 实例接口（Object Interface），在Java中声明一个类，然后用new关键字产生一个实
例，它是对一个类型的事物的描述，这是一种接口。

● 类接口（Class Interface），Java中经常使用的interface关键字定义的接口。



我们可以把这两个定义概括为一句话：建立单一接口，不要建立臃肿庞大的接口。再通
俗一点讲：接口尽量细化，同时接口中的方法尽量少。



4.3 保证接口的纯洁性

● 接口要尽量小

● 接口要高内聚

● 定制服务

● 接口设计是有限度的



4.4 最佳实践

● 一个接口只服务于一个子模块或业务逻辑；

● 通过业务逻辑压缩接口中的public方法，接口时常去回顾，尽量让接口达到“满身筋骨
肉”，而不是“肥嘟嘟”的一大堆方法；

● 已经被污染了的接口，尽量去修改，若变更的风险较大，则采用适配器模式进行转化
处理；

● 了解环境，拒绝盲从。每个项目或产品都有特定的环境因素，别看到大师是这样做的
你就照抄。千万别，环境不同，接口拆分的标准就不同。深入了解业务逻辑，最好的接口设
计就出自你的手中！



 */
