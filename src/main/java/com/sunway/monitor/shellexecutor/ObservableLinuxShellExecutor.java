package com.sunway.monitor.shellexecutor;

import java.io.File;
import java.io.IOException;
import java.util.Observer;

public class ObservableLinuxShellExecutor implements ShellExecuteService {

	@Override
	public synchronized ShellResult execute(Command command) {

		command.getWorkingDirectory().mkdirs();
		int exitVal = -1;

		ProcessBuilder pb = new ProcessBuilder(command.getCommand());
		pb.directory(command.getWorkingDirectory());

		try {
			Process process = pb.start();
			// any error message?
			StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), command.getErrorObserver());

			// any output?
			StreamGobbler outputGobbler = new StreamGobbler(process.getInputStream(), command.getObserver());
			outputGobbler.addObserver(new DefaultObserver());

			// kick them off
			new Thread(errorGobbler).start();
			new Thread(outputGobbler).start();

			exitVal = process.waitFor();

		} catch (IOException e) {
			exitVal = 1;
			e.printStackTrace();

		} catch (InterruptedException e) {
			exitVal = 2;
			e.printStackTrace();
		}

		System.out.println(exitVal);

		return null;
	}

	@Override
	public  ShellResult execute(File workfolder, String... command) {

		Command cmd = new Command() {

			@Override
			public Observer getObserver() {

				return new DefaultObserver();
			}

			@Override
			public String[] getCommand() {

				return new String[] { "ping", "127.0.0.1" };
			}
		};
		return execute(cmd);

	}

	@Override
	public ShellResult execute(String... command) {
		File workfolder = new File(".");
		workfolder.mkdirs();
		return execute(workfolder, command);
	}

}
