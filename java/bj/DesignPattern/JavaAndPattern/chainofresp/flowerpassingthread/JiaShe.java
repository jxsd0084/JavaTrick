package bj.DesignPattern.JavaAndPattern.chainofresp.flowerpassingthread;

class JiaShe extends Player {

	public JiaShe( Player aSuccessor ) {
		this.setSuccessor( aSuccessor );
	}

	public void handle() {
		if ( DrumBeater.stopped ) {
			System.out.println( "Jia She gotta drink!" );
		} else {
			System.out.println( "Jia She passed!" );
			next();
		}
	}

}
