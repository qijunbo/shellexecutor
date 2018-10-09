package com.sunway.monitor.shellexecutor;

public class LinuxShellExecutor {

	public static final int MAXSIZE = 4096;

	public static void main(String[] args) {
  
		if (args.length < 1) {
			args = new String[] { "ping", "127.0.0.1" };
		}
 
		ObservableLinuxShellExecutor executor = new ObservableLinuxShellExecutor();
		
		executor.execute(args);
		
	}

}

