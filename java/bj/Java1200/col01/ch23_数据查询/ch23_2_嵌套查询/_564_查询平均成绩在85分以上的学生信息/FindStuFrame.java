package bj.Java1200.col01.ch23_数据查询.ch23_2_嵌套查询._564_查询平均成绩在85分以上的学生信息;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class FindStuFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LocalTableModel model = new LocalTableModel();

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
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );

		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 434, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "查询平均成绩在85分以上的学生信息" );
		messageLabel.setFont( new Font( "微软雅黑", Font.PLAIN, 13 ) );
		messageLabel.setBounds( 98, 24, 213, 15 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 39, 70, 356, 144 );
		panel.add( scrollPane );

		table = new JTable( model );
		scrollPane.setViewportView( table );
		FindStu findStu = new FindStu();
		List    list    = findStu.getSubTable();
		for ( int i = 0; i < list.size(); i++ ) {
			Student stu = ( Student ) list.get( i );
			model
					.addRow( new Object[]{ stu.getId(), stu.getName(), stu.getCollege(), stu.getSpeciality(), stu.getAddress() } );
		}

	}

}
