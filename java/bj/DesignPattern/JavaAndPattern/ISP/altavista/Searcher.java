package bj.DesignPattern.JavaAndPattern.ISP.altavista;

public interface Searcher {

	void search( String[] keywords );

	void getResultset();

	/**
	 * @link aggregation
	 * @directed
	 */
	/*#Resultset lnkResultset;*/

}
