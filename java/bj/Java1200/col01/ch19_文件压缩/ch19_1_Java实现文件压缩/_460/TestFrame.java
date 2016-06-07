package bj.Java1200.col01.ch19_文件压缩.ch19_1_Java实现文件压缩._460;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.Serializable;

public class TestFrame extends JFrame implements Serializable {

	private static final long serialVersionUID = 8897601338301442816L;

	private JPanel    contentPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public TestFrame() {

		setTitle( "\u6D4B\u8BD5\u7528\u7A97\u4F53" );
		setBounds( 100, 100, 400, 250 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( new BorderLayout( 0, 0 ) );

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add( scrollPane, BorderLayout.CENTER );

		textArea = new JTextArea();
		textArea.setFont( new Font( "微软雅黑", Font.PLAIN, 16 ) );
		scrollPane.setViewportView( textArea );
	}
}
