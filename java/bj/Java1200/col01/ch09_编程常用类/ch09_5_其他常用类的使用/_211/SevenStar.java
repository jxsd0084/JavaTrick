package bj.Java1200.col01.ch09_编程常用类.ch09_5_其他常用类的使用._211;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SevenStar extends JFrame {

	private static final long serialVersionUID = 6787592245621788484L;

	private JPanel     contentPane;
	private JTextField textField;
	private JTextArea  textArea;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		try {
			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" );
		} catch ( Throwable e ) {
			e.printStackTrace();
		}
		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					SevenStar frame = new SevenStar();
					frame.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the frame.
	 */
	public SevenStar() {

		setTitle( "\u4E03\u661F\u5F69\u53F7\u7801\u751F\u6210\u5668" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		contentPane.setLayout( new BorderLayout( 0, 0 ) );
		setContentPane( contentPane );

		JPanel panel = new JPanel();
		contentPane.add( panel, BorderLayout.NORTH );
		panel.setLayout( new GridLayout( 1, 2, 5, 5 ) );

		JLabel label = new JLabel( "\u8BF7\u8F93\u5165\u53F7\u7801\u4E2A\u6570\uFF1A" );
		label.setFont( new Font( "微软雅黑", Font.PLAIN, 18 ) );
		label.setHorizontalAlignment( SwingConstants.CENTER );
		panel.add( label );

		textField = new JTextField();
		textField.setFont( new Font( "微软雅黑", Font.PLAIN, 18 ) );
		panel.add( textField );
		textField.setColumns( 10 );

		JPanel buttonPanel = new JPanel();
		contentPane.add( buttonPanel, BorderLayout.SOUTH );

		JButton button = new JButton( "\u751F\u6210\u53F7\u7801" );
		button.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {

				do_button_actionPerformed( e );
			}
		} );
		button.setFont( new Font( "微软雅黑", Font.PLAIN, 18 ) );
		buttonPanel.add( button );

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add( scrollPane, BorderLayout.CENTER );

		textArea = new JTextArea();
		textArea.setFont( new Font( "微软雅黑", Font.PLAIN, 18 ) );
		scrollPane.setViewportView( textArea );
	}

	protected void do_button_actionPerformed( ActionEvent e ) {

		int times = Integer.parseInt( textField.getText() );// 获得用户输入的需要生成的中奖号码个数
		// 省略提示购买数量太多的代码
		StringBuilder sb = new StringBuilder();// 利用StringBuilder类保存彩票中奖号码
		for ( int i = 0; i < times; i++ ) {
			int    number     = new Random().nextInt( (int) Math.pow( 10, 7 ) );// 生成随机数
			String luckNumber = "" + number;
			while ( luckNumber.length() < 7 ) {
				luckNumber = "0" + luckNumber;// 如果随机数长度不够7位用0补齐
			}
			sb.append( luckNumber + "\n" );
		}
		textArea.setText( sb.toString() );// 显示生成的中奖号码
	}
}
