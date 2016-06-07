package bj.Java1200.col01.ch17_文件与文件夹操作.ch17_2_文件与数据库._421;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class DataInputFrame extends JFrame {

	private static final long serialVersionUID = 7380411131151951458L;

	private JPanel contentPane;
	private JTable table;
	private JTree  tree;
	private String tableName;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		try {
			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" );
		} catch ( Throwable e ) {
			e.printStackTrace();
		}
		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					DataInputFrame frame = new DataInputFrame();
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
	public DataInputFrame() {

		setTitle( "\u63D0\u53D6\u6587\u672C\u6587\u4EF6\u5185\u5BB9\u5230MySQL\u6570\u636E\u5E93" );
		addWindowListener( new WindowAdapter() {

			@Override
			public void windowActivated( WindowEvent arg0 ) {

				do_this_windowActivated( arg0 );
			}
		} );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );

		JScrollPane treeScrollPane = new JScrollPane();

		JPanel      panel          = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout( contentPane );
		gl_contentPane.setHorizontalGroup( gl_contentPane.createParallelGroup( Alignment.LEADING ).addGroup(
				gl_contentPane.createSequentialGroup().addContainerGap().addComponent( treeScrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE ).addGap( 28 )
				              .addComponent( panel, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE ).addContainerGap() ) );
		gl_contentPane.setVerticalGroup( gl_contentPane.createParallelGroup( Alignment.LEADING ).addGroup(
				gl_contentPane.createSequentialGroup().addContainerGap().addGroup(
						gl_contentPane.createParallelGroup( Alignment.TRAILING ).addGroup(
								gl_contentPane.createSequentialGroup().addComponent( panel, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE ).addGap( 5 ) ).addComponent( treeScrollPane,
						                                                                                                                                                 Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE ) ).addContainerGap() ) );
		panel.setLayout( new BorderLayout( 0, 0 ) );

		JPanel buttonPanel = new JPanel();
		panel.add( buttonPanel, BorderLayout.SOUTH );

		JButton button = new JButton( "\u5BFC\u5165\u6570\u636E" );
		button.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_button_actionPerformed( arg0 );
			}
		} );
		buttonPanel.add( button );

		JScrollPane tableScrollPane = new JScrollPane();
		panel.add( tableScrollPane, BorderLayout.CENTER );

		table = new JTable();
		tableScrollPane.setViewportView( table );

		tree = new JTree();
		tree.addTreeSelectionListener( new TreeSelectionListener() {

			public void valueChanged( TreeSelectionEvent arg0 ) {

				do_tree_valueChanged( arg0 );
			}
		} );
		treeScrollPane.setViewportView( tree );
		contentPane.setLayout( gl_contentPane );
	}

	private static DefaultTableModel makeTableModel( String tableName ) {

		String            sql         = "select * from " + tableName;
		Object[]          tableHeader = DBHelper.getColumnNames( sql );
		List< Object[] >  tableBody   = DBHelper.query( sql );
		DefaultTableModel model       = new DefaultTableModel();
		model.setColumnIdentifiers( tableHeader );
		Iterator< Object[] > iterator = tableBody.iterator();
		while ( iterator.hasNext() ) {
			model.addRow( iterator.next() );
		}
		return model;
	}

	protected void do_this_windowActivated( WindowEvent arg0 ) {

		DefaultMutableTreeNode root       = new DefaultMutableTreeNode( "数据库中的表名" );
		List< Object >         tableNames = DBHelper.getTableNames();
		for ( int i = 0; i < tableNames.size(); i++ ) {
			root.add( new DefaultMutableTreeNode( tableNames.get( i ) ) );
		}
		tree.setModel( new DefaultTreeModel( root ) );
		table.setModel( makeTableModel( (String) tableNames.get( 0 ) ) );
	}

	protected void do_tree_valueChanged( TreeSelectionEvent arg0 ) {

		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if ( selectedNode == null || selectedNode.getChildCount() != 0 ) {
			return;
		}
		tableName = selectedNode.toString();
		table.setModel( makeTableModel( tableName ) );
	}

	protected void do_button_actionPerformed( ActionEvent arg0 ) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter( new FileNameExtensionFilter( "文本文件", "txt" ) );
		fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		fileChooser.setMultiSelectionEnabled( false );
		int result = fileChooser.showOpenDialog( tree );
		if ( result == JFileChooser.APPROVE_OPTION ) {
			File           file           = fileChooser.getSelectedFile();// 获得用户选择的文件
			FileReader     fileReader     = null;
			BufferedReader bufferedReader = null;
			try {
				fileReader = new FileReader( file );// 利用用户选择的文件创建FileReader对象
				bufferedReader = new BufferedReader( fileReader );// 创建BufferedReader对象
				// 利用StringBuilder对象保存用户选择的文件中的数据
				StringBuilder builder = new StringBuilder();
				String        temp    = null;
				while ( ( temp = bufferedReader.readLine() ) != null ) {// 读入用户选择的文件
					builder.append( temp );// 保存读入的一行数据
					builder.append( "\n" );// 利用换行符分隔读入的各行
				}
				String[] rows = builder.toString().split( "\n" );// 利用换行符分割各行
				if ( tableName == null ) {// 如果用户没有在树中选择要保存到的表名，则设置保存到第一个表
					tableName = (String) DBHelper.getTableNames().get( 0 );
				}
				for ( String row : rows ) {
					DBHelper.insertData( tableName, row.split( "\t" ) );// 利用工具类实现保存数据的功能
				}
				JOptionPane.showMessageDialog( this, "数据导入成功" );// 提示用户数据导入成功
			} catch ( IOException e ) {// 捕获IO异常
				e.printStackTrace();
			} finally {
				if ( bufferedReader != null ) {
					try {
						bufferedReader.close();
					} catch ( IOException e ) {
						e.printStackTrace();
					}
				}
				if ( fileReader != null ) {
					try {
						fileReader.close();
					} catch ( IOException e ) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
