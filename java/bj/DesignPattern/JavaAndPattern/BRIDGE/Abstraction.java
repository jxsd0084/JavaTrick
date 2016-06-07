package bj.DesignPattern.JavaAndPattern.BRIDGE;

abstract public class Abstraction {

	public void operation() {
		imp.operationImp();
	}

	/**
	 * @link aggregation
	 * @directed
	 * @supplierRole impl
	 */
	private Implementor imp;

}
