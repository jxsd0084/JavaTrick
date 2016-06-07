package bj.DesignPattern.JavaAndPattern.COMMAND.stocktrader;

// Invoker. Invoker.java 
public class Broker {

	/**
	 * @link aggregation
	 */
	private Command buyCommand, sellCommand;

	public Broker( Command buy, Command sell ) {
		buyCommand = buy;
		sellCommand = sell;
	}

	void buy() {
		buyCommand.execute();
	}

	void sell() {
		sellCommand.execute();
	}

} 
