function gotoP(page){
	document.getElementById("idforms").action = "list.do?method=zongbuHaveAtt&page=" + page;
	document.getElementById("idforms").submit();
}

function gotoPage(){
	document.getElementById("idforms").action = "list.do?method=zongbuHaveAtt&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}
