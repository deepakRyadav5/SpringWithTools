package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	private StudentDAO dao;

	public StudentServiceImpl(StudentDAO dao) {
		System.out.println("StudentServiceImpl.StudentServiceImpl()");
		this.dao = dao;
	}

	@Override
	public List<StudentDTO> fetchAllStudents() {
		System.out.println("StudentServiceImpl.fetchAllStudents(-,-)");
		System.out.println("StudentServiceImpl.fetchAllStudents(----)");
		List<StudentBO> listBO = null;
		List<StudentDTO> listDTO = new ArrayList();

		// use DAO
		listBO = dao.getAllStudentDetails();

		// converting BO to DTO
		listBO.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			// copy bo to dto
			BeanUtils.copyProperties(bo, dto);
			dto.setSrno(listDTO.size() + 1);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public String addStudent(StudentDTO dto) {
		StudentBO bo = null;
		int result = 0;

		// copy dto to bo
		bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);

		// use dao
		result = dao.registerStudent(bo);

		if (result == 0)
			return "Registration Failed";
		else
			return "Registration Successful";
	}

	@Override
	public String removeStudent(int sno) {
		int result=0;
		
		//use DAO
		result=dao.deleteStudent(sno);
		
		if(result==0)
		return "Record not Deleted";
		else
			return "Record deleted permenantly";
	}

	@Override
	public StudentDTO getStudentByID(int sno) {
		StudentBO bo=null;
		StudentDTO dto=null;
		
		//use dao
		bo=dao.fetchStudentByNumber(sno);
		
		//convert bo to dto
		dto=new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public String updateStudentById(StudentDTO dto) {
		int result=0;
		StudentBO bo=null;
		
		//copy dto to bo
		bo=new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		
		//use dao
		result=dao.updateStudent(bo);
		
		if(result==0)
			return "Update Failed";
		else
			return "Update Succeded";
				
				
	}

}
