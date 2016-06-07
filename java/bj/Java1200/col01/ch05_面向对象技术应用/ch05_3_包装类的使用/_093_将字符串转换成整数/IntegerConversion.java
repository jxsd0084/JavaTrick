package bj.Java1200.col01.ch05_面向对象技术应用.ch05_3_包装类的使用._093_将字符串转换成整数;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegerConversion extends JFrame {

	private static final long serialVersionUID = 2999739427405567838L;

	private JPanel     contentPane;
	private JTextField textField;
	private JLabel     label3;

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
					IntegerConversion frame = new IntegerConversion();
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
	public IntegerConversion() {

		setTitle( "\u8BA1\u7B97\u5E73\u65B9\u6570" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 400, 200 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		contentPane.setLayout( new BorderLayout( 0, 0 ) );
		setContentPane( contentPane );

		JPanel panel = new JPanel();
		contentPane.add( panel, BorderLayout.CENTER );
		panel.setLayout( new GridLayout( 3, 1, 5, 5 ) );

		JPanel inputPanel = new JPanel();
		inputPanel.setBorder( new EtchedBorder( EtchedBorder.LOWERED, null, null ) );
		panel.add( inputPanel );
		inputPanel.setLayout( new GridLayout( 0, 2, 0, 0 ) );

		JLabel label1 = new JLabel( "\u8F93\u5165\u76EE\u6807\u5B57\u7B26\u4E32\uFF1A" );
		label1.setFont( new Font( "微软雅黑", Font.PLAIN, 16 ) );
		inputPanel.add( label1 );

		textField = new JTextField();
		textField.setFont( new Font( "微软雅黑", Font.PLAIN, 16 ) );
		inputPanel.add( textField );
		textField.setColumns( 10 );

		JPanel resultPanel = new JPanel();
		resultPanel.setBorder( new EtchedBorder( EtchedBorder.LOWERED, null, null ) );
		panel.add( resultPanel );
		resultPanel.setLayout( new GridLayout( 0, 2, 0, 0 ) );

		JLabel label2 = new JLabel( "\u76EE\u6807\u5B57\u7B26\u4E32\u5E73\u65B9\uFF1A" );
		label2.setFont( new Font( "微软雅黑", Font.PLAIN, 16 ) );
		resultPanel.add( label2 );

		label3 = new JLabel( "" );
		label3.setFont( new Font( "微软雅黑", Font.PLAIN, 16 ) );
		resultPanel.add( label3 );

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder( new EtchedBorder( EtchedBorder.LOWERED, null, null ) );
		panel.add( buttonPanel );

		JButton button = new JButton( "\u8F6C\u6362" );
		button.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {

				do_button_actionPerformed( e );
			}
		} );
		button.setFont( new Font( "微软雅黑", Font.PLAIN, 16 ) );
		buttonPanel.add( button );
	}

	protected void do_button_actionPerformed( ActionEvent e ) {

		String input  = textField.getText();
		int    number = Integer.parseInt( input );
		label3.setText( number * number + "" );
	}
}
