package bj.Java1200.col01.ch24_数据库高级应用.ch24_2_使用触发器._589_在删除成绩表时将学生表中的数据删除;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FindStuFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LocalTableStuModel model       = new LocalTableStuModel();
	private DeleteGrade        deleteGrade = new DeleteGrade();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					FindStuFrame frame = new FindStuFrame();
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
	public FindStuFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 337 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );

		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 434, 299 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "学生表信息：" );
		messageLabel.setFont( new Font( "微软雅黑", Font.PLAIN, 15 ) );
		messageLabel.setBounds( 144, 44, 127, 25 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 41, 86, 356, 152 );
		panel.add( scrollPane );

		table = new JTable( model );
		scrollPane.setViewportView( table );
		List list = deleteGrade.executeStu();
		for ( int i = 0; i < list.size(); i++ ) {
			Stu stu = ( Stu ) list.get( i );
			model.addRow( new Object[]{ stu.getId(), stu.getName(), stu.getSex(), stu.getSpecialty() } );
		}
		JButton watchButton = new JButton( "查看成绩表" );
		watchButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_deleteButton_actionPerformed( arg0 );
			}
		} );
		watchButton.setBounds( 98, 255, 101, 23 );
		panel.add( watchButton );


		JButton closeButton = new JButton( "关闭" );
		closeButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_button_1_actionPerformed( arg0 );
			}
		} );
		closeButton.setBounds( 255, 255, 85, 23 );
		panel.add( closeButton );
	}

	protected void do_deleteButton_actionPerformed( ActionEvent arg0 ) {

		GradeFrame gradeFrame = new GradeFrame();
		gradeFrame.setVisible( true );
	}

	protected void do_button_1_actionPerformed( ActionEvent arg0 ) {

		System.exit( 0 );
	}
}
