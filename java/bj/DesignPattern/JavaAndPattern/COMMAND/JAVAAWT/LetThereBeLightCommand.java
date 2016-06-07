package bj.DesignPattern.JavaAndPattern.COMMAND.JAVAAWT;

import java.awt.*;

public class LetThereBeLightCommand extends Button implements CommandFromGod {

	Panel p;

	public LetThereBeLightCommand( String caption, Panel pnl ) {
		super( caption );
		p = pnl;
	}

	public void Execute() {
		p.setBackground( Color.white );
	}

}

