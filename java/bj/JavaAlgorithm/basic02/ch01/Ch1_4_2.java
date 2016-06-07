package bj.JavaAlgorithm.basic02.ch01;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ch1_4_2 extends Applet //简单实用为主
{
	private Color clr[]={Color.blue,Color.black,Color.red,Color.yellow,Color.green};
//	private int r=20,x=120,y=80,d=40,j=141,k=109;//方便修改
	private int r=20,x=120,y=80,d=40,j=138,k=111;//方便修改

	public void paint(Graphics g)
	{ 
		//BasicStroke a=new BasicStroke(3.0f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
		BasicStroke a=new BasicStroke(3.0f);
		((Graphics2D)g).setStroke(a);


		g.setColor(clr[0]);//第一个圆
		//g.drawOval(x-r,y-r,d,d);
		Ellipse2D ellipse=new Ellipse2D.Double(x-r,y-r,d,d);
		((Graphics2D)g).draw(ellipse);
		//((Graphics2D)g).fill(ellipse);

		((Graphics2D)g).setColor(clr[1]);
//		((Graphics2D)g).drawOval((x+42)-r,y-r,d,d);
		((Graphics2D)g).drawOval((x+36)-r,y-r,d,d);

		g.setColor(clr[2]);
//		((Graphics2D)g).drawOval((x+84)-r,y-r,d,d);
		((Graphics2D)g).drawOval((x+72)-r,y-r,d,d);

		g.setColor(clr[3]);
		((Graphics2D)g).drawOval(j-r,k-r,d,d);

		g.setColor(clr[4]);//第五个圆
//		g.drawOval((j+42)-r,k-r,d,d);
		g.drawOval((j+36)-r,k-r,d,d);
		
	
	}//END PAINT

}//END CLASS


