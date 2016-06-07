package bj.DesignPattern.JavaAndPattern.COMMAND.stocktrader;

class SellStockCommand implements Command {

	private StockMarket stock;

	public SellStockCommand( StockMarket stock ) {
		stock = stock;
	}

	public void execute() {
		stock.sell();
	}

} 

