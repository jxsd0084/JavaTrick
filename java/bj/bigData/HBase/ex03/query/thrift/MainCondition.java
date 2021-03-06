/**
 * Autogenerated by Thrift Compiler (0.9.0)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package bj.bigData.HBase.ex03.query.thrift;

import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import java.util.*;

public class MainCondition implements org.apache.thrift.TBase< MainCondition, MainCondition._Fields >, java.io.Serializable, Cloneable {

	private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct( "MainCondition" );

	private static final org.apache.thrift.protocol.TField STARTTIME_FIELD_DESC  = new org.apache.thrift.protocol.TField( "starttime", org.apache.thrift.protocol.TType.STRING, ( short ) 1 );
	private static final org.apache.thrift.protocol.TField ENDTIME_FIELD_DESC    = new org.apache.thrift.protocol.TField( "endtime", org.apache.thrift.protocol.TType.STRING, ( short ) 2 );
	private static final org.apache.thrift.protocol.TField FILTERS_FIELD_DESC    = new org.apache.thrift.protocol.TField( "filters", org.apache.thrift.protocol.TType.LIST, ( short ) 3 );
	private static final org.apache.thrift.protocol.TField ATTRIBUTES_FIELD_DESC = new org.apache.thrift.protocol.TField( "attributes", org.apache.thrift.protocol.TType.MAP, ( short ) 4 );

	private static final Map< Class< ? extends IScheme >, SchemeFactory > schemes = new HashMap< Class< ? extends IScheme >, SchemeFactory >();

	static {
		schemes.put( StandardScheme.class, new MainConditionStandardSchemeFactory() );
		schemes.put( TupleScheme.class, new MainConditionTupleSchemeFactory() );
	}

	public String                starttime; // required
	public String                endtime; // required
	public List< Filter >        filters; // required
	public Map< String, String > attributes; // required

	/** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
	public enum _Fields implements org.apache.thrift.TFieldIdEnum {
		STARTTIME( ( short ) 1, "starttime" ),
		ENDTIME( ( short ) 2, "endtime" ),
		FILTERS( ( short ) 3, "filters" ),
		ATTRIBUTES( ( short ) 4, "attributes" );

		private static final Map< String, _Fields > byName = new HashMap< String, _Fields >();

		static {
			for ( _Fields field : EnumSet.allOf( _Fields.class ) ) {
				byName.put( field.getFieldName(), field );
			}
		}

		/**
		 * Find the _Fields constant that matches fieldId, or null if its not found.
		 */
		public static _Fields findByThriftId( int fieldId ) {

			switch ( fieldId ) {
				case 1: // STARTTIME
					return STARTTIME;
				case 2: // ENDTIME
					return ENDTIME;
				case 3: // FILTERS
					return FILTERS;
				case 4: // ATTRIBUTES
					return ATTRIBUTES;
				default:
					return null;
			}
		}

		/**
		 * Find the _Fields constant that matches fieldId, throwing an exception
		 * if it is not found.
		 */
		public static _Fields findByThriftIdOrThrow( int fieldId ) {

			_Fields fields = findByThriftId( fieldId );
			if ( fields == null ) {
				throw new IllegalArgumentException( "Field " + fieldId + " doesn't exist!" );
			}
			return fields;
		}

		/**
		 * Find the _Fields constant that matches name, or null if its not found.
		 */
		public static _Fields findByName( String name ) {

			return byName.get( name );
		}

		private final short  _thriftId;
		private final String _fieldName;

		_Fields( short thriftId, String fieldName ) {

			_thriftId = thriftId;
			_fieldName = fieldName;
		}

		public short getThriftFieldId() {

			return _thriftId;
		}

		public String getFieldName() {

			return _fieldName;
		}
	}

	// isset id assignments
	public static final Map< _Fields, org.apache.thrift.meta_data.FieldMetaData > metaDataMap;

	static {
		Map< _Fields, org.apache.thrift.meta_data.FieldMetaData > tmpMap = new EnumMap< _Fields, org.apache.thrift.meta_data.FieldMetaData >( _Fields.class );
		tmpMap.put( _Fields.STARTTIME, new org.apache.thrift.meta_data.FieldMetaData( "starttime", org.apache.thrift.TFieldRequirementType.DEFAULT,
				new org.apache.thrift.meta_data.FieldValueMetaData( org.apache.thrift.protocol.TType.STRING ) ) );
		tmpMap.put( _Fields.ENDTIME, new org.apache.thrift.meta_data.FieldMetaData( "endtime", org.apache.thrift.TFieldRequirementType.DEFAULT,
				new org.apache.thrift.meta_data.FieldValueMetaData( org.apache.thrift.protocol.TType.STRING ) ) );
		tmpMap.put( _Fields.FILTERS, new org.apache.thrift.meta_data.FieldMetaData( "filters", org.apache.thrift.TFieldRequirementType.DEFAULT,
				new org.apache.thrift.meta_data.ListMetaData( org.apache.thrift.protocol.TType.LIST,
						new org.apache.thrift.meta_data.StructMetaData( org.apache.thrift.protocol.TType.STRUCT, Filter.class ) ) ) );
		tmpMap.put( _Fields.ATTRIBUTES, new org.apache.thrift.meta_data.FieldMetaData( "attributes", org.apache.thrift.TFieldRequirementType.DEFAULT,
				new org.apache.thrift.meta_data.MapMetaData( org.apache.thrift.protocol.TType.MAP,
						new org.apache.thrift.meta_data.FieldValueMetaData( org.apache.thrift.protocol.TType.STRING ),
						new org.apache.thrift.meta_data.FieldValueMetaData( org.apache.thrift.protocol.TType.STRING ) ) ) );
		metaDataMap = Collections.unmodifiableMap( tmpMap );
		org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap( MainCondition.class, metaDataMap );
	}

	public MainCondition() {

	}

	public MainCondition(
			String starttime,
			String endtime,
			List< Filter > filters,
			Map< String, String > attributes ) {

		this();
		this.starttime = starttime;
		this.endtime = endtime;
		this.filters = filters;
		this.attributes = attributes;
	}

	/**
	 * Performs a deep copy on <i>other</i>.
	 */
	public MainCondition( MainCondition other ) {

		if ( other.isSetStarttime() ) {
			this.starttime = other.starttime;
		}
		if ( other.isSetEndtime() ) {
			this.endtime = other.endtime;
		}
		if ( other.isSetFilters() ) {
			List< Filter > __this__filters = new ArrayList< Filter >();
			for ( Filter other_element : other.filters ) {
				__this__filters.add( new Filter( other_element ) );
			}
			this.filters = __this__filters;
		}
		if ( other.isSetAttributes() ) {
			Map< String, String > __this__attributes = new HashMap< String, String >();
			for ( Map.Entry< String, String > other_element : other.attributes.entrySet() ) {

				String other_element_key   = other_element.getKey();
				String other_element_value = other_element.getValue();

				String __this__attributes_copy_key = other_element_key;

				String __this__attributes_copy_value = other_element_value;

				__this__attributes.put( __this__attributes_copy_key, __this__attributes_copy_value );
			}
			this.attributes = __this__attributes;
		}
	}

	public MainCondition deepCopy() {

		return new MainCondition( this );
	}

	@Override
	public void clear() {

		this.starttime = null;
		this.endtime = null;
		this.filters = null;
		this.attributes = null;
	}

	public String getStarttime() {

		return this.starttime;
	}

	public MainCondition setStarttime( String starttime ) {

		this.starttime = starttime;
		return this;
	}

	public void unsetStarttime() {

		this.starttime = null;
	}

	/** Returns true if field starttime is set (has been assigned a value) and false otherwise */
	public boolean isSetStarttime() {

		return this.starttime != null;
	}

	public void setStarttimeIsSet( boolean value ) {

		if ( !value ) {
			this.starttime = null;
		}
	}

	public String getEndtime() {

		return this.endtime;
	}

	public MainCondition setEndtime( String endtime ) {

		this.endtime = endtime;
		return this;
	}

	public void unsetEndtime() {

		this.endtime = null;
	}

	/** Returns true if field endtime is set (has been assigned a value) and false otherwise */
	public boolean isSetEndtime() {

		return this.endtime != null;
	}

	public void setEndtimeIsSet( boolean value ) {

		if ( !value ) {
			this.endtime = null;
		}
	}

	public int getFiltersSize() {

		return ( this.filters == null ) ? 0 : this.filters.size();
	}

	public java.util.Iterator< Filter > getFiltersIterator() {

		return ( this.filters == null ) ? null : this.filters.iterator();
	}

	public void addToFilters( Filter elem ) {

		if ( this.filters == null ) {
			this.filters = new ArrayList< Filter >();
		}
		this.filters.add( elem );
	}

	public List< Filter > getFilters() {

		return this.filters;
	}

	public MainCondition setFilters( List< Filter > filters ) {

		this.filters = filters;
		return this;
	}

	public void unsetFilters() {

		this.filters = null;
	}

	/** Returns true if field filters is set (has been assigned a value) and false otherwise */
	public boolean isSetFilters() {

		return this.filters != null;
	}

	public void setFiltersIsSet( boolean value ) {

		if ( !value ) {
			this.filters = null;
		}
	}

	public int getAttributesSize() {

		return ( this.attributes == null ) ? 0 : this.attributes.size();
	}

	public void putToAttributes( String key, String val ) {

		if ( this.attributes == null ) {
			this.attributes = new HashMap< String, String >();
		}
		this.attributes.put( key, val );
	}

	public Map< String, String > getAttributes() {

		return this.attributes;
	}

	public MainCondition setAttributes( Map< String, String > attributes ) {

		this.attributes = attributes;
		return this;
	}

	public void unsetAttributes() {

		this.attributes = null;
	}

	/** Returns true if field attributes is set (has been assigned a value) and false otherwise */
	public boolean isSetAttributes() {

		return this.attributes != null;
	}

	public void setAttributesIsSet( boolean value ) {

		if ( !value ) {
			this.attributes = null;
		}
	}

	public void setFieldValue( _Fields field, Object value ) {

		switch ( field ) {
			case STARTTIME:
				if ( value == null ) {
					unsetStarttime();
				} else {
					setStarttime( ( String ) value );
				}
				break;

			case ENDTIME:
				if ( value == null ) {
					unsetEndtime();
				} else {
					setEndtime( ( String ) value );
				}
				break;

			case FILTERS:
				if ( value == null ) {
					unsetFilters();
				} else {
					setFilters( ( List< Filter > ) value );
				}
				break;

			case ATTRIBUTES:
				if ( value == null ) {
					unsetAttributes();
				} else {
					setAttributes( ( Map< String, String > ) value );
				}
				break;

		}
	}

	public Object getFieldValue( _Fields field ) {

		switch ( field ) {
			case STARTTIME:
				return getStarttime();

			case ENDTIME:
				return getEndtime();

			case FILTERS:
				return getFilters();

			case ATTRIBUTES:
				return getAttributes();

		}
		throw new IllegalStateException();
	}

	/** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
	public boolean isSet( _Fields field ) {

		if ( field == null ) {
			throw new IllegalArgumentException();
		}

		switch ( field ) {
			case STARTTIME:
				return isSetStarttime();
			case ENDTIME:
				return isSetEndtime();
			case FILTERS:
				return isSetFilters();
			case ATTRIBUTES:
				return isSetAttributes();
		}
		throw new IllegalStateException();
	}

	@Override
	public boolean equals( Object that ) {

		if ( that == null ) {
			return false;
		}
		if ( that instanceof MainCondition ) {
			return this.equals( ( MainCondition ) that );
		}
		return false;
	}

	public boolean equals( MainCondition that ) {

		if ( that == null ) {
			return false;
		}

		boolean this_present_starttime = true && this.isSetStarttime();
		boolean that_present_starttime = true && that.isSetStarttime();
		if ( this_present_starttime || that_present_starttime ) {
			if ( !( this_present_starttime && that_present_starttime ) ) {
				return false;
			}
			if ( !this.starttime.equals( that.starttime ) ) {
				return false;
			}
		}

		boolean this_present_endtime = true && this.isSetEndtime();
		boolean that_present_endtime = true && that.isSetEndtime();
		if ( this_present_endtime || that_present_endtime ) {
			if ( !( this_present_endtime && that_present_endtime ) ) {
				return false;
			}
			if ( !this.endtime.equals( that.endtime ) ) {
				return false;
			}
		}

		boolean this_present_filters = true && this.isSetFilters();
		boolean that_present_filters = true && that.isSetFilters();
		if ( this_present_filters || that_present_filters ) {
			if ( !( this_present_filters && that_present_filters ) ) {
				return false;
			}
			if ( !this.filters.equals( that.filters ) ) {
				return false;
			}
		}

		boolean this_present_attributes = true && this.isSetAttributes();
		boolean that_present_attributes = true && that.isSetAttributes();
		if ( this_present_attributes || that_present_attributes ) {
			if ( !( this_present_attributes && that_present_attributes ) ) {
				return false;
			}
			if ( !this.attributes.equals( that.attributes ) ) {
				return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode() {

		return 0;
	}

	public int compareTo( MainCondition other ) {

		if ( !getClass().equals( other.getClass() ) ) {
			return getClass().getName().compareTo( other.getClass().getName() );
		}

		int           lastComparison = 0;
		MainCondition typedOther     = ( MainCondition ) other;

		lastComparison = Boolean.valueOf( isSetStarttime() ).compareTo( typedOther.isSetStarttime() );
		if ( lastComparison != 0 ) {
			return lastComparison;
		}
		if ( isSetStarttime() ) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo( this.starttime, typedOther.starttime );
			if ( lastComparison != 0 ) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.valueOf( isSetEndtime() ).compareTo( typedOther.isSetEndtime() );
		if ( lastComparison != 0 ) {
			return lastComparison;
		}
		if ( isSetEndtime() ) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo( this.endtime, typedOther.endtime );
			if ( lastComparison != 0 ) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.valueOf( isSetFilters() ).compareTo( typedOther.isSetFilters() );
		if ( lastComparison != 0 ) {
			return lastComparison;
		}
		if ( isSetFilters() ) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo( this.filters, typedOther.filters );
			if ( lastComparison != 0 ) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.valueOf( isSetAttributes() ).compareTo( typedOther.isSetAttributes() );
		if ( lastComparison != 0 ) {
			return lastComparison;
		}
		if ( isSetAttributes() ) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo( this.attributes, typedOther.attributes );
			if ( lastComparison != 0 ) {
				return lastComparison;
			}
		}
		return 0;
	}

	public _Fields fieldForId( int fieldId ) {

		return _Fields.findByThriftId( fieldId );
	}

	public void read( org.apache.thrift.protocol.TProtocol iprot ) throws org.apache.thrift.TException {

		schemes.get( iprot.getScheme() ).getScheme().read( iprot, this );
	}

	public void write( org.apache.thrift.protocol.TProtocol oprot ) throws org.apache.thrift.TException {

		schemes.get( oprot.getScheme() ).getScheme().write( oprot, this );
	}

	@Override
	public String toString() {

		StringBuilder sb    = new StringBuilder( "MainCondition(" );
		boolean       first = true;

		sb.append( "starttime:" );
		if ( this.starttime == null ) {
			sb.append( "null" );
		} else {
			sb.append( this.starttime );
		}
		first = false;
		if ( !first ) {
			sb.append( ", " );
		}
		sb.append( "endtime:" );
		if ( this.endtime == null ) {
			sb.append( "null" );
		} else {
			sb.append( this.endtime );
		}
		first = false;
		if ( !first ) {
			sb.append( ", " );
		}
		sb.append( "filters:" );
		if ( this.filters == null ) {
			sb.append( "null" );
		} else {
			sb.append( this.filters );
		}
		first = false;
		if ( !first ) {
			sb.append( ", " );
		}
		sb.append( "attributes:" );
		if ( this.attributes == null ) {
			sb.append( "null" );
		} else {
			sb.append( this.attributes );
		}
		first = false;
		sb.append( ")" );
		return sb.toString();
	}

	public void validate() throws org.apache.thrift.TException {
		// check for required fields
		// check for sub-struct validity
	}

	private void writeObject( java.io.ObjectOutputStream out ) throws java.io.IOException {

		try {
			write( new org.apache.thrift.protocol.TCompactProtocol( new org.apache.thrift.transport.TIOStreamTransport( out ) ) );
		} catch ( org.apache.thrift.TException te ) {
			throw new java.io.IOException( te );
		}
	}

	private void readObject( java.io.ObjectInputStream in ) throws java.io.IOException, ClassNotFoundException {

		try {
			read( new org.apache.thrift.protocol.TCompactProtocol( new org.apache.thrift.transport.TIOStreamTransport( in ) ) );
		} catch ( org.apache.thrift.TException te ) {
			throw new java.io.IOException( te );
		}
	}

	private static class MainConditionStandardSchemeFactory implements SchemeFactory {

		public MainConditionStandardScheme getScheme() {

			return new MainConditionStandardScheme();
		}
	}

	private static class MainConditionStandardScheme extends StandardScheme< MainCondition > {

		public void read( org.apache.thrift.protocol.TProtocol iprot, MainCondition struct ) throws org.apache.thrift.TException {

			org.apache.thrift.protocol.TField schemeField;
			iprot.readStructBegin();
			while ( true ) {
				schemeField = iprot.readFieldBegin();
				if ( schemeField.type == org.apache.thrift.protocol.TType.STOP ) {
					break;
				}
				switch ( schemeField.id ) {
					case 1: // STARTTIME
						if ( schemeField.type == org.apache.thrift.protocol.TType.STRING ) {
							struct.starttime = iprot.readString();
							struct.setStarttimeIsSet( true );
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip( iprot, schemeField.type );
						}
						break;
					case 2: // ENDTIME
						if ( schemeField.type == org.apache.thrift.protocol.TType.STRING ) {
							struct.endtime = iprot.readString();
							struct.setEndtimeIsSet( true );
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip( iprot, schemeField.type );
						}
						break;
					case 3: // FILTERS
						if ( schemeField.type == org.apache.thrift.protocol.TType.LIST ) {
							{
								org.apache.thrift.protocol.TList _list34 = iprot.readListBegin();
								struct.filters = new ArrayList< Filter >( _list34.size );
								for ( int _i35 = 0; _i35 < _list34.size; ++_i35 ) {
									Filter _elem36; // required
									_elem36 = new Filter();
									_elem36.read( iprot );
									struct.filters.add( _elem36 );
								}
								iprot.readListEnd();
							}
							struct.setFiltersIsSet( true );
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip( iprot, schemeField.type );
						}
						break;
					case 4: // ATTRIBUTES
						if ( schemeField.type == org.apache.thrift.protocol.TType.MAP ) {
							{
								org.apache.thrift.protocol.TMap _map37 = iprot.readMapBegin();
								struct.attributes = new HashMap< String, String >( 2 * _map37.size );
								for ( int _i38 = 0; _i38 < _map37.size; ++_i38 ) {
									String _key39; // required
									String _val40; // required
									_key39 = iprot.readString();
									_val40 = iprot.readString();
									struct.attributes.put( _key39, _val40 );
								}
								iprot.readMapEnd();
							}
							struct.setAttributesIsSet( true );
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip( iprot, schemeField.type );
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip( iprot, schemeField.type );
				}
				iprot.readFieldEnd();
			}
			iprot.readStructEnd();

			// check for required fields of primitive type, which can't be checked in the validate method
			struct.validate();
		}

		public void write( org.apache.thrift.protocol.TProtocol oprot, MainCondition struct ) throws org.apache.thrift.TException {

			struct.validate();

			oprot.writeStructBegin( STRUCT_DESC );
			if ( struct.starttime != null ) {
				oprot.writeFieldBegin( STARTTIME_FIELD_DESC );
				oprot.writeString( struct.starttime );
				oprot.writeFieldEnd();
			}
			if ( struct.endtime != null ) {
				oprot.writeFieldBegin( ENDTIME_FIELD_DESC );
				oprot.writeString( struct.endtime );
				oprot.writeFieldEnd();
			}
			if ( struct.filters != null ) {
				oprot.writeFieldBegin( FILTERS_FIELD_DESC );
				{
					oprot.writeListBegin( new org.apache.thrift.protocol.TList( org.apache.thrift.protocol.TType.STRUCT, struct.filters.size() ) );
					for ( Filter _iter41 : struct.filters ) {
						_iter41.write( oprot );
					}
					oprot.writeListEnd();
				}
				oprot.writeFieldEnd();
			}
			if ( struct.attributes != null ) {
				oprot.writeFieldBegin( ATTRIBUTES_FIELD_DESC );
				{
					oprot.writeMapBegin( new org.apache.thrift.protocol.TMap( org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.attributes.size() ) );
					for ( Map.Entry< String, String > _iter42 : struct.attributes.entrySet() ) {
						oprot.writeString( _iter42.getKey() );
						oprot.writeString( _iter42.getValue() );
					}
					oprot.writeMapEnd();
				}
				oprot.writeFieldEnd();
			}
			oprot.writeFieldStop();
			oprot.writeStructEnd();
		}

	}

	private static class MainConditionTupleSchemeFactory implements SchemeFactory {

		public MainConditionTupleScheme getScheme() {

			return new MainConditionTupleScheme();
		}
	}

	private static class MainConditionTupleScheme extends TupleScheme< MainCondition > {

		@Override
		public void write( org.apache.thrift.protocol.TProtocol prot, MainCondition struct ) throws org.apache.thrift.TException {

			TTupleProtocol oprot     = ( TTupleProtocol ) prot;
			BitSet         optionals = new BitSet();
			if ( struct.isSetStarttime() ) {
				optionals.set( 0 );
			}
			if ( struct.isSetEndtime() ) {
				optionals.set( 1 );
			}
			if ( struct.isSetFilters() ) {
				optionals.set( 2 );
			}
			if ( struct.isSetAttributes() ) {
				optionals.set( 3 );
			}
			oprot.writeBitSet( optionals, 4 );
			if ( struct.isSetStarttime() ) {
				oprot.writeString( struct.starttime );
			}
			if ( struct.isSetEndtime() ) {
				oprot.writeString( struct.endtime );
			}
			if ( struct.isSetFilters() ) {
				{
					oprot.writeI32( struct.filters.size() );
					for ( Filter _iter43 : struct.filters ) {
						_iter43.write( oprot );
					}
				}
			}
			if ( struct.isSetAttributes() ) {
				{
					oprot.writeI32( struct.attributes.size() );
					for ( Map.Entry< String, String > _iter44 : struct.attributes.entrySet() ) {
						oprot.writeString( _iter44.getKey() );
						oprot.writeString( _iter44.getValue() );
					}
				}
			}
		}

		@Override
		public void read( org.apache.thrift.protocol.TProtocol prot, MainCondition struct ) throws org.apache.thrift.TException {

			TTupleProtocol iprot    = ( TTupleProtocol ) prot;
			BitSet         incoming = iprot.readBitSet( 4 );
			if ( incoming.get( 0 ) ) {
				struct.starttime = iprot.readString();
				struct.setStarttimeIsSet( true );
			}
			if ( incoming.get( 1 ) ) {
				struct.endtime = iprot.readString();
				struct.setEndtimeIsSet( true );
			}
			if ( incoming.get( 2 ) ) {
				{
					org.apache.thrift.protocol.TList _list45 = new org.apache.thrift.protocol.TList( org.apache.thrift.protocol.TType.STRUCT, iprot.readI32() );
					struct.filters = new ArrayList< Filter >( _list45.size );
					for ( int _i46 = 0; _i46 < _list45.size; ++_i46 ) {
						Filter _elem47; // required
						_elem47 = new Filter();
						_elem47.read( iprot );
						struct.filters.add( _elem47 );
					}
				}
				struct.setFiltersIsSet( true );
			}
			if ( incoming.get( 3 ) ) {
				{
					org.apache.thrift.protocol.TMap _map48 = new org.apache.thrift.protocol.TMap( org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32() );
					struct.attributes = new HashMap< String, String >( 2 * _map48.size );
					for ( int _i49 = 0; _i49 < _map48.size; ++_i49 ) {
						String _key50; // required
						String _val51; // required
						_key50 = iprot.readString();
						_val51 = iprot.readString();
						struct.attributes.put( _key50, _val51 );
					}
				}
				struct.setAttributesIsSet( true );
			}
		}
	}

}

