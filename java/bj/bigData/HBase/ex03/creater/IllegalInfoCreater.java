package bj.bigData.HBase.ex03.creater;

import java.text.ParseException;

public class IllegalInfoCreater extends BaseCreater {

	@Override
	public void initTableInfo( PropertiesInfo info ) {

		String family           = prop.getProperty( "table.family" );
		String compression      = prop.getProperty( "table.compression" );
		String tableDescriptor  = prop.getProperty( "table.descriptor" );
		String coprocessorPath  = prop.getProperty( "table.coprocessor.path" );
		String coprocessorClass = prop.getProperty( "table.coprocessor.class" );
		
		info.setFamliy( family );
		info.setCompression( compression );
		info.setTableDescriptor( tableDescriptor );
		info.setCoprocessorPath( coprocessorPath );
		info.setCoprocessorClass( coprocessorClass );
	}

	@Override
	public byte[][] buildRegionRange( String tableName ) {

		int      sprangsize = Integer.parseInt( prop.getProperty( "table.illegalinfo.region.size" ) );
		int      keylength  = Integer.parseInt( prop.getProperty( "table.illegalinfo.key.length" ) );
		int      offset     = 999999 / sprangsize;
		int      base       = offset;
		byte[][] splitrange = new byte[ sprangsize - 1 ][];
		for ( int i = 0; i < splitrange.length; i++ ) {
			splitrange[ i ] = formatKey( base, keylength, 6 );
			base = base + offset;
		}
		return splitrange;
	}

	public String getTable( String date ) throws ParseException {

		String table = prop.getProperty( "table.illegalinfo.name" );
		return table.replace( "$ENDS$", date );
	}
}
