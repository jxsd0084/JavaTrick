package bj.powernode.basic.day24.EMS.view;

import bj.powernode.basic.day25.EMS.common.GBC;
import bj.powernode.basic.day25.EMS.common.Orientation;
import bj.powernode.basic.day25.EMS.common.ScreenSizeKit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * EMS系统中的操作界面
 * @author Administrator
 *
 */
public class OperationPage extends JFrame {
	
	/**
	 * 操作按钮
	 * 		1.录入员工信息
	 * 		2.显示员工列表
	 * 		3.按条件查询员工
	 */
	private JButton entryEInfoButton,echoEListButton,queryEByConditionButton;
	private JPanel mainPanel;
	
	public OperationPage(){
		
		//初始化组件
		entryEInfoButton = new JButton("录入员工信息");
		echoEListButton = new JButton("显示员工列表");
		queryEByConditionButton = new JButton("按条件查询员工");
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createTitledBorder("操作选项"));
		
		//设置标题
		setTitle("操作界面");
		
		//设置大小和位置
		setBounds(ScreenSizeKit.getWidth()/10, 
				  ScreenSizeKit.getHeight()/18,
				  (int)(ScreenSizeKit.getWidth()/7),
				  (int)(ScreenSizeKit.getHeight()/1.2));
		
		//添加面板
		add(mainPanel);
		
		//设置面板的布局方式
		mainPanel.setLayout(new GridBagLayout());
		
		//将组件添加到面板上.
		mainPanel.add(entryEInfoButton,new GBC(0,0,1,1,100,100).setInsets((int)(ScreenSizeKit.getHeight()/1.5), Orientation.BOTTOM).setAnchor(GBC.WEST).setInsets(20, Orientation.LEFT));
		mainPanel.add(echoEListButton,new GBC(0,0,1,1,100,100).setInsets((int)(ScreenSizeKit.getHeight()/1.8), Orientation.BOTTOM).setAnchor(GBC.WEST).setInsets(20, Orientation.LEFT));
		mainPanel.add(queryEByConditionButton,new GBC(0,0,1,1,100,100).setInsets((int)(ScreenSizeKit.getHeight()/2.3), Orientation.BOTTOM).setAnchor(GBC.WEST).setInsets(20, Orientation.LEFT));
		
		
		//添加监听
		//录入员工信息
		entryEInfoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化录入员工信息的页面
				EntryEInfoPage ee = EntryEInfoPage.getMySelf();
				ee.setVisible(true);
				ee.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		
		echoEListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		queryEByConditionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		//设置不可变
		setResizable(false);
		
		
	}
	
	
	//测试
	public static void main(String[] args) {
		OperationPage o = new OperationPage();
		o.setVisible(true);
		o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
