package bj.DesignPattern.JavaPattern._04_迪米特原则.section4;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         业务场景
 */
public class Client {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		InstallSoftware invoker = new InstallSoftware();

		invoker.installWizard( new Wizard() );
	}

}
