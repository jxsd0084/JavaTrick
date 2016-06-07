package bj.JavaAlgorithm.basic02.ch01;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Ch1_4 extends Applet //简单实用为主
{
	private Color clr[]={Color.blue,Color.black,Color.red,Color.yellow,Color.green};
	private int r=20,x=120,y=80,d=40,j=138,k=111;//方便修改

	public void paint(Graphics g)
	{ 
		Font font = new Font("楷体",Font.PLAIN,20);//文字字体，大小
		g.setFont(font);
		g.setColor(clr[0]);//第一个圆
		g.drawOval(x-r,y-r,d,d);

		g.setColor(clr[1]);
		g.drawOval((x+36)-r,y-r,d,d);
	

		g.setColor(clr[2]);
		g.drawOval((x+72)-r,y-r,d,d);

		g.setColor(clr[3]);
		g.drawOval(j-r,k-r,d,d);

		g.setColor(clr[4]);//第五个圆
		g.drawOval((j+36)-r,k-r,d,d);

		g.setColor(Color.blue);
		g.setFont(font);

		g.drawString("奥运五环旗",120,169);
	}//END PAINT

}//END CLASS


