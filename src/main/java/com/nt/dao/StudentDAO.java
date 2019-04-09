package com.nt.dao;

import java.util.List;

import com.nt.bo.StudentBO;

public interface StudentDAO {
	public List<StudentBO> getAllStudentDetails();
	public int registerStudent(StudentBO bo);
	public int deleteStudent(int sno);
	public StudentBO fetchStudentByNumber(int sno);
	public int updateStudent(StudentBO bo);

}
