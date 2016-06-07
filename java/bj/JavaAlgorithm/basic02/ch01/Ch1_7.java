package bj.JavaAlgorithm.basic02.ch01;/*
* 双缓存显示图片
*/

import java.applet.*;
import java.awt.*;


public class Ch1_7 extends Applet
{ 
   int width, height; 
   Image image; //缓冲区对象

   Graphics g1; 
   
   public void init()
   { 
	   setBackground(Color.black); 
	   this.setSize(350, 310); 

	   width = getSize().width; 
	   height = getSize().height; 
	   image = createImage(width, height); 
	   g1 = image.getGraphics(); 
   } 
   public void paint(Graphics g)
   { 
	   g1.clearRect(0, 0, width, height); 
	   g1.setColor(Color.red); 
	   int i, j; 
	   double x, y, r; 

	   for(i = 0; i <= 90; i++) //横向变化
		   for(j = 0; j  <= 90; j++)//竖向变化
		   { 
		  
			   //转换为直角坐标
			   r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18; 
			   x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + width / 2; 
			   y = -r * Math.sin(Math.PI / 45 * j) + height / 4; 
		
			   g1.fillOval((int) x, (int)y, 2,2); 
//			   g1.fillRect((int) x, (int)y, 1,1);
		   } 
	   //显示缓存区的可变Image对象
	   g.drawImage(image, 0, 0, this); 
   } 
} 
