package com.hrd.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrd.edu.dto.TraineeDto;
import com.hrd.edu.model.service.ITraineeService;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ITraineeService service;
	
	

	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String main() {
		
		return "main";
	}
	
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("MemberController loginForm 이동");
		return "loginForm";
	}
	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(TraineeDto dto, Model model, HttpSession session) {
		
		logger.info("MemberController 로그인 {}", dto);
		
		TraineeDto tDto = service.trainee_Login(dto);
		
		session.setAttribute("trainee", tDto);
		
		return "main";
		
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		logger.info("MemberController 로그아웃 ");
		
		session.invalidate();
		
		return "redirect:/loginForm.do";
	}
	
	
	@RequestMapping(value = "/signUp.do", method = RequestMethod.GET)
	public String signUp() {
		
		logger.info("MemberController signUp 회원가입 이동 ");
		
		return "signUpForm";
	}
	

	@RequestMapping(value = "/idChk.do", method = RequestMethod.POST)
	@ResponseBody
	public String idCheck(String id) {
		
		logger.info("MemberController idCheck 아이디 중복검사 {} ",id);
		
		boolean isc = service.trainee_IdChk(id);
		
		return String.valueOf(isc);
		
	}
	
}
