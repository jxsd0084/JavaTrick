package bj.DesignPattern.JavaDesignPatterns.business_delegate.src.main;

/**
 * Service EJB implementation
 */
public class EjbService implements BusinessService {

	@Override
	public void doProcessing() {

		System.out.println( "EjbService is now processing" );
	}

}
