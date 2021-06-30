package com.hrd.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrd.edu.dto.ManagerDto;

@Repository
public class ManagerDaoImpl implements IManagerDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	private String NS="com.hrd.edu.model.dao.ManagerDaoImpl.";
	
	@Override
	public boolean master_Insert(ManagerDto mDto) {
		int n=sqlSession.insert(NS+"master_Insert", mDto);
		return (n>0)?true:false;
	}

	@Override
	public boolean manager_Insert(ManagerDto mDto) {
		int n=sqlSession.insert(NS+"manager_Insert", mDto);
		return (n>0)?true:false;
	}

	@Override
	public ManagerDto manager_Login(ManagerDto mDto) {
		
		return sqlSession.selectOne(NS+"manager_Login", mDto);
	}

	@Override
	public boolean manager_IdChk(String id) {
		int n=sqlSession.selectOne(NS+"manager_IdChk", id);
		return (n>0)?false:true;
	}

	@Override
	public List<ManagerDto> manager_ManagerList(String inst_ino) {
		return sqlSession.selectList(NS+"manager_ManagerList", inst_ino);
	}

	@Override
	public ManagerDto manager_DetailInfo(String id) {
		return sqlSession.selectOne(NS+"manager_DetailInfo", id);
	}

	@Override
	public boolean manager_ModifyPw(Map<String, Object> map) {
		int n=sqlSession.update(NS+"manager_ModifyPw", map);
		return (n>0)?true:false;
	}

	@Override
	public boolean manager_ModifyInfo(Map<String, Object> map) {
		int n=sqlSession.update(NS+"manager_ModifyInfo", map);
		return (n>0)?true:false;
	}

	@Override
	public boolean manager_ModifyAuth(Map<String, Object> map) {
		int n=sqlSession.update(NS+"manager_MofifyAuth", map);
		return (n>0)?true:false;
	}
	
	
	
}
