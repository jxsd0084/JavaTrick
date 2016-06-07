package bj.Java1200.col01.ch06_多线程技术.ch06_2_线程的同步._137;

import javax.swing.*;

public class Transfer implements Runnable {

	private Bank      bank;
	private JTextArea textArea;

	public Transfer( Bank bank, JTextArea textArea ) {

		this.bank = bank;
		this.textArea = textArea;
	}

	public void run() {

		for ( int i = 0; i < 10; i++ ) {
			bank.deposit( 10 );
			String text = textArea.getText();
			textArea.setText( text + "账户的余额是：" + bank.getAccount() + "\n" );
		}
	}
}
