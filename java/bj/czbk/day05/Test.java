package bj.czbk.day05;

class Demo1 {

	public static void main( String[] args ) {

		int x = 4;
		show( x );
		System.out.println( x );
	}

	public static void show( int x ) {

		x = 2;
	}
}

class Demo2 {

	int x = 3;

	public static void main( String[] args ) {

		Demo2 d = new Demo2();
		d.x = 10;
		show( d );  //  show(new Demo());
		System.out.println( d.x );
	}

	public static void show( Demo2 d ) {

		d.x = 6;
	}
}

class Demo3 {

	public static void main( String[] args ) {

		int[] arr = new int[ 2 ];
		show( arr );
		System.out.println( arr[ 0 ] );
	}

	public static void show( int[] arr ) {

		arr[ 0 ]++;
	}
}
