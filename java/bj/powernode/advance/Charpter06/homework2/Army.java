package bj.powernode.advance.Charpter06.homework2;

/*

 (5)写一个类Army,代表一支军队，这个类有一个属性
 Weapon数组w（用来存储该军队所拥有的所有武器）
 该类还提供一个构造方法，在构造方法里通过传一个int
 类型的参数来限定该类所能拥有的最大武器数量,并用这
 一大小来初始化数组w。该类还提供一个方法
 addWeapon(Weaponwa),表示把参数wa所代表的武器加入到
 数组w中。在这个类中还定义两个方法attackAll()让w数
 组中的所有武器攻击；以及moveAll()让w数组中的所有可
 移动的武器移动。

*/
public class Army {

	// 声明了一个存放武器的数组
	private Weapon[] w;

	// 初始化数组下标,并初始化为0(从数组的0位置开始)
	private int index = 0;

	public Army( int count ) {
		// 将数组放在构造方法中进行初始化初始化
		w = new Weapon[ count ];
	}

	// addWeapon方法,将武器数组传进来作为参数
	public void addWeapon( Weapon wa ) {

		// 如果下标小于武器数组的长度
		if ( index < w.length ) {

			// 将变量赋值给数组下标所指向的元素
			w[ index ] = wa;

			// 下标向上移动
			index++;
		} else {

			// 否则,输出无法添加武器的信息
			System.out.println( "武器库已满,不能在添加武器" );
		}
	}

	// attackAll方法
	public void attackAll() {

		// for循环遍历武器数组
		for ( int i = 0; i < w.length; i++ ) {

			// 将遍历出来 的元素调用attack()方法
			w[ i ].attack();
		}
	}

	// moveAll方法
	public void moveAll() {

		// for循环变量武器数组
		for ( int i = 0; i < w.length; i++ ) {

			// 将取出的元素比较是否是Mobile类的实例
			if ( w[ i ] instanceof Mobile ) {

				// 将取出的元素类型转换为Mobile类
				Mobile m = (Mobile) w[ i ];

				// 取出的元素调用move()方法
				m.move();
			}
		}
	}
}
