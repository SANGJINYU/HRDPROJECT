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
	
	

	@RequestMapping(value = "/traineeMain.do", method = RequestMethod.GET)
	public String main() {
		logger.info("MemberController traineeMain 이동");
		return "main";
	}
	
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("MemberController loginForm 이동");
		return "loginForm";
	}
	
	
	@RequestMapping(value = "/memberLogin.do", method = RequestMethod.POST)
	public String login(TraineeDto dto, HttpSession session,String id, String pw) {
		
		logger.info("MemberController 로그인 {}	", dto);

		TraineeDto tDto = service.trainee_Login(dto);
		System.out.println(tDto);
		
		if(tDto == null) {

			return "redirect:/logout.do";
			
		}else {
			session.setAttribute("t_info", tDto);
			return "redirect:/traineeMain.do";
		}
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
	
	@RequestMapping(value = "/signUpForm.do", method = RequestMethod.POST)
	public String signUpForm(TraineeDto dto) {
		
		boolean isc = service.trainee_Insert(dto);
		
		if(isc) {
			
			return "redirect:/loginForm.do";
			
		}else {
			
			return "javascript:alert('회원가입실패하셨어요')";
			
		}
		
		
	}
	
}
