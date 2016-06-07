package bj.Java1200.col01.ch24_数据库高级应用.ch24_4_使用视图._601_获取数据库中的全部用户视图;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class GetViewsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					GetViewsFrame frame = new GetViewsFrame();
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
	public GetViewsFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );

		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 434, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "显示数据库中所有视图" );
		messageLabel.setBounds( 139, 24, 157, 15 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 70, 72, 285, 150 );
		panel.add( scrollPane );

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView( textArea );
		GetViews views = new GetViews();
		List     list  = views.selectView();
		for ( int i = 0; i < list.size(); i++ ) {
			String name = list.get( i ).toString();
			textArea.append( name + "\n" );
		}
	}
}
