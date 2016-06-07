package bj.powernode.basic.day06.casting;

public class Cat extends Animal {

	//  子类独特的属性
	String catAttr;

	public Cat() {

	}

	public Cat( String name, int age, String catAttr ) {

		super( name, age );
		this.catAttr = catAttr;
	}


	public void run() {

		System.out.println( "Cat is running." );
	}


	// Cat eat
	public void eat() {

		System.out.println( "Cat eat." );
	}

}
