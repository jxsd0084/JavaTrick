package bj.DesignPattern.JavaAndPattern.STRATEGY.sortarray;

public class Sorter {

	public void sort() {
		sortStrategy.sort();
	}

	public void setSortStrategy( SortStrategy sort ) {
		this.sortStrategy = sort;
	}

	/**
	 * @link aggregation
	 * @directed
	 */
	private SortStrategy sortStrategy;

}
