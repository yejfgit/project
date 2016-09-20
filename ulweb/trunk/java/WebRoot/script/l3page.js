function goto1P(page){
	document.getElementById("idforms").action = "dept3l.do?method=sub1&page=" + page;
	document.getElementById("idforms").submit();
}

function goto1Page(){
	document.getElementById("idforms").action = "dept3l.do?method=sub1&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}

function goto2P(page){
	document.getElementById("idforms").action = "dept3l.do?method=sub2&page=" + page;
	document.getElementById("idforms").submit();
}

function goto2Page(){
	document.getElementById("idforms").action = "dept3l.do?method=sub2&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}


function goto3P(page){
	document.getElementById("idforms").action = "dept3l.do?method=sub3&page=" + page;
	document.getElementById("idforms").submit();
}

function goto3Page(){
	document.getElementById("idforms").action = "dept3l.do?method=sub3&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}
