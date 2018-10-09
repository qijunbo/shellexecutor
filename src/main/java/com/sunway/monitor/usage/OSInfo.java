package com.sunway.monitor.usage;

import java.io.File;
import java.util.stream.Stream;

public class OSInfo {

	private String osname;

	private String osversion;

	private String osarch;

	private OSInfo(String osname, String osversion, String osarch) {
		super();
		this.osname = osname;
		this.osversion = osversion;
		this.osarch = osarch;
	}

	public static OSInfo getSysInfo() {
		return new OSInfo(System.getProperty("os.name"), System.getProperty("os.version"),
				System.getProperty("os.arch"));
	}

	public static void main(String[] a) {

		System.out.println(JVMInfo.getJVMInfo().toString());

		Stream.of(File.listRoots()).map(f -> {
			return new DiskInfo(f.getAbsolutePath(), f.getTotalSpace(), f.getFreeSpace());
		}).forEach(f -> System.out.println(f.toString()));

		System.out.println(OSInfo.getSysInfo().toString());
	}

	@Override
	public String toString() {

		return "os.name: " + osname + "\nos.version: " + osversion + "\nos.arch： " + osarch;
	}

}