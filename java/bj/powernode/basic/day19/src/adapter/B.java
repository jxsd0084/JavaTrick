package bj.powernode.basic.day19.src.adapter;

public class B extends B_adapter {

	@Override
	public void a() {
		System.out.println( "a method invoke." );
	}

	@Override
	public void d() {
	}

	public static void main( String[] args ) {
		B b = new B();
		b.a();
	}


}
