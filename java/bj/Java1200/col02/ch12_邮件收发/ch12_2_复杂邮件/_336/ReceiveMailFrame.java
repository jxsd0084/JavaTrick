package bj.Java1200.col02.ch12_邮件收发.ch12_2_复杂邮件._336;

import com.sun.mail.imap.IMAPFolder;

import javax.mail.*;
import javax.mail.internet.MimeUtility;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;
import java.util.Vector;

public class ReceiveMailFrame extends JFrame {

	private   JTextArea ta_receive;
	protected Session   session;
	protected Store     store;
	private String             receiveHost          = "localhost";// 接收主机
	private String             receiveProtocol      = "imap";// 接收协议
	private String             username             = "zzk";// 用户名
	private String             password             = "zzk";// 密码
	private Vector< String >   readedEmailUIDVector = new Vector< String >();
	private ObjectOutputStream objectOut            = null;
	private ObjectInputStream  objectIn             = null;
	private int                ReadedNums           = 0;

	public static void main( String args[] ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					ReceiveMailFrame frame = new ReceiveMailFrame();
					frame.init();// 调用初始化方法
					frame.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	public ReceiveMailFrame() {

		super();
		getContentPane().setLayout( new BorderLayout() );
		setTitle( "接收邮件窗体" );
		setBounds( 100, 100, 386, 314 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add( scrollPane, BorderLayout.CENTER );

		ta_receive = new JTextArea();
		scrollPane.setViewportView( ta_receive );

		final JPanel panel = new JPanel();
		getContentPane().add( panel, BorderLayout.SOUTH );

		final JButton button = new JButton();
		button.addActionListener( new ActionListener() {
			public void actionPerformed( final ActionEvent e ) {

				try {
					receiveMessage();// 调用接收信息的方法
				} catch ( Exception e1 ) {
					e1.printStackTrace();
				}
			}
		} );
		button.setText( "接收邮件并下载附件" );
		panel.add( button );

		final JButton button_1 = new JButton();
		button_1.addActionListener( new ActionListener() {
			public void actionPerformed( final ActionEvent e ) {

				System.exit( 0 );
			}
		} );
		button_1.setText( "退出系统" );
		panel.add( button_1 );
	}

	public void init() throws Exception {

		Properties props = new Properties();// 声明Properties对象
		props.put( "mail.store.protocol", receiveProtocol );// 指定接收协议
		props.put( "mail.imap.class", "com.sun.mail.imap.IMAPStore" );// 指定使用Store进行接收
		session = Session.getDefaultInstance( props );// 获得Session对象
		store = session.getStore( receiveProtocol );// 获得Store对象
		store.connect( receiveHost, username, password );// 连接接收服务器
	}

	public void receiveMessage() throws Exception {

		IMAPFolder folder = ( IMAPFolder ) store.getFolder( "inbox" );// 获得inbox邮件夹
		if ( folder == null ) {
			throw new Exception( "不存在inbox邮件夹。" );
		}
		folder.open( Folder.READ_ONLY );// 以只读方式打开邮件夹
		Message[] messages = folder.getMessages();// 获得邮件夹中的所有邮件
		for ( int i = 0; i < messages.length; i++ ) {
			long uid = folder.getUID( messages[ i ] );// 获得邮件的UID
			try {
				objectIn = new ObjectInputStream( new FileInputStream(
						"c:/readedEmail.txt" ) );// 创建输入流对象
				Object readObj = objectIn.readObject();// 从输入流读取信息
				if ( readObj == null ) { // 文件中未存储已读文件的UID
					JOptionPane.showMessageDialog( null, "没有已读邮件。" );
					return;
				} else {
					readedEmailUIDVector = ( Vector< String > ) readObj;// 将从文件中读取的内容转换为Vector对象
					for ( int j = 0; j < readedEmailUIDVector.size(); j++ ) {// 遍历向量对象
						if ( String.valueOf( uid ).equals( readedEmailUIDVector.get( j ) ) ) {// 是已读邮件
							ReadedNums++;// 已读邮件数加1
							readMessage( messages[ i ], folder, i );// 调用readMessage()方法读取已读邮件内容
						}
					}
				}
			} catch ( Exception ex ) {
				ex.printStackTrace();
			}

		}
		ta_receive.append( "您共收到" + folder.getMessageCount() + "个邮件。\n" );// 显示收到的邮件总数
		if ( ReadedNums > 0 ) {
			if ( ReadedNums == folder.getMessageCount() ) {
				ta_receive.append( "全部已读。\n\n" );
			} else {
				ta_receive.append( "其中上述" + ReadedNums + "个是已读邮件。\n\n" );
			}
		} else {
			ta_receive.append( "没有已读邮件。\n\n" );
		}
		folder.close( false );// 关闭邮件夹，但不删除邮件
		store.close();// 关闭Store对象
		if ( objectOut != null ) {
			objectOut.close();
		}
		if ( objectIn != null ) {
			objectIn.close();
		}
	}

	public void readMessage( Message message, IMAPFolder folder, int i )
			throws Exception {

		Object content = message.getContent();// 获得邮件内容
		if ( content instanceof Multipart ) {// 有附件执行的代码
			ta_receive.append( "----第" + ( i + 1 ) + "个邮件----\n" );
			ta_receive.append( "主题：" + folder.getMessage( i + 1 ).getSubject() + "\n" );// 主题
			Multipart mPart = ( Multipart ) content;// 获得Multipart对象
			ta_receive.append( "正文：" + mPart.getBodyPart( 0 ).getContent() + "\n" );
			ta_receive.append( "发送日期：" + folder.getMessage( i + 1 ).getSentDate() + "\n" );// 发送日期
			Address[] ias = folder.getMessage( i + 1 ).getFrom();// 发件人地址
			ta_receive.append( "发件人：" + ias[ 0 ] + "\n" );
			Address[] iasTo = folder.getMessage( i + 1 ).getAllRecipients();// 收件人地址
			ta_receive.append( "收件人：" + iasTo[ 0 ] + "\n\n" );
			try {
				String fileName = mPart.getBodyPart( 1 ).getFileName();// 获得文件名
				ta_receive.append( "接收到一个名为“" + MimeUtility.decodeText( fileName ) + "”的附件\n\n" );
				InputStream in     = mPart.getBodyPart( 1 ).getInputStream();// 获得输入流对象
				FileDialog  dialog = new FileDialog( ReceiveMailFrame.this, "保存" );// 创建对话框
				dialog.setMode( FileDialog.SAVE );// 设置对话框为保存对话框
				dialog.setFile( MimeUtility.decodeText( fileName ) );
				dialog.setVisible( true );// 显示保存对话框
				String path         = dialog.getDirectory();// 获得文件的保存路径
				String saveFileName = dialog.getFile();// 获得保存的文件名
				if ( path == null || saveFileName == null ) {
					return;
				}
				OutputStream out = new BufferedOutputStream( new FileOutputStream( path + "/" + saveFileName ) );// 创建输出流对象
				int          len = -1;
				while ( ( len = in.read() ) != -1 ) {// 读取输入流的信息
					out.write( len );// 向输出流写入附件信息
				}
				out.close();
				in.close();
			} catch ( Exception ex ) {

			}
		} else {// 没有附件执行的代码
			ta_receive.append( "----第" + ( i + 1 ) + "个邮件----\n" );
			ta_receive.append( "主题：" + folder.getMessage( i + 1 ).getSubject() + "\n" );// 主题
			ta_receive.append( "正文：" + folder.getMessage( i + 1 ).getContent() + "\n" );// 正文
			ta_receive.append( "发送日期：" + folder.getMessage( i + 1 ).getSentDate() + "\n" );// 发送日期
			Address[] ias = folder.getMessage( i + 1 ).getFrom();// 发件人地址
			ta_receive.append( "发件人：" + ias[ 0 ] + "\n" );
			Address[] iasTo = folder.getMessage( i + 1 ).getAllRecipients();// 收件人地址
			ta_receive.append( "收件人：" + iasTo[ 0 ] + "\n\n" );
		}
	}
}
