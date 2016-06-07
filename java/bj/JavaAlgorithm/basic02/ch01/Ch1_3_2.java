package bj.JavaAlgorithm.basic02.ch01;

import java.applet.*;
import java.awt.*;

public class Ch1_3_2 extends Applet 
{
	int x,y;
	double a;

	@Override
	public void start() {
		// TODO Auto-generated method stub
		Graphics g=getGraphics();
		for(x=0;x<=750;x+=1)
		{
			g.drawString("·",x,200);
			if(x<=385) g.drawString("·",360,x);
		}
		g.drawString("Y",330,20);
		for(x=360;x<=370;x+=1)
		{
			g.drawString("·",x-10,375-x);
			g.drawString("·",x,x-355);
		}
		g.drawString("X",735,230);
		for(x=740;x<=750;x+=1)
		{
			g.drawString("·",x,x-550);
			g.drawString("·",x,950-x);
		}
		for(x=0;x<=720;x+=1)
		{
			a=Math.cos(x*Math. PI/180+Math.PI);
			y=(int)(200+80*a);
			g.drawString("·",x,y);
		}
		
	}

//	public void init()
//	{
//		
//	
//		
//
//		
//			
//		
//	}

}
