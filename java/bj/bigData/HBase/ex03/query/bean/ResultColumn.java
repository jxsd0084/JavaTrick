package bj.bigData.HBase.ex03.query.bean;

import org.apache.openjpa.lib.util.Bytes;

import java.io.Serializable;

//对应HBase内每个column qualifier的数据
public class ResultColumn implements Serializable, Comparable< ResultColumn > {

	private static final long serialVersionUID = -1643710018065786872L;
	private byte[] qualifier;
	private byte[] datarow;
	
	public ResultColumn( byte[] qualifier, byte[] datarow ) {

		this.qualifier = qualifier;
		this.datarow = datarow;
	}

	public byte[] getQualifier() {

		return qualifier;
	}

	public void setQualifier( byte[] qualifier ) {

		this.qualifier = qualifier;
	}

	public byte[] getDatarow() {

		return datarow;
	}

	public void setDatarow( byte[] datarow ) {

		this.datarow = datarow;
	}

	@Override
	public int compareTo( ResultColumn o ) {

		return Bytes.compareTo( qualifier, o.getQualifier() );
	}
}
