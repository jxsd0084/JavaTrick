package bj.Java1200.col01.ch18_文件的读取_写入_整理和控制.ch18_1_文件的读取与写入._444;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReaderJarFrame extends JFrame {

	private JPanel     contentPane;
	private JTextField pathTextField;
	private JTable     table;
	private LocalTableModel model = new LocalTableModel();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					ReaderJarFrame frame = new ReaderJarFrame();
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
	public ReaderJarFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );
		setTitle( "获取Jar文件的文件属性" );
		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 434, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "文件：" );
		messageLabel.setBounds( 39, 25, 41, 15 );
		panel.add( messageLabel );

		pathTextField = new JTextField();
		pathTextField.setBounds( 90, 22, 185, 21 );
		panel.add( pathTextField );
		pathTextField.setColumns( 10 );

		JButton button = new JButton( "选择" );
		button.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_button_actionPerformed( arg0 );
			}
		} );
		button.setBounds( 305, 21, 79, 23 );
		panel.add( button );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 30, 77, 372, 152 );
		panel.add( scrollPane );

		table = new JTable( model );
		scrollPane.setViewportView( table );
	}

	//打开按钮的单击事件
	protected void do_button_actionPerformed( ActionEvent arg0 ) {

		FileDialog fd = new FileDialog( this );
		fd.setVisible( true );
		String path = fd.getDirectory() + fd.getFile();
		if ( path.endsWith( ".jar" ) ) {
			pathTextField.setText( path );
			ReadJar readjar = new ReadJar();
			List    list    = ReadJar.process( path );
			for ( int i = 0; i < list.size(); i++ ) {
				FileName fileName = (FileName) list.get( i );
				model.addRow( new Object[]{ fileName.getName(), fileName.getSize() } );
			}

		}

	}
}
