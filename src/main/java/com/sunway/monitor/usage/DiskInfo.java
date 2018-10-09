package com.sunway.monitor.usage;

import java.io.File;
import java.util.stream.Stream;

public class DiskInfo {

	private String name;

	private long total;

	private long free;

	public DiskInfo(String name, long total, long free) {
		super();
		this.name = name;
		this.total = total;
		this.free = free;
	}

	public static DiskInfo[] getDiskInfo() {

		return (DiskInfo[]) Stream.of(File.listRoots()).map(f -> {
			return new DiskInfo(f.getAbsolutePath(), f.getTotalSpace(), f.getFreeSpace());

		}).toArray();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getFree() {
		return free;
	}

	public void setFree(long free) {
		this.free = free;
	}

	@Override
	public String toString() {
		return name + ":" + free + "/" + total;
	}

}
