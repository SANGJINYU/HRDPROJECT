package com.hrd.edu.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrd.edu.model.dao.IInterestDao;

@Service
public class InterestServiceImpl implements IInterestService {

	@Autowired
	private IInterestDao dao;
	

	@Override
	public boolean myInterest(Map<String, Object> map) {
		return dao.myInterest(map);
	}

}
