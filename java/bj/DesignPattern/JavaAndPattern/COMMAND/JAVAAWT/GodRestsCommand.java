package bj.DesignPattern.JavaAndPattern.COMMAND.JAVAAWT;

import java.awt.*;

public class GodRestsCommand extends Button implements CommandFromGod {

	public GodRestsCommand( String caption ) {
		super( caption );
	}

	public void Execute() {
		System.exit( 0 );
	}

}

