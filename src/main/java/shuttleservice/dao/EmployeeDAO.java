package shuttleservice.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import shuttleservice.beans.Employee;
import shuttleservice.fombeans.EmployeeForm;

@Repository
public class EmployeeDAO {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final Map<Long,Employee> EMP_MAP = new HashMap<>();
	
	static {
		initDATA();
	}
	
	private static void initDATA() {
		String encryptedPassword = "";
		
		Employee chan = new Employee(1000, false, "Christian", "Robles", "cstrobles@gmail.com", encryptedPassword);
		Employee juan = new Employee(1001, false, "Juan", "Dela Cruz", "jdcruz@gmail.com", encryptedPassword);
		
		EMP_MAP.put(chan.getEmpNum(),chan);
		EMP_MAP.put(juan.getEmpNum(), juan);
		
	}

	public Employee findEmployeeByName(String Fname, String Lname) {
		Collection<Employee> employee = EMP_MAP.values();
		for(Employee e: employee) {
			if(e.getEmpFirstName().equalsIgnoreCase(Fname) && e.getEmpLastName().equalsIgnoreCase(Lname)) {
				return e;
			}
		}
		return null;
	}
	
	public Employee findEmployeeByMail(String email) {
		Collection<Employee> employee = EMP_MAP.values();
		for(Employee e: employee) {
			if(e.getEmail().equals(email)) {
				return e;
			}
		}
		return null;
	}

	public Employee findEmployeeById(Long id) {
		Collection<Employee> employee = EMP_MAP.values();
		for(Employee e: employee) {
			if(e.getEmpNum() == id ) {
				return e;
			}
		}
		return null;
	}
	
	public List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<>();
		list.addAll(EMP_MAP.values());
		return list;
		
	}

	public Employee registerEmployee(EmployeeForm form) {
		String encryptedPassword = this.passwordEncoder.encode(form.getPassword());
		
		Employee emp = new Employee(form.getEmpNum(), false, form.getEmpFirstName(), form.getEmpLastName(), form.getEmail(), encryptedPassword);
		EMP_MAP.put(form.getEmpNum(), emp);
		return emp;
	}
}
