package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._118_适配器模式的简单应用;

public class Car {

	private String name;
	private double speed;

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public double getSpeed() {

		return speed;
	}

	public void setSpeed( double speed ) {

		this.speed = speed;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append( "车名:" + name + ", " );
		sb.append( "速度：" + speed + "千米/小时" );
		return sb.toString();
	}
}
