package bj.DesignPattern.JavaPattern._29_桥梁模式.section4;


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
		System.out.println( "-------房地产公司是这个样子运行的-------" );
		Corp houseCorp = new HouseCorp( new House() ); //先找到房地产公司
		houseCorp.makeMoney(); //看我怎么挣钱

		System.out.println( "\n" );

		//山寨公司生产的产品很多，不过我只要指定产品就成了
		System.out.println( "-------山寨公司是这样运行的-------" );
		Corp shanZhaiCorp = new ShanZhaiCorp( new Clothes() );
		shanZhaiCorp.makeMoney();

	}

}


