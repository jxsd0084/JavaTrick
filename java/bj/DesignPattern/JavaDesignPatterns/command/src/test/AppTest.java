package bj.DesignPattern.JavaDesignPatterns.command.src.test;

import bj.DesignPattern.JavaDesignPatterns.command.src.main.App;
import org.junit.Test;

import java.io.IOException;

/**
 * Tests that Command example runs without errors.
 */
public class AppTest {

	@Test
	public void test() throws IOException {

		String[] args = {};
		App.main( args );
	}

}
