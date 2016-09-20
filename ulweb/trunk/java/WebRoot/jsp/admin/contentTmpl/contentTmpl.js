
function previewTmpl() {
	var f = document.getElementById("form1");
	f.action = "web/admin/contentTmpl/contentTmplAdmin.do?method=preview";
	f.target = "_blank";
	f.submit();
}

function doAddSave() {
	if (!checkForm()) {
		return false;
	}
	var f = document.getElementById("form1");
	f.action = "web/admin/contentTmpl/contentTmplAdmin.do?method=addSave";
	f.target = "_self";
	f.submit();
}

function doEditSave() {
	if (!checkForm()) {
		return false;
	}
	var f = document.getElementById("form1");
	f.action = "web/admin/contentTmpl/contentTmplAdmin.do?method=editSave";
	f.target = "_self";
	f.submit();
}

function checkForm() {
	var ctn = document.getElementsByName("contentTmpl.tmplName")[0];
	if (ctn != null && ctn.value == "") {
		alert("\u8bf7\u8f93\u5165\u5185\u5bb9\u6a21\u677f\u540d\u79f0");
		return false;
	}
	return true;
}

function chooseTmpl(tid, tname) {
	//alert(tid + "," + tname);
	dialogArguments.document.getElementsByName("tmplId")[0].value = tid;
	dialogArguments.document.getElementsByName("tmplName")[0].value = tname;
	window.close();
}

