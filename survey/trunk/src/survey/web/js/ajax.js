
var dis;
var tableId = "";
var http_request = false;
function send_request(url) {//初始化、指定处理函数、发送请求的函数
	http_request = false;
//	url = decodeURI(url);
	if (window.XMLHttpRequest) {// file://Mozilla/ 浏览器
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {//设置MiME类别
			http_request.overrideMimeType("text/xml");
		}
	} else {
		if (window.ActiveXObject) { // IE浏览器
			try {
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e) {
				try {
					http_request = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch (e) {
				}
			}
		}
	}
	if (!http_request) { // 异常，创建对象实例失败
		window.alert("\u4e0d\u80fd\u521b\u5efaXMLHttpRequest\u5bf9\u8c61\u5b9e\u4f8b.");
		return false;
	}
	http_request.onreadystatechange = processRequest;
   // 确定发送请求的方式和URL以及是否同步执行下段代码
	http_request.open("post", url, true);
	http_request.setRequestHeader("Content-Type", "text/html; charset=UTF-8;");
	http_request.send(null);
}
  // 处理返回信息的函数
function processRequest() {
	if (http_request.readyState == 4) { // 判断对象状态
		if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
			dis = http_request.responseText;
			document.getElementById(tableId).innerHTML = dis;
		} else { //file://页/面不正常
			alert("\u60a8\u6240\u8bf7\u6c42\u7684\u9875\u9762\u6709\u5f02\u5e38\u3002");
		}
	}
}

