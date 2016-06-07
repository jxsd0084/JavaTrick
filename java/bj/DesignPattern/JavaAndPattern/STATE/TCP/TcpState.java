package bj.DesignPattern.JavaAndPattern.STATE.TCP;

public interface TcpState {

	void open();

	void close();

	void acknowledge();
}
