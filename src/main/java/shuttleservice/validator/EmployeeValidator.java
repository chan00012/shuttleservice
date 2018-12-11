package shuttleservice.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shuttleservice.beans.Employee;
import shuttleservice.dao.EmployeeDAO;
import shuttleservice.fombeans.EmployeeForm;

@Component
public class EmployeeValidator implements Validator {

	private EmailValidator emailValidator = EmailValidator.getInstance();
	
	@Autowired
	private EmployeeDAO empDAO;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == EmployeeForm.class;
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		EmployeeForm empForm = (EmployeeForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empFirstName", "NotEmpty.appUserForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empLastName", "NotEmpty.appUserForm.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.appUserForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.appUserForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.appUserForm.confirmPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empNum", "NotEmpty.appUserForm.confirmPassword");
        
		if(!this.emailValidator.isValid(empForm.getEmail())) {
			errors.rejectValue("email", "Pattern.appUserForm.email");
			
		if(!errors.hasFieldErrors("empNum")) {
			Employee emp = empDAO.findEmployeeById(empForm.getEmpNum());
			if(emp!=null) {
				errors.rejectValue("empNum", "Duplicate.appUserForm.employeeId");
			}
		}
		
		if(!errors.hasErrors()){
			if(!empForm.getConfirmPassword().equals(empForm.getPassword())) {
				errors.rejectValue("confirmPassword", "Match.appUserForm.confirmPassword");
			}
		}
		}
	}
	
	
}
