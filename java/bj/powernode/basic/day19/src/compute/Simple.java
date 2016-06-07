package bj.powernode.basic.day19.src.compute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simple {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		Compute c = new Compute();
		c.setVisible( true );
		c.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}


class Compute extends JFrame {

	private JTextField dataTextField;
	private JButton    b1, b2;


	// 非静态成员内部类
	class MyActionListener implements ActionListener {

		public void actionPerformed( ActionEvent e ) {
			String before = dataTextField.getText();
			dataTextField.setText( before + e.getActionCommand() );
		}

	}

	public Compute() {

		// 设置布局管理器
		setLayout( new FlowLayout() );

		// 准备三个组件
		dataTextField = new JTextField( 10 );
		b1 = new JButton( "1" );
		b1.addActionListener( new MyActionListener() );
		b2 = new JButton( "2" );
		b2.addActionListener( new MyActionListener() );

		// 添加
		add( dataTextField );
		add( b1 );
		add( b2 );


		// 设置大小和显示位置
		setBounds( 420, 160, 300, 300 );

	}
}



