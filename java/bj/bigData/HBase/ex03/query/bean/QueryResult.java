package bj.bigData.HBase.ex03.query.bean;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * @author ranhualin
 * @date 2013-7-22
 */
public class QueryResult implements Serializable {

	private static final long                   serialVersionUID = -7813884495385493981L;
	private              LinkedList< QueryRow > results          = new LinkedList< QueryRow >();
	private              int                    scansize         = 0;
	
	public LinkedList< QueryRow > getResult() {

		return results;
	}

	public void setResult( LinkedList< QueryRow > results ) {

		this.results = results;
	}

	public int getScansize() {

		return scansize;
	}

	public void setScansize( int scansize ) {

		this.scansize = scansize;
	}
	
	//添加行
	public void addData( QueryRow row ) {

		results.add( row );
	}
	
	//汇总行
	public void mergeData( LinkedList< QueryRow > rows ) {

		results.addAll( rows );
	}
	
}
