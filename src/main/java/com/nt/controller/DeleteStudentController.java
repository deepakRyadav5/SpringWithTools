package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class DeleteStudentController extends AbstractController {
	private StudentService service;
	
	public DeleteStudentController(StudentService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int sno=0;
		String status=null;
		List<StudentDTO> listDTO=null;
		ModelAndView mav=null;
		
		sno=Integer.parseInt(request.getParameter("sno"));
		
		//use service
		listDTO=service.fetchAllStudents();
		status=service.removeStudent(sno);
		
		mav= new ModelAndView();
				mav.addObject("listDTO", listDTO);
				mav.addObject("resMsg", status);
				mav.setViewName("all_students");
				
				return mav;
	}

}
