package bj.bigData.HBase.ex03.query.bean;

import org.apache.hadoop.hbase.util.Bytes;

/**
 * 表字段实体
 *
 * @author ranhualin
 * @date 2013-7-22
 */
public class FieldInfo implements Comparable< FieldInfo > {

	private String columnName;
	private String fieldName;
	private int    fieldIndex;

	// 预留
	// private String fieldType;
	public FieldInfo() {

	}

	public FieldInfo( String columnName, String fieldName, int fieldIndex ) {

		this.columnName = columnName;
		this.fieldName = fieldName;
		this.fieldIndex = fieldIndex;
	}

	public String getFieldName() {

		return fieldName;
	}

	public void setFieldName( String fieldName ) {

		this.fieldName = fieldName;
	}

	public int getFieldIndex() {

		return fieldIndex;
	}

	public void setFieldIndex( int fieldIndex ) {

		this.fieldIndex = fieldIndex;
	}

	public String getColumnName() {

		return columnName;
	}

	public void setColumnName( String columnName ) {

		this.columnName = columnName;
	}

	@Override
	public int compareTo( FieldInfo o ) {

		if ( !Bytes.equals( columnName.getBytes(), o.getColumnName().getBytes() ) ) {
			return Bytes.compareTo( columnName.getBytes(), o.getColumnName().getBytes() );
		} else {
			return fieldIndex - o.getFieldIndex();
		}
	}
	
}
