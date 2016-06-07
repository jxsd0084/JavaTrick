package bj.powernode.advance.Charpter06.homework2;

// Flighter类基础Weapon类并且实现Mobile接口
public class Flighter extends Weapon implements Mobile {

	// 有参构造方法
	public Flighter( String name ) {

		super( name );
	}

	// 实现attack的抽象方法
	@Override
	public void attack() {

		System.out.println( this.getName() + "飞机在进攻" );
	}

	// 实现mobile的抽象方法
	@Override
	public void move() {

		System.out.println( this.getName() + "飞机在移动" );
	}

}
