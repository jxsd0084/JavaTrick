package bj.bigData.HBase.ex03.query.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * HBase内每一行的数据
 *
 * @author ranhualin
 * @date 2013-7-22
 */
public class QueryRow implements Serializable {

	private static final long serialVersionUID = 4463657269404219555L;
	
	private List< ResultColumn > columns = new ArrayList< ResultColumn >();
	
	public QueryRow() {

	}

	public List< ResultColumn > getColumns() {

		return columns;
	}

	public void setColumns( List< ResultColumn > columns ) {

		this.columns = columns;
	}

	public void addColumns( byte[] qualifier, byte[] datarow ) {

		columns.add( new ResultColumn( qualifier, datarow ) );
	}
	
}
