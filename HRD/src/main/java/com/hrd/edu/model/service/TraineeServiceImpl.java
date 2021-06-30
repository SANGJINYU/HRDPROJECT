package com.hrd.edu.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrd.edu.dto.TraineeDto;
import com.hrd.edu.model.dao.ITraineeDao;

@Service
public class TraineeServiceImpl implements ITraineeService {

	@Autowired
	private ITraineeDao dao;
	
	@Override
	public boolean trainee_Insert(TraineeDto dto) {
		return dao.trainee_Insert(dto);
	}

	@Override
	public TraineeDto trainee_Login(TraineeDto dto) {
		return dao.trainee_Login(dto);
	}

	@Override
	public boolean trainee_IdChk(String id) {
		int n = dao.trainee_IdChk(id);
		return (n>0)?true:false;
	}

	@Override
	public String trainee_SearchId(String email) {
		return dao.trainee_SearchId(email);
	}

	@Override
	public String trainee_SearchPw(TraineeDto dto) {
		return dao.trainee_SearchPw(dto);
	}

	@Override
	public TraineeDto trainee_DetailInfo(String id) {
		return dao.trainee_DetailInfo(id);
	}

	@Override
	public boolean trainee_modifyInfo(Map<String, Object> map) {
		return dao.trainee_modifyInfo(map);
	}

	@Override
	public boolean trainee_DelUser(String id) {
		return dao.trainee_DelUser(id);
	}

}
