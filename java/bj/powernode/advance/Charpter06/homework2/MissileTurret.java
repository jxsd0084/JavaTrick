package bj.powernode.advance.Charpter06.homework2;

// MissileTurret类继承Weapon类
public class MissileTurret extends Weapon {

	// 有参构造,参数:String类型 name
	public MissileTurret( String name ) {

		super( name );
	}

	// 实现attack抽象方法
	@Override
	public void attack() {

		System.out.println( this.getName() + "导弹在进攻" );
	}
}
