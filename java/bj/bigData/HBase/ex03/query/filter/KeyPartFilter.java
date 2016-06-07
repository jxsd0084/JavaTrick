package bj.bigData.HBase.ex03.query.filter;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import com.boco.DataPlatform.hbase.query.filter.strategy.DateRangeFilterStrategy;
import com.boco.DataPlatform.hbase.query.filter.strategy.EqualFilterStrategy;
import com.boco.DataPlatform.hbase.query.filter.strategy.IFilterStrategy;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理针对于表key的一部分进行过滤 只支持等于比较或者区间比较
 *
 * @author ranhualin
 * @date 2013-7-23
 */
public class KeyPartFilter implements Serializable {

	private static final long                    serialVersionUID = 2618902251980372884L;
	private static final Logger                  logger           = Logger.getLogger( KeyPartFilter.class );
	/**
	 * 保存所有的过滤条件，key:column名称，
	 */
	private              List< IFilterStrategy > filters          = new ArrayList< IFilterStrategy >();
	private              int                     filtercount      = 0;

	/**
	 * Server端的过滤条件，格式如下 开始比较位置_比较位数_比较值，
	 * 如9_5_EQ_33333，表示比较key的从第9位（从0开始）起的后5位等于33333
	 *
	 * @param strfilter
	 */
	public KeyPartFilter( String in ) {

		String[] strfilters = in
				.split( TableConstants.FILTERS_MUTIL_SPLITER );
		if ( strfilters != null && strfilters.length > 0 ) {
			for ( String filter : strfilters ) {
				String[] fs = filter.split( TableConstants.FILTER_SPLITER );
				if ( fs.length == 4 ) {
					filtercount++;
					try {
						addFilter( fs[ 0 ], fs[ 1 ], fs[ 2 ], fs[ 3 ] );
					} catch ( Exception e ) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public boolean check( byte[] bvalue ) {

		if ( bvalue == null ) {
			return false;
		} else {
			String value = new String( bvalue );
			for ( IFilterStrategy fs : filters ) {
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

	private void addFilter( String offset, String length, String matchType,
	                        String value ) throws Exception {

		IFilterStrategy strategy = null;
		if ( matchType.equalsIgnoreCase( "EQ" ) ) {
			strategy = new EqualFilterStrategy( value, Integer.parseInt( offset ),
					Integer.parseInt( length ) );
		} else if ( matchType.equalsIgnoreCase( "DATERANGE" ) ) {
			strategy = new DateRangeFilterStrategy( value,
					Integer.parseInt( offset ) );
		} else {
			logger.error( "error matchType:" + matchType );
			return;
		}
		filtercount++;
		filters.add( strategy );
	}
}
