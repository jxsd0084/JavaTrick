package bj.DesignPattern.sxt_pattern.mediator;

public interface Mediator {

	void register( String dname, Department d );

	void command( String dname );

}
