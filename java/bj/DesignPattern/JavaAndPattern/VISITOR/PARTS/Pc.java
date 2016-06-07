package bj.DesignPattern.JavaAndPattern.VISITOR.PARTS;

public class Pc extends Composite {

	public Pc() {
		super.add( new IntegratedBoard() );
		super.add( new HardDisk() );
		super.add( new Case() );

	}
} 

