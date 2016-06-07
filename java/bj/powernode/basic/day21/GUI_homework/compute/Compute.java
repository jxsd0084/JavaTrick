package bj.powernode.basic.day21.GUI_homework.compute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Compute extends JFrame {
	
	private JPanel upPanel,downPanel;
	private JTextField echoResultField;
	
	private double before,after,result;
	private boolean flag = false;
	private String operator = "";
	
	public Compute(){
		
		setTitle("计算器");//设置标题
		
		setLayout(new BorderLayout());  //设置外部窗体的布局方式:边框布局
		
		
		upPanel = new JPanel();//准备上面板
		upPanel.setLayout(new FlowLayout());
		downPanel = new JPanel(); //准备下面板
		downPanel.setLayout(new GridLayout(4,4,5,5));
		
		add(upPanel,BorderLayout.NORTH); //上面板添加到北部
		add(downPanel,BorderLayout.CENTER); //下面板添加到中部
		
		echoResultField = new JTextField(18); //准备一个显示结果的文本框
		
		upPanel.add(echoResultField);  //添加文本框到上面板上.
		
		//准备16个按钮添加下面板上
		for(int i=1;i<=3;i++){
			JButton button = new JButton(i+"");
			button.addActionListener(new MyActionListener());
			downPanel.add(button);
		}
		
		JButton addButton = new JButton("+");
		addButton.addActionListener(new MyActionListener());
		downPanel.add(addButton);
		
		for(int i=4;i<=6;i++){
			JButton button = new JButton(i+"");
			button.addActionListener(new MyActionListener());
			downPanel.add(button);
		}
		
		JButton jianButton = new JButton("-");
		jianButton.addActionListener(new MyActionListener());
		downPanel.add(jianButton);
		
		for(int i=7;i<=9;i++){
			JButton button = new JButton(i+"");
			button.addActionListener(new MyActionListener());
			downPanel.add(button);
		}
		
		JButton byButton = new JButton("*");
		byButton.addActionListener(new MyActionListener());
		downPanel.add(byButton);
		
		JButton o = new JButton("0");
		o.addActionListener(new MyActionListener());
		downPanel.add(o);
		
		JButton dian = new JButton(".");
		dian.addActionListener(new MyActionListener());
		downPanel.add(dian);
		
		JButton eq = new JButton("=");
		eq.addActionListener(new MyActionListener());
		downPanel.add(eq);
		
		JButton chu = new JButton("/");
		chu.addActionListener(new MyActionListener());
		downPanel.add(chu);
		
		setBounds(420, 160, 220, 220);// 设置大小和位置
	}
	
	
	
	//非静态内部类
	class MyActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			String cmd = e.getActionCommand();
			
			if(!cmd.contains("+") && !cmd.contains("-") && !cmd.contains("*") && !cmd.contains("/") && !cmd.contains("=")){
				if(flag){
					echoResultField.setText("");
					flag = false;  //归位
				}
				echoResultField.setText(echoResultField.getText()+cmd);
			}else if(cmd.contains("=")){
				after = Double.parseDouble(echoResultField.getText());
				if(operator.equals("+")){
					result = before + after;
				}else if(operator.equals("-")){
					result = before - after;
				}else if(operator.equals("*")){
					result = before * after;
				}else if(operator.equals("/")){
					result = before / after;
				}
				
				echoResultField.setText(result+"");
			}else {
				operator = cmd;
				flag = true;
				before = Double.parseDouble(echoResultField.getText());
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Compute c = new Compute();
		c.setVisible(true);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
