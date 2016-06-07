package bj.powernode.advance.Charpter17.test2;

import bj.powernode.advance.Charpter17.test2.dao.EmpDao;
import bj.powernode.advance.Charpter17.test2.dao.StudentDao;
import bj.powernode.advance.Charpter17.test2.dao.UsersDao;
import bj.powernode.advance.Charpter17.test2.domain.Student;
import bj.powernode.advance.Charpter17.test2.domain.Users;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;


public class Main {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Users user = new Users();
		user.setName( "WUSZ" );
		user.setPassword( "1234" );
		user.setSex( "男" );

		String strBrithday = "1976-12-23";
		user.setBirthday( Date.valueOf( strBrithday ) );

		UsersDao ud = new UsersDao();

		if ( ud.insertUsers( user ) ) {
			System.out.println( "插入用户成功" );
		} else {
			System.out.println( "插入用户失败" );
		}

		Users user2 = new Users();
		user2.setName( "admin' or 'x'='x" );
		user2.setPassword( "1234" );

		UsersDao ud2 = new UsersDao();
		if ( ud2.login( user2 ) ) {
			System.out.println( "成功" );
		} else {
			System.out.println( "失败" );
		}

		List< Users > list = new LinkedList< Users >();

		Users user3 = new Users();
		user3.setName( "WUSZ" );
		user3.setPassword( "1234" );
		user3.setSex( "男" );

		String strBrithday2 = "1976-12-23";
		user.setBirthday( Date.valueOf( strBrithday2 ) );
		list.add( user );





		// ------------------------------

		Users user1 = new Users();
		user1.setName( "WUSZ2" );
		user1.setPassword( "12342" );
		user1.setSex( "男" );

		String strBrithday1 = "1976-12-23";
		user1.setBirthday( Date.valueOf( strBrithday1 ) );
		list.add( user1 );





		// ------------------------------

		Users user4 = new Users();
		user4.setName( "WUSZ" );
		user4.setPassword( "1234" );
		user4.setSex( "男" );

		String strBrithday3 = "1976-12-23";
		user2.setBirthday( Date.valueOf( strBrithday3 ) );
		list.add( user4 );

		UsersDao dao = new UsersDao();
		dao.batchInsert( list );

		Student stu = new Student();
		stu.setName( "张一" );
		stu.setAge( 21 );
		stu.setSex( "男" );

		StudentDao sd = new StudentDao();
		sd.insertStu( stu );

		sd.testProcParam();






		EmpDao ed = new EmpDao();
		ed.selectEmp();





	}

}
