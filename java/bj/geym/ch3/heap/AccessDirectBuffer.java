package bj.geym.ch3.heap;

import java.nio.ByteBuffer;

/**
 * -server 模式下 差异明显
 *
 * @author Geym
 */
public class AccessDirectBuffer {

	public void directAccess() {

		long       starttime = System.currentTimeMillis();
		ByteBuffer b         = ByteBuffer.allocateDirect( 500 );
		for ( int i = 0; i < 100000; i++ ) {
			for ( int j = 0; j < 99; j++ ) {
				b.putInt( j );
			}
			b.flip();
			for ( int j = 0; j < 99; j++ ) {
				b.getInt();
			}
			b.clear();
		}
		long endtime = System.currentTimeMillis();
		System.out.println( "testDirectWrite:" + ( endtime - starttime ) );
	}

	public void bufferAccess() {

		long       starttime = System.currentTimeMillis();
		ByteBuffer b         = ByteBuffer.allocate( 500 );
		for ( int i = 0; i < 100000; i++ ) {
			for ( int j = 0; j < 99; j++ ) {
				b.putInt( j );
			}
			b.flip();
			for ( int j = 0; j < 99; j++ ) {
				b.getInt();
			}
			b.clear();
		}
		long endtime = System.currentTimeMillis();
		System.out.println( "testBufferWrite:" + ( endtime - starttime ) );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		AccessDirectBuffer alloc = new AccessDirectBuffer();

		alloc.bufferAccess();
		alloc.directAccess();

		alloc.bufferAccess();
		alloc.directAccess();

	}

}
