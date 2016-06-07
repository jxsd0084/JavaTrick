package bj.hmkcode.itext_java_html_pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.FileInputStream;
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

			// step 2
			PdfWriter writer = PdfWriter.getInstance( document, new FileOutputStream( "index.pdf" ) );

			// step 3
			document.open();

			// step 4
			XMLWorkerHelper.getInstance().parseXHtml( writer, document,
			                                          new FileInputStream( "index.html" ) );
			//step 5
			document.close();

			System.out.println( "PDF Created!" );

		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

}
