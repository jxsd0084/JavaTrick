package bj.hmkcode.java_excel_poi;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/1.
 */
public class AppWrite {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 1. Create a new Workbook
		Workbook wb = new XSSFWorkbook();

		// 2. Create a new sheet
		Sheet sheet = wb.createSheet( "sheet 1" );

		// 3. Create a row
		Row row = sheet.createRow( (short) 0 );

		// 4. Create cells

		// 4.1 number cell
		row.createCell( 0 ).setCellValue( 1 );
		// 4.2 text
		row.createCell( 1 ).setCellValue( "Text" );

		// 4.3 date cell
		CreationHelper createHelper = wb.getCreationHelper();
		CellStyle      cellStyle    = wb.createCellStyle();
		cellStyle.setDataFormat( createHelper.createDataFormat().getFormat( "m/d/yy h:mm" ) );
		Cell cell = row.createCell( 2 );
		cell.setCellValue( new Date() );
		cell.setCellStyle( cellStyle );

		// 4.4 boolean cell
		row.createCell( 3 ).setCellValue( true );

		// 5. create excel file
		FileOutputStream fileOut;
		try {

			fileOut = new FileOutputStream( "workbook.xlsx" );
			wb.write( fileOut );
			fileOut.close();

		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}

		System.out.println( "File created!" );

	}

}
