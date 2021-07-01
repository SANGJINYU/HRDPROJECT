package com.hrd.edu.ctrl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrd.edu.dto.ManagerDto;
import com.hrd.edu.model.service.IManagerService;

@Controller
public class ManagerController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IManagerService mService;
	
	//마스터 회원가입 페이지로 이동
	@RequestMapping(value = "/managerSignUpForm.do", method = RequestMethod.GET)
	public String signupForm() {
		log.info("마스터 회원가입 페이지로 이동");
		return "managerSignUpForm";
	}
	
	//마스터의 계정생성
	@RequestMapping(value = "/masterInsert.do",method = RequestMethod.POST)
	public String master_Insert(ManagerDto dto) {
		log.info("마스터의 계정생성");
		boolean isc=mService.master_Insert(dto);
		return isc?"loginForm":"javascript:alert('계정 생성 실패')";    //??
	}
	
	//마스터로그인 후 상담사 계정생성
	@RequestMapping(value = "/managerInsert.do", method = RequestMethod.POST)
	public String manager_Insert(ManagerDto dto) {
		log.info("마스터로그인 후 상담사 계정생성");
		boolean isc= mService.manager_Insert(dto);
		
		return isc?"loginForm":"javascript:alert('계정 생성 실패')";   //??
	}
	
	//담당자 로그인
	@RequestMapping(value = "/managerLogin",method = RequestMethod.POST)
	public String manager_Login(ManagerDto dto,HttpSession session) {
		log.info("담당자 로그인{}",dto);
		ManagerDto mDto=  mService.manager_Login(dto);
		if (mDto!=null) {
			log.info("담당자 로그인 성공 : {}",mDto );
			session.setAttribute("m_info", mDto);
			return "managerMain";
			
		} else {
			log.info("담당자 로그인 실패");
			return null;
		}
	}
	
	//	(관리자) 아이디 중복체크
	@RequestMapping(value = "/managerIdChk.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean manager_IdChk(@RequestParam String id) {
		boolean isc=mService.manager_IdChk(id);
		
		return isc;
	}
	
	//(담당자) 목록리스트로 이동
	@RequestMapping(value = "/mListForm.do",method = RequestMethod.GET)
	public String manager_ListForm() {
		
		return "redirect:/managerList.do";
	}
	
//	마스터가 (담당자)목록보기
	@RequestMapping(value = "/managerList.do",method = RequestMethod.GET)
	public String manager_ManagerList(HttpSession session, Model model) {
		
		ManagerDto dto= (ManagerDto)session.getAttribute("m_info");
		List<ManagerDto> lists= mService.manager_ManagerList(dto.getInst_ino());
		model.addAttribute("m_list", lists);
		return "managerList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
