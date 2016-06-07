package bj.Java1200.col02.ch10_网络应用基础.ch10_1_网络地址解析._297;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SuppressWarnings( "serial" )
public class GetLocalHostIpFrame extends JFrame {

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
					GetLocalHostIpFrame frame = new GetLocalHostIpFrame();
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
	public GetLocalHostIpFrame() {

		super();
		getContentPane().setLayout( null );
		setTitle( "获取本地主机的Ip地址" );
		setBounds( 100, 100, 340, 211 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		final JButton button = new JButton();
		button.addActionListener( new ActionListener() {
			public void actionPerformed( final ActionEvent e ) {

				try {
					InetAddress inetAddr = InetAddress.getLocalHost();// 创建本地主机的InetAddress对象
					String      ip       = inetAddr.getHostAddress();// 获得本地主机的IP地址
					tf_ip.setText( ip );// 在文本框中显示IP地址
				} catch ( UnknownHostException e1 ) {
					e1.printStackTrace();
				}
			}
		} );
		button.setText( "获取IP地址" );
		button.setBounds( 29, 113, 106, 28 );
		getContentPane().add( button );

		final JLabel label = new JLabel();
		label.setForeground( new Color( 0, 0, 255 ) );
		label.setFont( new Font( "", Font.BOLD, 16 ) );
		label.setText( "获取本地主机的Ip地址" );
		label.setBounds( 73, 22, 171, 35 );
		getContentPane().add( label );

		final JLabel label_1 = new JLabel();
		label_1.setText( "Ip地址：" );
		label_1.setBounds( 29, 75, 66, 18 );
		getContentPane().add( label_1 );

		tf_ip = new JTextField();
		tf_ip.setBounds( 88, 73, 199, 22 );
		getContentPane().add( tf_ip );

		final JButton button_1 = new JButton();
		button_1.addActionListener( new ActionListener() {
			public void actionPerformed( final ActionEvent e ) {

				System.exit( 0 );
			}
		} );
		button_1.setText( "退出系统" );
		button_1.setBounds( 181, 113, 106, 28 );
		getContentPane().add( button_1 );
		//
	}

}
