package com.hrd.edu.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrd.edu.dto.ManagerDto;
import com.hrd.edu.model.service.IManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	private IManagerService mService;
	
	@RequestMapping(value = "/signupForm.do", method = RequestMethod.GET)
	public String signupForm() {
		return "signup";
	}
	
	
	@RequestMapping(value = "/masterInsert.do",method = RequestMethod.POST)
	public String master_Insert(ManagerDto dto) {
		boolean isc=mService.master_Insert(dto);
		return isc?"login":"signup";
	}
	
	@RequestMapping(value = "/managerInsert.do", method = RequestMethod.POST)
	public String manager_Insert(ManagerDto dto) {
		boolean isc= mService.manager_Insert(dto);
		
		return isc?"login":"signup";
	}
	
	
}
