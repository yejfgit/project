
/*********************************打开一个对话框********************************************/
function showDialog(url, width, height) {
	window.showModalDialog(url, window, 'dialogWidth:' + width + 'px;dialogHeight:'
		+ height + 'px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');

}
/*********************************************************************************************/


/*********************************提示一个表单的所有属性元素********************************************/
function tips(frm, rst) {
	var msg = rst + "\n表单提交参数如下：\n";
	for(var i = 0; i < frm.length; i++) {
		if (frm[i].type == "submit"
		 || frm[i].type == "reset"
		 || frm[i].type == "button") continue;
		msg += (frm[i].name == "" ? frm[i].id : frm[i].name) + ": " + frm[i].value + "\n";
	}
	alert(msg);
}
/*********************************************************************************************/
 


/**************************     打开对话框并接收返回值    ************************************/
//选择用户
function selectUser(id, name) {
	
	showDialog("select_user.htm", 500, 500);
	document.all[id].value = document.all.dialogReturnId.value;
	document.all[name].value = document.all.dialogReturnName.value;
	
	//alert(document.all.dialogReturn.value);
}
//选择组织
function selectDept(id, name) {

	showDialog("select_dept.htm", 500, 500);
	document.all[id].value = document.all.dialogReturnId.value;
	document.all[name].value = document.all.dialogReturnName.value;
}
//选择职位
function selectPosi(id, name) {

	showDialog("select_posi.htm", 500, 500);
	document.all[id].value = document.all.dialogReturnId.value;
	document.all[name].value = document.all.dialogReturnName.value;
}
//选择角色
function selectRole(id, name) {

	showDialog("select_role.htm", 500, 500);
	document.all[id].value = document.all.dialogReturnId.value;
	document.all[name].value = document.all.dialogReturnName.value;
}
//选择权限
function selectPriv(id, name) {

	showDialog("select_priv.htm", 500, 500);
	document.all[id].value = document.all.dialogReturnId.value;
	document.all[name].value = document.all.dialogReturnName.value;
}
//选择下属组织
function selectSubDept(id, name) {

	showDialog("select_sub_dept.htm", 500, 500);
	document.all[id].value = document.all.dialogReturnId.value;
	document.all[name].value = document.all.dialogReturnName.value;
}
/*********************************************************************************************/




/**************************     在对话框中按Esc退出     *******************************************/
window.document.onkeydown = function() {if (event.keyCode == 27) {window.close();}}
/*********************************************************************************************/



/****************************   单选对话框并发送返回值  *************************/
function choose(id, name) {
	dialogArguments.document.all.dialogReturnId.value = id;
	dialogArguments.document.all.dialogReturnName.value = name;
	window.close();
}
/********************************************************************************************/



/********************************  多选对话框并发送返回值  ************************************/
//选择多个并在父窗口添加
function addMultiChoose(id, name) {
	dialogArguments.document.all.dialogReturnId.value += id + ";";
	dialogArguments.document.all.dialogReturnName.value += name + ";";
	window.close();
}
function clearMultiChoose(id, name) {
	document.all[id].value='';
	document.all[name].value='';
	document.all.dialogReturnId.value = '';
	document.all.dialogReturnName.value = '';
}
/*
//新建项目对象
function Item(id, name, flag) {
	this.id = id;
	this.name = name;
	this.flag = flag;
	
}
//处理点击事件
function chooseN(id, tr) {
	//alert(getItemById(id).flag);
	if(getItemById(id).flag == 0) {
		getItemById(id).flag = 1;
		document.getElementById(tr).style.backgroundColor = '#E4E9F3';
		document.getElementById(tr).style.fontWeight = 'bold';
	} else {
		getItemById(id).flag = 0;
		document.getElementById(tr).style.backgroundColor = '#FFFFFF';	
		document.getElementById(tr).style.fontWeight = 'normal';
	}
}
//得到项目对象
function getItemById(id) {
	for (var i = 0; i < items.length; i++) {
		if (items[i].id == id) {
			return items[i];
		}
	}
}
//提交传回值
function chooseSubmit() {
//	var str = "";
	var id = "";
	var name = "";
	for (var j = 0; j < items.length; j++) {
		if (items[j].flag == 1) {
			//str += "id=" + items[j].id + " name=" + items[j].name + "\n";
			id += items[j].id + ";";
			name += items[j].name + ";";
		}
	}
	dialogArguments.document.all.dialogReturnId.value = id;
	dialogArguments.document.all.dialogReturnName.value = name;
	//mainFrame.document.all.operator = id;
	window.close();
	//alert(str);
	
}
//重置多选对话框
function chooseReset() {
	for (var j = 0; j < items.length; j++) {
		if (items[j].flag == 1) {
			chooseN(items[j].id, "t" + (j + 1));
		}
	}
}
*/
/*********************************************************************************************/




/*******************************           添加附件对话框         ******************************/
function addAtt() {
//alert("添加附件");
showDialog("task_att.htm", 600, 700);
}
function addForm() {
//alert("添加附件");
showDialog("task_form.htm", 600, 700);
}
function getImg() {
//alert("添加附件");
showDialog("task_img.htm", 700, 700);
}
/*********************************************************************************************/

//删除附件
function del(frm, url) {
	if (confirm("确实要删除吗？") == true) {
		//frm.action = url;
		//frm.submit();
		alert("已删除");
		//
	}
}

 
/*******************************           树节点展开函数         ******************************/
function o(id) {
	var dd = document.getElementById('dd' + id);
	var da = document.getElementById('da' + id);
	if (dd.style.display == 'block') {
		dd.style.display = 'none';
		da.innerHTML = '＋';
	} else {
		dd.style.display = 'block';
		da.innerHTML = '－';
	}
}

/*********************************************************************************************/

/************************************* 附件函数 ***************************************/
function refreshattachmentlist(){
  //alert('detail_normal.jsp: refreshattachmentlist');
  var attcchmentlistframe = document.getElementById("attcchmentlistframe");
  attcchmentlistframe.src=attcchmentlistframe.src;
}

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

/*********************************************************************************************/

	
	/*  */
	function cutStr(str, len, refer, header) {
		if (str.length > len) {
			if (document.getElementById(refer) != null) {
				document.getElementById(refer).title = 'header=[' + header + '] body=[' + str + ']';
			}
			return str.substring(0, len) + '...';
		} 
		return str;
	}

	/* 取得id元素 */
	function G(id) {
		return document.getElementById(id);
	}

	/* 取得名称为name的url参数的值 */
    function GetQueryValue(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r= window.location.search.substr(1).match(reg);
		if (r != null) {
			return unescape(r[2]);
		}
		return "";
	}

/*********************************************************************************************/


function gn(name) {
	o = document.getElementsByName(name)[0];
	if (o == null || o == undefined) {
		alert('name:[' + name + '] invalid');
		return false;
	}
	return o;
}

	
function trim(str) {
	//alert('[' + str.replace(/(^\s*)|(\s*$)/g, "") + ']');
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
	
function checkInputValue(name, min, max) {
	var o = gn(name);

	var len = trim(o.value).length;
	if (max == -1 && len < min) {
		return false;
	}
	if (min == -1 && len > max) {
		return false;
	}
	if (len < min || len > max) {
		return false;
	}
	o.value = trim(o.value);
	return true;
}


/*********************************************************************************************/
// 审批意见中的“同意”“不同意”提示
var str_agree = '【同意】';
var str_disagree = '【不同意】';
var str_mobile = ''; // 暂时留空


