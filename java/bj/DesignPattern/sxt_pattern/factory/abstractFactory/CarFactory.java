package bj.DesignPattern.sxt_pattern.factory.abstractFactory;

public interface CarFactory {

	Engine createEngine();

	Seat createSeat();

	Tyre createTyre();
}

