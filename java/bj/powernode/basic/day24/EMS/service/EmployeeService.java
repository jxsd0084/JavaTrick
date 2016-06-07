package bj.powernode.basic.day24.EMS.service;

import bj.powernode.basic.day24.EMS.entity.Employee;

import java.io.*;

/**
 * 关于员工的业务操作
 * 员工信息的增删改查，都在此业务类中完成.
 *
 * @author Administrator
 */
public class EmployeeService {

	private File employeeDBFile = new File( "c:/emsdb/employee.dll" );

	class EmployeeOutputStream extends ObjectOutputStream {

		public EmployeeOutputStream( OutputStream out ) throws IOException {

			super( out );
		}

		@Override
		protected void writeStreamHeader() throws IOException {

			if ( ! employeeDBFile.exists() ) {
				employeeDBFile.createNewFile();
			}

			if ( employeeDBFile.length() == 0 ) {
				super.writeStreamHeader();
			} else {
				super.reset();
			}

		}
	}


	/**
	 * 完成员工信息的持久化
	 *
	 * @param employee 员工对象
	 * @return 持久化成功返回true
	 */
	public boolean save( Employee employee ) {

		boolean flag = false;

		ObjectOutputStream oos = null;

		try {

			oos = new EmployeeOutputStream( new FileOutputStream( employeeDBFile ) );

			oos.writeObject( employee );

			oos.flush();

			flag = true;

		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			if ( oos != null ) {
				try {
					oos.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}

		return flag;
	}
}























