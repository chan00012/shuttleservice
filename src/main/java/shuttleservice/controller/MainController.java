package shuttleservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import shuttleservice.beans.Employee;
import shuttleservice.dao.EmployeeDAO;
import shuttleservice.fombeans.EmployeeForm;
import shuttleservice.validator.EmployeeValidator;

@Controller
public class MainController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder){
		Object target = dataBinder.getTarget();
		if(target==null) {
			return;
		}
		System.out.println("Target="+target);
		
		if(target.getClass() == EmployeeForm.class) {
			dataBinder.setValidator(employeeValidator);
		}
	}
	
	@RequestMapping("/")
	public String viewHome(Model model) {
		return "welcomePage";
	}
	
	@RequestMapping("/members")
	public String vieMembers(Model model) {
		List<Employee> list = employeeDAO.getEmployees();
		model.addAttribute("members", list);
		
		return "membersPage";
	}
	
	@RequestMapping("/registerSuccessful")
	public String viewRegisterSuccessful(Model model) {
		return "registerSuccessfulPage";
	}
	
}
