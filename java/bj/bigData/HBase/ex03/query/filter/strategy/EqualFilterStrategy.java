package bj.bigData.HBase.ex03.query.filter.strategy;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * 实现类似于SQL过滤 的 = 操作
 *
 * @author ranhualin
 * @date 2013-7-22
 */
public class EqualFilterStrategy implements IFilterStrategy, Serializable {

	protected static final Logger logger = Logger.getLogger( EqualFilterStrategy.class );

	private static final long serialVersionUID = 1929684764116713716L;
	private String condition;
	private int offset = 0;
	private int length = -1;
	private int index;

	public EqualFilterStrategy( String fieldIndex, String condition ) {

		if ( condition != null ) {
			this.condition = condition;
		}
		index = Integer.parseInt( fieldIndex );
	}

	public EqualFilterStrategy( String condition, int offset, int length ) {

		if ( condition != null ) {
			this.condition = condition;
		}
		this.offset = offset;
		this.length = length;
	}

	@Override
	public boolean check( String in ) {

		String[] vls = ( in + "|;" ).split( TableConstants.VALUE_SPLITER );
		if ( vls.length < index ) {
			return false;
		}
		String value = vls[ index ];
		if ( condition == null && value == null ) {
			return true;
		} else if ( value == null || condition == null ) {
			return false;
		}
		// 部分相等
		if ( this.offset > 0 ) {
			if ( value.length() >= ( offset + length ) ) {
				value = value.substring( offset, offset + length );
			} else {
				return false;
			}
		}
		logger.info( condition + "==" + value );
		return condition.equals( value );
	}
}
