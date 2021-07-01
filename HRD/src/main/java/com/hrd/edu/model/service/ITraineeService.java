package com.hrd.edu.model.service;

import java.util.Map;

import com.hrd.edu.dto.TraineeDto;

public interface ITraineeService {

	//사용자 회원가입
	public boolean trainee_Insert(TraineeDto dto);
	
	//사용자 로그인
	public TraineeDto trainee_Login(Map<String,Object> map);
	
	//사용자 아이디 중복체크
	public boolean trainee_IdChk(String id);
	
	//사용자 아이디 찾기
	public String trainee_SearchId(String email);
	
	//사용자 비밀번호 찾기
	public String trainee_SearchPw(TraineeDto dto);
	
	//사용자 내정보 보기
	public TraineeDto trainee_DetailInfo(String id);
	
	//사용자 정보 변경
	public boolean trainee_modifyInfo(Map<String, Object>map);
	
	//사용자 계정 상태 변경(탈퇴)
	public boolean trainee_DelUser(String id);
}
