package bj.powernode.basic.day26.EMS.view;

import bj.powernode.basic.day26.EMS.common.GBC;
import bj.powernode.basic.day26.EMS.common.Orientation;
import bj.powernode.basic.day26.EMS.common.ScreenSizeKit;
import bj.powernode.basic.day26.EMS.entity.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

/**
 * 显示员工详细信息的页面
 */
public class EmployeeDetailPage extends JFrame {

	/**
	 * 员工详情页面的组件
	 */
	private JPanel mainPanel;
	private JLabel enoLabel, enoInfoLabel;
	private JLabel enameLabel, enameInfoLabel;
	private JLabel esexLabel, esexInfoLabel;
	private JLabel ebirthLabel, ebirthInfoLabel;
	private JLabel joinDateLabel, joinDateInfoLabel;
	private JLabel jobLabel, jobInfoLabel;
	private JLabel salLabel, salInfoLabel;
	private JLabel telLabel, telInfoLabel;
	private JLabel emailLabel, emailInfoLabel;
	private JLabel gradeLabel, gradeInfoLabel;
	private JLabel addrLabel, addrInfoLabel;
	private JLabel ssLabel, ssInfoLabel;
	private JLabel remarkLabel, remarkInfoLabel;
	private JButton closeButton;

	public EmployeeDetailPage( Employee employee ) {

		setTitle( employee.getEname() + "详细信息" ); //设置标题
		mainPanel = new JPanel();
		add( mainPanel );
		mainPanel.setLayout( new GridBagLayout() );

		//设置窗体的大小和位置
		//设置大小和位置
		setBounds( ScreenSizeKit.getWidth() / 3,
		           ScreenSizeKit.getHeight() / 6,
		           (int) ( ScreenSizeKit.getWidth() / 2 ),
		           (int) ( ScreenSizeKit.getHeight() / 1.8 ) );


		//初始化所有组件
		enoLabel = new JLabel( "员工编号：" );
		enoInfoLabel = new JLabel( employee.getEno() );

		enameLabel = new JLabel( "员工姓名：" );
		enameInfoLabel = new JLabel( employee.getEname() );

		esexLabel = new JLabel( "员工性别：" );
		esexInfoLabel = new JLabel( employee.isSex() ? "男" : "女" );

		ebirthLabel = new JLabel( "员工生日：" );
		ebirthInfoLabel = new JLabel( employee.getEbirth() );

		joinDateLabel = new JLabel( "入职日期：" );
		joinDateInfoLabel = new JLabel( employee.getJoinDate() );

		jobLabel = new JLabel( "员工职位：" );
		jobInfoLabel = new JLabel( employee.getJob().getJobName() );

		salLabel = new JLabel( "员工月薪：" );
		salInfoLabel = new JLabel( employee.getSal() + "" );

		telLabel = new JLabel( "联系电话：" );
		telInfoLabel = new JLabel( employee.getTel() );

		emailLabel = new JLabel( "员工邮箱：" );
		emailInfoLabel = new JLabel( employee.getEmail() );

		gradeLabel = new JLabel( "员工学历：" );
		gradeInfoLabel = new JLabel( employee.getGrade() );

		addrLabel = new JLabel( "家庭住址：" );
		addrInfoLabel = new JLabel( employee.getAddress() );

		ssLabel = new JLabel( "员工保险：" );
		Set< String > ss = employee.getSocialInsurances();
		StringBuffer  sb = new StringBuffer();
		int           i  = 0;
		for ( String s : ss ) {
			i++;
			if ( i == ss.size() ) {
				sb.append( s );
			} else {
				sb.append( s + "," );
			}
		}
		ssInfoLabel = new JLabel( sb.toString() );

		remarkLabel = new JLabel( "备注：" );
		remarkInfoLabel = new JLabel( employee.getRemark() );

		closeButton = new JButton( "关闭" );

		//添加组件
		mainPanel.add( enoLabel, new GBC( 0, 0, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( enoInfoLabel, new GBC( 0, 0, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( enameLabel, new GBC( 0, 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( enameInfoLabel, new GBC( 0, 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( esexLabel, new GBC( 0, 2, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( esexInfoLabel, new GBC( 0, 2, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( ebirthLabel, new GBC( 0, 3, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( ebirthInfoLabel, new GBC( 0, 3, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( joinDateLabel, new GBC( 0, 4, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( joinDateInfoLabel, new GBC( 0, 4, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( jobLabel, new GBC( 0, 5, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( jobInfoLabel, new GBC( 0, 5, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( salLabel, new GBC( 0, 6, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( salInfoLabel, new GBC( 0, 6, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( telLabel, new GBC( 0, 7, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( telInfoLabel, new GBC( 0, 7, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( emailLabel, new GBC( 0, 8, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( emailInfoLabel, new GBC( 0, 8, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( gradeLabel, new GBC( 0, 9, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( gradeInfoLabel, new GBC( 0, 9, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( addrLabel, new GBC( 0, 10, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( addrInfoLabel, new GBC( 0, 10, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( ssLabel, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( ssInfoLabel, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( remarkLabel, new GBC( 0, 12, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( remarkInfoLabel, new GBC( 0, 12, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( closeButton, new GBC( 0, 13, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 300, Orientation.LEFT ) );

		//给关闭按钮添加监听
		closeButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				EmployeeDetailPage.this.dispose();
			}
		} );
	}

}
