package bj.powernode.basic.day25.EMS.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * EMS系统中的“员工信息”实体类 (javaBean:咖啡豆) 抽象属性： 1.员工编号 2.员工姓名 3.员工性别 4.员工生日 5.入职日期
 * 6.员工职位 7.员工月薪 8.联系电话 9.员工邮件 10.员工学历 11.家庭住址 12.社会保险 13.备注
 *
 * @author Administrator
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = - 8054713154143078593L;

	private String        address;
	private String        ebirth;
	private String        email;
	private String        ename;
	private String        eno;
	private String        grade;
	private Job           job;
	private String        joinDate;
	private String        remark;
	private double        sal;
	private boolean       sex; // true表示男,false表示女
	private Set< String > socialInsurances; // 社会保险
	private String        tel;

	public Employee() {

		super();
	}

	public Employee( String address, String ebirth, String email,
	                 String ename, String eno, String grade, Job job, String joinDate,
	                 String remark, double sal, boolean sex,
	                 Set< String > socialInsurances, String tel ) {

		super();
		this.address = address;
		this.ebirth = ebirth;
		this.email = email;
		this.ename = ename;
		this.eno = eno;
		this.grade = grade;
		this.job = job;
		this.joinDate = joinDate;
		this.remark = remark;
		this.sal = sal;
		this.sex = sex;
		this.socialInsurances = socialInsurances;
		this.tel = tel;
	}

	public String getAddress() {

		return address;
	}

	public String getEbirth() {

		return ebirth;
	}

	public String getEmail() {

		return email;
	}

	public String getEname() {

		return ename;
	}

	public String getEno() {

		return eno;
	}

	public String getGrade() {

		return grade;
	}

	public Job getJob() {

		return job;
	}

	public String getJoinDate() {

		return joinDate;
	}

	public String getRemark() {

		return remark;
	}

	public double getSal() {

		return sal;
	}

	public Set< String > getSocialInsurances() {

		return socialInsurances;
	}

	public String getTel() {

		return tel;
	}

	public boolean isSex() {

		return sex;
	}

	public void setAddress( String address ) {

		this.address = address;
	}

	public void setEbirth( String ebirth ) {

		this.ebirth = ebirth;
	}

	public void setEmail( String email ) {

		this.email = email;
	}

	public void setEname( String ename ) {

		this.ename = ename;
	}

	public void setEno( String eno ) {

		this.eno = eno;
	}

	public void setGrade( String grade ) {

		this.grade = grade;
	}

	public void setJob( Job job ) {

		this.job = job;
	}

	public void setJoinDate( String joinDate ) {

		this.joinDate = joinDate;
	}

	public void setRemark( String remark ) {

		this.remark = remark;
	}

	public void setSal( double sal ) {

		this.sal = sal;
	}

	public void setSex( boolean sex ) {

		this.sex = sex;
	}

	public void setSocialInsurances( Set< String > socialInsurances ) {

		this.socialInsurances = socialInsurances;
	}

	public void setTel( String tel ) {

		this.tel = tel;
	}


	@Override
	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( getClass() != obj.getClass() ) {
			return false;
		}
		Employee other = (Employee) obj;
		if ( eno == null ) {
			if ( other.eno != null ) {
				return false;
			}
		} else if ( ! eno.equals( other.eno ) ) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {

		final int prime  = 31;
		int       result = 1;
		result = prime * result + ( ( eno == null ) ? 0 : eno.hashCode() );
		return result;
	}

	@Override
	public String toString() {

		return "EmployeeInfo [ename=" + ename + ", eno=" + eno + "]";
	}

}
