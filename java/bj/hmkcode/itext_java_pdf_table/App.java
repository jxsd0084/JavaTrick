package bj.hmkcode.itext_java_pdf_table;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/6/1.
 */
public class App {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		try {

			// step 1
			Document document = new Document();
			document.setPageSize( PageSize.A4 );

			// step 2
			PdfWriter.getInstance( document, new FileOutputStream( "table.pdf" ) );

			// step 3
			document.open();

			// step 4 create PDF contents
			document.add( TableBuilder.createTable() );

			//step 5
			document.close();

			System.out.println( "PDF Created!" );

		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

}
