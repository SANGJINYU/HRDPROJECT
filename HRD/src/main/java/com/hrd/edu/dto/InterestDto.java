package com.hrd.edu.dto;

public class InterestDto {

	private int seq;
	private String id;
	private int outcome_seq;
	private String delflag;
	
	
	public InterestDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InterestDto(int seq, String id, int outcome_seq, String delflag) {
		super();
		this.seq = seq;
		this.id = id;
		this.outcome_seq = outcome_seq;
		this.delflag = delflag;
	}


	@Override
	public String toString() {
		return "InterestDto [seq=" + seq + ", id=" + id + ", outcome_seq=" + outcome_seq + ", delflag=" + delflag + "]";
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getOutcome_seq() {
		return outcome_seq;
	}


	public void setOutcome_seq(int outcome_seq) {
		this.outcome_seq = outcome_seq;
	}


	public String getDelflag() {
		return delflag;
	}


	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	
	
}
