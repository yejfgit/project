
function page(no) {
	var cid = gn("column.columnId").value;
	//alert(cid + "," + no);
	tableId = "idcontentList";
	send_request("web/admin/content/contentAdmin.do?method=getContentList&id=" + cid + "&pageNum=" + no);
}

function list1(cid,pageId) {
	tableId = "idcontentList";
	send_request("web/admin/content/contentAdmin.do?method=getContentList&id=" + cid+"&pageNum="+pageId);
}

function list(cid) {
	tableId = "idcontentList";
	send_request("web/admin/content/contentAdmin.do?method=getContentList&id=" + cid);
}

function cList(cid) {
	tableId = "idcolumn";
	send_request("web/admin/content/contentAdmin.do?method=edit&id=" + cid);
}

function toAdd() {
	document.getElementById("idform1").action = "web/admin/content/contentAdmin.do?method=add";
	document.getElementById("idform1").submit();
}

function getContents() {
	var oEditor = FCKeditorAPI.GetInstance("FCKeditor1");
	return oEditor.GetXHTML(true);
}

function checkForm() {
	if (gn("content.contentName").value == "") {
		alert("\u8bf7\u8f93\u5165\u5185\u5bb9\u6807\u9898");
		return false;
	}
	/*
	if (filter(getContents()) == "" && gn("att").checked == false) {
		alert("\u8bf7\u8f93\u5165\u5185\u5bb9\u6216\u6dfb\u52a0\u9644\u4ef6");
		return false;
	}
	*/
	return true;
}

function subFrm() {
	if (!checkForm()) {
		return false;
	}
	document.getElementById("idcontent").value = filter(getContents());
	document.getElementById("idform1").submit();
}

//判断是否上传附件
function subEditFrm() {
	if (!checkForm()) {
		return false;
	}
	document.getElementById("idcontent").value = filter(getContents());
	document.getElementById("idform1").submit();
}

function filter(str) {
		//return str.replace(/<script|</script|<frame|</frame|<iframe|<object|<embed|javascript:|onload=|onbeforeunload/ig, "");
	return str.replace(/<script|<\/script|<frame|<\/frame|<iframe|javascript:|onload=|onbeforeunload/ig, "");
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

function cancel() {
	var a = document.getElementById("pageId");
	location.href = 'contentAdmin.do?method=list&deptId='
	 + gn("content.organId").value + '&columnId=' + gn("content.columnId").value + '&pageId='+document.getElementById("pageId").value;

}

