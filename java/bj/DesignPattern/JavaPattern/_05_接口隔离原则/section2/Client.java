package bj.DesignPattern.JavaPattern._05_接口隔离原则.section2;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         场景类
 */
public class Client {

	// 搜索并展示美女信息
	public static void main( String[] args ) {

		// 定义一个气质美女
		IGreatTemperamentGirl yanYan = new PrettyGirl( "嫣嫣" );

		// 定义一个身材好的美女
		// IGoodBodyGirl yanYan = new PrettyGirl("嫣嫣");
		AbstractSearcher searcher = new Searcher( yanYan );

		// AbstractSearcher searcher = new Searcher(yanYan, yanYan2);
		searcher.show();

	}

}
