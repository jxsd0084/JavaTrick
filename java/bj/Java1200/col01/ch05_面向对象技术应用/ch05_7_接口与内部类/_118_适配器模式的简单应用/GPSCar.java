package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._118_适配器模式的简单应用;

import java.awt.*;

public class GPSCar extends Car implements GPS {

	@Override
	public Point getLocation() {

		Point point = new Point();
		point.setLocation( super.getSpeed(), super.getSpeed() );
		return point;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append( super.toString() );
		sb.append( ", 坐标：(" + getLocation().x + ", " + getLocation().y + ")" );
		return sb.toString();
	}
}
