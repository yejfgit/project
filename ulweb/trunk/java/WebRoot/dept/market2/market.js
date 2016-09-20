function goto1P(page){
	document.getElementById("idforms").action = "market2.do?method=subPage1&page=" + page;
	document.getElementById("idforms").submit();
}

function goto1Page(){
	document.getElementById("idforms").action = "market2.do?method=subPage1&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}

function goto2P(page){
	document.getElementById("idforms").action = "market2.do?method=subPage2&page=" + page;
	document.getElementById("idforms").submit();
}

function goto2Page(){
	document.getElementById("idforms").action = "market2.do?method=subPage2&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}

function gotocP(page){
	document.getElementById("idforms").action = "market2.do?method=check&page=" + page;
	document.getElementById("idforms").submit();
}

function gotocPage(){
	document.getElementById("idforms").action = "market2.do?method=check&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}