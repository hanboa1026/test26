package ksmart.project.test26.service.idol;

public class Idol {
	private int idolId;
	private String idolName;
	public int getIdolId() {
		return idolId;
	}
	public void setIdolId(int idolId) {
		this.idolId = idolId;
	}
	public String getIdolName() {
		return idolName;
	}
	public void setIdolName(String idolName) {
		this.idolName = idolName;
	}
	
	@Override
	public String toString() {
		return "idol [idolId=" + idolId + ", idolName=" + idolName + "]";
	}		
	

}
