package com.hrd.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrd.edu.dto.CounselDto;
import com.hrd.edu.model.dao.ICounselDao;


@Service
public class CounselServiceImpl implements ICounselService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ICounselDao dao;

	@Override
	public boolean trainee_CounselBook(CounselDto dto) {
		log.info("CounselServiceImpl trainee_CounselBook (사용자) 상담 예약 신청 {}", dto);
		return dao.trainee_CounselBook(dto);
	}

	@Override
	public boolean trainee_CounselModify(String seq) {
		log.info("CounselServiceImpl trainee_CounselModify (사용자) 상담 예약 수정 {}", seq);
		return dao.trainee_CounselModify(seq);
	}

	@Override
	public boolean trainee_CounselDelete(String seq) {
		log.info("CounselServiceImpl trainee_CounselDelete (사용자) 상담 예약 삭제 {}", seq);
		return dao.trainee_CounselDelete(seq);
	}

	@Override
	public List<CounselDto> trainee_CounselLists(String id) {
		log.info("CounselServiceImpl trainee_CounselLists (사용자) 상담 예약 목록 조회 {}", id);
		return dao.trainee_CounselLists(id);
	}

	@Override
	public CounselDto trainee_CounselDetail(Map<String, Object> map) {
		log.info("CounselServiceImpl trainee_CounselDetail (사용자) 상담 예약 상세 조회 {}", map);
		return dao.trainee_CounselDetail(map);
	}

	@Override
	public List<CounselDto> manager_CounselLists(String m_id) {
		log.info("CounselServiceImpl manager_CounselLists (담당자) 상담 예약 목록 조회 {}", m_id);
		return dao.manager_CounselLists(m_id);
	}

	@Override
	public CounselDto manager_CounselDetail(Map<String, Object> map) {
		log.info("CounselServiceImpl manager_CounselDetail (담당자) 상담 예약 상세 조회 {}", map);
		return dao.manager_CounselDetail(map);
	}

	@Override
	public boolean manager_CounselUpdate(String seq) {
		log.info("CounselServiceImpl manager_CounselUpdate (담당자) 상담 예약 상태 변경 {}", seq);
		return dao.manager_CounselUpdate(seq);
	}

	@Override
	public boolean manager_CounselShare(String seq) {
		log.info("CounselServiceImpl manager_CounselShare (마스터) 예약신청 배분 {}", seq);
		return dao.manager_CounselShare(seq);
	}
	
}
