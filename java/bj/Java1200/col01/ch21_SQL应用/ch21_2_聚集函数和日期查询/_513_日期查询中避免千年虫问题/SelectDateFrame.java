package bj.Java1200.col01.ch21_SQL应用.ch21_2_聚集函数和日期查询._513_日期查询中避免千年虫问题;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectDateFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LocalTableModel model = new LocalTableModel();
	SelectDateUtil util = new SelectDateUtil();
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					SelectDateFrame frame = new SelectDateFrame();
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
	public SelectDateFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );
		setTitle( "日期查询中避免千年虫问题" );
		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 434, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel dateLabel = new JLabel( "日期：" );
		dateLabel.setBounds( 53, 42, 44, 15 );
		panel.add( dateLabel );
		List     list    = util.getStuDateList();
		String[] strName = new String[ list.size() ];
		for ( int i = 0; i < list.size(); i++ ) {
			strName[ i ] = list.get( i ).toString();
		}
		comboBox = new JComboBox( strName );
		comboBox.setBounds( 107, 39, 165, 21 );
		panel.add( comboBox );

		JButton findButton = new JButton( "查询" );
		findButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_findButton_actionPerformed( arg0 );
			}
		} );
		findButton.setBounds( 299, 38, 71, 23 );
		panel.add( findButton );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 40, 101, 353, 131 );
		panel.add( scrollPane );

		table = new JTable( model );
		scrollPane.setViewportView( table );
	}

	//查询按钮的单击事件
	protected void do_findButton_actionPerformed( ActionEvent arg0 ) {

		String sDate    = comboBox.getSelectedItem().toString();
		List   listDate = util.getStuUseDate( sDate );
		model.setRowCount( 0 );
		for ( int i = 0; i < listDate.size(); i++ ) {
			StuInfo info = ( StuInfo ) listDate.get( i );
			model.addRow( new Object[]{ info.getId(), info.getsName(), info.getsSex(), info.getsBrithday(), info.getsSpeciality(), info.getsAddress() } );
		}
	}
}
