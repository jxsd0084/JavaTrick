package bj.Java1200.col02.ch11_TCP套接字.ch11_1_Socket基础._309;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

@SuppressWarnings( "serial" )
public class ConnectionTimeoutSetFrame extends JFrame {

	private JTextArea    ta_info;
	private ServerSocket server; // 声明ServerSocket对象

	public void getserver() {

		try {
			server = new ServerSocket( 1978 ); // 实例化Socket对象
			server.setSoTimeout( 10000 );// 设置连接超时时间为10秒
			ta_info.append( "服务器套接字已经创建成功\n" ); // 输出信息
			while ( true ) { // 如果套接字是连接状态
				ta_info.append( "等待客户机的连接......\n" ); // 输出信息
				server.accept();// 等待客户机连接
			}
		} catch ( SocketTimeoutException e ) {
			ta_info.append( "连接超时......" );
			JOptionPane.showMessageDialog( null, "连接超时......" );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public static void main( String[] args ) { // 主方法
		ConnectionTimeoutSetFrame frame = new ConnectionTimeoutSetFrame(); // 创建本类对象
		frame.setVisible( true );
		frame.getserver(); // 调用方法
	}

	public ConnectionTimeoutSetFrame() {

		super();
		setTitle( "设置等待连接的超时时间" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 336, 257 );

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add( scrollPane, BorderLayout.CENTER );

		ta_info = new JTextArea();
		scrollPane.setViewportView( ta_info );
	}
}
