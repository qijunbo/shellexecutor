package com.sunway.monitor.shellexecutor;

import java.util.Observable;
import java.util.Observer;

public class DefaultObserver implements Observer {

	@Override
	public void update(Observable var1, Object var2) {
		
		System.out.println(var2);

	}

}
