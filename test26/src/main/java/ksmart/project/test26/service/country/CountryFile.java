package ksmart.project.test26.service.country;

public class CountryFile {
	private int countryFileId;
	private int countryId;
	private String fileName;
	private String fileExt;
	private long fileSize;
	
	public int getcountryFileId() {
		return countryFileId;
	}
	public void setcountryFileId(int countryFileId) {
		this.countryFileId = countryFileId;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	@Override
	public String toString() {
		return "CountryFile [countryId=" + countryId + ", fileName=" + fileName + ", fileExt=" + fileExt + ", fileSize="
				+ fileSize + "]";
	}
	
	
}
