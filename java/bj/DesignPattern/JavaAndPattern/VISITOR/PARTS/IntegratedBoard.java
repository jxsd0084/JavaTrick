package bj.DesignPattern.JavaAndPattern.VISITOR.PARTS;

public class IntegratedBoard extends Composite {

	public IntegratedBoard() {
		super.add( new MainBoard() );
		super.add( new Cpu() );
	}
}

