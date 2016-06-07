package bj.bigData.HBase.ex03.query.filter;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import com.boco.DataPlatform.hbase.query.filter.strategy.*;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理针对于表value的过滤条件
 *
 * @author ranhualin
 * @date 2013-7-23
 */
public class ValueFilter implements Serializable {

	private static final long                                   serialVersionUID = -3034455239598043909L;
	private static final Logger                                 logger           = Logger.getLogger( ValueFilter.class );
	/**
	 * 保存所有的过滤条件，key:column名称，
	 */
	private              Map< String, List< IFilterStrategy > > filters          = new HashMap< String, List< IFilterStrategy > >();
	private              int                                    filtercount      = 0;

	/**
	 * Server端的过滤条件，格式如下 字段位置_比较方式_比较值，如c_1_EQ_60
	 *
	 * @param strfilter
	 */
	public ValueFilter( String in ) {

		String[] strfilters = in.split( TableConstants.FILTERS_MUTIL_SPLITER );
		if ( strfilters != null && strfilters.length > 0 ) {
			for ( String filter : strfilters ) {
				String[] fs = filter.split( TableConstants.FILTER_SPLITER );
				if ( fs.length == 4 ) {
					filtercount++;
					addFilter( fs[ 0 ], fs[ 1 ], fs[ 2 ], fs[ 3 ] );
				}
			}
		}
	}

	public boolean check( byte[] bcolumn, byte[] bvalue ) {

		String column = new String( bcolumn );
		if ( !filters.containsKey( column ) ) {
			// 当没有该字段的过滤时，返回true
			return true;
		} else {
			String value = new String( bvalue );
			for ( IFilterStrategy fs : filters.get( column ) ) {
				if ( !fs.check( value ) ) {
					// 只考虑多条件的AND情况，因此一个条件不满足后，不再比较后面的条件
					return false;
				}
			}
			// 所有条件满足，返回true
			return true;
		}
	}

	public int getFilterCount() {

		return filtercount;
	}

	private void addFilter( String column, String fieldIndex, String matchType,
	                        String value ) {

		IFilterStrategy strategy = null;
		if ( matchType.equalsIgnoreCase( "EQ" ) ) {
			logger.info( "matchType EQ" );
			strategy = new EqualFilterStrategy( fieldIndex, value );
		} else if ( matchType.equalsIgnoreCase( "LIKE" ) ) {
			strategy = new LikeFilterStrategy( fieldIndex, value );
		} else if ( matchType.equalsIgnoreCase( "IPLIKE" ) ) {
			strategy = new IpFilterStrategy( fieldIndex, value );
		} else if ( matchType.equalsIgnoreCase( "DATERANGE" ) ) {
			strategy = new DateRangeFilterStrategy( fieldIndex, value );
		} else if ( matchType.equalsIgnoreCase( "IPRANGE" ) ) {
			strategy = new IpRangeFilterStrategy( fieldIndex, value );
		} else {
			logger.error( "error matchType:" + matchType );
			return;
		}
		if ( !filters.containsKey( column ) ) {
			List< IFilterStrategy > list = new ArrayList< IFilterStrategy >();
			list.add( strategy );
			filters.put( column, list );
		} else {
			filters.get( column ).add( strategy );
		}
	}
}
