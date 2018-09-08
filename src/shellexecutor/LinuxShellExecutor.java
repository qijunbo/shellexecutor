package shellexecutor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LinuxShellExecutor {

	public static final int MAXSIZE = 4096;

	public static void main(String[] args) {
		int exitVal = -1;

		File workfolder = new File(".");

		if (args.length < 1) {
			args = new String[] { "ping", "127.0.0.1" };
		}

		ProcessBuilder pb = new ProcessBuilder(args);
		pb.directory(workfolder);

		try {

			Process process = pb.start();

			// any error message?
			StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "ERROR");

			// any output?
			StreamGobbler outputGobbler = new StreamGobbler(process.getInputStream(), "OUTPUT");

			// kick them off
			errorGobbler.start();
			outputGobbler.start();

			exitVal = process.waitFor();

		} catch (IOException e) {
			exitVal = 1;
			e.printStackTrace();

		} catch (InterruptedException e) {
			exitVal = 2;
			e.printStackTrace();
		}

		System.out.println(exitVal);

	}

}

class StreamGobbler extends Thread {
	InputStream is;
	String type;

	StreamGobbler(InputStream is, String type) {
		this.is = is;
		this.type = type;
	}

	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				System.out.println(type + ">" + line);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
