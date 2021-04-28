/**
 * 
 */

let id = document.getElementById("id");
let pw = document.getElementById("pw");
let pw2 = document.getElementById("pw2");
let btn = document.getElementById("btn");
let etc = document.getElementsByClassName("etc");
let idResult = document.getElementById("idResult");
let idCehckResult = document.getElementById("idCheckResult");

let idCheckResult = false; //id check 결과
let pwCheckResult = false; //pw check 결과
let pwEqualResult = false; //pw equal 결과
let etcResult = true; // name, email, phone 결과

// ID Check *********************************
id.addEventListener("blur", function() {
	alert("6글자 미만입니다");
	let c = "r1"
	if(id.value.length>5){
		alert("6글자 이상 입니다");
		c = "r2";
		idCheckResult = true;
	} else {
		idCheckResult = false;
	}
	
	idResult.innerHTML = message;
	idResult.setAttribute("class", c);
});

// Id 중복 확인
$("#id").blur(function() {
	let id = $("#id").val();
	$.get("./memberIdCheck?id="+id, function(result) {
		result = result.trim();
		let str = "사용 가능한 ID 입니다";
		
		if(result=='0' && id.value.length<6) {
			str = "사용 불가능한 ID 입니다";
		}
		
		$("#idCheckResult").html(str);
	});
});

// **** PW CHECK *********************************

pw.addEventListener("blur", function(){
	pwCheckResult=false;
	alert("8글자 미만입니다");
	let c = "r1";
	if(pw.value.length>7){
		alert("8글자 이상입니다");
		c= "r2";
		pwCheckResult=true;
	}
	
	let pwResult = document.getElementById("pwResult");
	pwResult.innerHTML=message;
	pwResult.setAttribute("class", c);
});

// PW EQUAL CHECK **********************************
pw2.addEventListener("blur", function() {
	let message2 = "";
	let c = "r1";

	if(pw.value != pw2.value){
		pw2.value="";
		message2 = "비밀번호가 같지 않습니다.";
		c="r1";
	} else {
		pwEqualResult=true;
		message2 = "비밀번호가 일치합니다.";
		c = "r2";
	}

	pw2Result.innerHTML = message2;
	pw2Result.setAttribute("class", c)
});

pw.addEventListener("change", function(){
	pw2.value="";
});

// ***************************************************

btn.addEventListener("click", function(){
	for(let e of etc){
		if(e.value == ""){
			etcResult=false;
			break;
		}
	}
	
	//조건이 만족하면
	if(idCheckResult && pwCheckResult && pwEqualResult && etcResult) {
		let frm = document.getElementById("frm");
		//frm.submit();
		alert("회원가입 진행");
	} else {
		alert("필수 항목을 입력하세요");
	}
});