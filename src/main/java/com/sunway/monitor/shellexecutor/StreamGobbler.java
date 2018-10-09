package com.sunway.monitor.shellexecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

public class StreamGobbler extends Observable implements Runnable {
	InputStream is;
 

	StreamGobbler(InputStream is , Observer observer) {
		this.is = is;
		this.addObserver(observer);
	}

	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				this.setChanged();
				this.notifyObservers(line);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}