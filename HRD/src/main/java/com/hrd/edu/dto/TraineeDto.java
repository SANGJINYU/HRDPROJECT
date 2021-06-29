package com.hrd.edu.dto;

public class TraineeDto {

	private String id;
	private String email;
	private String pw;
	private String phone;
	private String name;
	private String addr;
	private String detail_addr;
	private String delflag;
	private String auth;
	
	
	public TraineeDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TraineeDto(String id, String email, String pw, String phone, String name, String addr, String detail_addr,
			String delflag, String auth) {
		super();
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.phone = phone;
		this.name = name;
		this.addr = addr;
		this.detail_addr = detail_addr;
		this.delflag = delflag;
		this.auth = auth;
	}


	@Override
	public String toString() {
		return "TraineeDto [id=" + id + ", email=" + email + ", pw=" + pw + ", phone=" + phone + ", name=" + name
				+ ", addr=" + addr + ", detail_addr=" + detail_addr + ", delflag=" + delflag + ", auth=" + auth + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getDetail_addr() {
		return detail_addr;
	}


	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}


	public String getDelflag() {
		return delflag;
	}


	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}


	public String getAuth() {
		return auth;
	}


	public void setAuth(String auth) {
		this.auth = auth;
	}
	

}
