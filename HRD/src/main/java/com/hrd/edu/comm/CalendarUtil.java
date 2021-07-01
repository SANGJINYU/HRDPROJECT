package com.hrd.edu.comm;

import java.util.List;

import com.hrd.edu.dto.CounselDto2;

public class CalendarUtil {

	
	public static String twoWord(int month) {
		String m = String.valueOf(month);
		return (m.length()>1)?m:"0"+m;
	}
	
	//요일별 색깔
	public static String fontColor(int date, int dayOfWeek) {
		int dayCal = (dayOfWeek-1+date)%7;
		if(dayCal == 0) {
			return "blue";
		}else if(dayCal ==1 ) {
			return "red";
		}else {
			return "black";
		}
	}
	
	public static String getCalView(int i, List<CounselDto2> clist) {
		String res = "";
		String d = twoWord(i);
		for(CounselDto2 dto : clist) {
			if(dto.getMdate().substring(6,8).equals(d)) {//202105"17"1010=>17을 갖고옴 : 01
				StringBuffer sb = new StringBuffer();
				sb.append("<p title='"+dto.getDegr()+":"+dto.getId()+"'>"); //degr상담차수, id상담자아이디
				sb.append("<a href=''></a>");
				//제목의 길이 표시 ...
				if(dto.getId().length()>5) {
					sb.append(dto.getId().substring(0,6));
					sb.append("...");
				}else {
					sb.append(dto.getId());
				}
				sb.append("</p>");
				res += sb.toString();
			}
		}
		return res;
	}
}
