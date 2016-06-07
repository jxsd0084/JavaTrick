package bj.powernode.basic.day07.exercise.exercise02;

public class Army {

	// 属性(武器数组)
	private Weapon[] w;  //可以存放各种类型的武器.


	// 构造方法
	public Army() {

		super();
	}

	// 初始化一个军队,并且初始化 “武器库”
	public Army( int maxWeaponCount ) {     // maxWeaponCount 是最大武器数  3
		w = new Weapon[ maxWeaponCount ];   // null,null,null
	}


	// 实例方法.
	// 军队添加武器.
	public void addWeapon( Weapon wa ) {

		if ( w[ 0 ] == null ) { // 武器库是空的.
			w[ 0 ] = wa;
			System.out.println( wa.getName() + "武器添加成功" );
			return;
		}

		boolean flag = true;    // 武器库已满.

		// 遍历数组.
		for ( int i = 1; i < w.length; i++ ) {

			if ( w[ i ] == null ) {

				flag = false;

				w[ i ] = wa;

				System.out.println( wa.getName() + "武器添加成功" );

				break;
			}

		}

		if ( flag ) {

			System.out.println( "添加" + wa.getName() + "武器失败,武器库已满." );
		}

	}


	// 全部攻击
	public void attackAll() {

		// 遍历武器数组,每遍历一次取出一个武器,取出武器调用攻击方法
		for ( int i = 0; i < w.length; i++ ) {

			if ( w[ i ] != null ) {

				w[ i ].attack();
			}

		}
	}

	// 全部移动
	public void moveAll() {
		// 可以移动的才能移动
		for ( int i = 0; i < w.length; i++ ) {

			if ( w[ i ] != null && ( w[ i ] instanceof Mobile ) ) {

				Mobile m = (Mobile) w[ i ];  //

				m.move();
			}
		}
	}

	// setter and getter
	public void setW( Weapon[] w ) {

		this.w = w;
	}

	public Weapon[] getW() {

		return w;
	}

	// 测试
	public static void main( String[] args ) {




		// 1.创建军队
		Army a = new Army( 3 );





		// 2.创建武器对象
		Weapon wa1 = new Tank( "001坦克" );
		Weapon wa2 = new Tank( "002坦克" );
		Weapon wa3 = new Flighter( "747战斗机" );
		Weapon wa4 = new MissileTurret( "201发射塔" );




		// 3.添加武器
		a.addWeapon( wa1 );
		a.addWeapon( wa2 );
		a.addWeapon( wa3 );
		a.addWeapon( wa4 );





		//4.全部攻击
		a.attackAll();

		a.moveAll();

	}

}
