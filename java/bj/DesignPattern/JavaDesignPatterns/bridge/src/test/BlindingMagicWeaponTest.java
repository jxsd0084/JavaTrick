package bj.DesignPattern.JavaDesignPatterns.bridge.src.test;

import bj.DesignPattern.JavaDesignPatterns.bridge.src.main.BlindingMagicWeapon;
import bj.DesignPattern.JavaDesignPatterns.bridge.src.main.Excalibur;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Date: 12/6/15 - 11:15 PM
 *
 * @author Jeroen Meulemeester
 */
public class BlindingMagicWeaponTest extends MagicWeaponTest {

	/**
	 * Invoke all possible actions on the weapon and check if the actions are executed on the actual
	 * underlying weapon implementation.
	 */
	@Test
	public void testExcalibur() throws Exception {

		final Excalibur           excalibur           = spy( new Excalibur() );
		final BlindingMagicWeapon blindingMagicWeapon = new BlindingMagicWeapon( excalibur );

		testBasicWeaponActions( blindingMagicWeapon, excalibur );

		blindingMagicWeapon.blind();
		verify( excalibur, times( 1 ) ).blindImp();
		verifyNoMoreInteractions( excalibur );
	}

}
