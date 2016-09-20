function gotoP(page){
	document.getElementById("idforms").action = "list.do?method=zongbu&page=" + page;
	document.getElementById("idforms").submit();
}

function gotoPage(){
	document.getElementById("idforms").action = "list.do?method=zongbu&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}

/* ulweb 2.0 */
function page(no) {
	var url = location.href;
	url = url.replace(/&?pageNum=\d+/g, "") + "&pageNum=" + no;
	location.href = url;
}