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
