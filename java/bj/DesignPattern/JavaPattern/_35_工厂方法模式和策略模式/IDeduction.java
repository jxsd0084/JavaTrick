package bj.DesignPattern.JavaPattern._35_工厂方法模式和策略模式;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public interface IDeduction {

	// 扣款,提供交易和卡信息，进行扣款，并返回扣款是否成功
	public boolean exec( Card card, Trade trade );

}
