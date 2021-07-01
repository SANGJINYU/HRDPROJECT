package com.hrd.edu.ctrl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrd.edu.dto.TraineeDto;
import com.hrd.edu.model.dao.IInterestDao;

@Controller
public class InterestController {

	@Autowired
	private IInterestDao service;
	
	@RequestMapping(value = "/interestList.do", method = RequestMethod.GET)
	public String myInterest(@RequestParam Map<String,Object>map ,HttpSession session) {
					
	
		return "interesList";
	}
	
	@RequestMapping(value = "/outcome.do", method = RequestMethod.GET)
	public String outcome(@RequestParam Map<String,Object>map ,HttpSession session) {
					
		service.outcome(map);
		
		return "interesList";
	}
}
