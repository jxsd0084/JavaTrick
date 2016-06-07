package bj.powernode.basic.day24.EMS.common;

import bj.powernode.basic.day24.EMS.entity.Administrator;
import bj.powernode.basic.day24.EMS.entity.Job;

import java.io.*;


/**
 * 初始化DB(绝密类)
 *
 * @author Administrator
 */
public class InitDB {

	private static File jobDBFile = new File( "c:/emsdb/job.dll" );

	/**
	 * 静态内部类
	 */
	static class JobOutputStream extends ObjectOutputStream {

		public JobOutputStream( OutputStream out ) throws IOException {

			super( out );
		}

		@Override
		protected void writeStreamHeader() throws IOException {

			if ( ! jobDBFile.exists() ) {
				jobDBFile.createNewFile();
			}

			if ( jobDBFile.length() == 0 ) {
				super.writeStreamHeader();
			} else {
				super.reset();
			}

		}


	}

	public static void initJobDB() {

		ObjectOutputStream oos = null;
		try {
			oos = new JobOutputStream( new FileOutputStream( jobDBFile, true ) );

			oos.writeObject( new Job( "001", "CEO" ) );
			oos.writeObject( new Job( "002", "A1级高级讲师" ) );
			oos.writeObject( new Job( "003", "A2级高级讲师" ) );
			oos.writeObject( new Job( "004", "B1级高级讲师" ) );
			oos.writeObject( new Job( "005", "B2级高级讲师" ) );
			oos.writeObject( new Job( "006", "技术总监" ) );
			oos.writeObject( new Job( "007", "项目经理" ) );
			oos.writeObject( new Job( "008", "架构师" ) );
			oos.writeObject( new Job( "009", "技术支持工程师" ) );
			oos.writeObject( new Job( "010", "项目实施工程师" ) );

			oos.flush();

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
	}

	public static void initAdminDB() {

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream( "c:/emsdb/admin.dll" ) );
			oos.writeObject( new Administrator( "admin", "admin" ) );
			oos.flush();
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
	}

	public static void main( String[] args ) throws Exception {

		initAdminDB();
		initJobDB();
		
		/*
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jobDBFile));
		
		while(true){
			try{
				System.out.println(ois.readObject());
			}catch(EOFException e){
				System.out.println("读取结束");
				break;
			}
			
		}
		
		ois.close();
		*/

	}

}
