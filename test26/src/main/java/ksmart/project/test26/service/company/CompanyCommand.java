package ksmart.project.test26.service.company;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CompanyCommand {

		private int companyId;
		private String companyName;
		private List<MultipartFile> file;
		
		public int getCompanyId() {
			return companyId;
		}
		public void setCompanyId(int companyId) {
			this.companyId = companyId;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public List<MultipartFile> getFile() {
			return file;
		}
		public void setFile(List<MultipartFile> file) {
			this.file = file;
		}
		@Override
		public String toString() {
			return "CompanyCommand [companyId=" + companyId + ", companyName=" + companyName + ", file=" + file + "]";
		}
		
		
		
		
}
