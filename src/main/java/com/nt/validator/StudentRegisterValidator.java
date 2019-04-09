package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.StudentCommand;

public class StudentRegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(StudentCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		StudentCommand cmd=(StudentCommand) target;
		
		if(cmd.getSname()==null || cmd.getSname().trim().equals(""))
			errors.rejectValue("sname", "student.name.required");
			
		if(cmd.getAddress()==null || cmd.getAddress().trim().equals(""))
			errors.rejectValue("address", "student.address.required");
		else if(cmd.getAddress().length()<10)
			errors.rejectValue("address","student.address.range");
		
		if(cmd.getMobile()==null || cmd.getMobile().toString().trim().equals(""))
			errors.rejectValue("mobile", "student.mobile.required");
		else if(cmd.getMobile().toString().length()<10)
			errors.rejectValue("mobile", "student.mobile.range");
		
		if(cmd.getEmail()==null || cmd.getEmail().trim().equals(""))
			errors.rejectValue("email", "student.email.required");
		else if(!cmd.getEmail().trim().contains("@"))
			errors.rejectValue("email", "student.email.range");
		
	}

}
