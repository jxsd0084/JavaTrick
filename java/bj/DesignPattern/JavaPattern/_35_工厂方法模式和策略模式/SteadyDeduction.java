package bj.DesignPattern.JavaPattern._35_工厂方法模式和策略模式;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class SteadyDeduction implements IDeduction {

	// 固定性交易扣款
	public boolean exec( Card card, Trade trade ) {
		// 固定金额和自由金额各扣除50%
		int halfMoney = (int) Math.rint( trade.getAmount() / 2.0 );
		card.setFreeMoney( card.getFreeMoney() - halfMoney );
		card.setSteadyMoney( card.getSteadyMoney() - halfMoney );
		return true;
	}

}
