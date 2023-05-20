package complexNestedJSONObject;

import java.util.List;

public class NestedJSONPOJOClass {
	
	private String CompanyName;
	private String Street;
	private String City;
	private String State;
	private int PinCode;
	private List<String> bankAccount;
	
	private List<EmployeesPojoClass> employeeList;

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getPinCode() {
		return PinCode;
	}

	public void setPinCode(int pinCode) {
		PinCode = pinCode;
	}

	public List<String> getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(List<String> bankAccount) {
		this.bankAccount = bankAccount;
	}

	public List<EmployeesPojoClass> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeesPojoClass> employeeList) {
		this.employeeList = employeeList;
	}
	
	
}
