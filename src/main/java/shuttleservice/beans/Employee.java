package shuttleservice.beans;

public class Employee {
	
	long empNum;
	boolean isRegistered;
	String empFirstName;
	String empLastName;
	String email;
	String encryptedPassword;
	Route shuttleRoute;
	
	
	public Employee(long empNum, boolean isRegistered, String empFirstName, String empLastName, String email,
			String encryptedPassword) {
		super();
		this.empNum = empNum;
		this.isRegistered = isRegistered;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.email = email;
		this.encryptedPassword = encryptedPassword;
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
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public Route getShuttleRoute() {
		return shuttleRoute;
	}
	public void setShuttleRoute(Route shuttleRoute) {
		this.shuttleRoute = shuttleRoute;
	}
	
	
	

}
