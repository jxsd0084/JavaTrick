package bj.DesignPattern.JavaAndPattern.BUILDER;

public class Client {

	/**
	 * @link aggregation
	 * @directed
	 */
	private Director director;

	private Builder builder = new ConcreteBuilder();

	public void requestBuild() {
		director = new Director( builder );
	}

}
