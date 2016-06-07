package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._120_局部内部类的简单应用;

import javax.swing.*;

public class Test {

	public static void main( String[] args ) {

		AlarmClock clock = new AlarmClock( 1000, true );
		clock.start();
		JOptionPane.showMessageDialog( null, "是否退出？" );
		System.exit( 0 );
	}
}
