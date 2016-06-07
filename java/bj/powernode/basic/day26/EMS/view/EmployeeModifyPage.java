package bj.powernode.basic.day26.EMS.view;

import bj.powernode.basic.day26.EMS.entity.Employee;

import javax.swing.*;
import java.util.Set;

/**
 * 员工信息修改页面
 *
 * @author Administrator
 */
public class EmployeeModifyPage extends EntryEInfoPage {

	public EmployeeModifyPage( Employee employee ) {

		super();

		//重新设置标题
		setTitle( "修改员工信息" );

		//员工编号
		getEchoEnoLabel().setText( employee.getEno() );

		//员工姓名
		getEnameTextField().setText( employee.getEname() );

		//员工性别
		System.out.println( employee.isSex() );
		if ( employee.isSex() ) {
			getMaleRadioButton().setSelected( true );
		} else {
			getFemaleRadioButton().setSelected( true );
		}

		//员工生日
		String   birth = employee.getEbirth();
		String[] YMD   = birth.split( "-" );
		getYearBox().setSelectedItem( YMD[ 0 ] );
		getMonthBox().setSelectedItem( YMD[ 1 ] );
		getDayBox().setSelectedItem( YMD[ 2 ] );

		//员工入职日期
		String   joinDate = employee.getJoinDate();
		String[] YMD2     = joinDate.split( "-" );
		getYearBox1().setSelectedItem( YMD2[ 0 ] );
		getMonthBox1().setSelectedItem( YMD2[ 1 ] );
		getDayBox1().setSelectedItem( YMD2[ 2 ] );

		//员工职位
		getEjobBox().setSelectedItem( employee.getJob().getJobName() );

		//员工月薪
		getEsalTextField().setText( employee.getSal() + "" );

		//联系电话
		geteTelTextField().setText( employee.getTel() );

		//邮箱
		getEmailTextField().setText( employee.getEmail() );

		//学历
		getEgradeBox().setSelectedItem( employee.getGrade() );

		//住址
		getAddressTextField().setText( employee.getAddress() );

		//员工保险
		Set< String > ss = employee.getSocialInsurances();

		if ( ss.contains( "养老" ) ) {
			getSs01CheckBox().setSelected( true );
		} else {
			getSs01CheckBox().setSelected( false );
		}
		if ( ss.contains( "失业" ) ) {
			getSs02CheckBox().setSelected( true );
		} else {
			getSs02CheckBox().setSelected( false );
		}
		if ( ss.contains( "工伤" ) ) {
			getSs03CheckBox().setSelected( true );
		} else {
			getSs03CheckBox().setSelected( false );
		}
		if ( ss.contains( "生育" ) ) {
			getSs04CheckBox().setSelected( true );
		} else {
			getSs04CheckBox().setSelected( false );
		}
		if ( ss.contains( "医保" ) ) {
			getSs05CheckBox().setSelected( true );
		} else {
			getSs05CheckBox().setSelected( false );
		}
		if ( ss.contains( "公积金" ) ) {
			getSs06CheckBox().setSelected( true );
		} else {
			getSs06CheckBox().setSelected( false );
		}

		//备注
		getRemarkArea().setText( employee.getRemark() );

		//修改按钮
		getEntryButton().setText( "修改" );

		getMainPanel().setBorder( BorderFactory.createTitledBorder( "修改员工资料" ) );

	}


}
