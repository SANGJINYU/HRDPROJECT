package com.hrd.edu.dto;

public class CurriculumDto {

	private String acceptflag;
	private String id;
	private int outcome_seq;
	private int seq;
	
	
	public CurriculumDto() {
		
		super();
		// TODO Auto-generated constructor stub
	}


	public CurriculumDto(String acceptflag, String id, int outcome_seq, int seq) {
		super();
		this.acceptflag = acceptflag;
		this.id = id;
		this.outcome_seq = outcome_seq;
		this.seq = seq;
	}


	@Override
	public String toString() {
		return "CurriculumDto [acceptflag=" + acceptflag + ", id=" + id + ", outcome_seq=" + outcome_seq + ", seq="
				+ seq + "]";
	}


	public String getAcceptflag() {
		return acceptflag;
	}


	public void setAcceptflag(String acceptflag) {
		this.acceptflag = acceptflag;
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


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}

	
}
