package bj.Java1200.col01.ch20_操作办公文档.ch20_3_操作PDF._490;

import com.sun.pdfview.FullScreenWindow;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FullScreenFrame extends JFrame {

	private static final long serialVersionUID = - 5506015730370161973L;

	private JPanel  contentPane;
	private JPanel  pdfPanel;
	private PDFPage pdfPage;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		try {
			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" );
		} catch ( Throwable e ) {
			e.printStackTrace();
		}
		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					FullScreenFrame frame = new FullScreenFrame();
					frame.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the frame.
	 */
	public FullScreenFrame() {

		setTitle( "\u5168\u5C4F\u663E\u793APDF\u6587\u4EF6" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( new BorderLayout( 0, 0 ) );

		JPanel buttonPanel = new JPanel();
		contentPane.add( buttonPanel, BorderLayout.SOUTH );

		JButton chooseButton = new JButton( "\u9009\u62E9\u6587\u4EF6" );
		chooseButton.setFont( new Font( "微软雅黑", Font.PLAIN, 16 ) );
		chooseButton.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_chooseButton_actionPerformed( arg0 );
			}
		} );
		buttonPanel.add( chooseButton );

		JButton fullscreenButton = new JButton( "\u5168\u5C4F\u663E\u793A" );
		fullscreenButton.setFont( new Font( "微软雅黑", Font.PLAIN, 16 ) );
		fullscreenButton.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {

				do_fullscreenButton_actionPerformed( arg0 );
			}
		} );
		buttonPanel.add( fullscreenButton );

		pdfPanel = new JPanel();
		contentPane.add( pdfPanel, BorderLayout.CENTER );
	}

	protected void do_chooseButton_actionPerformed( ActionEvent arg0 ) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter( new FileNameExtensionFilter( "PDF文件", "pdf" ) );
		fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		fileChooser.setMultiSelectionEnabled( false );
		int result = fileChooser.showOpenDialog( this );
		if ( result == JFileChooser.APPROVE_OPTION ) {
			File selectFile = fileChooser.getSelectedFile();
			try {
				pdfPage = getPDFPage( selectFile );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
			PagePanel pagePanel = new PagePanel();
			pdfPanel.add( pagePanel );
			validate();
			pagePanel.showPage( pdfPage );
		}
	}

	private static PDFPage getPDFPage( File file ) throws IOException {

		RandomAccessFile raf     = new RandomAccessFile( file, "r" );
		FileChannel      channel = raf.getChannel();
		ByteBuffer       buffer  = channel.map( FileChannel.MapMode.READ_ONLY, 0, channel.size() );
		PDFFile          pdfFile = new PDFFile( buffer );
		return pdfFile.getPage( 2 );
	}

	protected void do_fullscreenButton_actionPerformed( ActionEvent arg0 ) {

		if ( pdfPage == null ) {
			JOptionPane.showMessageDialog( this, "请选择PDF文件", null, JOptionPane.WARNING_MESSAGE );
			return;
		}
		Rectangle rect      = new Rectangle( 0, 0, (int) pdfPage.getBBox().getWidth(), (int) pdfPage.getBBox().getHeight() );// 获得用户选中的PDF页面的边框
		Toolkit   toolkit   = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize(); // 获得用户的显示器大小
		double    times     = dimension.getHeight() / rect.height;// 获得高度需要放大的倍数
		Image     image     = pdfPage.getImage( (int) ( rect.width * times ), dimension.height, rect, null, true, true );// 设置图片的大小
		if ( pdfPanel != null ) {
			pdfPanel.removeAll();
		}
		pdfPanel.add( new JLabel( new ImageIcon( image ) ) ); // 显示生成的图片
		new FullScreenWindow( pdfPanel );
	}
}
