package bj.Java1200.col02.ch10_网络应用基础.ch10_1_网络地址解析._299;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SuppressWarnings( "serial" )
public class ByDomainGainIpFrame extends JFrame {

	private JTextField tf_domain;
	private JTextField tf_ip;

	/**
	 * Launch the application
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					ByDomainGainIpFrame frame = new ByDomainGainIpFrame();
					frame.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the frame
	 */
	public ByDomainGainIpFrame() {

		super();
		getContentPane().setLayout( null );
		setTitle( "通过域名获得IP地址" );
		setBounds( 100, 100, 340, 211 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		final JButton button = new JButton();
		button.addActionListener( new ActionListener() {
			public void actionPerformed( final ActionEvent e ) {

				try {
					String      domain   = tf_domain.getText();// 获得输入的域名
					InetAddress inetAddr = InetAddress.getByName( domain );// 创建InetAddress对象
					String      ip       = inetAddr.getHostAddress();// 获得IP地址
					tf_ip.setText( ip );// 在文本框中显示IP地址
				} catch ( UnknownHostException e1 ) {
					e1.printStackTrace();
				}
			}
		} );
		button.setText( "获取IP地址" );
		button.setBounds( 29, 135, 106, 28 );
		getContentPane().add( button );

		final JLabel label = new JLabel();
		label.setForeground( new Color( 0, 0, 255 ) );
		label.setFont( new Font( "", Font.BOLD, 16 ) );
		label.setText( "通过域名获得IP地址" );
		label.setBounds( 89, 22, 171, 35 );
		getContentPane().add( label );

		final JLabel label_1 = new JLabel();
		label_1.setText( "IP地址：" );
		label_1.setBounds( 29, 98, 66, 18 );
		getContentPane().add( label_1 );

		tf_ip = new JTextField();
		tf_ip.setBounds( 98, 96, 189, 22 );
		getContentPane().add( tf_ip );

		final JButton button_1 = new JButton();
		button_1.addActionListener( new ActionListener() {
			public void actionPerformed( final ActionEvent e ) {

				System.exit( 0 );
			}
		} );
		button_1.setText( "退出系统" );
		button_1.setBounds( 181, 135, 106, 28 );
		getContentPane().add( button_1 );

		final JLabel label_2 = new JLabel();
		label_2.setText( "输入域名：" );
		label_2.setBounds( 29, 63, 66, 18 );
		getContentPane().add( label_2 );

		tf_domain = new JTextField();
		tf_domain.setBounds( 99, 63, 188, 22 );
		getContentPane().add( tf_domain );
		//
	}

}
