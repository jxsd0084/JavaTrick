package bj.Java1200.col02.ch11_TCP套接字.ch11_1_Socket基础._307;

import javax.swing.*;
import java.awt.*;
import java.net.*;

public class ServerSocketFrame extends JFrame {

	private JTextArea    ta_info;
	private ServerSocket server; // 声明ServerSocket对象
	private Socket       socket; // 声明Socket对象socket

	public void getServer() {

		try {
			server = new ServerSocket( 1978 ); // 实例化Socket对象
			ta_info.append( "服务器套接字已经创建成功\n" ); // 输出信息
			while ( true ) { // 如果套接字是连接状态
				ta_info.append( "等待客户机的连接......\n" ); // 输出信息
				socket = server.accept(); // 实例化Socket对象
				ta_info.append( "连接成功......\n" );
			}
		} catch ( Exception e ) {
			e.printStackTrace(); // 输出异常信息
		}
	}

	public static void main( String[] args ) { // 主方法
		ServerSocketFrame frame = new ServerSocketFrame(); // 创建本类对象
		frame.setVisible( true );
		frame.getServer(); // 调用方法
	}

	public ServerSocketFrame() {

		super();
		setTitle( "建立服务器套接字" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 260, 167 );

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add( scrollPane, BorderLayout.CENTER );

		ta_info = new JTextArea();
		scrollPane.setViewportView( ta_info );
	}
}
