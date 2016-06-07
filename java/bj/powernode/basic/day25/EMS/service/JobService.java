package bj.powernode.basic.day25.EMS.service;

import bj.powernode.basic.day25.EMS.entity.Job;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * JobService是完成职位对象的增删改查等操作.
 *
 * @author Administrator
 */
public class JobService {

	/**
	 * 通过职位的名称返回职位对象
	 *
	 * @param jobName 职位名称
	 * @return 返回职位对象, 如果没有找到改职位返回null
	 */
	public Job findJobByJobName( String jobName ) {

		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream( new FileInputStream( "c:/emsdb/job.dll" ) );
			while ( true ) {
				Job job = (Job) ois.readObject();
				if ( jobName.equals( job.getJobName() ) ) {
					return job;
				}
			}
		} catch ( Exception e ) {

			e.printStackTrace();

		} finally {

			if ( ois != null ) {
				try {
					ois.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}


	public String[] findAllJobNames() {

		ObjectInputStream ois           = null;
		Set< String >     jobNames      = null;
		String[]          jobNamesArray = null;

		try {
			ois = new ObjectInputStream( new FileInputStream( "c:/emsdb/job.dll" ) );
			jobNames = new HashSet< String >();

			while ( true ) {
				try {
					jobNames.add( ( (Job) ois.readObject() ).getJobName() );
				} catch ( EOFException e ) {
					System.out.println( "职位文件读取结束" );
					break;
				}

			}

			//转换
			jobNamesArray = new String[ jobNames.size() ];
			int i = 0;
			for ( String jobName : jobNames ) {
				jobNamesArray[ i++ ] = jobName;
			}


		} catch ( Exception e ) {

			e.printStackTrace();

		} finally {

			if ( ois != null ) {
				try {
					ois.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}

		return jobNamesArray;
	}
}













