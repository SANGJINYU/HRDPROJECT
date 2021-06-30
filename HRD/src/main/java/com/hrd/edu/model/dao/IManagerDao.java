package com.hrd.edu.model.dao;

import java.util.List;
import java.util.Map;

import com.hrd.edu.dto.ManagerDto;

public interface IManagerDao {

	//	마스터 회원가입
	public boolean master_Insert(ManagerDto mDto);
	
	//	마스터가 (담당자)계정생성
	public boolean manager_Insert(ManagerDto mDto);
	
	//	담당자 로그인
	public ManagerDto manager_Login(ManagerDto mDto);
	
	//	(관리자) 아이디 중복체크
	public boolean manager_IdChk(String id);
	
	//	마스터가 (담당자)목록보기
	public List<ManagerDto> manager_ManagerList(String inst_ino);
	
	//	(담당자)상세 정보 보기
	public ManagerDto manager_DetailInfo(String id);
	
	//	(담당자) 비밀번호 변경
	public boolean manager_ModifyPw(Map<String, Object> map);
	
	//	(담당자) 정보 변경
	public boolean manager_ModifyInfo(Map<String, Object> map);
	
	//	(담당자) 계정 상태 변경(M/Y/N)
	public boolean manager_ModifyAuth(Map<String, Object> map);

}
