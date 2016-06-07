package bj.sxt.pattern.factory.abstractFactory;

public interface CarFactory {

	Engine createEngine();

	Seat createSeat();

	Tyre createTyre();
}

