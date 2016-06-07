package bj.bigData.HBase.ex03.query.filter.strategy;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;

public class IpRangeFilterStrategy implements IFilterStrategy, Serializable {

	private static final long    serialVersionUID = 1929684764116713819L;
	private static final Logger  logger           = Logger
			.getLogger( IpRangeFilterStrategy.class );
	private static final String  IP_RANGE_SPLITER = ",";
	private static final Pattern v4pattern        = Pattern.compile( "\\." );
	private static final Pattern v6pattern        = Pattern.compile( ":" );
	private int        index;
	private BigInteger start;
	private BigInteger end;

	public IpRangeFilterStrategy( String fieldIndex, String condition ) {

		if ( condition != null ) {
			String[] conds = condition.split( IP_RANGE_SPLITER );
			if ( conds != null && conds.length == 2 ) {
				this.start = new BigInteger( ipToBytes( conds[ 0 ] ) );
				this.end = new BigInteger( ipToBytes( conds[ 1 ] ) );
				//交换大小
				if ( start.compareTo( end ) > 0 ) {
					BigInteger temp = start;
					start = end;
					end = temp;
				}
			}
		}
		index = Integer.parseInt( fieldIndex );
	}
	
	/**
	 * @param ip
	 * @return
	 */
	private byte[] ipToBytes( String ip ) {

		ip = ip.replaceAll( "\\s", "" );
		byte[] out;
		if ( ip.contains( ":" ) ) {
			out = ipv6Addr2bytes( ip );
		} else {
			out = ipv4Addr2bytes( ip );
		}
		return out;
	}

	/**
	 * ipv4 转换成5位byte
	 * 首位代表符号位    防止出现负数
	 *
	 * @param ip
	 * @return
	 */
	private byte[] ipv4Addr2bytes( String ip ) {

		String[] ips = v4pattern.split( ip, -1 );
		byte[]   out = new byte[ 5 ];
		out[ 0 ] = 0;
		for ( int i = 0; i < 4; i++ ) {
			out[ i + 1 ] = ( byte ) ( Integer.parseInt( ips[ i ] ) & 0xff );
		}
		return out;
	}
	
	/**
	 * ipv6  转换成17位byte
	 * 首位代表符号位    防止出现负数
	 *
	 * @param ip
	 * @return
	 */
	private byte[] ipv6Addr2bytes( String ip ) {

		byte[] out = new byte[ 17 ];
		for ( int i = 0; i < 17; i++ ) {
			out[ i ] = 0;
		}
		int      pos = 16;
		String[] ips = v6pattern.split( ip, -1 );
		for ( int i = ips.length - 1; i >= 0; i-- ) {
			//n:n:n:n:n:n:d.d.d.d   混合形式
			if ( ips[ i ].contains( "." ) ) {
				byte[] temp = ipv4Addr2bytes( ips[ ips.length - 1 ] );
				for ( int j = 4; j > 0; j-- ) {
					out[ pos-- ] = temp[ j ];
				}
			} else if ( "".equals( ips[ i ] ) ) {
				pos -= 2;
			} else {
				int t = Integer.parseInt( ips[ i ], 16 );
				out[ pos-- ] = ( byte ) ( t & 0xff );
				out[ pos-- ] = ( byte ) ( ( t >> 8 ) & 0xff );
			}
		}
		return out;
	}

	@Override
	public boolean check( String in ) {

		String[] vls = in.split( TableConstants.VALUE_SPLITER, -1 );
		if ( vls.length < index ) {
			return false;
		}
		String value = vls[ index ];
		if ( value != null ) {
			BigInteger curVal = new BigInteger( ipToBytes( value ) );
			return true && curVal.compareTo( start ) >= 0 && curVal.compareTo( end ) <= 0;
		}
		return false;
	}
	
	public static void main( String[] args ) {

		IpRangeFilterStrategy s   = new IpRangeFilterStrategy( "1", ":1:1:1:1:1:1:1,1:1:1:1:1:1:1:fff1" );
		boolean               res = s.check( "sdff|:1:1:1:1:f:1:eade" );
		System.out.println( res );
	}
}