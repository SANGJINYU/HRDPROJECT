/**
 * 
 */


function loginCheck(){
	var id= document.getElementById("inputId");
	var pw= document.getElementById("inputPw");
	
	console.log(id.value);
	console.log(pw.value);
	
	var frm= document.forms[0];
	frm.action="./login.do";
	console.log(frm);
}


											
									