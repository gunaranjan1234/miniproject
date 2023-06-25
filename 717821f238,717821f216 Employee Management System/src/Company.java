
public class Company {
	private String company_name;
	private int company_id;
	private String company_address;
	public Company(String company_name, int company_id, String company_address) {
		super();
		this.company_name = company_name;
		this.company_id = company_id;
		this.company_address = company_address;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	@Override
	public String toString() {
		return "Company [company_name=" + company_name + ", company_id=" + company_id + ", company_address="
				+ company_address + "]";
	}
	

}
