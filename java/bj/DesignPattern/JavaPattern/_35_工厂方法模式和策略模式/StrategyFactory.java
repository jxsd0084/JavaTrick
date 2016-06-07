package bj.DesignPattern.JavaPattern._35_工厂方法模式和策略模式;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         策略工厂
 */
public class StrategyFactory {

	// 策略工厂
	public static IDeduction getDeduction( StrategyMan strategy ) {
		IDeduction deduction = null;
		try {
			deduction = (IDeduction) Class.forName( strategy.getValue() ).newInstance();
		} catch ( Exception e ) {
			// 异常处理
			e.printStackTrace();
		}
		return deduction;
	}

}
