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
import com.hrd.edu.dto.CounselDto;
import com.hrd.edu.dto.CounselDto2;
import com.hrd.edu.dto.TraineeDto;
import com.hrd.edu.model.service.ICounselService;

@Controller
public class CounselController {
private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICounselService service;
	
	@RequestMapping(value="/counselCalendar.do", method=RequestMethod.GET)
	public String counselCalendar(@RequestParam Map<String, Object> map,  HttpSession session) {
		log.info("CounselController counselCalendar 상담 예약 달력 게시판 메인페이지 {}",map);
		
//		System.out.println(cdto.getcListMdate());
//		
//		dto.setMdate(cdto.getMdate());
//		String yyyymm = dto.getMdate();
//		System.out.println(yyyymm);
		System.out.println(map);
		
		
//		map.put("yyyymm", year+date);
		
		
		String year = (String)map.get("year");
		String month = (String)map.get("month");
//		String date = (String)map.get("date");
		
		String yyyymm = year+month;
		String y = (String)map.get("year");
		String mm = CalendarUtil.twoWord(Integer.parseInt(yyyymm));
		map.put("yyyymm", yyyymm);
		
		List<CounselDto2> cList = service.counsel_getCalViewList(map);
		System.out.println(cList);
		session.setAttribute("cList", cList);
		
		return "counselCalendar";
	}
	
	@RequestMapping(value="/counselBook.do", method=RequestMethod.GET)
	public String counselBook(HttpServletRequest request) {
		log.info("CounselController counselBook (사용자) 상담 예약 글 작성하기");
		int year = Integer.parseInt(request.getParameter("year").trim()); //공백들어가면 오류나니까 꼭 trim()
		int month = Integer.parseInt(request.getParameter("month"));
		int date = Integer.parseInt(request.getParameter("date"));
		
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.set(year,month-1,date);
		
		int lastDay = gcal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int hour = gcal.get(Calendar.HOUR_OF_DAY);
		int minute = gcal.get(Calendar.MINUTE);
		
		System.out.printf("%d %d %d \n", lastDay, hour, minute);
		
		request.setAttribute("lastDay", lastDay);
		request.setAttribute("hour", hour);
		request.setAttribute("minute", minute);
		
		
		return "counselBookForm";
	}
	
	@RequestMapping(value="/counselBookForm.do", method=RequestMethod.POST)
	public String counselBookForm(CounselDto2 dto, HttpSession session, Model model) {
		log.info("CounselController counselBookForm (사용자) 상담 예약 글 작성 완료");
		CounselDto2 cDto2 = (CounselDto2)session.getAttribute("dto");
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
		log.info("CounselController counselDetail (사용자) 상담 예약 글 상세페이지");
		map.put("id", id);
		map.put("seq", seq);
		CounselDto2 cDto2 = service.trainee_CounselDetail(map);
		model.addAttribute(cDto2);
		return "counselDetail";
	}
		
	@RequestMapping(value="/manager_CounselLists.do", method=RequestMethod.GET)
	public String manager_CounselLists() {
		log.info("CounselController manager_CounselLists (담당자) 상담 예약 글 목록");

		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
}
