package bj.powernode.advance.Charpter14;

import java.io.*;
import java.net.*;
import java.util.*;

public class Service extends Thread implements Serializable {

	private Socket socket;

	private BufferedReader reader = null;

	private PrintStream writer = null;

	private List< Socket > list;

	public Service( Socket socket, String name, List< Socket > list ) {

		super( name );
		this.socket = socket;
		this.list = list;
		this.start();
	}

	public void run() {

		try {
			String ip = socket.getInetAddress().getHostAddress();
			reader = new BufferedReader( new InputStreamReader( socket
					                                                    .getInputStream() ) );
			writer = new PrintStream( socket.getOutputStream() );
			int      size = list.size();
			String[] s    = new String[ size ];
			for ( int i = 0; i < size; i++ ) {
				s[ i ] = list.get( i ).getInetAddress().getHostAddress();
			}
			Iterator< Socket > itUsers = list.iterator();
			while ( itUsers.hasNext() ) {
				Socket      soc = itUsers.next();
				PrintStream out = new PrintStream( soc.getOutputStream() );
				if ( soc == socket ) {
					for ( int i = 0; i < size; i++ ) {
						out.println( s[ i ] );
					}
				} else {
					out.println( s[ size - 1 ] );
				}
			}

			String             notice = this.getName() + "进入了房间！";
			Iterator< Socket > it     = list.iterator();
			while ( it.hasNext() ) {
				Socket      soc   = it.next();
				PrintStream print = new PrintStream( soc.getOutputStream() );
				print.println( notice );
			}
			// 公聊的实现
			while ( true ) {
				String             desIP = reader.readLine();
				String             data  = reader.readLine();
				Iterator< Socket > it1   = list.iterator();
				if ( desIP.contains( "." ) ) {
					while ( it1.hasNext() ) {
						Socket soc = it1.next();
//						if(soc==socket){
//							continue;
//						}
//						if(socket.getInetAddress().getHostAddress().equals(desIP)){
//							writer.println("不要自言自语！");
//							break;
//						}
						if ( soc.getInetAddress().getHostAddress().equals( desIP ) ) {
							PrintStream print = new PrintStream( soc.getOutputStream() );

							print.println( ip + "对你说：" + data );
							writer.println( "你对" + desIP + "说：" + data );
							break;
						}
					}
				} else {
					while ( it1.hasNext() ) {
						Socket      soc   = it1.next();
						PrintStream print = new PrintStream( soc.getOutputStream() );
						print.println( ip + "对大家说：" + data );
					}
				}
			}

		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}
