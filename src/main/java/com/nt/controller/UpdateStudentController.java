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

public class UpdateStudentController extends SimpleFormController {
	private StudentService service;

	public UpdateStudentController(StudentService service) {
		this.service = service;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		StudentDTO dto = null;
		StudentCommand cmd = new StudentCommand();
		int sno = 0;

		sno = Integer.parseInt(request.getParameter("sno"));

		// use service
		dto = service.getStudentByID(sno);

		// convert from dto to command class
		BeanUtils.copyProperties(dto, cmd);

		return cmd;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		StudentCommand cmd=(StudentCommand) command;
		StudentDTO dto=null;
		String status=null;
		List<StudentDTO> listDTO=null;
		ModelAndView mav=null;
		
		//converting command obj to DTO
		dto=new StudentDTO();
		BeanUtils.copyProperties(cmd, dto);
		
		//use service
		status=service.updateStudentById(dto);
		listDTO=service.fetchAllStudents();
		
		mav= new ModelAndView("all_students");
		mav.addObject("listDTO", listDTO);
		mav.addObject("resMsg", status);
		
		return mav;
		
	}
	
	@Override
	protected ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("error");
	}
	
}
