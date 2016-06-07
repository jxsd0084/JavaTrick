package bj.bigData.Oozie.ex01;

//import cn.crxy.idc.utils.Metadata;

import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.OozieClientException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by gs on 2015/10/25.
 */
public class OozieRunner {

	//配置参数
	public static String OOZIECLIENT  = "";
	public static String NAMENODE     = "";
	public static String JOBTRACKER   = "";
	public static String QUEUENAME    = "";
	public static String EXAMPLESROOT = "";
	public static String USERNAME     = "";

	//传递参数
	public static String JOB_NAME = "";
	public static String WF_PATH  = "";
	public static String LIBPATH  = "";


	public OozieRunner() {

/*		Metadata metadata = new Metadata( "/config/oozie.properties" );
		OOZIECLIENT = metadata.getValue( "oozieClient" );
		NAMENODE = metadata.getValue( "nameNode" );
		JOBTRACKER = metadata.getValue( "jobTracker" );
		QUEUENAME = metadata.getValue( "queueName" );
		EXAMPLESROOT = metadata.getValue( "examplesRoot" );
		USERNAME = metadata.getValue( "username" );
		LIBPATH = metadata.getValue( "libpath" );*/

	}

	public static void main( String[] args ) {
		//获取参数
		if ( args.length != 2 ) {
			System.out.println( "USage: <JOB_NAME> <WF_PATH>" );
			System.exit( 1 );
		}

		JOB_NAME = args[ 0 ]; //当前启动oozie流程名称
		WF_PATH = args[ 1 ]; //workflow.xml文件所在的地址（HDFS上）

		try {
			//获取oozie配置文件对象，设置相应配置
			OozieRunner oozieRunner = new OozieRunner();

			OozieClient client = new OozieClient( OOZIECLIENT );
			Properties  conf   = client.createConfiguration();

			conf.setProperty( OozieClient.USER_NAME, USERNAME );
			conf.setProperty( OozieClient.APP_PATH, NAMENODE + "/user/" + USERNAME + "/" + WF_PATH );
			conf.setProperty( OozieClient.LIBPATH, NAMENODE + "/user/" + USERNAME + "/" + LIBPATH );

			conf.setProperty( "oozieClient", OOZIECLIENT );
			conf.setProperty( "nameNode", NAMENODE );
			conf.setProperty( "queueName", QUEUENAME );
			conf.setProperty( "jobTracker", JOBTRACKER );
			conf.setProperty( "jobname", JOB_NAME );
			conf.setProperty( "examplesRoot", EXAMPLESROOT );


			//获取上一个小时的时间
			Calendar calendar = Calendar.getInstance();
			calendar.set( Calendar.HOUR_OF_DAY, calendar.get( Calendar.HOUR_OF_DAY ) - 1 );
			SimpleDateFormat df = new SimpleDateFormat( "yyyyMMddHH" );
			conf.setProperty( "inputtime", df.format( calendar.getTime() ) );


			System.out.println( "当前的时间：" + df.format( new Date() ) );
			System.out.println( "一个小时前的时间：" + df.format( calendar.getTime() ) );
			//启动job
			System.out.println( "job_minute启动成功，id : " + client.run( conf ) );

		} catch ( OozieClientException e ) {
			e.printStackTrace();
		}

	}

}
