package com.sunway.monitor.shellexecutor;

import java.io.File;

public interface ShellExecuteService {

	public ShellResult execute(Command command);

	public ShellExecuteService.ShellResult execute(File workfolder, String... command);

	public ShellExecuteService.ShellResult execute(String... command);

	public static class ShellResult {

		int errorcode;

		String message;

		public ShellResult(int errorcode, String message) {
			super();
			this.errorcode = errorcode;
			this.message = message;
		}

		public int getErrorcode() {
			return errorcode;
		}

		public String getMessage() {
			return message;
		}

		@Override
		public String toString() {
			return String.format("ShellExecutorService.ShellResult[errorcode=%d, message='%s' ]", errorcode, message);
		}
	}
}
