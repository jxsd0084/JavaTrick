package bj.bigData.HBase.ex03.creater;

import java.io.IOException;
import java.text.ParseException;

/**
 * 创建表
 *
 * @author ranhualin
 * @date 2013-7-19
 */
public class TableCreateFactory {

	private static AccessLogsCreater    accessCreater;
	private static MonitorLogsCreater   monitorCreater;
	private static FilterLogsCreater    filterCreater;
	private static MonitorIpinfoCreater ipinfoCreater;
	private static IllegalInfoCreater   illegalCreater;

	public static void main( String[] args ) throws Exception {

	}

	private static String createTable( String date, BaseCreater creater )
			throws ParseException, IOException {

		String tableName = creater.getTable( date );
		creater.spliter( tableName );
		return tableName;
	}

	/**
	 * 2012-07-23 16:00:00
	 *
	 * @param date
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String createAccessLogs( String date ) throws ParseException,
			IOException {

		if ( accessCreater == null ) {
			accessCreater = new AccessLogsCreater();
		}
		return createTable( date, accessCreater );
	}

	public static String createMonitorLogs( String date ) throws ParseException,
			IOException {

		if ( monitorCreater == null ) {
			monitorCreater = new MonitorLogsCreater();
		}
		return createTable( date, monitorCreater );
	}

	public static String createFilterLogs( String date ) throws ParseException,
			IOException {

		if ( filterCreater == null ) {
			filterCreater = new FilterLogsCreater();
		}
		return createTable( date, filterCreater );
	}

	public static String createMonitorIpinfo( String date )
			throws ParseException, IOException {

		if ( ipinfoCreater == null ) {
			ipinfoCreater = new MonitorIpinfoCreater();
		}
		return createTable( date, ipinfoCreater );
	}

	public static String createIllegalInfo( String date ) throws ParseException,
			IOException {

		if ( illegalCreater == null ) {
			illegalCreater = new IllegalInfoCreater();
		}
		return createTable( date, illegalCreater );
	}

}
