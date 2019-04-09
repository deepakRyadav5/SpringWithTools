package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentDTO implements Serializable {
	private int srno;
	private int sno;
	private String sname;
	private String address;
	private Long mobile;
	private String email;
	
}
