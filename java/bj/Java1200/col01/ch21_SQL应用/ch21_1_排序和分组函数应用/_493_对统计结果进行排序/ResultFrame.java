package bj.Java1200.col01.ch21_SQL应用.ch21_1_排序和分组函数应用._493_对统计结果进行排序;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ResultFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	LocalTableModel model = new LocalTableModel();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					ResultFrame frame = new ResultFrame();
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
	public ResultFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );
		setTitle( "按统计结果排序" );
		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 434, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JButton ascButton = new JButton( "按总分升序排序" );
		ascButton.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_ascButton_actionPerformed( arg0 );
			}
		} );
		ascButton.setBounds( 44, 25, 146, 23 );
		panel.add( ascButton );

		JButton descButton = new JButton( "按总分降序排序" );
		descButton.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_descButton_actionPerformed( arg0 );
			}
		} );
		descButton.setBounds( 238, 25, 146, 23 );
		panel.add( descButton );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 33, 58, 362, 194 );
		panel.add( scrollPane );

		table = new JTable( model );
		scrollPane.setViewportView( table );
		ResultUtil util = new ResultUtil();
		List       list = util.getGrade();
		for ( int i = 0; i < list.size(); i++ ) {
			Grade grade = (Grade) list.get( i );
			model.addRow( new Object[]{
					grade.getId(), grade.getName(),
					grade.getChinses(), grade.getMath(), grade.getEnglish(),
					grade.getHistory(), grade.getPhysics()
			} );
		}

	}

	// 按总分升序排序
	protected void do_ascButton_actionPerformed( ActionEvent arg0 ) {

		ResultTableModel resultModel = new ResultTableModel();
		table.setModel( resultModel );
		ResultUtil util = new ResultUtil();
		List       list = util.getGradeDesc( "asc" );
		for ( int i = 0; i < list.size(); i++ ) {
			Grade grade = (Grade) list.get( i );
			resultModel.addRow( new Object[]{
					grade.getId(), grade.getName(),
					grade.getSum()
			} );
		}
	}

	// 按总分降序排序
	protected void do_descButton_actionPerformed( ActionEvent arg0 ) {

		ResultTableModel resultModel = new ResultTableModel();
		table.setModel( resultModel );
		ResultUtil util = new ResultUtil();
		List       list = util.getGradeDesc( "desc" );
		for ( int i = 0; i < list.size(); i++ ) {
			Grade grade = (Grade) list.get( i );
			resultModel.addRow( new Object[]{
					grade.getId(), grade.getName(),
					grade.getSum()
			} );
		}
	}
}
