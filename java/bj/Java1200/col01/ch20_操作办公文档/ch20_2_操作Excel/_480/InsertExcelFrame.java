package bj.Java1200.col01.ch20_操作办公文档.ch20_2_操作Excel._480;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class InsertExcelFrame extends JFrame {

	private JPanel     contentPane;
	private JTextField nameTextField;
	private JTextField sexTextField;
	private JTextField deptTextField;
	private JTextField jobTextField;
	private JTextField ageTextField;
	private JLabel     laborageLabel;
	private JTextField laborageTextField;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					InsertExcelFrame frame = new InsertExcelFrame();
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
	public InsertExcelFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 337, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );
		setTitle( "将信息导入到Excel表" );
		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 321, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel nameLabel = new JLabel( "姓 名：" );
		nameLabel.setBounds( 51, 41, 59, 15 );
		panel.add( nameLabel );

		nameTextField = new JTextField();
		nameTextField.setBounds( 97, 38, 155, 21 );
		panel.add( nameTextField );
		nameTextField.setColumns( 10 );

		JLabel sexLabel = new JLabel( "性 別：" );
		sexLabel.setBounds( 51, 69, 54, 15 );
		panel.add( sexLabel );

		sexTextField = new JTextField();
		sexTextField.setBounds( 97, 66, 155, 21 );
		panel.add( sexTextField );
		sexTextField.setColumns( 10 );

		JLabel deptLabel = new JLabel( "部 门：" );
		deptLabel.setBounds( 51, 130, 54, 15 );
		panel.add( deptLabel );

		deptTextField = new JTextField();
		deptTextField.setBounds( 97, 127, 155, 21 );
		panel.add( deptTextField );
		deptTextField.setColumns( 10 );

		JLabel jobLabel = new JLabel( "职 位：" );
		jobLabel.setBounds( 51, 158, 54, 15 );
		panel.add( jobLabel );

		jobTextField = new JTextField();
		jobTextField.setBounds( 97, 158, 155, 21 );
		panel.add( jobTextField );
		jobTextField.setColumns( 10 );

		JLabel ageLabel = new JLabel( "年 龄：" );
		ageLabel.setBounds( 51, 94, 54, 15 );
		panel.add( ageLabel );

		ageTextField = new JTextField();
		ageTextField.setBounds( 97, 94, 155, 21 );
		panel.add( ageTextField );
		ageTextField.setColumns( 10 );

		laborageLabel = new JLabel( "工 资：" );
		laborageLabel.setBounds( 51, 189, 54, 15 );
		panel.add( laborageLabel );

		laborageTextField = new JTextField();
		laborageTextField.setBounds( 97, 189, 155, 21 );
		panel.add( laborageTextField );
		laborageTextField.setColumns( 10 );

		JButton insertButton = new JButton( "添加到Excel" );
		insertButton.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_insertButton_actionPerformed( arg0 );
			}
		} );
		insertButton.setBounds( 97, 220, 114, 23 );
		panel.add( insertButton );
	}

	//添加到Exvel按钮的单击处理事件
	protected void do_insertButton_actionPerformed( ActionEvent arg0 ) {

		String   name     = nameTextField.getText();
		String   sex      = sexTextField.getText();
		String   age      = ageTextField.getText();
		String   dept     = deptTextField.getText();
		String   job      = jobTextField.getText();
		String   laborage = laborageTextField.getText();
		CreateXL create   = new CreateXL();
		File     file     = new File( "c:/temp.xls" );
		if ( ! file.exists() ) {
			create.createExcel();
		}
		create.insertvalue( name, sex, age, dept,
		                    job, laborage );
		JOptionPane.showMessageDialog( getContentPane(),
		                               "数据添加成功！", "信息提示框", JOptionPane.WARNING_MESSAGE );

	}
}
