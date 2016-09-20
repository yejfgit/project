
function selectConTmpl() {
	window.showModalDialog("../contentTmpl/contentTmplAdmin.do?method=selectConTmpl", window, "dialogWidth:600px;dialogHeight:400px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;");
	//window.open('../contentTmpl/contentTmplAdmin.do?method=selectConTmpl');
	//alert(document.all.tmplId.value + "," + document.all.tmplName.value);
	if (document.all.tmplName.value == null || document.all.tmplName.value == "") {
		return false;
	}
	document.getElementsByName("dept.contentTmplId")[0].value = document.all.tmplId.value;
	document.getElementsByName("dept.contentTmplName")[0].value = document.all.tmplName.value;
	document.all.tmplId.value = "";
	document.all.tmplName.value = "";
}

function checkForm() {
	var di = document.getElementsByName("dept.deptId")[0];
	var dn = document.getElementsByName("dept.deptName")[0];
	var pat = new RegExp("^\\w+$");
	if (di != null && (di.value == "" || !pat.test(di.value))) {
		alert("\u8bf7\u8f93\u5165\u90e8\u95e8\u7f16\u53f7\uff0c\u683c\u5f0f\u4e3a\u5b57\u6bcd\u6216\u6570\u5b57");
		return false;
	}
	if (dn != null && dn.value == "") {
		alert("\u8bf7\u8f93\u5165\u90e8\u95e8\u540d\u79f0");
		return false;
	}
	return true;
}

function doAddSave() {
	if (!checkForm()) {
		return false;
	}
	var f = document.getElementById("form1");
	f.action = "web/admin/dept/deptAdmin.do?method=addSave";
	f.target = "_self";
	f.submit();
}

function doEditSave() {
	if (!checkForm()) {
		return false;
	}
	var f = document.getElementById("form1");
	f.action = "web/admin/dept/deptAdmin.do?method=editSave";
	f.target = "_self";
	f.submit();
}

