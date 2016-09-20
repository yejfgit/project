
/**************************     在对话框中按Esc退出     *******************************************/
window.document.onkeydown = function () {
	if (event.keyCode == 27) {
		window.close();
	}
};
/*******************************           树节点展开函数         ******************************/
function o(id) {
	var dd = document.getElementById("dd" + id);
	var da = document.getElementById("da" + id);
	if (dd.style.display == "block") {
		dd.style.display = "none";
		da.innerHTML = "\uff0b";
	} else {
		dd.style.display = "block";
		da.innerHTML = "\uff0d";
	}
}
/************************************* 附件函数 ***************************************/
function setWinHeight(obj) {
	var win = obj;
	if (document.getElementById) {
		if (win && !window.opera) {
			if (win.contentDocument && win.contentDocument.body.offsetHeight) {
				win.height = win.contentDocument.body.offsetHeight;
			} else {
				if (win.Document && win.Document.body.scrollHeight) {
					win.height = win.Document.body.scrollHeight;
				}
			}
		}
	}
}
/*********************************************************************************************/
function gi(id) {
	return document.getElementById(id);
}
function gn(name) {
	return document.getElementsByName(name)[0];
}
/* 取得名称为name的url参数的值 */
function getQueryValue(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return unescape(r[2]);
	}
	return "";
}
/* 切换标签页，标签组名为grp，序号时idx，总数为len（用户隐藏其他标签页） */
function tagSelect(grp, idx, len) {
	try {
		for (i = 1; i <= len; i++) {
			if (i == idx) {
				gi(grp + i).style.display = "block";
				gi("tag_" + grp + i).className = "tagSel";
			} else {
				gi(grp + i).style.display = "none";
				gi("tag_" + grp + i).className = "tag";
			}
		}
	}
	catch (e) {
	}
}
/* 重写String的substring方法 */
function substr(from, len) {
	cnt = 0;
	ret = "";
	for (i = from; i < this.length && cnt < len; i++) {
		c = this.charAt(i);
		if (escape(c).indexOf("%u") != -1) {
			cnt += 1;
		} else {
			cnt += 0.5;
		}
		ret += c;
		//document.writeln(c + ", " + cnt + "<br>");
	}
	return ret;
}
String.prototype.substring = substr;

