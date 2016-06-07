package bj.powernode.basic.day24.EMS.view;

import bj.powernode.basic.day25.EMS.common.GBC;
import bj.powernode.basic.day25.EMS.common.Orientation;
import bj.powernode.basic.day25.EMS.common.ScreenSizeKit;
import bj.powernode.basic.day25.EMS.entity.Employee;
import bj.powernode.basic.day25.EMS.entity.Job;
import bj.powernode.basic.day25.EMS.service.EmployeeService;
import bj.powernode.basic.day25.EMS.service.JobService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Set;


/**
 * 录入员工信息的界面
 *
 * @author Administrator
 */
public class EntryEInfoPage extends JFrame {

	private JobService js = new JobService();

	private static EntryEInfoPage eep;
	private        JPanel         mainPanel;

	/**
	 * 准备录入员工信息页面的属性
	 */
	private JLabel       enoLabel; //员工编号的Label
	private JLabel       echoEnoLabel; //显示员工编号的Label
	private JLabel       enameLabel; //员工姓名的Label
	private JTextField   enameTextField; //员工姓名文本框
	private JLabel       esexLabel; //员工性别的Label
	private JRadioButton maleRadioButton, femaleRadioButton;  //单选按钮
	private JLabel    eBirthLabel; //员工生日的Label
	private JComboBox yearBox, monthBox, dayBox; //年月日
	private JLabel yearLabel, monthLabel, dayLabel; //年月日的Label

	private JLabel    joinDateLabel;//入职日期的Label
	private JComboBox yearBox1, monthBox1, dayBox1; //年月日
	private JLabel yearLabel1, monthLabel1, dayLabel1; //年月日的Label

	private JLabel    ejobLabel; //员工职位的Label
	private JComboBox ejobBox; //员工职位列表

	private JLabel     esalLabel; //员工薪资的Label
	private JTextField esalTextField; //员工薪资文本框

	private JLabel     eTelLabel; //员工联系电话的Label
	private JTextField eTelTextField; //员工联系电话的文本框

	private JLabel     emailLabel; //员工邮件的Label
	private JTextField emailTextField; //邮件的文本框

	private JLabel    egradeLabel; //员工学历的Label
	private JComboBox egradeBox; //员工学历的下拉列表


	private JLabel     addressLabel; //家庭住址的Label
	private JTextField addressTextField; //家庭住址的文本框

	private JLabel    socialSecurityLabel; //社会保险的Label
	private JCheckBox ss01CheckBox, ss02CheckBox, ss03CheckBox, ss04CheckBox, ss05CheckBox, ss06CheckBox; //社会保险的复选框

	private JLabel    remarkLabel; //备注的Label
	private JTextArea remarkArea; //备注的文本域

	private JScrollPane jsp; //存放备注的面板

	private JButton entryButton, clearButton; //录入按钮,清空按钮


