/**
 * Autogenerated by Thrift Compiler (0.9.0)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package bj.bigData.HBase.ex03.query.thrift;

public enum MatchType implements org.apache.thrift.TEnum {
	EQUAL( 1 ),
	LIKE( 2 ),
	IPREGEX( 3 ),
	IPRANGE( 4 );

	private final int value;

	private MatchType( int value ) {

		this.value = value;
	}

	/**
	 * Get the integer value of this enum value, as defined in the Thrift IDL.
	 */
	public int getValue() {

		return value;
	}

	/**
	 * Find a the enum type by its integer value, as defined in the Thrift IDL.
	 * @return null if the value is not found.
	 */
	public static MatchType findByValue( int value ) {

		switch ( value ) {
			case 1:
				return EQUAL;
			case 2:
				return LIKE;
			case 3:
				return IPREGEX;
			case 4:
				return IPRANGE;
			default:
				return null;
		}
	}
}