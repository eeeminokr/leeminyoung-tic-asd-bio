package medical.framework.file;

public class ExcelFile {

	public static final int XLS = 2003;
	public static final int XLSX = 2007;

	private int version = 2007;
	private byte[] bytes;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	
	public boolean isXlsx() {
		return this.version == XLSX;
	}

}
