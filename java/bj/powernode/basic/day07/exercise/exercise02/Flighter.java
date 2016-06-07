package bj.powernode.basic.day07.exercise.exercise02;

public class Flighter extends Weapon implements Mobile {

	public Flighter() {

	}

	public Flighter( String name ) {

		super( name );
	}

	public void attack() {

		System.out.println( "战斗机开始攻击." );
	}

	public void move() {

		System.out.println( "战斗机起飞." );
	}

}
