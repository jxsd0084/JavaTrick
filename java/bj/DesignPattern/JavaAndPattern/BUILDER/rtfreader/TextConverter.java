package bj.DesignPattern.JavaAndPattern.BUILDER.rtfreader;

abstract public class TextConverter {

	public void convertCharacter( char c ) {
	}

	public void convertParagraph() {
	}

	public abstract ASCIIText getResult();

}
