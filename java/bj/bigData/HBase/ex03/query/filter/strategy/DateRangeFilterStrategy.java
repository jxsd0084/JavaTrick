package bj.bigData.HBase.ex03.query.filter.strategy;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * 时间范围关系匹配
 *
 * @author ranhualin
 * @date 2013-7-22
 */
public class DateRangeFilterStrategy implements IFilterStrategy, Serializable {

	private static final   long   serialVersionUID   = 1929684764116713716L;
	protected static final Logger logger             = Logger.getLogger( EqualFilterStrategy.class );
	private static final   String DATE_RANGE_SPLITER = ",";
	// 数据长度,时间格式必须是yyyyMMddHHmmss的14位
	private static final   int    datelength         = 14;
	private byte[] bstart;
	private byte[] bend;
	private byte[] bvalue;
	private int offset = 0;
	private int index;

	/**
	 * 时间格式必须是yyyyMMddHHmmss的14位 开始和结束条件
	 *
	 * @param start
	 * @param end
	 */
	public DateRangeFilterStrategy( String fieldIndex, String condition ) {

		if ( condition != null ) {
			String[] conds = ( condition + DATE_RANGE_SPLITER + " " )
					.split( DATE_RANGE_SPLITER );
			if ( conds != null && conds.length >= 2 ) {
				if ( conds[ 0 ] != null && conds[ 0 ].length() == datelength ) {
					this.bstart = conds[ 0 ].getBytes();
				}
				if ( conds[ 1 ] != null && conds[ 1 ].length() == datelength ) {
					this.bend = conds[ 1 ].getBytes();
				}
			}
		}
		index = Integer.parseInt( fieldIndex );
	}

	public DateRangeFilterStrategy( String condition, int offset ) {

		String[] conds = condition.split( DATE_RANGE_SPLITER );
		if ( conds != null && conds.length == 2 ) {
			if ( conds[ 0 ] != null && conds[ 0 ].length() == datelength ) {
				this.bstart = conds[ 0 ].getBytes();
			}
			if ( conds[ 1 ] != null && conds[ 1 ].length() == datelength ) {
				this.bend = conds[ 1 ].getBytes();
			}
		}
		this.offset = offset;
	}

	@Override
	public boolean check( String in ) {

		String[] vls = ( in + "|;" ).split( TableConstants.VALUE_SPLITER );
		if ( vls.length < index ) {
			return false;
		}
		String value = vls[ index ];
		if ( value != null && value.length() >= ( offset + datelength ) ) {
			if ( this.offset > 0 ) {
				value = value.substring( offset, offset + datelength );
			}
//			logger.info(new String(bstart)+"<"+value+"<"+new String(bend));
			boolean ok = true;
			
			
			this.bvalue = value.getBytes();
			if ( bstart != null ) {
				ok = ok
				     && Bytes.compareTo( bvalue, 0, datelength, bstart, 0,
						datelength ) >= 0;
			}
			if ( bend != null ) {
				ok = ok
				     && Bytes.compareTo( bvalue, 0, datelength, bend, 0,
						datelength ) <= 0;
			}
			return ok;
		} else {
			return false;
		}
	}
}
