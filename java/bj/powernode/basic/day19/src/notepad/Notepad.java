package bj.powernode.basic.day19.src.notepad;

import javax.swing.*;
import java.awt.*;

/**
 * 编写记事本
 * 	1.布局
 * 	2.JMenuBar,JMenu,JMenuItem的使用.
 * @author Administrator
 *
 */
public class Notepad extends JFrame {
	
	private JPanel topPanel,bottomPanel;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu menu1,menu2;
	private JMenuItem menuItem1,menuItem2,menuItem3,menuItem4,menuItem5;
	private JTextArea textArea;
	
	public Notepad(){
		
		setTitle("记事本"); //设置标题
		
		setLayout(new BorderLayout()); //主窗口设置布局方式是 “边框布局”
		
		topPanel = new JPanel();  //顶部面板
		bottomPanel = new JPanel(); //底部面板
		
		topPanel.setLayout(new BorderLayout()); //顶部面板“边框布局”
		
		menuBar = new JMenuBar();  //创建菜单栏
		
		menu1 = new JMenu("文件");//准备菜单 " 文件"
		//给menu1准备菜单项
		menuItem1 = new JMenuItem("新建");
		menuItem2 = new JMenuItem("打开");
		menuItem3 = new JMenuItem("保存");
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		
		
		menu2 = new JMenu("帮助");//准备菜单 " 编辑"
		//给menu2准备菜单项
		menuItem4 = new JMenuItem("帮助主题");
		menuItem5 = new JMenuItem("关于记事本");
		menu2.add(menuItem4);
		menu2.add(menuItem5);
		
		//将菜单添加到菜单栏
		menuBar.add(menu1); 
		menuBar.add(menu2);
		
		topPanel.add(menuBar,BorderLayout.NORTH);  //菜单栏添加到北部
		
		bottomPanel.setLayout(new BorderLayout()); //底部面板“边框布局”
		
		
		//准备文本域
		textArea = new JTextArea("你好,我不好",50,50);
		scrollPane = new JScrollPane(textArea);
		bottomPanel.add(scrollPane,BorderLayout.CENTER);
		
		
		add(topPanel,BorderLayout.NORTH); //顶部面板添加到北部
		add(bottomPanel,BorderLayout.CENTER); //底部面板添加到中部.
		
		setBounds(250, 100, 900, 600); //设置大小和位置
		
	}
	
	
	//主方法
	public static void main(String[] args) {
		Notepad notepad = new Notepad();
		notepad.setVisible(true);
		notepad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
