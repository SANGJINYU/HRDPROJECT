function modifyTrainee(){
	
	alert("정보 수정하세요")
	
	var info = document.getElementsByClassName("form-control")
	
	info[2].removeAttribute("readonly");
	info[3].removeAttribute("readonly");
	info[4].removeAttribute("readonly");
	info[5].removeAttribute("readonly");
	
	
	
}


function modifyManager(){
	var isc= confirm("수정하시겠습니까?");
	if(isc==true){
		return "location.href='./modifyManager.do'";
	}else{
		alert("수정 실패");
		return;
	}
	
}