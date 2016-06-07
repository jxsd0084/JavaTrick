package bj.bigData.HBase.ex03.query.bean;

import bj.bigData.HBase.ex03.query.type.OperatorType;
import com.boco.DataPlatform.hbase.common.constants.TableConstants;

import java.util.*;

/**
 * 表定义实体
 *
 * @author ranhualin
 * @date 2013-7-22
 */
public class TableInfo {

	private String tableName;
	private List< FieldInfo >        fields        = new ArrayList< FieldInfo >();
	// 字段及所在位置Map
	private Map< String, FieldInfo > fieldIndexMap = new LinkedHashMap< String, FieldInfo >();

	public String getTableName() {

		return tableName;
	}

	public void setTableName( String tableName ) {

		this.tableName = tableName;
	}

	public List< FieldInfo > getFields() {

		return fields;
	}

	public void setFields( List< FieldInfo > fields ) {

		this.fields = fields;
	}

	public void addFieldInfo( String column, String field, int index ) {

		FieldInfo fi = new FieldInfo( column, field, index );
		fields.add( fi );
		fieldIndexMap.put( field, fi );
	}

	public void addFieldInfo( FieldInfo info ) {

		fields.add( info );
		fieldIndexMap.put( info.getFieldName(), info );
	}
	
	public FieldInfo getFieldInfo( String fieldName ) {

		return fieldIndexMap.get( fieldName );
	}
	
	public List< String > getMetadata() {

		Collections.sort( fields );
		List< String > meta = new ArrayList< String >();
		for ( FieldInfo info : fields ) {
			meta.add( info.getFieldName() );
		}
		return meta;
	}

	public String getValueFilterStr( String field, OperatorType matchType, String value ) {

		FieldInfo     info = fieldIndexMap.get( field );
		StringBuilder sb   = new StringBuilder();
		if ( info != null ) {
			sb.append( info.getColumnName() + TableConstants.FILTER_SPLITER );
			sb.append( info.getFieldIndex() + TableConstants.FILTER_SPLITER );
			sb.append( matchType.toString() + TableConstants.FILTER_SPLITER );
			sb.append( value );
		}
		return sb.toString();
	}
}
