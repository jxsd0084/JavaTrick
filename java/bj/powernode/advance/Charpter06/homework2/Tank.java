package bj.powernode.advance.Charpter06.homework2;

// Tank类继承Weapon类并且实现Mobile接口
public class Tank extends Weapon implements Mobile {

	// 有参构造,参数:String类型 name
	public Tank( String name ) {

		super( name );
	}

	// 实现attack()方法
	@Override
	public void attack() {

		System.out.println( this.getName() + "在进攻" );
	}

	// 实现move()方法
	@Override
	public void move() {

		System.out.println( this.getName() + "坦克在移动" );
	}

}
