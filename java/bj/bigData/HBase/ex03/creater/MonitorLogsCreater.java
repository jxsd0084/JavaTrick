package bj.bigData.HBase.ex03.creater;

import com.boco.DataPlatform.hbase.common.utils.ByteUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MonitorLogsCreater extends BaseCreater {

	private SimpleDateFormat format = new SimpleDateFormat( "yyyyMMddHHmmss" );

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

		int      sprangsize = Integer.parseInt( prop.getProperty( "table.monitorlogs.region.size" ) );
		int      keylength  = Integer.parseInt( prop.getProperty( "table.monitorlogs.key.length" ) );
		int      offset     = 999999 / sprangsize;
		int      base       = offset;
		byte[][] splitrange = new byte[ sprangsize - 1 ][];
		for ( int i = 0; i < splitrange.length; i++ ) {
			splitrange[ i ] = formatKey( base, keylength, 6 );
			base = base + offset;
		}
		return splitrange;
	}

	//	@Override
//	public byte[][] buildRegionRange(String tableName) {
//		int sprangsize = Integer.parseInt(prop.getProperty("table.monitorlogs.region.size"));
//		int keylength = Integer.parseInt(prop.getProperty("table.monitorlogs.key.length"));	
//		
//		String lineDay = getDayFromTable(tableName);
//		long startline = 0;
//		try {
//			startline = format.parse(lineDay+"000000").getTime();
//		} catch (ParseException e) {
//		
//			e.printStackTrace();
//		}
//				
//		//1天的毫秒数
//		long offset = (24*60*60*1000)/sprangsize;
//		long base = startline + offset;
//		byte[][] splitrange = new byte[sprangsize - 1][];	 
//		for (int i = 0; i < splitrange.length; i++) {
//			splitrange[i] = formatFKey(base,keylength);
//			base = base + offset;
//		}	
//		return splitrange;
//	}
	public String getTable( String date ) throws ParseException {

		String table = prop.getProperty( "table.monitorlogs.name" );
		return table.replace( "$ENDS$", date );
	}

	private byte[] formatFKey( long time, int keylength ) {

		byte[] key    = ByteUtils.createArray( keylength, ( byte ) '0' );
		byte[] perfix = format.format( new Date( time ) ).getBytes();
		System.arraycopy( perfix, 0, key, 0, 14 );
		return key;
	}

	private String getDayFromTable( String tableName ) {
		//表为天表，名称为XXXX_20130726
		String lineDay = tableName.substring( tableName.length() - 8, tableName.length() );
		return lineDay;
	}
}
