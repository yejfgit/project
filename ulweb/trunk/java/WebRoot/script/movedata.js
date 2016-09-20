function startMove(){
	document.getElementById("idform1").action = "admin/config.do?method=moveData";
	
	document.getElementById("idform1").submit();
}

function continueMove(){
	document.getElementById("idform1").action = "admin/config.do?method=moveData";
	document.getElementById("idform1").submit();
}

function cancleThisTime(){
	document.getElementById("idform1").action = "admin/config.do?method=cancleThisTime";
	document.getElementById("idform1").submit();
}

function cancleAll(){
	document.getElementById("idform1").action = "admin/config.do?method=cancleAllData";
	document.getElementById("idform1").submit();
}