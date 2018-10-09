package com.sunway.monitor.shellexecutor;

import java.io.File;
import java.util.Observer;

public interface Command {

	default File getWorkingDirectory() {
		return new File(".");
	}

	String[] getCommand();

	Observer getObserver();

	default Observer getErrorObserver() {
		return new DefaultObserver();
	}

	public static String[] DEFAULT_CHARSET = { "locale", "charmap" };

}
