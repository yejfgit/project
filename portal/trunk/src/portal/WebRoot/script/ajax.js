
/*
	简易的ajax函数库
*/

/* 
get方式发送ajax请求
	func是成功后的回调函数 
	
*/
function ajaxGet(url, func) {
	
	var xmlhttp = _getXmlhttp();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
    		func(xmlhttp.responseText)
    	}
    }
    xmlhttp.open('GET', url);
	xmlhttp.send();
	
}

/* 
post方式发送ajax请求
	param 参数串，格式：'userName=Peter&password=888888'
	func 返回后的回调函数 
	
*/
function ajaxPost(url, param, func) {
	
	var xmlhttp = _getXmlhttp();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
    		func(xmlhttp.responseText)
    	}
    }
	xmlhttp.open('POST', url);
    xmlhttp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xmlhttp.send(param);
	
}

function _getXmlhttp() {
	var xmlhttp = null;
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	} else {
		// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}