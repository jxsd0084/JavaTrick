package bj.Java1200.col01.ch24_数据库高级应用.ch24_1_在Java程序中使用存储过程._586_修改存储过程;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ALterProcFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					ALterProcFrame frame = new ALterProcFrame();
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
	public ALterProcFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 660, 406 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );
		setTitle( "修改存储过程窗体" );
		MyJPanel panel = new MyJPanel();
		panel.setBounds( 0, 0, 644, 368 );
		contentPane.add( panel );
		panel.setLayout( null );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 79, 62, 311, 226 );
		panel.add( scrollPane );


		scrollPane.setViewportView( textArea );
		textArea.setLineWrap( true );
		JButton updateButton = new JButton( "修改" );
		updateButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_updateButton_actionPerformed( arg0 );
			}
		} );
		updateButton.setBounds( 179, 298, 74, 23 );
		panel.add( updateButton );
	}

	protected void do_updateButton_actionPerformed( ActionEvent arg0 ) {

		String     sql        = textArea.getText();
		AlterProce alterProce = new AlterProce();
		boolean    bool       = alterProce.executeUpdate( sql );
		if ( bool == true ) {
			JOptionPane.showMessageDialog( getContentPane(),
					"存储构成修改成功！", "信息提示框", JOptionPane.WARNING_MESSAGE );

		}
	}
}
