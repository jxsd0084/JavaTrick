package bj.bigData.HBase.ex03.query.service.common;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import com.boco.DataPlatform.hbase.query.bean.FieldInfo;
import com.boco.DataPlatform.hbase.query.bean.TableInfo;
import com.boco.DataPlatform.hbase.query.exception.ClientParameterException;
import com.boco.DataPlatform.utils.ConfigUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 初始化表信息配置
 * 
 * @author ranhualin
 * @date 2013-7-23
 */
public class IdcTableInfos {

	protected static final Logger logger = Logger
			.getLogger(IdcTableInfos.class);

	private static final String accesslog_path = TableConstants.PROP_FILE_PATH
			+ "/HTABLE_TO_NET_ODS_ACCESSLOGS.properties";
	private static final String filterlog_path = TableConstants.PROP_FILE_PATH
			+ "/HTABLE_TO_NET_ODS_FILTERLOGS.properties";
	private static final String monitorlog_path = TableConstants.PROP_FILE_PATH
			+ "/HTABLE_TO_NET_ODS_MONITORLOGS.properties";
	private static final String monitoripinfo_path = TableConstants.PROP_FILE_PATH
			+ "/HTABLE_TO_NET_ODS_MONITOR_IPINFO.properties";
	private static final String illegalinfo_path = TableConstants.PROP_FILE_PATH
			+ "/HTABLE_TO_NET_ODS_ILLEGALINFO.properties";
	private static Map<String, TableInfo> idctables;

	public static TableInfo getTableInfo(String tableTypeName) {
		if (idctables == null) {
			initTableInfo();
		}
		return idctables.get(tableTypeName);
	}

	public static Map<String, TableInfo> initTableInfo() {
		idctables = new HashMap<String, TableInfo>();
		idctables.put(TableConstants.TO_NET_ODS_ACCESSLOGS,
				read(accesslog_path));
		idctables.put(TableConstants.TO_NET_ODS_FILTERLOGS,
				read(filterlog_path));
		idctables.put(TableConstants.TO_NET_ODS_MONITORLOGS,
				read(monitorlog_path));
		idctables.put(TableConstants.TO_NET_ODS_MONITOR_IPINFO,
				read(monitoripinfo_path));
		idctables.put(TableConstants.TO_NET_ODS_ILLEGALINFO,
				read(illegalinfo_path));
		return idctables;
	}

	private static FieldInfo buildFieldInfo(String key, String value) {
		String[] vs = value.split(":");
		return new FieldInfo(vs[1], key, Integer.parseInt(vs[2]));
	}

	@SuppressWarnings("rawtypes")
	private static TableInfo read(String path) {
		Properties prop = new Properties();
		InputStream inputStream = null;
		TableInfo info = new TableInfo();
		int count = 0;
		try {
			inputStream = ConfigUtils.class.getResourceAsStream(path);
			prop.load(inputStream);
			if (prop != null) {
				Enumeration e = prop.keys();
				while (e.hasMoreElements()) {
					String k = e.nextElement().toString();
					info.addFieldInfo(buildFieldInfo(k, prop.get(k) + ""));
					count++;
				}
			}
			logger.info("init [" + path + "] success...total field:" + count);
		} catch (Exception e) {
			System.out.println("init properties error: " + path);
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println("can't close the inputstream!");
					e.printStackTrace();
				}
			}
		}
		return info;
	}
	
	/**
	 * 检查过滤条件输入是否合法   主要检查  字段名与表中字段名 是否一致
	 * @param tableName
	 * @param fieldName
	 * @throws ClientParameterException
	 */
	public static void checkFilter(String tableName,String fieldName) throws ClientParameterException{
		if (idctables == null) {
			initTableInfo();
		}
		TableInfo ti = idctables.get(tableName);
		FieldInfo fi = ti.getFieldInfo(fieldName);
		if(fi==null){
			throw new ClientParameterException(TableConstants.ERROR_CODE_1,"Error field name["+fieldName+"]!");
		}
	}

	public static void main(String[] args) {
		initTableInfo();
		TableInfo ti = idctables.get(TableConstants.TO_NET_ODS_MONITORLOGS);
		for (FieldInfo fi : ti.getFields()) {
			System.out.println(fi.getColumnName());
			System.out.println(fi.getFieldName());
			System.out.println(fi.getFieldIndex());
			System.out.println("----------------");
		}
	}
}