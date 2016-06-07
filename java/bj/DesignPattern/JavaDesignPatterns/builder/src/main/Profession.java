package bj.DesignPattern.JavaDesignPatterns.builder.src.main;

/**
 * Profession enumeration
 */
public enum Profession {

	WARRIOR, THIEF, MAGE, PRIEST;

	@Override
	public String toString() {

		return name().toLowerCase();
	}

}
