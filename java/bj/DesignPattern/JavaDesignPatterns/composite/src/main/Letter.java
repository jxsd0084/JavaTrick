package bj.DesignPattern.JavaDesignPatterns.composite.src.main;

/**
 * Letter
 */
public class Letter extends LetterComposite {

	private char c;

	public Letter( char c ) {

		this.c = c;
	}

	@Override
	protected void printThisBefore() {

		System.out.print( c );
	}

	@Override
	protected void printThisAfter() {
		// nop
	}

}
