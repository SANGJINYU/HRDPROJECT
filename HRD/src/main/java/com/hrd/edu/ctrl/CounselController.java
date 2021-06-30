package com.hrd.edu.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrd.edu.model.service.ICounselService;

@Controller
public class CounselController {
private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICounselService service;
	
	@RequestMapping(value="/counselBook.do", method=RequestMethod.GET)
	public String counselBook() {
		log.info("CounselController counselBook 상담예약하기");
		return "counselBook";
	}
	@RequestMapping(value="/BookForm.do", method=RequestMethod.POST)
	public String BookForm() {
		log.info("CounselController BookForm 상담예약 폼작성완료");

		return "";
	}
	
}
