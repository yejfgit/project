function goto1P(page){
	document.getElementById("idforms").action = "pinxuan.do?method=subPage&page=" + page;
	document.getElementById("idforms").submit();
}

function goto1Page(){
	document.getElementById("idforms").action = "pinxuan.do?method=subPage&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}

function gotocP(page){
	document.getElementById("idforms").action = "pinxuan.do?method=check&page=" + page;
	document.getElementById("idforms").submit();
}

function gotocPage(){
	document.getElementById("idforms").action = "pinxuan.do?method=check&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}



function topnavOver(index){
	topnav0.style.display = 'none';
	topnav1.style.display = 'none';
	topnav2.style.display = 'none';
	topnav3.style.display = 'none';
	topnav4.style.display = 'none';
	topnav5.style.display = 'none';
	topnav6.style.display = 'none';
	topnav7.style.display = 'none';
	if(index == 0) topnav0.style.display = '';
	if(index == 1) topnav1.style.display = '';
	if(index == 2) topnav2.style.display = '';
	if(index == 3) topnav3.style.display = '';
	if(index == 4) topnav4.style.display = '';
	if(index == 5) topnav5.style.display = '';
	if(index == 6) topnav6.style.display = '';
	if(index == 7) topnav7.style.display = '';
	
}
function navOut(index){
	topnav0.style.display = 'none';
	topnav1.style.display = 'none';
	topnav2.style.display = 'none';
	topnav3.style.display = 'none';
	topnav4.style.display = 'none';
	topnav5.style.display = 'none';
	topnav6.style.display = 'none';
	topnav7.style.display = 'none';
	if(index == 0) topnav0.style.display = '';
	if(index == 1) topnav1.style.display = '';
	if(index == 2) topnav2.style.display = '';
	if(index == 3) topnav3.style.display = '';
	if(index == 4) topnav4.style.display = '';
	if(index == 5) topnav5.style.display = '';
	if(index == 6) topnav6.style.display = '';
	if(index == 7) topnav7.style.display = '';
}
