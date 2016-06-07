package bj.bigData.HBase.ex03.query.type;

/**
 * 过滤比较方式
 *
 * @author ranhualin
 * @date 2013-7-19
 */
public enum OperatorType {
	
	EQ, LIKE, IPLIKE, DATERANGE, IPRANGE;
	
	public static OperatorType matchType( String type ) {

		if ( type.equalsIgnoreCase( "EQ" ) ) {
			return EQ;
		}
		if ( type.equalsIgnoreCase( "LIKE" ) ) {
			return LIKE;
		}
		if ( type.equalsIgnoreCase( "IPLIKE" ) ) {
			return IPLIKE;
		}
		if ( type.equalsIgnoreCase( "DATERANGE" ) ) {
			return DATERANGE;
		}
		if ( type.equalsIgnoreCase( "IPRANGE" ) ) {
			return IPRANGE;
		}
		return null;
	}

}
