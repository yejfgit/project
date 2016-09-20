
function G(id) {
	return document.getElementById(id);
}

function pressEnter(func) {
	if (event.keyCode == 13) {
		func();
	}
}

function over_btn(id, index) {

	for (i = 1; i <= 5; i++) {
		if (G("btn_" + id + i) == null) {
			continue;
		}
		G("btn_" + id + i).className = 'col_sub_btn_off';
		G("sheet_" + id + i).className = 'col_sub_content_off';
	}
	//alert(id);
	G("btn_" + id + index).className = 'col_sub_btn_on';
	G("sheet_" + id + index).className = 'col_sub_content_on';

	
}

function page(no) {
	var url = location.href;
	url = url.replace(/&?page=\d+/g, "") + "&page=" + no;
	location.href = url;
}


function search() {

	var keyWord = G("input_search").value;
	//alert(keyWord);
	keyWord = escape(keyWord);
	keyWord = keyWord.replace(/%/g, 'U')
	var url = "falv.do?method=search&keyWord=" + keyWord;
	location.href = url;
}
