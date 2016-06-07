package bj.Java1200.col01.ch05_面向对象技术应用.ch05_4_面向对象的特征._099_重写父类中的方法;

public class Manager extends Employee {

	@Override
	public String getInfo() {

		return "子类：我是明日科技的经理！";
	}

}
