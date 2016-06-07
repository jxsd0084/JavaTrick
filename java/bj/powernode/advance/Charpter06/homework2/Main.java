package bj.powernode.advance.Charpter06.homework2;

public class Main {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		Weapon t1 = new Tank( "坦克1" );
		Weapon t2 = new Tank( "坦克2" );
		Weapon t3 = new Tank( "坦克3" );

		Weapon f1 = new Flighter( "飞机1" );
		Weapon f2 = new Flighter( "飞机2" );
		Weapon f3 = new Flighter( "飞机3" );


		Weapon m1 = new MissileTurret( "导弹1" );
		Weapon m2 = new MissileTurret( "导弹1" );
		Weapon m3 = new MissileTurret( "导弹1" );



		Army a = new Army( 9 );
		a.addWeapon( t1 );
		a.addWeapon( t2 );
		a.addWeapon( t3 );

		a.addWeapon( f1 );
		a.addWeapon( f2 );
		a.addWeapon( f3 );

		a.addWeapon( m1 );
		a.addWeapon( m2 );
		a.addWeapon( m3 );



		a.attackAll();


		a.moveAll();



	}

}
