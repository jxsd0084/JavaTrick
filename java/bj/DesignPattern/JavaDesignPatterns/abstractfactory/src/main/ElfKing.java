package bj.DesignPattern.JavaDesignPatterns.abstractfactory.src.main;

/**
 * ElfKing
 */
public class ElfKing implements King {

	public static final String DESCRIPTION = "This is the Elven king!";

	@Override
	public String getDescription() {

		return DESCRIPTION;
	}
}
