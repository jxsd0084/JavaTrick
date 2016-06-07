package bj.mldn.javase01.no15;

class A3 {

	private String name;

	public String getName() {

		return this.name;
	}
}

class B3 extends A3 {

	public void fun() {

		System.out.println( "name = " + getName() );
	}

}
