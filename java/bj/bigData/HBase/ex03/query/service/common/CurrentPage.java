package bj.bigData.HBase.ex03.query.service.common;

import java.util.ArrayList;
import java.util.List;

/**
 *  存放client端所需的数据
 * @author ranhualin
 * @date 2013-1-5
 */
public class CurrentPage {

	Object pagelock;
	private int pageNo;
	private int pageSize;
	private List<String> metadata;
	private int resultsize = 0;
	private int start;
	private int needs;
	private List<List<String>> objrows = new ArrayList<List<String>>();
	private boolean iscount = false;
	private long countrs = 0;

	public CurrentPage(int pageNo, int pageSize) {
		if (pageNo < 0) {
			pageNo = 0;
		}
		if (pageSize <= 0) {
			pageSize = 1000;
		}
		this.pageNo = pageNo;
		start = (pageNo-1) * pageSize;
		needs = (pageNo) * pageSize;
		this.pageSize = pageSize;
		this.pagelock = new Object();
	}
	public void clear(){
		objrows  = new ArrayList<List<String>>();
		metadata = null;
	}

	public int getResultsize() {
		return resultsize;
	}
	

	public boolean isIscount() {
		return iscount;
	}

	public void setIscount(boolean iscount) {
		this.iscount = iscount;
	}

	public void setResultsize(int resultsize) {
		this.resultsize = resultsize;
	}

	public List<String> getMetadata() {

		return metadata;
	}
	public void setMetadata(List<String> metadata) {
		this.metadata = metadata;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 获取开始的记录
	 * 
	 * @return
	 */
	public int getStart() {
		return start;
	}

	/**
	 * 获取查询该页必须保留的数据数
	 * 
	 * @return
	 */
	public int getNeeds() {
		return needs;
	}

	/**
	 * 获取该页记录的
	 * 
	 * @return
	 */
	public List<List<String>> getStringRows() {
		return objrows;
	}
	public void setObjrows(List<List<String>> objrows) {
		this.objrows = objrows;
	}

	public int getRowCount() {
		synchronized (pagelock) {
			return objrows.size();
		}
	}
	public long getCountrs() {
		return countrs;
	}
	public void setCountrs(long countrs) {
		this.countrs = countrs;
	}
	
}
