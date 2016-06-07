package bj.DesignPattern.JavaPattern._05_接口隔离原则.section2;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         星探
 */
public class Searcher extends AbstractSearcher {

	public Searcher( IGoodBodyGirl _goodBodyGirl ) {
		super( _goodBodyGirl );
	}

	public Searcher( IGreatTemperamentGirl _greatTemperamentGirl ) {
		super( _greatTemperamentGirl );
	}

	public Searcher( IGreatTemperamentGirl _greatTemperamentGirl, IGoodBodyGirl _goodBodyGirl ) {
		super( _greatTemperamentGirl, _goodBodyGirl );
	}

	// 展示美女的信息
	public void show() {
		System.out.println( "--------美女的信息如下：---------------" );
		// 外形气质佳的美女
		if ( super.goodBodyGirl != null && super.greatTemperamentGirl != null ) {
			super.goodBodyGirl.goodLooking();
			super.goodBodyGirl.niceFigure();
			super.greatTemperamentGirl.greatTemperament();
		}

		if ( super.goodBodyGirl != null ) { // 展示外形美的美女
			super.goodBodyGirl.goodLooking();
			super.goodBodyGirl.niceFigure();
		}

		if ( super.greatTemperamentGirl != null ) {
			super.greatTemperamentGirl.greatTemperament();
		}

	}

}
