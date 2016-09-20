

function G(id) {
	return document.getElementById(id);
}

function page(no) {
	var url = location.href;
	url = url.replace(/&?pageNum=\d+/g, "") + "&pageNum=" + no;
	location.href = url;
}

function pressEnter(func) {
	if (event.keyCode == 13) {
		func();
	}
}


function doSearch() {

	var keyWord = G("input_search").value;
	//alert(keyWord);
	keyWord = escape(keyWord);
	keyWord = keyWord.replace(/%/g, 'U')
	var url = "list.jsp?keyWord=" + keyWord;
	location.href = url;
}