package bj.Java1200.col01.ch20_操作办公文档.ch20_1_操作Word._475;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;

public class GuideFrame extends JFrame {

	private static final long serialVersionUID = - 1427029548189335430L;

	private JPanel     contentPane;
	private JTextField filePathTextField;
	private JTextField nameTextField;
	private JComboBox fileRootComboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					GuideFrame frame = new GuideFrame();
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
	public GuideFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 533, 186 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );
		setTitle( "将文本文件导入到word" );
		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 517, 153 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel filePathLabel = new JLabel( "文件目录：" );
		filePathLabel.setBounds( 31, 39, 70, 15 );
		panel.add( filePathLabel );

		filePathTextField = new JTextField();
		filePathTextField.setBounds( 103, 36, 275, 21 );
		panel.add( filePathTextField );
		filePathTextField.setColumns( 10 );

		JButton chooseButton = new JButton( "选择文件" );
		chooseButton.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_chooseButton_actionPerformed( arg0 );
			}
		} );
		chooseButton.setBounds( 388, 35, 93, 23 );
		panel.add( chooseButton );

		JLabel saveLabel = new JLabel( "保存地址：" );
		saveLabel.setBounds( 31, 93, 70, 15 );
		panel.add( saveLabel );


		File[] files = File.listRoots();       //调用获取本地有效磁盘方法
		String str[] = new String[ files.length ];            //创建字符串数组
		for ( int i = 0; i < files.length; i++ ) {
			str[ i ] = files[ i ].getPath();
		}
		//将获取的磁盘信息添加到下拉列表中
		fileRootComboBox.setModel( new javax.swing.DefaultComboBoxModel( str ) );
		fileRootComboBox.setBounds( 103, 90, 70, 21 );
		panel.add( fileRootComboBox );

		JLabel nameLabel = new JLabel( "文件名称：" );
		nameLabel.setBounds( 183, 93, 70, 15 );
		panel.add( nameLabel );

		nameTextField = new JTextField();
		nameTextField.setBounds( 263, 90, 115, 21 );
		panel.add( nameTextField );
		nameTextField.setColumns( 10 );

		JButton guideButton = new JButton( "导入" );
		guideButton.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_guideButton_actionPerformed( arg0 );
			}
		} );
		guideButton.setBounds( 388, 89, 93, 23 );
		panel.add( guideButton );
	}

	//选择文件按钮的单击事件
	protected void do_chooseButton_actionPerformed( ActionEvent arg0 ) {

		FileDialog fd = new FileDialog( this );
		fd.setVisible( true );
		String filePath = fd.getDirectory() + fd.getFile();
		if ( filePath.endsWith( ".txt" ) ) {
			filePathTextField.setText( filePath );
		}
	}

	//导入按钮的单击事件
	protected void do_guideButton_actionPerformed( ActionEvent arg0 ) {

		String name = nameTextField.getText();
		if ( ( ! name.equals( "" ) ) && ( name != null ) ) {
			WordBean msWordManager = new WordBean(); // 创建本类对象
			try {
				msWordManager.createNewDocument(); // 调用新建文档方法
				File         file     = new File( filePathTextField.getText() );
				FileReader   instream = new FileReader( file );
				char         by[]     = new char[ 1 ];
				int          a        = 0;
				StringBuffer buffer   = new StringBuffer();
				while ( ( a = instream.read( by ) ) != - 1 ) {

					String str = new String( by );
					buffer.append( str );


				}
				msWordManager.insertText( buffer.toString() ); // 向文档添加值
				msWordManager.save( (String) fileRootComboBox.getSelectedItem() + name + ".doc" ); // 调用保存文档方法
			} catch ( Exception e ) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog( getContentPane(),
			                               "数据导入成功！", "信息提示框", JOptionPane.WARNING_MESSAGE );
		}
	}
}
