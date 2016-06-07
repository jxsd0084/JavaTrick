package bj.DesignPattern.JavaPattern._05_接口隔离原则.section1;

public class Searcher2 implements ISearcher {

	public IPrettyGirl pettyGirl;

	public Searcher2( IPrettyGirl pettyGirl ) {
		this.pettyGirl = pettyGirl;
	}

	@Override
	public void show() {
		System.out.println( "--------美女的信息如下：---------------" );
		// 展示面容
		this.pettyGirl.goodLooking();
		// 展示身材
		this.pettyGirl.niceFigure();
		// 展示气质
		this.pettyGirl.greatTemperament();
	}

//	@Override
//	public void getPrettyGirl(IPettyGirl pettyGirl) {
//		super.pettyGirl = pettyGirl;
//	}

}
