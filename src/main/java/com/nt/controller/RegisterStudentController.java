package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class RegisterStudentController extends SimpleFormController {
	private StudentService service;

	public RegisterStudentController(StudentService service) {
		this.service = service;
	}
	
	
	@Override
	protected ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("error");
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		StudentCommand cmd = null;
		StudentDTO dto = null;
		String status = null;
		List<StudentDTO> listDTO=null;
		ModelAndView mav=null;

		cmd = (StudentCommand) command;

		// convert command to dto
		dto = new StudentDTO();
		BeanUtils.copyProperties(cmd, dto);

		// use service
		status = service.addStudent(dto);
		listDTO=service.fetchAllStudents();

		mav= new ModelAndView("all_students");
		mav.addObject("listDTO", listDTO);
		mav.addObject("resMsg", status);
		
		return mav;
	}

}
