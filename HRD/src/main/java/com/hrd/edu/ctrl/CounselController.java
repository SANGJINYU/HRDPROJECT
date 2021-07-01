package com.hrd.edu.ctrl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrd.edu.comm.CalendarUtil;
import com.hrd.edu.dto.CounselDto2;
import com.hrd.edu.dto.ManagerDto;
import com.hrd.edu.model.service.ICounselService;

@Controller
public class CounselController {
private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICounselService service;
	
	@RequestMapping(value="/counselCalendar.do", method=RequestMethod.GET)
	public String counselCalendar(@RequestParam Map<String, Object> map,  HttpSession session,HttpServletRequest request) {
		log.info("CounselController counselCalendar 상담 예약 달력 게시판 메인페이지 {}",map);
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		
		String paramYear = request.getParameter("year");
		String paramMonth = request.getParameter("month");
		
		System.out.printf("%s. %s \n", paramYear, paramMonth);
		
		if(paramYear != null){
			year = Integer.parseInt(paramYear);
		}
		if(paramMonth != null){
			month = Integer.parseInt(paramMonth);
		}
		cal.set(year,month-1, 1);

		String yyyymm=year+CalendarUtil.twoWord(month);
		System.out.printf("%s. %s, %s \n", year, month, yyyymm);
		
		map.put("yyyymm", yyyymm);
		
		System.out.println("--------------map : =========="+map);
		
		List<CounselDto2> cList = service.counsel_getCalViewList(map);
		System.out.println(cList);
		session.setAttribute("cList", cList);
		
		return "counselCalendar";
	}

	
	@RequestMapping(value="/counselBook.do", method=RequestMethod.GET)
	public String counselBook(HttpServletRequest request) {
		log.info("CounselController counselBook (사용자) 상담 예약 글 작성하기");
		int year = Integer.parseInt(request.getParameter("year").trim());
		int month = Integer.parseInt(request.getParameter("month"));
		int date = Integer.parseInt(request.getParameter("date"));
		
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.set(year,month-1,date);
		
		int lastDay = gcal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		System.out.printf("%d \n", lastDay);
		
		request.setAttribute("lastDay", lastDay);

		
		return "counselBookForm";
	}
	
	@RequestMapping(value="/counselBookForm.do", method=RequestMethod.POST)
	public String counselBookForm(CounselDto2 dto, HttpSession session, Model model) {
		log.info("CounselController counselBookForm (사용자) 상담 예약 글 작성 완료");
		CounselDto2 cDto2 = (CounselDto2)session.getAttribute("cList");
		System.out.println("==========================================="+cDto2);
		dto.setId(cDto2.getId());
		boolean isc = service.trainee_CounselBook(cDto2);
		if(isc) {
			model.addAttribute("cDto2", dto);
			return "redirect:counselDetail.do?seq="+dto.getSeq()+"&id="+dto.getId();
		}else {
			return "counselCalendar";
		}
	}
	
	@RequestMapping(value="/counselDetail.do", method=RequestMethod.GET)
	public String counselDetail(Map<String, Object> map, Model model, String id, String seq) {
		log.info("CounselController counselDetail (사용자) 상담 예약 글 상세페이지 {}", map);
		map.put("id", id);
		map.put("seq", seq);
		CounselDto2 cDto2 = service.trainee_CounselDetail(map);
		model.addAttribute("cDto2",cDto2);
		return "counselDetail";
	}
		
	@RequestMapping(value="/manager_CounselLists.do", method=RequestMethod.GET)
	public String manager_CounselLists(HttpSession session, HttpServletRequest request) {
		ManagerDto m_info = (ManagerDto)session.getAttribute("m_info");
		log.info("CounselController manager_CounselLists (담당자) 상담 예약 글 목록 {}",m_info);
		String id = m_info.getId();
		System.out.println(id);
		
		List<ManagerDto> mList = service.manager_CounselLists(id);
		
		return "manager_CounselLists";
	}
	
	@RequestMapping(value="/manager_CounselDetail.do", method=RequestMethod.GET)
	public String manager_CounselDetail(@RequestParam Map<String, Object> map, HttpSession session) {
		log.info("CounselController manager_CounselDetail (담당자) 상담 예약 글 상세 조회 {}",map);
		ManagerDto dto=(ManagerDto)session.getAttribute("m_info");
		
		map.put("id",dto.getM_id());
		
		ManagerDto mdto = service.manager_CounselDetail(map);
		session.setAttribute("mdto", mdto);
		return "counselDetail";
	}
	
	
	
	
	
	
	
	
	
	
}
