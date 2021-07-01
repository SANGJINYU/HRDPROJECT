package com.hrd.edu.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InterestDaoImpl implements IInterestDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean myInterest(Map<String, Object> map) {
		
		logger.info("InterestDaoImpl myInterest {}", map);
		int n = session.insert("com.hrd.edu.model.dao.InterestDaoImpl.", map);
		return (n>0)?true:false;
		
	}

	@Override
	public boolean outcome(Map<String, Object> map) {
		
		int n =session.insert("com.hrd.edu.model.dao.InterestDaoImpl.", map);
		return (n>0)?true:false;
	}

}
