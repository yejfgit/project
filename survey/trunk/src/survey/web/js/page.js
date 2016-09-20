function nextPage() {

	pageNum = document.getElementsByName("pageNum")[0].value;
	if (pageNum == 0) {
		pageNum = 1;
	}
	document.getElementsByName("pageNum")[0].value = Math.abs(pageNum) + 1;
	//alert(document.getElementsByName("pageNum")[0].value);
	doQuery(Math.abs(pageNum) + 1);
}

function prevPage() {
	pageNum = document.getElementsByName("pageNum")[0].value;
	if (pageNum == 0) {
		pageNum = 1;
	}
	document.getElementsByName("pageNum")[0].value = Math.abs(pageNum) - 1;
	doQuery(Math.abs(pageNum) - 1);
	
}

function jumpPage() {

	pageNum = document.getElementsByName("jumpPageNum")[0].value;
	if (!(/^\d+$/g.test(pageNum))) {
		document.getElementsByName("jumpPageNum")[0].value = '';
		return false;
	}
	//alert(pageNum);
	document.getElementsByName("pageNum")[0].value = pageNum;
	doQuery(pageNum);
}
