
/**
 * 常用js
 * 
 */
function g(id) {
	return document.getElementById(id);
}

function gn(name) {
	return document.getElementsByName(name)[0];
}

/* 将json字符串转换为json对象 */
function json2obj(s) {
	return eval('(' + s + ')');
}

/* 显示页面对象 */
function show(id) {
	g(id).style.display = 'block';
}

/* 隐藏页面对象 */
function hide(id) {
	g(id).style.display = 'none';
}

/* 聚焦时显示输入框提示信息 */
function focusInput(o, h) {
	var hint = h == undefined ? '请输入' : h;
	if (o.value == hint) {
		o.value = '';
		o.style.color = '#000000';
	}
}

/* 失焦时消除输入框提示信息 */
function blurInput(o, h) {
	var hint = h == undefined ? '请输入' : h;
	if (o.value == '') {
		o.value = hint;
		o.style.color = '#999999';
	}
}

/**
 * 显示提示信息
 * @param text
 */
function msg(text) {
	write('message', text);
	if (text == '') {
		hide('message');
	} else {
		show('message');
	}
}

/**
 * 加载中的遮罩
 */
function loading() {
	create_msgbox('180px', '20px', '<div class="loading">正在努力加载中...</div>');
	create_mask();
}
/**
 * 消除遮罩
 */
function loadingDone() {
	remove_mask();
	var o = g('msgbox');
	if (o) {
		o.parentNode.removeChild(o);
	}
}

/* 打开对话框 */
function openDialog(url, w, h, title) {
	title = title ? title : '';
	var t = '<div class="dialog-box" style="height: ' + h + 'px;">';
	t += '<div class=\"dialog-head\">' + title + '</div>';
	t += '<a href="javascript:void(0)" class="dialog-close" onclick="closeDialog();return false;">关闭</a>';
	t += '<div id="dialogBox" class="dialog-body">loading...</div>';
	t += '</div>';
	create_mask();
	create_msgbox(w + 'px', h + 'px', t);
	
	// load data
	ajaxGet(url, function (text) {
		//alert(text);
		g('dialogBox').innerHTML = text;
		return true;
	});
}

/* 打开iframe对话框 */
function openDialogIframe(url, w, h, title) {
	title = title ? title : '';
	var t = '<div class="dialog-box">';
	t += '<div class="dialog-head">' + title + '</div>';
	t += '<a href="javascript:void(0)" class="dialog-close" onclick="closeDialog();return false;">关闭</a>';
	t += '<iframe id="dialogBox" src="' + url + '" width="99%" height="' + h + '" scrolling="no" frameborder="0" onload="SetWinHeight(this)"></iframe>';
	t += '</div>';
	create_mask();
	create_msgbox(w + 'px', h + 'px', t);
}

/* 关闭对话框 */
function closeDialog() {
	remove_mask();
	var msgbox = g('msgbox');
	if (msgbox) {
		msgbox.parentNode.removeChild(msgbox);
		msgbox = null;
	}
}

/* 选择Tab标签 */
function selTab(idx) {
	var i = 1;
	while (true) {
		var t = g('tab' + i);
		if (t) {
			t.className = 'tab';
			hide('tabContent' + i);
		} else {
			break;
		}
		i++;
	}
	g('tab' + idx).className = 'tab-sel';
	hide('tabContent' + idx);
}

/* 自动调整对象高度 */
function SetWinHeight(obj)
{
 var win=obj;
 if (document.getElementById)
 {
    if (win && !window.opera)
    {
  if (win.contentDocument && win.contentDocument.body.offsetHeight)
    win.height = win.contentDocument.body.offsetHeight;
  else if(win.Document && win.Document.body.scrollHeight)
    win.height = win.Document.body.scrollHeight;
    }
 }
}

