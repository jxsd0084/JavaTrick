package bj.powernode.advance.Charpter14;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class Server {

	private static List< Socket > list = new ArrayList< Socket >();

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		ServerSocket server = null;
		Socket       socket = null;
		String       tname  = null;
		int          i      = 1;

		try {

			server = new ServerSocket( 6000 );
			System.out.println( "the server will be start!" );

			while ( true ) {

				tname = "线程" + i++;
				socket = server.accept();
				System.out.println( socket.getInetAddress().getHostAddress() + "上线了！" );
				list.add( socket );

				new Service( socket, tname, list );
			}

		} catch ( IOException e ) {
			e.printStackTrace();
		}

	}

}
