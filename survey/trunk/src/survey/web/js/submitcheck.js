/* 
	check userName and userPassword
*/

function checkNameAndPw(){
	var userName = document.getElementsByName("userName")[0];
	var pw = document.getElementsByName("pw")[0];
	var password1 = document.getElementsByName("password1")[0];
	if(userName.value == "") {
		alert("请填写用户名");
		return false;
	}
	
	if(userName.value == " ") {
		alert("请填写用户名");
		return false;
	}
	
	if(password1.value == "" || password1.value == " ") {
	 	alert("请填写密码");
	 	return false;
	 }
	 
	 
	 pw.value=hex_hmac_md5(userName.value+password1.value, document.getElementsByName("challenge")[0].value);
	 document.getElementsByName("form1")[0].submit();
}

	