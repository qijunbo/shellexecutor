package usage;

public class JVMInfo {

	private long total;

	private long free;

	protected JVMInfo(long total, long free) {
		super();
		this.total = total;
		this.free = free;
	}

	public static JVMInfo getJVMInfo() {
		return new JVMInfo(Runtime.getRuntime().totalMemory(), Runtime.getRuntime().freeMemory());
	}

	public long getTotal() {
		return total;
	}

	public long getFree() {
		return free;
	}

	@Override
	public String toString() {
 
		return "JVM: " + free + "/" + total;
	}

	
}
