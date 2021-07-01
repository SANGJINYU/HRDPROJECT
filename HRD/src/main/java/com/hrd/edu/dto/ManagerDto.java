package com.hrd.edu.dto;

import java.util.List;

public class ManagerDto {

	private String id;
	private String inst_ino;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String auth;
	
	private List<CounselDto> counselDto;

	public ManagerDto() {
		super();
	}


	public ManagerDto(String id, String inst_ino, String password, String name, String email, String phone,
			String auth) {
		super();
		this.id = id;
		this.inst_ino = inst_ino;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.auth = auth;
	}



	@Override
	public String toString() {
		return "ManagerDto [id=" + id + ", inst_ino=" + inst_ino + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", auth=" + auth + ", counselDto=" + counselDto + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getM_id() {
		return id;
	}


	public void setM_id(String id) {
		this.id = id;
	}


	public String getInst_ino() {
		return inst_ino;
	}


	public void setInst_ino(String inst_ino) {
		this.inst_ino = inst_ino;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public String getPw() {
		return password;
	}
	
	
	public void setPw(String pw) {
		this.password = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAuth() {
		return auth;
	}


	public void setAuth(String auth) {
		this.auth = auth;
	}
	
}
