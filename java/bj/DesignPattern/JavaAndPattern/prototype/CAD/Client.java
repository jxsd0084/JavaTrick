/* Generated by Together */

package bj.DesignPattern.JavaAndPattern.prototype.CAD;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		CadSymbolManager csm = new CadSymbolManager();

		CadSymbolLoader  csl = new CadSymbolLoader( csm );

		String fname = "fancyfont";

		csl.loadCadSymbols( fname );

	}

}
