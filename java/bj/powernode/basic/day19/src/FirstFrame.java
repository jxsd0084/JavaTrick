package bj.powernode.basic.day19.src;

import javax.swing.*;

/**
 * java教学中GUI中的第一个程序：窗口(javax.swing.JFrame)
 * <p>
 * 2011-6-02 AM 9:48
 */
public class FirstFrame {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 1.在内存中生成一个JFrame对象(窗口对象)

		// JFrame firstFrame = new JFrame("这是我的第一个窗口");

		JFrame firstFrame = new JFrame();
		firstFrame.setTitle( "这是我的第一个窗口" ); //设置title
		
		/*

		// 2.设置窗口的大小(宽和高)
		// ???缺陷:宽和高最好是相对整个屏幕的大小.
		firstFrame.setSize(300, 300); //以像素为单位.
		
		// 3.设置JFrame出现的位置
		firstFrame.setLocation(420, 160);

		*/

		// 也可以这样去同时设置显示位置和大小
		firstFrame.setBounds( 420, 160, 300, 300 );


		// 4.把窗口显示在屏幕上
		firstFrame.setVisible( true );


		// 5.在关闭JFrame的时候执行默认的操作：退出系统
		firstFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


	}
}
