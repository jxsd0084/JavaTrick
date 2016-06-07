package bj.powernode.advance.Charpter19.domain;

import java.util.*;

public class EmpPage {

	public static final int itemPerPage = 5;// 每页的数据条数
	private int         totalNum; // 数据的总条数
	private int         totalPage; // 总页数
	private int         currentPage; // 当前页
	private List< Emp > list;


	public int getTotalNum() {

		return totalNum;
	}

	public void setTotalNum( int totalNum ) {

		this.totalNum = totalNum;
		if ( totalNum % itemPerPage == 0 ) {
			this.totalPage = this.totalNum / itemPerPage;
		} else {
			this.totalPage = this.totalNum / itemPerPage + 1;
		}
	}

	public int getTotalPage() {

		return totalPage;
	}

	public void setTotalPage( int totalPage ) {

		this.totalPage = totalPage;
	}

	public int getCurrentPage() {

		return currentPage;
	}

	public void setCurrentPage( int currentPage ) {

		this.currentPage = currentPage;
	}

	public List< Emp > getList() {

		return list;
	}

	public void setList( List< Emp > list ) {

		this.list = list;
	}
}
