package bj.bigData.HBase.ex03.common.constants;

import bj.bigData.HBase.ex03.common.utils.HbaseConfigUtils;

import java.util.Properties;

/**
 * @author ranhualin
 * @date 2013-7-22
 */
public class TableConstants {

	/**
	 * 配置文件所在的基本路径
	 */
	public static final String PROP_FILE_PATH = "/config";
	
	public static final String TO_NET_ODS_ACCESSLOGS     = "TO_NET_ODS_ACCESSLOGS";
	public static final String TO_NET_ODS_FILTERLOGS     = "TO_NET_ODS_FILTERLOGS";
	public static final String TO_NET_ODS_MONITORLOGS    = "TO_NET_ODS_MONITORLOGS";
	public static final String TO_NET_ODS_MONITOR_IPINFO = "TO_NET_ODS_ MONITOR_IPINFO";
	public static final String TO_NET_ODS_ILLEGALINFO    = "TO_NET_ODS_ILLEGALINFO";
	
	private static final Properties prop                  = HbaseConfigUtils.getConfigs();
	/**
	 * 过滤条件标识
	 */
	public static final  String     VALUE_FILTERS_FLAG    = "VFILTERS";
	public static final  String     KEY_FILTERS_FLAG      = "KFILTERS";
	/**
	 * 返回最大结果数标识
	 */
	public static final  String     LIMIT_FLAG            = "PAGELIMIT";
	/**
	 * 多个过滤条件分隔符
	 */
	public static final  String     FILTERS_MUTIL_SPLITER = ";;;;";
	/**
	 * 过滤条件内各部分分割符
	 */
	public static final  String     FILTER_SPLITER        = "####";
	/**
	 * COLUMN_FAMILY
	 */
	public static final  byte[]     COMMON_COLUMN_FAMILY  = "f".getBytes();
	
	public static final byte[] COMMON_ROWKEY_FLAG = "A".getBytes();
	
	/**
	 * 访问日志表表 key长度
	 */
//	public static final int TABLE_ACCESSLOGS_KEY_LENGTH = 35;
	public static final int TABLE_ACCESSLOGS_KEY_LENGTH = Integer.parseInt( prop.getProperty( "table.accesslogs.key.length" ) );
	
	/**
	 * 监测日志表 key 长度
	 */
	public static final int    TABLE_MONITORLOGS_KEY_LENGTH    = Integer.parseInt( prop.getProperty( "table.monitorlogs.key.length" ) );
//	public static final int TABLE_MONITORLOGS_KEY_LENGTH = 27;
	/**
	 * 过滤日志表 key 长度
	 */
	public static final int    TABLE_FILTERLOGS_KEY_LENGTH     = Integer.parseInt( prop.getProperty( "table.filterlogs.key.length" ) );
//	public static final int TABLE_FILTERLOGS_KEY_LENGTH = 27;
	/**
	 * 异常ip监测表 key长度
	 */
//	public static final int TABLE_MONITOR_IPINFO_KEY_LENGTH = Integer.parseInt(prop.getProperty("table.monitoripinfo.key.length"));
	public static final int    TABLE_MONITOR_IPINFO_KEY_LENGTH = 27;
	/**
	 * 违法违规网站表 key长度
	 */
	public static final int    TABLE_ILLEGALINFO_KEY_LENGTH    = Integer.parseInt( prop.getProperty( "table.illegalinfo.key.length" ) );
	//	public static final int TABLE_ILLEGALINFO_KEY_LENGTH = 27;
	public static final String VALUE_SPLITER                   = "\\|";
	
	public static final int ERROR_CODE_1 = 1;
	public static final int ERROR_CODE_2 = 1;
	public static final int ERROR_CODE_3 = 1;
	
}
