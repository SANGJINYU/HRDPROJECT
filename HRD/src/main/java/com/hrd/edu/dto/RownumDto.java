package com.hrd.edu.dto;

public class RownumDto {
	private int pageCount; // 출력할 페이지 번호 개수
	private int pageNum; // 출력한 페이지의 번호
	private int startPageNum; // 출력할 페이지 시작번호
	private int listCount; // 출력할 리스트의 개수
	private int listTotalCount; // 리스트의 총 개수
	
	{
		pageCount = 5;
		pageNum = 0;
		startPageNum = 1;
		listCount = 5;
	}
	
	public RownumDto() {
	}
	
	public RownumDto(String pageNum, String startPageNum, String listCount) {
		if (pageNum != null) {
			this.pageNum = Integer.parseInt(pageNum);
		}
		if (startPageNum != null) {
			this.startPageNum = Integer.parseInt(startPageNum);
		}
		if (listCount != null) {
			this.listCount = Integer.parseInt(listCount);
		}
	}
	
	public int getStart() {
		return pageNum*listCount+1;
	}
	
	public int getLast() {
		return (pageNum*listCount)+listCount;
	}
	
	public int getCount() {
		int temp = listTotalCount-listCount*(startPageNum-1);
		int min = temp/listCount;
		int count = 0;
		if (temp%listCount != 0) {
			min++;
		}
		System.out.println("temp="+temp+"//"+"min="+min);
		if (temp <= listCount) {
			count = startPageNum;
		} else if(min <= pageCount) {
			count = min+startPageNum-1;
		} else {
			count = pageCount+startPageNum-1;
		}
		System.out.println("count="+count);
		return count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getListTotalCount() {
		return listTotalCount;
	}

	public void setListTotalCount(int listTotalCount) {
		this.listTotalCount = listTotalCount;
	}

	@Override
	public String toString() {
		return "RownumDto [pageCount=" + pageCount + ", pageNum=" + pageNum + ", startPageNum=" + startPageNum
				+ ", listCount=" + listCount + ", listTotalCount=" + listTotalCount + "]";
	}
}
