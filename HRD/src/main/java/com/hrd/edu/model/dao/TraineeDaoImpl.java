package com.hrd.edu.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrd.edu.dto.TraineeDto;

@Repository
public class TraineeDaoImpl implements ITraineeDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private final String NS= "com.hrd.edu.model.dao.MemberDaoImpl.";
	
	@Override
	public boolean trainee_Insert(TraineeDto dto) {
		int n = session.insert(NS+"trainee_Insert", dto);
		return (n>0)?true:false;
	}

	@Override
	public TraineeDto trainee_Login(TraineeDto dto) {
		return session.selectOne(NS+"trainee_Login", dto);
	}

	@Override
	public int trainee_IdChk(String id) {
		return session.selectOne(NS+"trainee_IdChk", id);
	}

	@Override
	public String trainee_SearchId(String email) {
		return session.selectOne(NS+"trainee_SearchId", email);
	}

	@Override
	public String trainee_SearchPw(TraineeDto dto) {
		return session.selectOne(NS+"trainee_SearchPw", dto);
	}

	@Override
	public TraineeDto trainee_DetailInfo(String id) {
		return session.selectOne(NS+"trainee_DetailInfo", id);
	}

	@Override
	public boolean trainee_modifyInfo(Map<String, Object> map) {
		int n  = session.update(NS+"trainee_modifyInfo", map);
		return (n>0)?true:false;
	}

	@Override
	public boolean trainee_DelUser(String id) {
		int n = session.update(NS+"trainee_DelUser", id);
		return (n>0)?true:false;
	}

}
