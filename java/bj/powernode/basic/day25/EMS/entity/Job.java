package bj.powernode.basic.day25.EMS.entity;

import java.io.Serializable;

/**
 * 抽象EMS系统中的职位
 *
 * @author Administrator
 */
public class Job implements Serializable {

	private static final long serialVersionUID = 1857646843803178788L;

	private String jobName;
	private String jobNo;

	public Job() {

		super();
	}

	public Job( String jobNo, String jobName ) {

		super();
		this.jobNo = jobNo;
		this.jobName = jobName;
	}

	public String getJobName() {

		return jobName;
	}

	public String getJobNo() {

		return jobNo;
	}

	public void setJobName( String jobName ) {

		this.jobName = jobName;
	}

	public void setJobNo( String jobNo ) {

		this.jobNo = jobNo;
	}

	@Override
	public int hashCode() {

		final int prime  = 31;
		int       result = 1;
		result = prime * result + ( ( jobName == null ) ? 0 : jobName.hashCode() );
		result = prime * result + ( ( jobNo == null ) ? 0 : jobNo.hashCode() );
		return result;
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
		Job other = (Job) obj;
		if ( jobName == null ) {
			if ( other.jobName != null ) {
				return false;
			}
		} else if ( ! jobName.equals( other.jobName ) ) {
			return false;
		}
		if ( jobNo == null ) {
			if ( other.jobNo != null ) {
				return false;
			}
		} else if ( ! jobNo.equals( other.jobNo ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "Job [jobName=" + jobName + ", jobNo=" + jobNo + "]";
	}

}
