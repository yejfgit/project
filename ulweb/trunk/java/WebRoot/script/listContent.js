
	function cList(cid, columnName){
		document.getElementById("idcolumnId").value = cid;
		document.getElementById("idcolumnName").value = columnName;
		tableId = "idcontentList";
		send_request("admin/content.do?method=getContentList&columnId=" + cid);
	}
	
	function deleteContent(cid){
		if(!confirm("您确认要删除这条内容吗？"))return;
		tableId = "idcontentList";
		send_request("admin/content.do?method=delete&contentId=" + cid);	
	}
	
	function editContent(id){
		document.getElementById("idform1").action = "admin/content.do?method=bEdit&contentId=" + id;
		document.getElementById("idform1").submit();	
	}
	
	function editDocument(id){
		document.getElementById("idform1").action = "admin/document.do?method=bEdit&cId=" + id;
		document.getElementById("idform1").submit();	
	}
	
	function toAdd(){
		document.getElementById("idform1").action = "admin/content.do?method=bAdd";
		document.getElementById("idform1").submit();
	}
	
	function findContant(){
	
		tableId = "idcontentList";	
		send_request("admin/content.do?method=find&ccName=" + encodeURI(document.getElementById("idccName").value) 
			+ "&ts=" + document.getElementById("idts").value + "&te=" + document.getElementById("idte").value
			+ "&deptId=" + document.getElementById("iddeptId").value);
	}
	
	function gotoP(page){
		tableId = "idcontentList";
		send_request("admin/content.do?method=find&page=" + page + "&condition=" + document.getElementById("idcondition").value);
	}
	
	function gotoPage(){
		tableId = "idcontentList";
		send_request("admin/content.do?method=find&page=" 
		+ document.getElementById("idpage").value + "&condition=" + document.getElementById("idcondition").value);
	}
	
	
	