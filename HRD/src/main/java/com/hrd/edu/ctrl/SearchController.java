package com.hrd.edu.ctrl;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search.do", method = RequestMethod.GET , produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String course2(String url, Model model) throws IOException {
		
		System.out.println("url : " + url );
		Document doc = Jsoup.connect(url).get();
		Elements els = doc.select("scn_list");
		JSONObject result = new JSONObject();
		JSONArray jlist = new JSONArray();
		for(Element el : els) {
			JSONObject jObj = new JSONObject();;
			el.select("address"); // 주소
//			el.select("contents");
//			el.select("courseMan");
//			el.select("eiEmplCnt3");
//			el.select("eiEmplCnt3Gt10");
//			el.select("eiEmplRate3");
//			el.select("eiEmplRate6");
//			el.select("grade");
//			el.select("imgGubun");
//			el.select("instCd");
//			el.select("ncsCd");
//			el.select("realMan");
//			el.select("regCourseMan");
//			el.select("subTitle");
//			el.select("subTitleLink");
//			el.select("superViser");
//			el.select("telNo");
//			el.select("title");
//			el.select("titleIcon");
//			el.select("titleLink");
			el.select("traEndDate"); //과정 종료일
			el.select("traStartDate"); // 과정 시작일
//			el.select("trainTarget");
//			el.select("trainTargetCd");
			el.select("trainstCstId"); // 기관ID 
			el.select("trprDegr"); // 훈련회차 
//			el.select("trprId");
//			el.select("yardMan");
			String trprId = el.select("trprId").toString().replace("<trprId>", "").replace("</trprId>", "").trim();//훈련과정 ID
			String trprDegr = el.select("trprDegr").toString().replace("<trprDegr>", "").replace("</trprDegr>", "").trim();//훈련 회차
			String trainstCstId = el.select("trainstCstId").toString().replace("<trainstCstId>", "").replace("</trainstCstId>", "").trim();//훈련기관 ID
			
			System.out.println("차수 : " +trprDegr);
		
				String detailurl ="http://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_2.jsp?"
						+ "authKey=zTTgDhnacOrKYEU7PyiCIPquwdPOJFDO&"
						+ "returnType=XML&"
						+ "outType=2&"
						+ "srchTrprId="+trprId+"&"  
						+ "srchTrprDegr="+trprDegr+"&"	
						+ "srchTorgId="+trainstCstId; //기관 일단 이거 다 넘기고
			
			Document detailsdoc = Jsoup.connect(detailurl).get();
			Elements detailEls = detailsdoc.select("inst_base_info");
			
			
			
			jObj.put("address", el.select("address").toString().replace("<address>", "").replace("</address>", "").trim());//주소
			jObj.put("addr1", detailEls.select("addr1").toString().replace("<addr1>", "").replace("</addr1>", "").trim());
			jObj.put("addr2", detailEls.select("addr2").toString().replace("<addr2>", "").replace("</addr2>", "").trim());
			jObj.put("hpAddr", detailEls.select("hpAddr").toString().replace("<hpAddr>", "").replace("</hpAddr>", "").trim());		
			jObj.put("instIno", detailEls.select("instIno").toString().replace("<instIno>", "").replace("</instIno>", "").trim());
			jObj.put("subTitle", el.select("subTitle").toString().replace("<subTitle>", "").replace("</subTitle>", "").trim());
			jObj.put("trDcnt", detailEls.select("trDcnt").toString().replace("<trDcnt>", "").replace("</trDcnt>", "").trim());
			jObj.put("trprChap", detailEls.select("trprChap").toString().replace("<trprChap>", "").replace("</trprChap>", "").trim());
			jObj.put("trprChapEmail", detailEls.select("trprChapEmail").toString().replace("<trprChapEmail>", "").replace("</trprChapEmail>", "").trim());
			jObj.put("trprChapTel", detailEls.select("trprChapTel").toString().replace("<trprChapTel>", "").replace("</trprChapTel>", "").trim());
			jObj.put("trprDegr", detailEls.select("trprDegr").toString().replace("<trprDegr>", "").replace("</trprDegr>", "").trim());
			jObj.put("trprId", detailEls.select("trprId").toString().replace("<trprId>", "").replace("</trprId>", "").trim());			
			jObj.put("trprNm", detailEls.select("trprNm").toString().replace("<trprNm>", "").replace("</trprNm>", "").trim());
			jObj.put("trtm", detailEls.select("trtm").toString().replace("<trtm>", "").replace("</trtm>", "").trim());
			jObj.put("inoNm", detailEls.select("inoNm").toString().replace("<inoNm>", "").replace("</inoNm>", "").trim());
			jObj.put("traStartDate", el.select("traStartDate").toString().replace("<traStartDate>", "").replace("</traStartDate>", "").trim());
			jObj.put("traEndDate", el.select("traEndDate").toString().replace("<traEndDate>", "").replace("</traEndDate>", "").trim());
			jObj.put("yardMan", el.select("yardMan").toString().replace("<yardMan>", "").replace("</yardMan>", "").trim());
			
			
			jlist.add(jObj);
			System.out.println("사이즈 : " +jlist.size());
			
//			}
		}
		
		result.put("info", jlist);
		System.out.println(result.toString());
		
		return result.toString(); 
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	@ResponseBody
	public String detail(String url, Model model) throws IOException {
		
		System.out.println("url 정보 왜 짤리는가?: " + url );
		Document doc = Jsoup.connect(url).get();
		Elements els = doc.select("scn_list");
		JSONObject result = new JSONObject();
		JSONArray jlist = new JSONArray();
		for(Element el : els) {	
			JSONObject jObj = new JSONObject();;
			el.select("address"); // 주소
//			el.select("contents");
//			el.select("courseMan");
//			el.select("eiEmplCnt3");
//			el.select("eiEmplCnt3Gt10");
//			el.select("eiEmplRate3");
//			el.select("eiEmplRate6");
//			el.select("grade");
//			el.select("imgGubun");
//			el.select("instCd");
//			el.select("ncsCd");
//			el.select("realMan");
//			el.select("regCourseMan");
//			el.select("subTitle");
//			el.select("subTitleLink");
//			el.select("superViser");
//			el.select("telNo");
//			el.select("title");
//			el.select("titleIcon");
//			el.select("titleLink");
			el.select("traEndDate"); //과정 종료일
			el.select("traStartDate"); // 과정 시작일
//			el.select("trainTarget");
//			el.select("trainTargetCd");
			el.select("trainstCstId"); // 기관ID 
			el.select("trprDegr"); // 훈련회차 
//			el.select("trprId");
//			el.select("yardMan");
			String trprId = el.select("trprId").toString().replace("<trprId>", "").replace("</trprId>", "").trim();//훈련과정 ID
			String trprDegr = el.select("trprDegr").toString().replace("<trprDegr>", "").replace("</trprDegr>", "").trim();//훈련 회차
			String trainstCstId = el.select("trainstCstId").toString().replace("<trainstCstId>", "").replace("</trainstCstId>", "").trim();//훈련기관 ID
			
			System.out.println("차수 : " +trprDegr);
		
				String detailurl ="http://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_2.jsp?"
						+ "authKey=zTTgDhnacOrKYEU7PyiCIPquwdPOJFDO&"
						+ "returnType=XML&"
						+ "outType=2&"
						+ "srchTrprId="+trprId+"&"  
						+ "srchTrprDegr="+trprDegr+"&"	
						+ "srchTorgId="+trainstCstId; //기관 일단 이거 다 넘기고
			
			Document detailsdoc = Jsoup.connect(detailurl).get();
			Elements detailEls = detailsdoc.select("inst_base_info");
			
			
			
			jObj.put("address", el.select("address").toString().replace("<address>", "").replace("</address>", "").trim());//주소
			jObj.put("addr1", detailEls.select("addr1").toString().replace("<addr1>", "").replace("</addr1>", "").trim());
			jObj.put("addr2", detailEls.select("addr2").toString().replace("<addr2>", "").replace("</addr2>", "").trim());
			jObj.put("hpAddr", detailEls.select("hpAddr").toString().replace("<hpAddr>", "").replace("</hpAddr>", "").trim());		
			jObj.put("instIno", detailEls.select("instIno").toString().replace("<instIno>", "").replace("</instIno>", "").trim());
			jObj.put("subTitle", el.select("subTitle").toString().replace("<subTitle>", "").replace("</subTitle>", "").trim());
			jObj.put("trDcnt", detailEls.select("trDcnt").toString().replace("<trDcnt>", "").replace("</trDcnt>", "").trim());
			jObj.put("trprChap", detailEls.select("trprChap").toString().replace("<trprChap>", "").replace("</trprChap>", "").trim());
			jObj.put("trprChapEmail", detailEls.select("trprChapEmail").toString().replace("<trprChapEmail>", "").replace("</trprChapEmail>", "").trim());
			jObj.put("trprChapTel", detailEls.select("trprChapTel").toString().replace("<trprChapTel>", "").replace("</trprChapTel>", "").trim());
			jObj.put("trprDegr", detailEls.select("trprDegr").toString().replace("<trprDegr>", "").replace("</trprDegr>", "").trim());
			jObj.put("trprId", detailEls.select("trprId").toString().replace("<trprId>", "").replace("</trprId>", "").trim());			
			jObj.put("trprNm", detailEls.select("trprNm").toString().replace("<trprNm>", "").replace("</trprNm>", "").trim());
			jObj.put("trtm", detailEls.select("trtm").toString().replace("<trtm>", "").replace("</trtm>", "").trim());
			jObj.put("inoNm", detailEls.select("inoNm").toString().replace("<inoNm>", "").replace("</inoNm>", "").trim());
			jObj.put("traStartDate", el.select("traStartDate").toString().replace("<traStartDate>", "").replace("</traStartDate>", "").trim());
			jObj.put("traEndDate", el.select("traEndDate").toString().replace("<traEndDate>", "").replace("</traEndDate>", "").trim());
			jObj.put("yardMan", el.select("yardMan").toString().replace("<yardMan>", "").replace("</yardMan>", "").trim());
			
			
			jlist.add(jObj);
			System.out.println("사이즈 : " +jlist.size());
			
//			}
		}
		
		result.put("info", jlist);
		System.out.println(result.toString());
		
		return result.toString(); 
	}
}
