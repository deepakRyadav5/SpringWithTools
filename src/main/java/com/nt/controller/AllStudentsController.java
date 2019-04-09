package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class AllStudentsController extends AbstractController {
	private StudentService service;

	public AllStudentsController(StudentService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<StudentDTO> listDTO = null;

		// use service
		listDTO = service.fetchAllStudents();

		return new ModelAndView("all_students", "listDTO", listDTO);
	}

}
