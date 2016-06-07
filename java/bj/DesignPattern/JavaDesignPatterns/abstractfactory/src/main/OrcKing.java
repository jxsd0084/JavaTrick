package bj.DesignPattern.JavaDesignPatterns.abstractfactory.src.main;

/**
 * OrcKing
 */
public class OrcKing implements King {

	public static final String DESCRIPTION = "This is the Orc king!";

	@Override
	public String getDescription() {

		return DESCRIPTION;
	}

}
