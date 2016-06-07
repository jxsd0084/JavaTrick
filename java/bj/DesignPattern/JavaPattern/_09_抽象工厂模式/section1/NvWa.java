package bj.DesignPattern.JavaPattern._09_抽象工厂模式.section1;


/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         女娲建立起了两条生产线，分别是：
 *         男性生产线
 *         女性生产线
 */
public class NvWa {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		// 第一条生产线，男性生产线
		HumanFactory maleHumanFactory = new MaleFactory();

		// 第二条生产线，女性生产线
		HumanFactory femaleHumanFactory = new FemaleFactory();

		// 生产线建立完毕，开始生产人了:
		Human maleYellowHuman   = maleHumanFactory.createYellowHuman();
		Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();

		System.out.println( "---生产一个黄色女性---" );
		femaleYellowHuman.getColor();
		femaleYellowHuman.talk();
		femaleYellowHuman.getSex();

		System.out.println( "\n---生产一个黄色男性---" );
		maleYellowHuman.getColor();
		maleYellowHuman.talk();
		maleYellowHuman.getSex();
		
		/*
		 * .....
		 * 后面你可以续了
		 */
		Human maleWhiteHuman   = maleHumanFactory.createWhiteHuman();
		Human femaleWhiteHuman = femaleHumanFactory.createWhiteHuman();

		System.out.println( "---生产一个白色女性---" );
		femaleWhiteHuman.getColor();
		femaleWhiteHuman.talk();
		femaleWhiteHuman.getSex();

		System.out.println( "\n---生产一个白色男性---" );
		maleWhiteHuman.getColor();
		maleWhiteHuman.talk();
		maleWhiteHuman.getSex();

		Human maleBlackHuman   = maleHumanFactory.createBlackHuman();
		Human femaleBlackHuman = femaleHumanFactory.createBlackHuman();

		System.out.println( "---生产一个黑色女性---" );
		femaleBlackHuman.getColor();
		femaleBlackHuman.talk();
		femaleBlackHuman.getSex();

		System.out.println( "\n---生产一个黑色男性---" );
		maleBlackHuman.getColor();
		maleBlackHuman.talk();
		maleBlackHuman.getSex();

	}

}
