package bj.Java1200.col01.ch03_数组与集合应用.ch03_3_数组排序与查询._050_使用选择排序法;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SelectSort extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					SelectSort frame = new SelectSort();
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
	public SelectSort() {

		setTitle( "\u9009\u62E9\u6392\u5E8F\u7B97\u6CD5\u3011" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{ 0, 0 };
		gbl_contentPane.rowHeights = new int[]{ 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[]{ 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[]{
				1.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE
		};
		contentPane.setLayout( gbl_contentPane );

		JScrollPane        scrollPane     = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets( 0, 0, 5, 0 );
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add( scrollPane, gbc_scrollPane );

		textArea1 = new JTextArea();
		scrollPane.setViewportView( textArea1 );

		JButton button = new JButton( "\u751F\u6210\u968F\u673A\u6570" );
		button.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {

				do_button_actionPerformed( e );
			}
		} );
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets( 0, 0, 5, 0 );
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		contentPane.add( button, gbc_button );

		JScrollPane        scrollPane_1     = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets( 0, 0, 5, 0 );
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		contentPane.add( scrollPane_1, gbc_scrollPane_1 );

		textArea2 = new JTextArea();
		scrollPane_1.setViewportView( textArea2 );

		JButton button_1 = new JButton( "\u9009\u62E9\u6392\u5E8F\u6CD5" );
		button_1.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {

				do_button_1_actionPerformed( e );
			}
		} );
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 3;
		contentPane.add( button_1, gbc_button_1 );
	}

	private int[] array = new int[ 10 ];
	private JTextArea textArea1;
	private JTextArea textArea2;

	protected void do_button_actionPerformed( ActionEvent e ) {

		Random random = new Random();// 创建随机数对象
		textArea1.setText( "" );// 清空文本域
		for ( int i = 0; i < array.length; i++ ) {// 初始化数组元素
			array[ i ] = random.nextInt( 50 );// 生成50以内的随机数
			textArea1.append( array[ i ] + "  " );// 把数组元素显示的文本域控件中
		}
	}

	protected void do_button_1_actionPerformed( ActionEvent e ) {

		textArea2.setText( "" );// 清空文本域
		int index;
		for ( int i = 1; i < array.length; i++ ) {
			index = 0;
			for ( int j = 1; j <= array.length - i; j++ ) {
				if ( array[ j ] > array[ index ] ) {
					index = j;// 查找最大值
				}
			}
			// 交换在位置array.length-i和index(最大值)两个数
			int temp = array[ array.length - i ];
			array[ array.length - i ] = array[ index ];
			array[ index ] = temp;
		}
		for ( int i = 0; i < array.length; i++ ) {
			textArea2.append( array[ i ] + "  " );// 把排序后的数组元素显示到文本域中
		}
	}
}
