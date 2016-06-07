package bj.bigData.HBase.ex03.query.filter.strategy;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;

import java.io.Serializable;


/**
 * like关系匹配
 *
 * @author ranhualin
 * @date 2013-7-22
 */
public class LikeFilterStrategy implements IFilterStrategy, Serializable {

	private static final long serialVersionUID = -8717136299084349011L;
	private String condition;
	private int    index;

	public LikeFilterStrategy( String fieldIndex, String condition ) {

		this.condition = condition;
		index = Integer.parseInt( fieldIndex );
	}

	public boolean check( String in ) {

		if ( in == null ) {
			return false;
		}
		String[] vls = ( in + "|;" ).split( TableConstants.VALUE_SPLITER );
		if ( vls.length < index ) {
			return false;
		}
		return vls[ index ].indexOf( condition ) != -1;
	}
}
