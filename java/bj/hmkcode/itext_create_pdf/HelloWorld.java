package bj.hmkcode.itext_create_pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/6/1.
 */
public class HelloWorld {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		// 1. create the document
		Document document = new Document();

		try {

			// 2. get PdWriter
			PdfWriter.getInstance( document, new FileOutputStream( "helloworld.pdf" ) );

			// 3. open the document
			document.open();

			// 4. add the content
			document.add( new Paragraph( "Hello World!" ) );

			// 5. close the document
			document.close();

			System.out.println( " Document created! " );

		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

}
