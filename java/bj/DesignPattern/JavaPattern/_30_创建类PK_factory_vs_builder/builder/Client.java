package bj.DesignPattern.JavaPattern._30_创建类PK_factory_vs_builder.builder;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		// 建造一个成年超人
		SuperMan adultSuperMan = Director.getAdultSuperMan();

		// 展示一下超人的信息
		adultSuperMan.getSpecialTalent();

	}

}
