package bj.DesignPattern.ym_pattern.state.example4;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		VoteManager vm = new VoteManager();
		for ( int i = 0; i < 10; i++ ) {
			vm.vote( "u1", "A" );
		}
	}

}
