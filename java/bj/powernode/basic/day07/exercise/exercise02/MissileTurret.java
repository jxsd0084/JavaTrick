package bj.powernode.basic.day07.exercise.exercise02;

public class MissileTurret extends Weapon {


	public MissileTurret() {

	}

	public MissileTurret( String name ) {

		super( name );
	}

	public void attack() {

		System.out.println( "导弹发射器开始发射导弹攻击." );
	}

}
