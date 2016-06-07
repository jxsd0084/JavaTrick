package bj.DesignPattern.JavaAndPattern.BUILDER.EXTENDED;

public class ConcreteBuilder1 extends Builder {

	/**
	 * @label Creates
	 */
	private Product1 product = new Product1();

	public void buildPart1() {
		//build the first part of the product
	}

	public void buildPart2() {
		//build the second part of the product
	}

	public Product retrieveResult() {
		return product;
	}

}
