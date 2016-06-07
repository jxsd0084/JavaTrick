package bj.DesignPattern.JavaDesignPatterns.builder.src.main;

/**
 * HairColor enumeration
 */
public enum HairColor {

	WHITE, BLOND, RED, BROWN, BLACK;

	@Override
	public String toString() {

		return name().toLowerCase();
	}

}
