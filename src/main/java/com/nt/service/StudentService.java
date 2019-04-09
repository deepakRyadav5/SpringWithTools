package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface StudentService {
	public List<StudentDTO> fetchAllStudents();
	public String addStudent(StudentDTO dto);
	public String removeStudent(int sno);
	public StudentDTO getStudentByID(int sno);
	public String updateStudentById(StudentDTO dto);

}
