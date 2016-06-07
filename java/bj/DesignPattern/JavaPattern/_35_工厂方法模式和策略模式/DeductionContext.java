package bj.DesignPattern.JavaPattern._35_工厂方法模式和策略模式;


/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class DeductionContext {

	// 扣款策略
	private IDeduction deduction = null;

	// 构造函数传递策略
	public DeductionContext( IDeduction _deduction ) {
		this.deduction = _deduction;
	}

	// 执行扣款
	public boolean exec( Card card, Trade trade ) {
		return this.deduction.exec( card, trade );
	}

}
