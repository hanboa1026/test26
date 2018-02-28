package ksmart.project.test26.service.company;

import java.util.List;

public class CompanyAndCompanyFile {
		private int companyId;
		private String CompanyName;
		private List<CompanyFile> list;
		public int getCompanyId() {
			return companyId;
		}
		public void setCompanyId(int companyId) {
			this.companyId = companyId;
		}
		public String getCompanyName() {
			return CompanyName;
		}
		public void setCompanyName(String companyName) {
			CompanyName = companyName;
		}
		public List<CompanyFile> getList() {
			return list;
		}
		public void setList(List<CompanyFile> list) {
			this.list = list;
		}
		@Override
		public String toString() {
			return "CompanyAndCompanyFile [companyId=" + companyId + ", CompanyName=" + CompanyName + "]";
		}
		
		
}
