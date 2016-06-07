package bj.powernode.basic.day26.EMS.service;

import bj.powernode.basic.day26.EMS.entity.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 关于员工的业务操作
 * 员工信息的增删改查，都在此业务类中完成.
 *
 * @author Administrator
 */
public class EmployeeService {

	private static File employeeDBFile = new File( "c:/emsdb/employee.dll" );

	static {
		if ( ! employeeDBFile.exists() ) {
			try {
				employeeDBFile.createNewFile();
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}

	class EmployeeOutputStream extends ObjectOutputStream {

		public EmployeeOutputStream( OutputStream out ) throws IOException {

			super( out );
		}

		@Override
		protected void writeStreamHeader() throws IOException {

			if ( employeeDBFile.length() == 0 ) {
				super.writeStreamHeader();
			} else {
				super.reset();
			}

		}
	}

	/**
	 * 修改员工的信息
	 *
	 * @param employee 员工新的
	 * @return 修改成功返回true, 修改失败返回false
	 */
	public boolean modify( Employee employee ) {

		boolean isSuccess = false;

		try {
			//1.找出所有员工
			List< Employee > employees = findAllEmployee();

			//2.遍历集合,找出employee
			for ( int i = 0; i < employees.size(); i++ ) {
				Employee e = employees.get( i );
				if ( e.getEno().equals( employee.getEno() ) ) {
					employees.remove( e );
					employees.add( i, employee );
					break;
				}
			}

			//3.删除文件
			employeeDBFile.delete();
			if ( ! employeeDBFile.exists() ) {
				employeeDBFile.createNewFile();
			}

			//4.将集合中的数据持久化到文件中
			isSuccess = save( employees );

		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return isSuccess;
	}


	public boolean deleteEmployee( Employee employee ) {

		boolean isSuccess = false;

		try {
			//1.找出所有员工
			List< Employee > employees = findAllEmployee();

			//2.遍历集合,找出employee
			employees.remove( employee );

			//3.删除文件
			employeeDBFile.delete();
			if ( ! employeeDBFile.exists() ) {
				employeeDBFile.createNewFile();
			}

			//4.将集合中的数据持久化到文件中
			isSuccess = save( employees );

		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	/**
	 * 完成员工信息的持久化
	 *
	 * @param employee 员工对象
	 * @return 持久化成功返回true
	 */
	public boolean save( Object obj ) {

		boolean flag = false;

		ObjectOutputStream oos = null;

		try {

			oos = new EmployeeOutputStream( new FileOutputStream( employeeDBFile, true ) );

			if ( obj instanceof Employee ) {
				oos.writeObject( obj );
				oos.flush();
			}

			if ( obj instanceof List ) {
				List< Employee > employees = (List< Employee >) obj;
				for ( Employee e : employees ) {
					oos.writeObject( e );
					oos.flush();
				}
			}


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


	/**
	 * 判断给定的员工编号是否存在
	 *
	 * @param eno 员工编号
	 * @return 如果存在返回true, 如果不存在返回false
	 */
	public boolean isExists( String eno ) {

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream( new FileInputStream( employeeDBFile ) );
			while ( true ) {
				try {
					Employee employee = (Employee) ois.readObject();
					if ( employee.getEno().equals( eno ) ) {
						return true;
					}
				} catch ( EOFException e ) {
					System.out.println( "员工文件读取结束" );
					return false;
				}
			}
		} catch ( EOFException e ) {
			System.out.println( "员工表中没有员工数据" );
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
		return false;
	}


	public List< Employee > findAllEmployee() {

		ObjectInputStream ois       = null;
		List< Employee >  employees = new ArrayList< Employee >();
		try {
			ois = new ObjectInputStream( new FileInputStream( employeeDBFile ) );

			//循环添加
			while ( true ) {
				try {
					Employee e = (Employee) ois.readObject();
					employees.add( e );
				} catch ( EOFException e1 ) {
					System.out.println( "员工文件已经读取结束." );
					break;
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
		return employees;
	}


	/**
	 * 根据员工编号找出对应的员工信息
	 *
	 * @param eno 员工编号
	 * @return 找到返回员工对象，反之返回null
	 */
	public Employee findEmployeeByEno( String eno ) {

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream( new FileInputStream( employeeDBFile ) );

			while ( true ) {
				try {
					Employee e = (Employee) ois.readObject();
					if ( e.getEno().equals( eno ) ) {
						return e;
					}
				} catch ( EOFException e1 ) {
					System.out.println( "员工文件已经读取结束." );
					break;
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


}
