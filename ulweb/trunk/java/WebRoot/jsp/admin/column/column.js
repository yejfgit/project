
function nList(cid) {
	tableId = "idcolumn";
	send_request("web/admin/column/columnAdmin.do?method=edit&id=" + cid);
}

function toAddColumn(cId, deptId) {
	tableId = "idcolumn";
	send_request("web/admin/column/columnAdmin.do?method=add&id=" + cId + "&deptId=" + deptId);
}

function addColumn() {
	if (document.getElementsByName("column.includeColumn")[0].value == 0) {
		document.getElementsByName("column.includeContent")[0].value = 1;
	}
	document.getElementById("idcolumnName").value = filtertxt(document.getElementById("idcolumnName").value);
	document.getElementById("idform1").action = "web/admin/column/columnAdmin.do?method=addSave";
	document.getElementById("idform1").submit();
}

function editColumn() {
	document.getElementById("idform1").action = "web/admin/column/columnAdmin.do?method=editSave";
	document.getElementById("idform1").submit();
}

function deleteColumn() {
	if (!window.confirm("\u60a8\u786e\u5b9a\u8981\u5220\u9664" + document.getElementsByName("column.columnName")[0].value + "\u5417\uff1f")) {
		return false;
	}
	document.getElementById("idform1").action = "web/admin/column/columnAdmin.do?method=del&id=" + document.getElementsByName("column.columnId")[0].value;
	document.getElementById("idform1").submit();
}

function filtertxt(str) {
	var filterStr = str.replace(/(^\s*)|(\s*$)/g, "").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/\n/g, "<br>");
	return filterStr;
}

function ValidateHtmlTag(v) {
	return !(/[\"\']|\<[^\>]*\>/ig).test(v);
}

function selectConTmpl() {
	window.showModalDialog("../contentTmpl/contentTmplAdmin.do?method=selectConTmpl", window, "dialogWidth:600px;dialogHeight:400px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;");
	if (document.all.tmplName.value == null || document.all.tmplName.value == "") {
		return false;
	}
	document.getElementsByName("column.contentTmplId")[0].value = document.all.tmplId.value;
	document.getElementsByName("column.contentTmplName")[0].value = document.all.tmplName.value;
	document.all.tmplId.value = "";
	document.all.tmplName.value = "";
}

