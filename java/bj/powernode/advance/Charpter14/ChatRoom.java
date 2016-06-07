package bj.powernode.advance.Charpter14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatRoom {

	private JFrame f;

	private Panel top, top1, topPanel, bottom;

	private ScrollPane scroll;

	private TextArea area;

	private Label sip, sport, text;

	private JButton connect, discon, send;
	private TextField sip1, sport1, text1, sayTo;
	private Socket socket;

	private PrintStream writer;

	public ChatRoom() {

		f = new JFrame( "童童聊天室" );
		f.setBackground( Color.pink );
		top = new Panel();
		top1 = new Panel();
		bottom = new Panel();
		topPanel = new Panel();
		scroll = new ScrollPane();
		area = new TextArea( 20, 50 );
		area.setEditable( false );
		area.setBackground( Color.pink );
		sip = new Label( "服务器IP:" );
		sport = new Label( "端口号：" );
		text = new Label( "对：" );
		sayTo = new TextField( "大家", 10 );
		sayTo.setBackground( Color.pink );
		sayTo.setEditable( false );
		connect = new JButton( "连接服务器" );
		// connect.setIcon(new ImageIcon("pig.jpg"));
		discon = new JButton( "断开服务器" );
		discon.setEnabled( false );
		send = new JButton( "发送" );
		send.setEnabled( false );
		sip1 = new TextField( "127.0.0.1", 10 );
		sport1 = new TextField( "6000", 10 );
		text1 = new TextField( 40 );
		text1.setBackground( Color.pink );

	}

	public void launchFrame() {

		top.add( sip );
		top.add( sip1 );
		top.add( sport );
		top.add( sport1 );
		top1.add( connect );
		top1.add( discon );
		topPanel.setLayout( new BorderLayout() );
		topPanel.add( top, BorderLayout.NORTH );
		topPanel.add( top1, BorderLayout.CENTER );
		scroll.add( area );
		bottom.add( text );
		bottom.add( sayTo );
		bottom.add( text1 );
		bottom.add( send );
		f.add( topPanel, BorderLayout.NORTH );
		f.add( scroll, BorderLayout.CENTER );
		f.add( bottom, BorderLayout.SOUTH );
		f.setSize( 600, 400 );
		f.setResizable( false );
		f.setVisible( true );

		connect.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent event ) {

				String ip   = sip1.getText();
				int    port = Integer.parseInt( sport1.getText() );
				try {
					socket = new Socket( ip, port );
					if ( socket != null ) {
						discon.setEnabled( true );
						send.setEnabled( true );

					}
					socket.setSoTimeout( 0 );

					writer = new PrintStream( socket.getOutputStream() );
					new CreateList( socket, f, area, sayTo );
					connect.setEnabled( false );

				} catch ( UnknownHostException e ) {
					e.printStackTrace();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		} );

		send.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent event ) {

				send();
			}
		} );
		f.addWindowListener( new WindowAdapter() {

			public void windowClosing( WindowEvent e ) {

				System.exit( 0 );
			}
		} );
		text1.addKeyListener( new KeyAdapter() {

			public void keyPressed( KeyEvent e ) {

				if ( e.getKeyCode() == e.VK_ENTER ) {
					send();
				}
			}
		} );

	}

	public void send() {

		String ip   = sayTo.getText();
		String data = text1.getText();
		if ( data.length() == 0 ) {
			JOptionPane.showMessageDialog( f, "输入内容不能为空，请重新输入！" );
		} else {
			writer.println( ip );
			writer.println( data );
			text1.setText( "" );
		}

	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		ChatRoom room = new ChatRoom();
		room.launchFrame();

	}

}
