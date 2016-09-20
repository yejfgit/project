	
	var titleColor =  ["#004A1B","#ffffff","#000000","#0066ff",
							"#009900","#00dddd","#ffccff","#9900cc","#ffcc00","#ff0000"];
	
	function filter(str){
		//return str.replace(/<script|<\/script|<frame|<\/frame|<iframe|<object|<embed|javascript:|onload=|onbeforeunload/ig, "");
		return str.replace(/<script|<\/script|<frame|<\/frame|<iframe|javascript:|onload=|onbeforeunload/ig, "");
	}

	function getContents(){
		var oEditor=FCKeditorAPI.GetInstance('FCKeditor1');
		return oEditor.GetXHTML(true);
	}

	function subFrm(){
		var i=0;
		if(document.getElementById("idcolumnId").value=="" || document.getElementById("idcolumnId").value=="0"){
			alert('请选择栏目');
			return;
		}else if(document.getElementById("idcolumnId").value=="-1"){
			alert('您不能在此栏目下添加内容');
			return;
		}
		if(document.getElementById("idcontentName").value == "" ){
			alert('请填写名称'); 
			return;
		}
		if(!ValidateHtmlTag(document.getElementById("idcontentName").value)){
			alert("标题不能包含html标记");
			document.getElementById("idcontentName").value = filtertxt(document.getElementById("idcontentName").value);
			return false;
		}	
		
		if(!window.confirm("确认要将内容发布到\""+ document.getElementById("idcolumnName").value +"\"吗？")){
	 		return false;
	 	}	 	
		document.getElementById("idcontent").value=filter(getContents());		
		if(document.getElementById("idcontent").value == "" && document.getElementById("idattNull").checked ){
			alert("不能既没有内容也没有附件");
			return false;
		}	
		document.getElementById('idform1').submit();
		
	}
	
	function subEditFrm(){
		var i=0;
		if(document.getElementById("idcolumnId").value=="" || document.getElementById("idcolumnId").value=="0"){
			alert('请选择栏目');
			return;
		}else if(document.getElementById("idcolumnId").value=="-1"){
			alert('您不能在此栏目下添加内容');
			return;
		}
		if(document.getElementById("idcontentName").value == "" ){
			alert('请填写名称'); 
			return;
		}
		if(!ValidateHtmlTag(document.getElementById("idcontentName").value)){
			alert("标题不能包含html标记");
			document.getElementById("idcontentName").value = filtertxt(document.getElementById("idcontentName").value);
			return false;
		}		
		
	 	if(!window.confirm("确认要将内容发布到\""+ document.getElementById("idcolumnName").value +"\"吗？")){
	 		return false;
	 	}
		document.getElementById("idcontent").value=filter(getContents());
		if(document.getElementById("idcontent").value == "" && document.getElementById("idattNull").checked && attSum == 0 ){
			alert("不能既没有内容也没有附件");
			return false;
		}
		document.getElementById('idform1').submit();
		
	}
	
	function cList(cid, columnName){
		if(window.confirm("您确定要改变发布内容的上级栏目吗？")){
			document.getElementById("idcolumnId").value = cid;
			document.getElementById("idcolumnName").value = columnName;
			document.getElementById("idcolumnInfo").innerHTML = "<font color='#00cc55'>" + columnName + "</font>";
			colNmae = columnName;
		}
	}
		
	function nList(cid, columnName){
		
		document.getElementById("idcolumnInfo").innerHTML = "<font color='#ff0000'>您没有此项栏目的发布权</font>";
	}
	
	function toAdd(){
		document.getElementById('idform1').action = 'admin/content.do?method=bAdd';
		document.getElementById('idform1').submit();
	}
	

	
	function addFile(){
		var inputFile = document.createElement("input");
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		inputFile.name = "files";
		inputFile.type = "file";
		td.appendChild(inputFile);
		tr.appendChild(td);
		document.getElementById("idtbody").appendChild(tr);
		
	}
	
	function filtertxt(str){
		var filterStr=str.replace(/(^\s*)|(\s*$)/g, '').replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/\n/g,"<br>");
		return filterStr;
	}
	
	function ValidateHtmlTag(v)
	{
	  return !(/[\"\']|\<[^\>]*\>/ig).test(v);
	}
	
	function deleteA(num){	
		document.getElementById("idattDel").value += "," + num;
		document.getElementById("ida" + num).style.textDecoration = "line-through";
		attSum--;
		document.getElementById("idattSum").value = attSum;
		document.getElementById("ida" + num).href = "javascript:cancleDeleteA(" + num + ");";
	}
	
	function cancleDeleteA(num){
		document.getElementById("idattDel").value = document.getElementById("idattDel").value.replace(num, "");
		document.getElementById("ida" + num).style.textDecoration = "";
		attSum++;
		document.getElementById("idattSum").value = attSum;
		document.getElementById("ida" + num).href = "javascript:deleteA(" + num + ");";
	}
	
	
	function changeTitleColor(){
		document.getElementById("idcontentName").style.color = titleColor[document.getElementById("iddisplaytype").value];
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	