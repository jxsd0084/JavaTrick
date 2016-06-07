package bj.DesignPattern.JavaDesignPatterns.abstractfactory.src.main;

/**
 * KingdomFactory factory interface.
 */
public interface KingdomFactory {

	Castle createCastle();

	King createKing();

	Army createArmy();

}