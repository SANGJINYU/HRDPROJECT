package com.hrd.edu.model.service;

import java.util.List;
import java.util.Map;

import com.hrd.edu.dto.CounselDto;

public interface ICounselService {

	//	(사용자) 상담 예약 신청
	public boolean trainee_CounselBook(CounselDto dto);
	//	(사용자) 상담 예약 수정
	public boolean trainee_CounselModify(String seq);
	//	(사용자) 상담 예약 삭제
	public boolean trainee_CounselDelete(String seq);
	//	(사용자) 상담 예약 목록 조회
	public List<CounselDto>trainee_CounselLists(String id);
	//	(사용자) 상담 예약 상세 조회
	public CounselDto trainee_CounselDetail(Map<String, Object> map);
	//	(담당자) 상담 예약 목록 조회
	public List<CounselDto>manager_CounselLists(String m_id);
	//	(담당자) 상담 예약 상세 조회
	public CounselDto manager_CounselDetail(Map<String, Object> map);
	//	(담당자) 상담 예약 상태 변경
	public boolean manager_CounselUpdate(String seq);
	//	(마스터) 예약신청 배분
	public boolean manager_CounselShare(String seq);
}
