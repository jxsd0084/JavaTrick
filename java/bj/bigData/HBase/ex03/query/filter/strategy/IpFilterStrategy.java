package bj.bigData.HBase.ex03.query.filter.strategy;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import com.boco.DataPlatform.utils.Ipv6Utils;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * IP过滤,支持IP内的*号匹配
 *
 * @author ranhualin
 * @date 2013-7-22
 */
public class IpFilterStrategy implements IFilterStrategy, Serializable {

	private static final long serialVersionUID = -8717136299084349011L;
	private String pattern;
	private int    index;
	
	private boolean ipv6 = false;

	public IpFilterStrategy( String fieldIndex, String condition ) {

		if ( condition.contains( ":" ) ) {
			condition = Ipv6Utils.formatIpv6IP( condition );
			ipv6 = true;
		}
		this.pattern = condition.replaceAll( "\\.", "\\\\." ).replaceAll( "\\*", ".*" ).toUpperCase();
//		System.out.println(pattern);
		index = Integer.parseInt( fieldIndex );
	}

	public boolean check( String in ) {

		if ( in == null ) {
			return false;
		}
		if ( ipv6 && in.contains( ":" ) ) {
			in = Ipv6Utils.formatIpv6IP( in );
		}
		String[] vls = in.split( TableConstants.VALUE_SPLITER, -1 );
		if ( vls.length < index + 1 ) {
			return false;
		}
		return Pattern.matches( pattern, vls[ index ].toUpperCase() );
	}

	public static void main( String[] args ) {

		IpFilterStrategy is = new IpFilterStrategy( "0", "::::0:1:1:1" );
		System.out.println( is.check( ":0:0:::1:1:1" ) );
		System.out.println( is.check( ":2::0::1:2:3" ) );
	}
}
