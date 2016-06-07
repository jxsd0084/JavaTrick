package bj.DesignPattern.JavaAndPattern.doubledispatch.POINTS;

import java.awt.*;

public class Point {

	private int x;
	private int y;

	public Point() {
	}

	public void draw( Canvas c ) {
		//write you code here
	}

	public void translate( int d ) {
		x += d;
		y += d;
	}

	public void translate( int dx, int dy ) {
		x += dx;
		y += dy;
	}

}

