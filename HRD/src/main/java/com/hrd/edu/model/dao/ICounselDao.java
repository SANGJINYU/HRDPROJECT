package com.hrd.edu.model.dao;

import java.util.List;
import java.util.Map;

import com.hrd.edu.dto.CounselDto2;
import com.hrd.edu.dto.ManagerDto;

public interface ICounselDao {

	// 공통 _ 달별 일별 리스트
	public List<CounselDto2> counsel_getCalViewList(Map<String, Object> map);

	// (사용자) 상담 예약 신청
	public boolean trainee_CounselBook(CounselDto2 dto);

	// (사용자) 상담 예약 수정
	public boolean trainee_CounselModify(String seq);

	// (사용자) 상담 예약 삭제
	public boolean trainee_CounselDelete(String seq);

	// (사용자) 상담 예약 목록 조회
	public List<CounselDto2> trainee_CounselLists(String id);

	// (사용자) 상담 예약 상세 조회
	public CounselDto2 trainee_CounselDetail(Map<String, Object> map);

	// (담당자) 상담 예약 목록 조회
	public List<ManagerDto> manager_CounselLists(String m_id);

	// (담당자) 상담 예약 상세 조회
	public ManagerDto manager_CounselDetail(Map<String, Object> map);

	// (담당자) 상담 예약 상태 변경
	public boolean manager_CounselUpdate(String seq);

	// (마스터) 예약신청 배분
	public boolean manager_CounselShare(String seq);

}
