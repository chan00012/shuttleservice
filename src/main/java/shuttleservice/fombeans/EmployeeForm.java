package shuttleservice.fombeans;


public class EmployeeForm {
	
	long empNum;
	boolean isRegistered;
	String empFirstName;
	String empLastName;
	String email;
	String Password;
	String confirmPassword;

	public EmployeeForm(long empNum, boolean isRegistered, String empFirstName, String empLastName, String email,
			String password, String confirmPassword) {
		super();
		this.empNum = empNum;
		this.isRegistered = isRegistered;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.email = email;
		Password = password;
		this.confirmPassword = confirmPassword;
	}
	
	public long getEmpNum() {
		return empNum;
	}
	public void setEmpNum(long empNum) {
		this.empNum = empNum;
	}
	public boolean isRegistered() {
		return isRegistered;
	}
	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
