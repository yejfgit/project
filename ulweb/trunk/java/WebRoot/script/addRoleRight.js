function addAdminRight(){
	document.getElementsByName("form1").submit();
}

function clearRight(){
	document.getElementById("adminRightPage").innerHTML = "";
}

function displayRight(){
	tableId = "adminRightPage";
	send_request("/admin/displayRightPage.do");
}

function adminRight(num){
	document.getElementsByName("adminRight").value = num;
}

function adminRight(dept){
	tableId = "adminRightPage";
	send_request("/admin/displayRightPage.do?dept=" + dept);
}