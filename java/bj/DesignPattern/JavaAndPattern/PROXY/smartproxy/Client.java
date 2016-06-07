package bj.DesignPattern.JavaAndPattern.PROXY.smartproxy;

public class Client {

	/**
	 * @link aggregation
	 * @directed
	 */
	private static Searcher searcher;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		searcher = new Proxy();
		String userId     = "Admin";
		String searchType = "SEARCH_BY_ACCOUNT_NUMBER";

		String result = searcher.doSearch( userId, searchType );

		System.out.println( result );
	}

}

