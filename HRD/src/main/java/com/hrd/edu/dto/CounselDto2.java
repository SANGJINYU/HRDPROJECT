package com.hrd.edu.dto;

import java.util.Date;

public class CounselDto2 {

	private int seq;
	private String m_id;
	private String id;
	private String content;
	private int degr;
	private String trpr_id;
	private int trpr_degr;
	private String trpr_nm;
	private Date regdate;
	private String flag;
	private String mdate;
	
	private ManagerDto2 mdto2;
	
	public CounselDto2() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CounselDto2(int seq, String m_id, String id, String content, int degr, String trpr_id, int trpr_degr,
			String trpr_nm, Date regdate, String flag, String mdate) {
		super();
		this.seq = seq;
		this.m_id = m_id;
		this.id = id;
		this.content = content;
		this.degr = degr;
		this.trpr_id = trpr_id;
		this.trpr_degr = trpr_degr;
		this.trpr_nm = trpr_nm;
		this.regdate = regdate;
		this.flag = flag;
		this.mdate = mdate;
	}


	@Override
	public String toString() {
		return "CounselDto [seq=" + seq + ", m_id=" + m_id + ", id=" + id + ", content=" + content + ", degr=" + degr
				+ ", trpr_id=" + trpr_id + ", trpr_degr=" + trpr_degr + ", trpr_nm=" + trpr_nm + ", regdate=" + regdate
				+ ", flag=" + flag + ", mdate=" + mdate + "]";
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getDegr() {
		return degr;
	}


	public void setDegr(int degr) {
		this.degr = degr;
	}


	public String getTrpr_id() {
		return trpr_id;
	}


	public void setTrpr_id(String trpr_id) {
		this.trpr_id = trpr_id;
	}


	public int getTrpr_degr() {
		return trpr_degr;
	}


	public void setTrpr_degr(int trpr_degr) {
		this.trpr_degr = trpr_degr;
	}


	public String getTrpr_nm() {
		return trpr_nm;
	}


	public void setTrpr_nm(String trpr_nm) {
		this.trpr_nm = trpr_nm;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


	public String getMdate() {
		return mdate;
	}


	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	

	
}
