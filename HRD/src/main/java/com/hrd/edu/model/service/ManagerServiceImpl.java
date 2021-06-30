package com.hrd.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrd.edu.dto.ManagerDto;
import com.hrd.edu.model.dao.IManagerDao;

@Service
public class ManagerServiceImpl implements IManagerService {
	@Autowired
	private IManagerDao mDao;
	
	private Logger log= LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean master_Insert(ManagerDto mDto) {
		log.info("ManagerServiceImpl master_Insert실행");
		return mDao.master_Insert(mDto);
	}

	@Override
	public boolean manager_Insert(ManagerDto mDto) {
		log.info("ManagerServiceImpl manager_Insert실행");
		return mDao.manager_Insert(mDto);
	}

	@Override
	public ManagerDto manager_Login(ManagerDto mDto) {
		log.info("ManagerServiceImpl manager_Login실행");
		return mDao.manager_Login(mDto);
	}

	@Override
	public boolean manager_IdChk(String id) {
		log.info("ManagerServiceImpl manager_IdChk실행");
		return mDao.manager_IdChk(id);
	}

	@Override
	public List<ManagerDto> manager_ManagerList(String inst_ino) {
		log.info("ManagerServiceImpl manager_ManagerList실행");
		return mDao.manager_ManagerList(inst_ino);
	}

	@Override
	public ManagerDto manager_DetailInfo(String id) {
		log.info("ManagerServiceImpl manager_DetailInfo실행");
		return mDao.manager_DetailInfo(id);
	}

	@Override
	public boolean manager_ModifyPw(Map<String, Object> map) {
		log.info("ManagerServiceImpl manager_ModifyPw실행");
		return mDao.manager_ModifyPw(map);
	}

	@Override
	public boolean manager_ModifyInfo(Map<String, Object> map) {
		log.info("ManagerServiceImpl manager_ModifyInfo실행");
		return mDao.manager_ModifyInfo(map);
	}

	@Override
	public boolean manager_ModifyAuth(Map<String, Object> map) {
		log.info("ManagerServiceImpl manager_MofifyAuth실행");
		return mDao.manager_ModifyAuth(map);
	}
}
