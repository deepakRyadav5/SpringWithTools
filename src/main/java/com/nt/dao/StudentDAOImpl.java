package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String GET_ALL_STUDENTS = "SELECT SNO,SNAME,ADDRESS,MOBILE,EMAIL FROM STUDENT ORDER BY SNAME";
	private static final String REGISTER_STUDENT = "INSERT INTO STUDENT VALUES (SNO_SEQ.NEXTVAL,?,?,?,?)";
	private static final String DELETE_STUDENT = "DELETE FROM STUDENT WHERE SNO=?";
	private static final String GET_STUDENT_BY_NUMBER = "SELECT SNO,SNAME,ADDRESS,MOBILE,EMAIL FROM STUDENT WHERE SNO=?";
	private static final String UPDATE_STUDENT_BY_ID="UPDATE STUDENT SET SNAME=?,ADDRESS=?,MOBILE=?,EMAIL=? WHERE SNO=?";
	private JdbcTemplate jt;

	public StudentDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<StudentBO> getAllStudentDetails() {
		List<StudentBO> listBO = null;
		listBO = jt.query(GET_ALL_STUDENTS, rs -> {
			List<StudentBO> listInner = new ArrayList();
			StudentBO bo = null;
			while (rs.next()) {
				bo = new StudentBO();
				bo.setSno(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setAddress(rs.getString(3));
				bo.setMobile(rs.getLong(4));
				bo.setEmail(rs.getString(5));

				listInner.add(bo);
			} // while
			return listInner;
		});
		return listBO;
	}

	@Override
	public int registerStudent(StudentBO bo) {
		int result = 0;

		result = jt.update(REGISTER_STUDENT, bo.getSname(), bo.getAddress(), bo.getMobile(), bo.getEmail());

		return result;

	}

	@Override
	public int deleteStudent(int sno) {
		int result = 0;

		result = jt.update(DELETE_STUDENT, sno);

		return result;
	}

	@Override
	public StudentBO fetchStudentByNumber(int sno) {
		StudentBO bo = null;

		bo = jt.queryForObject(GET_STUDENT_BY_NUMBER, new RowMapper<StudentBO>() {

			public StudentBO mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
				StudentBO bo = new StudentBO();

				bo.setSno(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setAddress(rs.getString(3));
				bo.setMobile(rs.getLong(4));
				bo.setEmail(rs.getString(5));

				return bo;

			};// method
		}// inner
				, sno);

		return bo;
	}

	@Override
	public int updateStudent(StudentBO bo) {
		int result=0;
		
		result=jt.update(UPDATE_STUDENT_BY_ID, bo.getSname(),bo.getAddress(),bo.getMobile(),bo.getEmail(),bo.getSno());
		
		return result;
	}

}
