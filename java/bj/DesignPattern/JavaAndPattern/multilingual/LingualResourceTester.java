package bj.DesignPattern.JavaAndPattern.multilingual;

public class LingualResourceTester {

	/**
	 * @link aggregation
	 * @directed
	 */
	private LingualResource lnkLingualResource;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		LingualResource ling = LingualResource.getInstance( "en", "US" );

		String usDollar = ling.getLocaleString( "USD" );

		System.out.println( "USD=" + usDollar );

		LingualResource lingZh = LingualResource.getInstance( "zh", "CH" );

		String usDollarZh = lingZh.getLocaleString( "USD" );

		System.out.println( "USD=" + usDollarZh );
	}

}

