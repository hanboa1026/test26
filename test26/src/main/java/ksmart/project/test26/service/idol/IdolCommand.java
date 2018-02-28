package ksmart.project.test26.service.idol;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class IdolCommand {
	private int idolId;
	private String idolName;
	private List<MultipartFile> file;
	public int getIdolId() {
		return idolId;
	}
	public void setIdolId(int idolId) {
		this.idolId = idolId;
	}
	public String getidolName() {
		return idolName;
	}
	public void setidolName(String idolName) {
		this.idolName = idolName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "IdolCommand [idolId=" + idolId + ", idolName=" + idolName + ", file=" + file + "]";
	}
	

	
}
