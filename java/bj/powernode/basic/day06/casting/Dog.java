package bj.powernode.basic.day06.casting;

public class Dog extends Animal {

	//  子类独特的属性
	String dogAttr;

	public Dog() {

	}

	public Dog( String name, int age, String dogAttr ) {

		super( name, age );
		this.dogAttr = dogAttr;
	}


	//  Dog eat
	public void eat() {

		System.out.println( "dog eat." );
	}

}
