package bj.Java1200.col01.ch18_文件的读取_写入_整理和控制.ch18_2_实现文件整理._448;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SortFrame extends JFrame {

	private JPanel     contentPane;
	private JTextField pathTextField;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					SortFrame frame = new SortFrame();
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
	public SortFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 434, 196 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );
		setTitle( "文件夹分类管理" );
		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 418, 158 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "分类文件夹：" );
		messageLabel.setBounds( 19, 48, 92, 15 );
		panel.add( messageLabel );

		pathTextField = new JTextField();
		pathTextField.setBounds( 121, 45, 187, 21 );
		panel.add( pathTextField );
		pathTextField.setColumns( 10 );

		JButton choicBbutton = new JButton( "选择" );
		choicBbutton.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_choicBbutton_actionPerformed( arg0 );
			}
		} );
		choicBbutton.setBounds( 318, 44, 77, 23 );
		panel.add( choicBbutton );

		JButton sortButton = new JButton( "确定分类" );
		sortButton.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_sortButton_actionPerformed( arg0 );
			}
		} );
		sortButton.setBounds( 156, 96, 93, 23 );
		panel.add( sortButton );
	}

	// 定义获取只可以选择文件夹的选择框
	public JFileChooser getChooser() {

		JFileChooser fd      = new JFileChooser();
		String       windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		try {
			UIManager.setLookAndFeel( windows );
		} catch ( Exception e ) {
			e.printStackTrace();
		}// 设置见面风格
		SwingUtilities.updateComponentTreeUI( fd );// 使设置的界面风格生效
		fd.setFileSelectionMode( fd.DIRECTORIES_ONLY ); // 指示只显示目录
		fd.showOpenDialog( this );
		return fd;
	}

	protected void do_choicBbutton_actionPerformed( ActionEvent arg0 ) {

		JFileChooser fd = getChooser();
		if ( ( fd.getSelectedFile() != null )
		     && ( ! fd.getSelectedFile().equals( "" ) ) ) {
			String strPath = fd.getSelectedFile().getPath();
			pathTextField.setText( strPath );
		}

	}

	protected void do_sortButton_actionPerformed( ActionEvent arg0 ) {

		SortUtil sortUtil = new SortUtil();
		List     list     = sortUtil.getList( pathTextField.getText() ); //获取用户选择文件夹中所有文件集合
		for ( int i = 0; i < list.size(); i++ ) {              //循环遍历该文件集合
			String strFile = list.get( i ).toString();
			int    index   = strFile.lastIndexOf( "." );
			if ( index != - 1 ) {
				String strN        = strFile.substring( index + 1, strFile.length() ); //对文件夹进行截取，获取文件扩展名
				int    ind         = strFile.lastIndexOf( "\\" );
				String strFileName = strFile.substring( ind, index );
				sortUtil.createFolder( pathTextField.getText() + "\\" + "分类" );//调用创建文件夹方法，新建文件夹
				sortUtil.createFolder( pathTextField.getText() + "\\" + "分类" + "\\" + strN );
				if ( strFile.endsWith( strN ) ) {
					//将文件集合中与文件夹名称相同的文件复制到相应的文件夹中
					sortUtil.copyFile( strFile, pathTextField.getText() + "\\" + "分类" + "\\" + strN +
					                            "\\" + strFileName + strFile.substring( index, strFile.length() ) );
				}
			}
		}
		JOptionPane.showMessageDialog( getContentPane(), //给出用户分类完成提示框
		                               "文件分类成功！", "信息提示框", JOptionPane.WARNING_MESSAGE );
	}
}
