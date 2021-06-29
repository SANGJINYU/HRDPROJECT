package com.hrd.edu.dto;

/**
 * Outcome(1)과 Interest(1) join dto
 */
public class OutcomeInterestDto {

	private int seq;
	private String inst_ino;
	private String trpr_id;
	private String trpr_degr;
	private String json;
	
	private InterestDto interestDto;

	public OutcomeInterestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OutcomeInterestDto(int seq, String inst_ino, String trpr_id, String trpr_degr, String json,
			InterestDto interestDto) {
		super();
		this.seq = seq;
		this.inst_ino = inst_ino;
		this.trpr_id = trpr_id;
		this.trpr_degr = trpr_degr;
		this.json = json;
		this.interestDto = interestDto;
	}

	@Override
	public String toString() {
		return "OutcomeInterestDto [seq=" + seq + ", inst_ino=" + inst_ino + ", trpr_id=" + trpr_id + ", trpr_degr="
				+ trpr_degr + ", json=" + json + ", interestDto=" + interestDto + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getInst_ino() {
		return inst_ino;
	}

	public void setInst_ino(String inst_ino) {
		this.inst_ino = inst_ino;
	}

	public String getTrpr_id() {
		return trpr_id;
	}

	public void setTrpr_id(String trpr_id) {
		this.trpr_id = trpr_id;
	}

	public String getTrpr_degr() {
		return trpr_degr;
	}

	public void setTrpr_degr(String trpr_degr) {
		this.trpr_degr = trpr_degr;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public InterestDto getInterestDto() {
		return interestDto;
	}

	public void setInterestDto(InterestDto interestDto) {
		this.interestDto = interestDto;
	}
	
		
}
