package bj.powernode.basic.day25.EMS.view;

import bj.powernode.basic.day25.EMS.common.GBC;
import bj.powernode.basic.day25.EMS.common.Orientation;
import bj.powernode.basic.day25.EMS.common.ScreenSizeKit;
import bj.powernode.basic.day25.EMS.entity.Employee;
import bj.powernode.basic.day25.EMS.service.EmployeeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeListPage extends JFrame {

	/**
	 * 单例模式
	 */
	private static EmployeeListPage elp;

	public static EmployeeListPage getMySelf() {

		if ( elp == null ) {
			elp = new EmployeeListPage();
		}
		return elp;
	}


	//定义所有组件
	private JPanel mainPanel;

	class EmployeeListPageMainPanel extends JPanel {

		@Override
		public void paint( Graphics g ) {

			super.paint( g );
			//横线
			int x1 = 40;
			int x2 = 800;
			int y  = 50;
			for ( int i = 0; i < 11; i++ ) {
				g.drawLine( x1, y, x2, y );
				y += 50;
			}

			//竖线
			int x  = 180;
			int y1 = 20;
			int y2 = 550;
			for ( int i = 0; i < 3; i++ ) {
				g.drawLine( x, y1, x, y2 );
				x += 200;
			}
		}
	}

	private JLabel noLabel, enoLabel, enameLabel, operatorLabel;
	private JButton indexButton, previousButton, nextButton, lastButton;
	private JLabel totalPagesLabel, forwardWhichPageLabelBefore, forwardWhichPageLabelAfter;
	private JTextField forwardWhichPageTextField;
	private JButton    forwardButton;


	//总页数
	private int totalPages     = 0;
	//当前页码
	private int currentPageNum = 1;


	//从数据库中取出所有的员工
	private EmployeeService  es        = new EmployeeService();
	private List< Employee > employees = es.findAllEmployee();


	//初始化一个60个长度的组件数组
	JComponent[] components1 = new JComponent[ 60 ];
	JComponent[] components2 = new JComponent[ 60 ];


	//构造方法私有化
	private EmployeeListPage() {

		setTitle( "员工信息列表" ); //设置标题

		//设置大小和位置
		setBounds( ScreenSizeKit.getWidth() / 10 + (int) ( ScreenSizeKit.getWidth() / 7 ),
		           ScreenSizeKit.getHeight() / 18,
		           (int) ( ScreenSizeKit.getWidth() / 1.5 ),
		           (int) ( ScreenSizeKit.getHeight() / 1.2 ) );

		//初始化所有组件
		mainPanel = new EmployeeListPageMainPanel();
		noLabel = new JLabel( "序号" );
		enoLabel = new JLabel( "员工编号" );
		enameLabel = new JLabel( "员工姓名" );
		operatorLabel = new JLabel( "操作" );
		indexButton = new JButton( "首页" );
		previousButton = new JButton( "上一页" );
		nextButton = new JButton( "下一页" );
		lastButton = new JButton( "末页" );


		//添加面板
		add( mainPanel );

		//向面板上添加Label
		mainPanel.setLayout( new GridBagLayout() );
		mainPanel.add( noLabel, new GBC( 0, 0, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 90, Orientation.LEFT ).setInsets( 18, Orientation.TOP ) );
		mainPanel.add( enoLabel, new GBC( 0, 0, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 250, Orientation.LEFT ).setInsets( 18, Orientation.TOP ) );
		mainPanel.add( enameLabel, new GBC( 0, 0, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 450, Orientation.LEFT ).setInsets( 18, Orientation.TOP ) );
		mainPanel.add( operatorLabel, new GBC( 0, 0, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 650, Orientation.LEFT ).setInsets( 18, Orientation.TOP ) );


		//初始化分页组件

		if ( employees.size() % 10 == 0 ) {
			totalPages = employees.size() / 10;
		} else {
			totalPages = ( employees.size() / 10 ) + 1;
		}

		totalPagesLabel = new JLabel( "共" + totalPages + "页/第" + currentPageNum + "页" );
		forwardWhichPageLabelBefore = new JLabel( "跳转到第" );
		forwardWhichPageTextField = new JTextField( "5", 2 );
		forwardWhichPageLabelAfter = new JLabel( "页" );
		forwardButton = new JButton( "跳转" );


		printEmployeesList( employees, currentPageNum );

		//添加分页按钮
		mainPanel.add( indexButton, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 210, Orientation.LEFT ).setInsets( 30, Orientation.TOP ) );
		mainPanel.add( previousButton, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 300, Orientation.LEFT ).setInsets( 30, Orientation.TOP ) );
		mainPanel.add( nextButton, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 400, Orientation.LEFT ).setInsets( 30, Orientation.TOP ) );
		mainPanel.add( lastButton, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 500, Orientation.LEFT ).setInsets( 30, Orientation.TOP ) );

		mainPanel.add( totalPagesLabel, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ).setInsets( 30, Orientation.TOP ) );
		mainPanel.add( forwardWhichPageLabelBefore, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 600, Orientation.LEFT ).setInsets( 30, Orientation.TOP ) );
		mainPanel.add( forwardWhichPageTextField, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 655, Orientation.LEFT ).setInsets( 30, Orientation.TOP ) );
		mainPanel.add( forwardWhichPageLabelAfter, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 680, Orientation.LEFT ).setInsets( 30, Orientation.TOP ) );
		mainPanel.add( forwardButton, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 700, Orientation.LEFT ).setInsets( 30, Orientation.TOP ) );


		//给首页按钮添加监听
		indexButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				currentPageNum = 1;
				totalPagesLabel.setText( "共" + EmployeeListPage.this.totalPages + "页/第" + currentPageNum + "页" );
				printEmployeesList( employees, currentPageNum );
			}
		} );


		//给下一页添加监听
		nextButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				if ( currentPageNum != totalPages ) {
					currentPageNum++;
				}
				totalPagesLabel.setText( "共" + EmployeeListPage.this.totalPages + "页/第" + currentPageNum + "页" );
				printEmployeesList( employees, currentPageNum );
			}
		} );

		//给上一页添加监听
		previousButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				if ( currentPageNum != 1 ) {
					currentPageNum--;
				}
				totalPagesLabel.setText( "共" + EmployeeListPage.this.totalPages + "页/第" + currentPageNum + "页" );
				printEmployeesList( employees, currentPageNum );

			}
		} );

		//给末页添加监听
		lastButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				currentPageNum = totalPages;
				totalPagesLabel.setText( "共" + EmployeeListPage.this.totalPages + "页/第" + currentPageNum + "页" );
				printEmployeesList( employees, currentPageNum );
			}
		} );


		//给跳转到第几页添加监听
		forwardButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				try {
					currentPageNum = Integer.parseInt( forwardWhichPageTextField.getText() );
					if ( currentPageNum > totalPages ) {
						JOptionPane.showMessageDialog( EmployeeListPage.this, "总页数小于您指定的页码", "页码超出范围", JOptionPane.ERROR_MESSAGE );
						return;
					}
					totalPagesLabel.setText( "共" + EmployeeListPage.this.totalPages + "页/第" + currentPageNum + "页" );
					printEmployeesList( employees, currentPageNum );
				} catch ( NumberFormatException nfe ) {
					JOptionPane.showMessageDialog( EmployeeListPage.this, "页码数字格式错误", "数字格式错误", JOptionPane.ERROR_MESSAGE );
				}
			}
		} );


	}

	public void printEmployeesList( List< Employee > employees, int currentPageNum ) {

		if ( components1[ 0 ] != null ) {
			for ( int i = 0; i < components1.length; i++ ) {
				if ( components1[ i ] != null ) {
					if ( components1[ i ] instanceof JLabel ) {
						JLabel j = (JLabel) components1[ i ];
						j.setText( "" );
					}
					if ( components1[ i ] instanceof JButton ) {
						JButton j = (JButton) components1[ i ];
						mainPanel.remove( j );
					}
				}
			}
		}


		if ( components2[ 0 ] != null ) {
			for ( int i = 0; i < components2.length; i++ ) {
				if ( components2[ i ] != null ) {
					if ( components2[ i ] instanceof JLabel ) {
						JLabel j = (JLabel) components2[ i ];
						j.setText( "" );
					}
					if ( components2[ i ] instanceof JButton ) {
						JButton j = (JButton) components2[ i ];
						mainPanel.remove( j );
					}
				}
			}
		}

		//遍历集合
		//动态向面板中添加数据.
		if ( employees.size() % 10 == 0 || currentPageNum != totalPages ) {
			int k = - 1;
			for ( int i = 0; i < 10; i++ ) {

				components1[ ++ k ] = new JLabel( currentPageNum * 10 - 9 + i + "" );
				mainPanel.add( components1[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 90, Orientation.LEFT ) );

				components1[ ++ k ] = new JLabel( employees.get( currentPageNum * 10 - 10 + i ).getEno() );
				mainPanel.add( components1[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 220, Orientation.LEFT ) );

				components1[ ++ k ] = new JLabel( employees.get( currentPageNum * 10 - 10 + i ).getEname() );
				mainPanel.add( components1[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 450, Orientation.LEFT ) );

				components1[ ++ k ] = new JButton( "修改" );
				mainPanel.add( components1[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 600, Orientation.LEFT ) );

				components1[ ++ k ] = new JButton( "删除" );
				mainPanel.add( components1[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 670, Orientation.LEFT ) );

				components1[ ++ k ] = new JButton( "详情" );
				mainPanel.add( components1[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 740, Orientation.LEFT ) );
			}

		} else {//最后一页
			int k = - 1;
			int i = 0;
			for (; i < employees.size() % 10; i++ ) {

				components2[ ++ k ] = new JLabel( currentPageNum * 10 - 9 + i + "" );
				mainPanel.add( components2[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 90, Orientation.LEFT ) );

				components2[ ++ k ] = new JLabel( employees.get( currentPageNum * 10 - 10 + i ).getEno() );
				mainPanel.add( components2[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 220, Orientation.LEFT ) );

				components2[ ++ k ] = new JLabel( employees.get( currentPageNum * 10 - 10 + i ).getEname() );
				mainPanel.add( components2[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 450, Orientation.LEFT ) );

				components2[ ++ k ] = new JButton( "修改" );
				mainPanel.add( components2[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 600, Orientation.LEFT ) );

				components2[ ++ k ] = new JButton( "删除" );
				mainPanel.add( components2[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 670, Orientation.LEFT ) );

				components2[ ++ k ] = new JButton( "详情" );
				mainPanel.add( components2[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 740, Orientation.LEFT ) );
			}

			for (; i <= 9; i++ ) {

				components2[ ++ k ] = new JLabel( "无" );
				mainPanel.add( components2[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 90, Orientation.LEFT ) );

				components2[ ++ k ] = new JLabel( "无" );
				mainPanel.add( components2[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 250, Orientation.LEFT ) );

				components2[ ++ k ] = new JLabel( "无" );
				mainPanel.add( components2[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 450, Orientation.LEFT ) );

				components2[ ++ k ] = new JButton( "无操作" );
				mainPanel.add( components2[ k ], new GBC( 0, i + 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 600, Orientation.LEFT ) );
			}

		}


	}


	//测试
	public static void main( String[] args ) {

		EmployeeListPage elp = EmployeeListPage.getMySelf();
		elp.setVisible( true );
		elp.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