	private EntryEInfoPage() {

		//初始化组件
		mainPanel = new JPanel();
		enoLabel = new JLabel( "员工编号" );
		echoEnoLabel = new JLabel( "201106111404" );
		enameLabel = new JLabel( "员工姓名" );
		enameTextField = new JTextField( 15 );
		esexLabel = new JLabel( "员工性别" );

		maleRadioButton = new JRadioButton( "男" );
		femaleRadioButton = new JRadioButton( "女" );
		ButtonGroup sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add( maleRadioButton );
		sexButtonGroup.add( femaleRadioButton );

		eBirthLabel = new JLabel( "员工生日" );
		String[] years = new String[ 56 ];
		for ( int i = 1945; i < 2001; i++ ) {
			years[ i - 1945 ] = i + "";
		}
		yearBox = new JComboBox( years );
		yearBox.addItemListener( new MyItemListener() );

		yearLabel = new JLabel( "年" );

		String[] months = new String[ 12 ];
		for ( int i = 0; i < 12; i++ ) {
			if ( i < 9 ) {
				months[ i ] = "0" + ( i + 1 ) + "";
			} else {
				months[ i ] = i + 1 + "";
			}

		}
		monthBox = new JComboBox( months );
		monthBox.addItemListener( new MyItemListener() );

		monthLabel = new JLabel( "月" );

		dayBox = new JComboBox( getDaysByYearAndMonth( (String) yearBox.getSelectedItem(), (String) monthBox.getSelectedItem() ) );
		dayLabel = new JLabel( "日" );


		joinDateLabel = new JLabel( "入职日期" );
		yearBox1 = new JComboBox( years );
		yearBox1.addItemListener( new MyItemListener() );
		yearLabel1 = new JLabel( "年" );
		monthBox1 = new JComboBox( months );
		monthBox1.addItemListener( new MyItemListener() );
		monthLabel1 = new JLabel( "月" );
		dayBox1 = new JComboBox( getDaysByYearAndMonth( (String) yearBox1.getSelectedItem(), (String) monthBox1.getSelectedItem() ) );
		dayLabel1 = new JLabel( "日" );


		ejobLabel = new JLabel( "员工职位" );
		String[] jobs = js.findAllJobNames();
		ejobBox = new JComboBox( jobs );


		esalLabel = new JLabel( "员工月薪" );
		esalTextField = new JTextField( 15 );

		eTelLabel = new JLabel( "联系电话" );
		eTelTextField = new JTextField( 15 );

		emailLabel = new JLabel( "员工邮件" );
		emailTextField = new JTextField( 15 );

		egradeLabel = new JLabel( "员工学历" );
		String[] grade = { "专科", "本科", "研究生", "博士" };
		egradeBox = new JComboBox( grade );


		addressLabel = new JLabel( "家庭住址" );
		addressTextField = new JTextField( 50 );

		socialSecurityLabel = new JLabel( "社会保险" );
		ss01CheckBox = new JCheckBox( "养老" );
		ss02CheckBox = new JCheckBox( "失业" );
		ss03CheckBox = new JCheckBox( "工伤" );
		ss04CheckBox = new JCheckBox( "生育" );
		ss05CheckBox = new JCheckBox( "医保" );
		ss06CheckBox = new JCheckBox( "公积金" );


		remarkLabel = new JLabel( "员工备注" );
		remarkArea = new JTextArea( 8, 60 );
		jsp = new JScrollPane( remarkArea );

		entryButton = new JButton( "提交" );
		clearButton = new JButton( "清空" );


		//设置标题
		setTitle( "录入员工信息" );

		//设置大小和位置
		setBounds( ScreenSizeKit.getWidth() / 10 + (int) ( ScreenSizeKit.getWidth() / 7 ),
		           ScreenSizeKit.getHeight() / 18,
		           (int) ( ScreenSizeKit.getWidth() / 1.5 ),
		           (int) ( ScreenSizeKit.getHeight() / 1.2 ) );


		//将面板添加到窗体
		add( mainPanel );

		//设置面板的布局方式
		mainPanel.setLayout( new GridBagLayout() );

		//添加组件
		mainPanel.add( enoLabel, new GBC( 0, 0, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( echoEnoLabel, new GBC( 0, 0, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 80, Orientation.LEFT ) );

		mainPanel.add( enameLabel, new GBC( 0, 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( enameTextField, new GBC( 0, 1, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 80, Orientation.LEFT ) );

		mainPanel.add( esexLabel, new GBC( 0, 2, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( maleRadioButton, new GBC( 0, 2, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( femaleRadioButton, new GBC( 0, 2, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 200, Orientation.LEFT ) );

		mainPanel.add( eBirthLabel, new GBC( 0, 3, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( yearBox, new GBC( 0, 3, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( yearLabel, new GBC( 0, 3, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 160, Orientation.LEFT ) );
		mainPanel.add( monthBox, new GBC( 0, 3, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 180, Orientation.LEFT ) );
		mainPanel.add( monthLabel, new GBC( 0, 3, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 225, Orientation.LEFT ) );
		mainPanel.add( dayBox, new GBC( 0, 3, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 245, Orientation.LEFT ) );
		mainPanel.add( dayLabel, new GBC( 0, 3, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 290, Orientation.LEFT ) );


		mainPanel.add( joinDateLabel, new GBC( 0, 4, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( yearBox1, new GBC( 0, 4, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( yearLabel1, new GBC( 0, 4, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 160, Orientation.LEFT ) );
		mainPanel.add( monthBox1, new GBC( 0, 4, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 180, Orientation.LEFT ) );
		mainPanel.add( monthLabel1, new GBC( 0, 4, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 225, Orientation.LEFT ) );
		mainPanel.add( dayBox1, new GBC( 0, 4, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 245, Orientation.LEFT ) );
		mainPanel.add( dayLabel1, new GBC( 0, 4, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 290, Orientation.LEFT ) );

		mainPanel.add( ejobLabel, new GBC( 0, 5, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( ejobBox, new GBC( 0, 5, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 80, Orientation.LEFT ) );


		mainPanel.add( esalLabel, new GBC( 0, 6, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( esalTextField, new GBC( 0, 6, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 80, Orientation.LEFT ) );


		mainPanel.add( eTelLabel, new GBC( 0, 7, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( eTelTextField, new GBC( 0, 7, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 80, Orientation.LEFT ) );

		mainPanel.add( emailLabel, new GBC( 0, 8, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( emailTextField, new GBC( 0, 8, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 80, Orientation.LEFT ) );

		mainPanel.add( egradeLabel, new GBC( 0, 9, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( egradeBox, new GBC( 0, 9, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 80, Orientation.LEFT ) );

		mainPanel.add( addressLabel, new GBC( 0, 10, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( addressTextField, new GBC( 0, 10, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 80, Orientation.LEFT ) );

		mainPanel.add( socialSecurityLabel, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( ss01CheckBox, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 100, Orientation.LEFT ) );
		mainPanel.add( ss02CheckBox, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 160, Orientation.LEFT ) );
		mainPanel.add( ss03CheckBox, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 220, Orientation.LEFT ) );
		mainPanel.add( ss04CheckBox, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 280, Orientation.LEFT ) );
		mainPanel.add( ss05CheckBox, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 340, Orientation.LEFT ) );
		mainPanel.add( ss06CheckBox, new GBC( 0, 11, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 400, Orientation.LEFT ) );

		mainPanel.add( remarkLabel, new GBC( 0, 12, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 20, Orientation.LEFT ) );
		mainPanel.add( jsp, new GBC( 0, 12, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 80, Orientation.LEFT ) );

		mainPanel.add( entryButton, new GBC( 0, 13, 1, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( 300, Orientation.LEFT ) );
		mainPanel.add( clearButton, new GBC( 0, 13, 1, 1, 100, 100 ).setAnchor( GBC.EAST ).setInsets( 300, Orientation.RIGHT ) );

		mainPanel.setBorder( BorderFactory.createTitledBorder( "填写员工资料" ) );

		//给提交按钮添加监听
		entryButton.addActionListener( new CommitButtonActionListener() );

		//设置不可变
		setResizable( false );
	}


	public static EntryEInfoPage getMySelf() {

		if ( eep == null ) {
			eep = new EntryEInfoPage();
		}
		return eep;
	}


	//根据年和月计算日对应的天数
	public static String[] getDaysByYearAndMonth( String year, String month ) {

		String[] subMonths01 = { "01", "03", "05", "07", "08", "10", "12" };
		for ( int i = 0; i < subMonths01.length; i++ ) {
			if ( subMonths01[ i ].equals( month ) ) {
				String[] days = new String[ 31 ];
				for ( int j = 0; j < 31; j++ ) {
					if ( j < 9 ) {
						days[ j ] = "0" + ( j + 1 ) + "";
					} else {
						days[ j ] = j + 1 + "";
					}

				}
				return days;
			}
		}

		String[] subMonths02 = { "04", "06", "09", "11" };
		for ( int i = 0; i < subMonths02.length; i++ ) {
			if ( subMonths02[ i ].equals( month ) ) {
				String[] days = new String[ 30 ];
				for ( int j = 0; j < 30; j++ ) {
					if ( j < 9 ) {
						days[ j ] = "0" + ( j + 1 ) + "";
					} else {
						days[ j ] = j + 1 + "";
					}
				}
				return days;
			}
		}

		//闰年
		int numYear = Integer.parseInt( year );
		if ( ( numYear % 4 == 0 && numYear % 100 == 0 ) || numYear % 400 == 0 ) {
			String[] days = new String[ 29 ];
			for ( int j = 0; j < 29; j++ ) {
				if ( j < 9 ) {
					days[ j ] = "0" + ( j + 1 ) + "";
				} else {
					days[ j ] = j + 1 + "";
				}
			}
			return days;
		}

		//非闰年
		String[] days = new String[ 28 ];
		for ( int j = 0; j < 28; j++ ) {
			if ( j < 9 ) {
				days[ j ] = "0" + ( j + 1 ) + "";
			} else {
				days[ j ] = j + 1 + "";
			}
		}
		return days;

	}


	//非静态内部类
	class MyItemListener implements ItemListener {

		@Override
		public void itemStateChanged( ItemEvent e ) {

		}

	}

	class CommitButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed( ActionEvent e ) {

			//1.获取页面中的所有信息.
			String  eno      = echoEnoLabel.getText();
			String  ename    = enameTextField.getText();
			boolean sex      = maleRadioButton.getText().equals( "男" ) ? true : false;
			String  ebirth   = (String) yearBox.getSelectedItem() + "-" + (String) monthBox.getSelectedItem() + "-" + (String) dayBox.getSelectedItem();
			String  joinDate = (String) yearBox1.getSelectedItem() + "-" + (String) monthBox1.getSelectedItem() + "-" + (String) dayBox1.getSelectedItem();

			String jobName = (String) ejobBox.getSelectedItem();
			Job    job     = js.findJobByJobName( jobName );

			double sal     = Double.parseDouble( esalTextField.getText() );
			String tel     = eTelTextField.getText();
			String email   = emailTextField.getText();
			String grade   = (String) egradeBox.getSelectedItem();
			String address = addressTextField.getText();

			Set< String > socialInsurances = new HashSet< String >();
			if ( ss01CheckBox.isSelected() ) {
				socialInsurances.add( ss01CheckBox.getText() );
			}
			if ( ss02CheckBox.isSelected() ) {
				socialInsurances.add( ss02CheckBox.getText() );
			}
			if ( ss03CheckBox.isSelected() ) {
				socialInsurances.add( ss03CheckBox.getText() );
			}
			if ( ss04CheckBox.isSelected() ) {
				socialInsurances.add( ss04CheckBox.getText() );
			}
			if ( ss05CheckBox.isSelected() ) {
				socialInsurances.add( ss05CheckBox.getText() );
			}
			if ( ss06CheckBox.isSelected() ) {
				socialInsurances.add( ss06CheckBox.getText() );
			}

			for ( String s : socialInsurances ) {
				System.out.println( s );
			}

			String remark = remarkArea.getText();


			//2.将信息封装成 EmployeeInfo对象.
			Employee employee = new Employee( address, ebirth, email, ename, eno, grade, job, joinDate, remark, sal, sex, socialInsurances, tel );

			//3.持久化(对员工信息实体类进行操作)
			EmployeeService es        = new EmployeeService();
			boolean         isSuccess = es.save( employee );

			//4.如果持久化成功,提醒
			if ( isSuccess ) {
				JOptionPane.showMessageDialog( EntryEInfoPage.this, "录入员工信息成功", "录入成功", JOptionPane.INFORMATION_MESSAGE );
			} else {
				//5.如果持久化失败,提醒
				JOptionPane.showMessageDialog( EntryEInfoPage.this, "录入员工信息失败", "录入失败", JOptionPane.ERROR_MESSAGE );
			}


		}

	}

	//测试
	public static void main( String[] args ) {

		EntryEInfoPage a = new EntryEInfoPage();
		a.setVisible( true );
		a.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}
