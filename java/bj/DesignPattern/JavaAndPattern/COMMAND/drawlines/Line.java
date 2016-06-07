package bj.DesignPattern.JavaAndPattern.COMMAND.drawlines;

import java.awt.*;

public class Line {

	private Point start;
	private Point end;

	public Line( Point startPos, Point endPos ) {
		start = startPos;
		end = endPos;
	}

	public void paint( Graphics graphics ) {
		graphics.drawLine( start.x, start.y, end.x, end.y );
	}

}
