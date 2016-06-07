package bj.DesignPattern.JavaAndPattern.BRIDGE.imageviewer;


abstract public class ImageAbstraction {

	public abstract void load();

	public abstract void show();

	/**
	 * @link aggregation
	 * @directed
	 * @supplierRole imp
	 */
	protected ImageImpl imp;

}
