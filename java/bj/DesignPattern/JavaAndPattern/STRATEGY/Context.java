package bj.DesignPattern.JavaAndPattern.STRATEGY;

public class Context {

	public void contextInterface() {
		strategy.strategyInterface();
	}

	/**
	 * @link aggregation
	 * @directed
	 */
	private Strategy strategy;
}
