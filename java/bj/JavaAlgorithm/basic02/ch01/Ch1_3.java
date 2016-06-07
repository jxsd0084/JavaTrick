package bj.JavaAlgorithm.basic02.ch01;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
  图解java数据结构
*/
public class Ch1_3 extends Applet implements ActionListener
{
	int x,y;
	double a;int flag;
	Button bn2=new Button("清除");
	JComboBox list=new JComboBox();
	public void init()
	{
		add(list);
		list.addItem("清除");
		list.addItem("余弦曲线");
		list.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		flag=list.getSelectedIndex();
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

		if(flag==1)
		{
			for(x=0;x<=720;x+=1)
			{
				a=Math.cos(x*Math. PI/180+Math.PI);
				y=(int)(200+80*a);
				g.drawString("·",x,y);
			}
		}
		if(flag==0)
			repaint();
	}
}
