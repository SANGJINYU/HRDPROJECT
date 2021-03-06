package com.hrd.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrd.edu.dto.CounselDto2;
import com.hrd.edu.dto.ManagerDto;


@Repository
public class CounselDaoImpl implements ICounselDao {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	private final String NS = "com.hrd.edu.model.dao.CounselDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CounselDto2> counsel_getCalViewList(Map<String, Object> map) {
		log.info("CounselDaoImpl counsel_getCalViewList (공통) 달별 일별 리스트 {}",map);
		return sqlSession.selectList(NS+"counsel_getCalViewList", map);
	}
	
	@Override
	public int counsel_getCounselCount(Map<String, Object> map) {
		log.info("CounselDaoImpl counsel_getCounselCount (공통) 일정개수 {}",map);
		return sqlSession.selectOne(NS+"counsel_getCounselCount", map);
	}
	
	@Override
	public boolean trainee_CounselBook(CounselDto2 dto) {
		log.info("CounselDaoImpl trainee_CounselBook (사용자) 상담 예약 신청 {}",dto);
		int n = sqlSession.insert(NS+"trainee_CounselBook",dto);
		return (n>0)?true:false;
	}

	@Override
	public boolean trainee_CounselModify(String seq) {
		log.info("CounselDaoImpl trainee_CounselModify (사용자) 상담 예약 수정 {}", seq);
		int n = sqlSession.update(NS+"trainee_CounselModify", seq);
		return (n>0)?true:false;
	}

	@Override
	public boolean trainee_CounselDelete(String seq) {
		log.info("CounselDaoImpl trainee_CounselDelete (사용자) 상담 예약 삭제 {}", seq);
		int n = sqlSession.update(NS+"trainee_CounselDelete", seq);
		return (n>0)?true:false;
	}

	@Override
	public List<CounselDto2> trainee_CounselLists(String id) {
		log.info("CounselDaoImpl trainee_CounselLists (사용자) 상담 예약 목록 조회 {}", id);
		return sqlSession.selectList(NS+"trainee_CounselLists");
	}

	@Override
	public CounselDto2 trainee_CounselDetail(Map<String, Object> map) {
		log.info("CounselDaoImpl trainee_CounselDetail (사용자) 상담 예약 상세 조회 {}", map);
		CounselDto2 dto = null;
		dto = sqlSession.selectOne(NS+"trainee_CounselDetail", map);
		return dto;
	}

	@Override
	public List<ManagerDto> manager_CounselLists(String m_id) {
		log.info("CounselDaoImpl manager_CounselLists (담당자) 상담 예약 목록 조회 {}", m_id);
		return sqlSession.selectList(NS+"manager_CounselLists");
	}

	@Override
	public ManagerDto manager_CounselDetail(Map<String, Object> map) {
		log.info("CounselDaoImpl manager_CounselDetail (담당자) 상담 예약 상세 조회 {}", map);
		ManagerDto dto = null;
		dto = sqlSession.selectOne(NS+"manager_CounselDetail", map);
		return dto;
	}

	@Override
	public boolean manager_CounselUpdate(String seq) {
		log.info("CounselDaoImpl manager_CounselUpdate (담당자) 상담 예약 상태 변경 {}", seq);
		int n = sqlSession.update(NS+"manager_CounselUpdate", seq);
		return (n>0)?true:false;
	}

	@Override
	public boolean manager_CounselShare(String seq) {
		log.info("CounselDaoImpl manager_CounselShare (마스터) 예약신청 배분 {}", seq);
		int n = sqlSession.update(NS+"manager_CounselUpdate", seq);
		return (n>0)?true:false;
	}

	

	
	
	
	
}
