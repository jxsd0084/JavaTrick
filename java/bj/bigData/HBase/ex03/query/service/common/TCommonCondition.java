package bj.bigData.HBase.ex03.query.service.common;

import com.boco.DataPlatform.hbase.query.thrift.CommonCondition;

/**
 * 封装基础的查询参数，并检查参数是否合法，如果不合法，设置为默认值
 * 
 * @author ranhualin
 * @date 2013-7-19
 */
public class TCommonCondition {
	private static final int default_page_no = 1; // 页码
	private static final int default_page_size = 100; // 每页显示条数
	private static final int default_timeout = 300000; // 默认超时时间 5分钟
	private int pageNo; // required
	private int pageSize; // required
	private int timeout; // required

	public TCommonCondition(CommonCondition condition) {
		if (condition.pageNo <= 0) {
			pageNo = default_page_no;
		} else {
			pageNo = condition.pageNo;
		}
		if (condition.pageSize <= 0) {
			pageSize = default_page_size;
		} else {
			pageSize = condition.pageSize;
		}
		if (condition.timeout <= 0) {
			timeout = default_timeout;
		} else {
			timeout = condition.timeout;
		}
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
}
