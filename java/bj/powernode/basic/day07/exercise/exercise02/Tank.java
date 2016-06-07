package bj.powernode.basic.day07.exercise.exercise02;
/*

	java中类之间是单继承.
	
	但是一个类可以在继承另一个类的同时去实现多个接口.

*/

public class Tank extends Weapon implements Mobile {

	public Tank() {

	}

	public Tank( String name ) {

		super( name );
	}

	public void attack() {

		System.out.println( "坦克开始攻击." );
	}

	public void move() {

		System.out.println( "坦克开始前进." );
	}

}
