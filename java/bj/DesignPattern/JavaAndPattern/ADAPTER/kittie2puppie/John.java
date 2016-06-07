package bj.DesignPattern.JavaAndPattern.ADAPTER.kittie2puppie;

public class John extends Kittie implements Puppie {

	public void wao() {
		this.miao();
	}

	public void fetchBall() {
		this.catchRat();
	}

	public void run() {
		super.run();
	}

	public void sleep() {
		super.sleep();
	}

	public String getName() {
		return super.getName();
	}

	public void setName( String name ) {
		super.setName( name );
	}
}
