/* Generated by Together */

package bj.DesignPattern.JavaAndPattern.COMMAND.BOOK;

public interface MacroCommand extends Command {

	void execute();

	void remove( Command toRemove );

	void add( Command toAdd );

}