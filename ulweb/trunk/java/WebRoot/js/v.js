	//根据KEY取得Cookie的值
	function getCookie(c_name)
	{
		if (document.cookie.length>0)
		{
			c_start=document.cookie.indexOf(c_name + "=");
			if (c_start!=-1)
			{
				c_start=c_start + c_name.length+1;
				c_end=document.cookie.indexOf(";",c_start);
				if (c_end==-1) c_end=document.cookie.length;
				return unescape(document.cookie.substring(c_start,c_end));
			}
		}
		return null;
	}
	
	//删除KEY对应的Cookie值
	function delCookie(c_name)
	{
		var c_value=getCookie(c_name);
		if(c_value!=null)
		{
		var c_expires = new Date();
		c_expires.setTime(c_expires.getTime() - 1);
		document.cookie= c_name + "="+""+";expires="+c_expires.toGMTString();
		}
	}
// 检验密码只能是大小写字母和数字的组合，长度为8～15位！
function vPassword(value)
{
	var reg_num = /[0-9]+/g ; //数字
	var reg_char= /[a-z]+/g ; //小写英文字母
	var reg_char2= /[A-Z]+/g ; //小写英文字母
	if(!(value.length>=8&&value.length<=15))
	{
		return false ;
	}
	//检查是否包含数字
	if(!(reg_num.test(value)&&reg_char.test(value)&&reg_char2.test(value)))
	{
		return false ;
	}
	return true ;
}
/*
	????????????????????????????

*/

function ValidateName(v)
{

	var reg = /^\w+$/;

	return reg.test(v);
}

/*
	?????????????
*/
function ValidateInput(v)
{

	var reg = /[\x00-\x2f\x3a-\x40\x5b-\x5e\x60\x7b-\x7f]+/;
	return !reg.test(v);
}
function ValidateEmail(v)
{
	var reg=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
	return reg.test(v);
}
function ValidateUrl(v)
{
	var reg= /[a-zA-z]+:\/\/[^\s]*/;
	return reg.test(v);
}
function vNumeric(so,to,nullable){
	if(!nullable && $(so).value==''){
		setTip(to,'请填写此字段');
		return false;
	}else if($(so).value=='' && nullable){
  	setTip(to,'');
  	return true;
  }
	try{
		var i=Number($(so).value);
		if(isNaN(i)){
			setTip(to,'必须填写数字!');
			return false;
		}
		else{
			setTip(to,'');
			return true;
		}
	}catch(e){
		return false;
	}
}

/**
 * 判断是否是正整数
 */
function vIntegerNumber(so,to,nullable)
{
	if(!nullable && $(so).value=='')
	{
		setTip(to,'请填写此字段');
		return false;
	}
	else if($(so).value=='' && nullable)
	{
	  	setTip(to,'');
	  	return true;
  	}
  	var regext = /^[0-9]+$/ ;
  	if(!regext.test($(so).value))
  	{
  		setTip(to,'必须填写数字!');
		return false;
  	}
  	else
  	{
  		setTip(to,'');
		return true;
  	}
	return false;
}
/**
 * 判断数字是否为零
 */
function noZero(so,to,nullable)
{
	if(!nullable && $(so).value=='')
	{
		setTip(to,'请填写此字段');
		return false;
	}
	else if($(so).value=='' && nullable)
	{
	  	setTip(to,'');
	  	return true;
  	}
  	if($(so).value==0)
  	{
  		setTip(to,'此字段不能填零');
		return false;
  	}
  	else
  	{
  		setTip(to,'');
	  	return true;
  	}
	return false ;
}

/**
 * 比较数字大小
 * 0 相等
 * 1 so1大于so2
 * -1 so1小于so2
 */
function compareNumber(so1,so2)
{
	try
	{
		var vso1 = Number($(so1).value) ;
		var vso2 = Number($(so2).value) ;
	  	if(vso1==vso2)
	  	{
	  		return 0 ;
	  	}
	  	if(vso1 < vso2)
	  	{
	  		return -1 ;
	  	}
	  	if(vso1 > vso2)
	  	{
	  		return 1 ;
	  	}
	}
	catch(e)
	{
		
	}
	
}

function vNumber(v,t)
{
	var reg= /\d/;
	var ret= reg.test($(v).value);
	alert(ret) ;
	if(ret){
		setTip(t,'');
	}
	else{
		setTip(t,'必能输入数字！');
	}
	return ret;
}

/*
	????
*/
function confirmDel(n)
{
	return window.confirm("确认删除 " + n + " 吗？")==1?true:false;
}

/*
	??????html??
*/
function ValidateHtmlTag(v)
{
  return !(/[\"\']|\<[^\>]*\>/ig).test(v);
}
/*
*  英文验证Html(不限制“'”符号)
*/
function EnValidateHtmlTag(v)
{
  return !(/[\"]|\<[^\>]*\>/ig).test(v);
}
function filtertxt(str){
	var filterStr=str.replace(/(^\s*)|(\s*$)/g, '').replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/\n/g,"<br>");
	return filterStr;
}
function setInnerHTML(v,text)
{
	document.getElementById(v).innerHTML=text;
}

function setTip(v,text)
{
	document.getElementById(v).innerText=text;
}
function setValue(o,v)
{
	if(v == null || v=="null") return;
	document.getElementById(o).value=v;
}
function setCheckBox(o,checked)
{
	try{
	document.getElementById(o).checked=checked;
	}catch(e){}
}
function getValue(o)
{
	return document.getElementById(o).value.replace(/(^\s*)|(\s*$)/g, "");
}
/*
	??????Html
	??so??????to?????;n??????

*/
function vHtml(so,to,n)
{
	var tip ="包含非法字符!";
	if(getValue(so)=="")
	{
		if(!n) //not allow null
		{
			setTip(to,"请填写此字段！");
			return false;
		}
		else
		{
			setTip(to,"");
			return true;
		}
	}
	else
	{
		if(!ValidateHtmlTag(getValue(so)))
		{
			setTip(to,tip);
			return false;
		}
		else
		{
			setTip(to,"");
			return true;
		}
	}
}
function vEmail(o,tp,n){
	var r = false;
	if(vHtml(o,tp,n)){
		r= ValidateEmail(getValue(o));
		if(r){
			if(strLen($(o).value)>100){
				setTip(tp,'超出最大长度！');
				return r;
			}
		}
		if(!r)
			setTip(tp,"Email格式不正确！");
		return r;
	}
	return r;
}
function isNullValue(value)
{
	if(value.length==0||value=="")
	{
		return true ;
	}
	else
	{
		return false ;
	}
}
function vMobile(o,tp,isAllowNull){
	setTip(tp,"");
	var value = getValue(o);
	if(isAllowNull&&isNullValue(value))
	{
		return true ;
	}
	if(!isAllowNull&&isNullValue(value))
	{
		setTip(tp,"请填写此字段！");
		return false;
	}
	//移动13x号码段
	var phone_reg0 = /^13[456789]{1}\d{8}$/ ;
	//移动15x号码段
	var phone_reg1 = /^15[01789]{1}\d{8}$/ ;
	//移动18x号码段
	var phone_reg2 = /^18[78]{1}\d{8}$/ ;
	
	//联通号码段
	//联通13x号码段
	var phone_reg3 = /^13[012]{1}\d{8}$/ ;
	//联通15x号码段
	var phone_reg4 = /^15[256]{1}\d{8}$/ ;
	//联通18x号码段
	var phone_reg5 = /^18[56]{1}\d{8}$/ ;
	
	//电信号码段
	//电信18x号码段
	var phone_reg6 = /^18[09]{1}\d{8}$/ ;
	//电信13x号码段
	var phone_reg7 = /^13[3]{1}\d{8}$/ ;
	//电信15x号码段
	var phone_reg8 = /^15[3]{1}\d{8}$/ ;
	//电信1349号码段
	var phone_reg9 = /^1349\d{7}$/ ;
	
	if(phone_reg0.test(value))
	{
		return true ;
	}
	if(phone_reg1.test(value))
	{
		return true ;
	}
	if(phone_reg2.test(value))
	{
		return true ;
	}
	if(phone_reg3.test(value))
	{
		return true ;
	}
	if(phone_reg4.test(value))
	{
		return true ;
	}
	if(phone_reg5.test(value))
	{
		return true ;
	}
	if(phone_reg6.test(value))
	{
		return true ;
	}
	if(phone_reg7.test(value))
	{
		return true ;
	}
	if(phone_reg8.test(value))
	{
		return true ;
	}
	if(phone_reg9.test(value))
	{
		return true ;
	}
	setTip(tp,"手机号码格式不正确！");
	return false ;
}
function vMaxLength(so,to,min,max)
{
	var r = getValue(so);
	if(r.length == 0 && min>0)
	{
		setTip(to,"请填写此字段!");
		return false;
	}
	else
	if(r.length< min || r.length>max)
	{
		setTip(to,"超出最大长度!");
		return false;
	}else
	{
		return true;
	}
}

function strLen(s){
	return s.replace(/[^\x00-\xff]/g,"aa").length;
}
function vPhone(so,to,nullable){
	if(!vHtml(so,to,nullable))
		return false;
  var theDate=$(so).value;
  if(theDate=='' && !nullable){
  	setTip(to,'请填写此字段');
  	return false;
  }else if(theDate=='' && nullable){
  	setTip(to,'');
  	return true;
  }
  var reg = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
  var result=true;
  if(!reg.test(theDate))
    result = false;
  if(result){
  	if(strLen(theDate)>=20){
  		result = false;
  		setTip(to,'超出最大长度');
  		return result;
  	}
  }
  if(result){
  	setTip(to,'');
  }	else{
  	setTip(to,'电话号码不正确！');
  }
  return result;
}function vPhoneAndMobile(so,to,nullable){	if(!vHtml(so,to,nullable))		return false;  var theDate=$(so).value;  if(theDate=='' && !nullable){  	setTip(to,'请填写此字段');  	return false;  }else if(theDate=='' && nullable){  	setTip(to,'');  	return true;  }  var reg = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;  var reg2 = /^1(3\d{1}|5\d{1})\d{8}$/;  var result=true;  if(!reg.test(theDate)&&!reg2.test(theDate))    result = false;  if(result){  	if(strLen(theDate)>=20){  		result = false;  		setTip(to,'超出最大长度');  		return result;  	}  }  if(result){  	setTip(to,'');  }	else{  	setTip(to,'电话号码不正确！');  }  return result;}
function vDate(so,to,nullable){
  var theDate=$(so).value;
  if(theDate=='' && !nullable){
  	setTip(to,'请填写此字段');
  	return false;
  }else if(theDate=='' && nullable){
  	setTip(to,'');
  	return true;
  }
  var reg = /^\d{4}-((0{0,1}[1-9]{1})|(1[0-2]{1}))-((0{0,1}[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))$/;  
  var result=true;
  if(!reg.test(theDate))
    result = false;
  else{
    var arr_hd=theDate.split("-");
    var dateTmp;
    dateTmp= new Date(arr_hd[0],parseFloat(arr_hd[1])-1,parseFloat(arr_hd[2]));
    if(dateTmp.getFullYear()!=parseFloat(arr_hd[0])
       || dateTmp.getMonth()!=parseFloat(arr_hd[1]) -1 
        || dateTmp.getDate()!=parseFloat(arr_hd[2])){
        result = false
    }
  }
  if(!result){
  	setTip(to,'日期格式错误！');
  }else{
		setTip(to,'');
	}
  return result;
}
function vImg(so,to){
	var regTextPost = /^.*?\.(jpg|jpeg|bmp|gif)$/
	var s = $(so).value.toLowerCase();
	if(s=='')
		return true;	
	
	var r = regTextPost.test(s);
	if(!r){
		setTip(to,'文件格式错误！');
	}else{
		setTip(to,'');
	}
	return r;
	
}
function vSwf(so,to){
	var regTextPost = /^.*?\.(swf)$/;
	var s = $(so).value.toLowerCase();
	if(s=='')
		return true;
	var r = regTextPost.test(s);
	if(!r){
		setTip(to,'文件格式错误！');
	}else{
		setTip(to,'');
	}
	return r;

}
function vPostCode(so,to,nullable)
{
	var strValue = $(so).value;
	if(strValue=='' && !nullable){
		setTip(to,'请填写此字段！');
		return false;
	}else if(strValue=='' && nullable){
  		setTip(to,'');
	  	return true;
  }
	var regTextPost = /^(\d){6}$/;
	var r= regTextPost.test(strValue);
	if(!r){
		setTip(to,'邮编错误！');
	}else{
		setTip(to,'');
	}
	return r;
}
function vAlphaNumeric(so,to,nullable){
	var s = $(so).value;
	if(s=='' && !nullable){
		setTip(to,'请填写此字段');
		return false;
	}else if(s=='' && nullable){
  	setTip(to,'');
  	return true;
  }
	var regTextPost=/^[A-Za-z0-9]+$/;
	var r = regTextPost.test(s);
	if(!r){
		setTip(to,'只允许输入字母和数字');
	}else{
		setTip(to,'');
	}
	return r;
}
function $(o)
{
return document.getElementById(o);
}

/*
	ajax helper
*/

function ajax()
{
	//
	var objTransport = null;
	// create transport object
	if (navigator.userAgent.indexOf("Opera")>=0)
	{
			objTransport=new XMLHttpRequest();//alert("This example doesn't work in Opera")
	//	return;
	}
	if (navigator.userAgent.indexOf("MSIE")>=0)
	{
		var strName="Msxml2.XMLHTTP";
		if (navigator.appVersion.indexOf("MSIE 5.5")>=0)
		{
			strName="Microsoft.XMLHTTP";
		}
		try
		{
			objTransport=new ActiveXObject(strName);
		//	objTransport.onreadystatechange=handler

		}
		catch(e)
		{
			alert("Error. Scripting for ActiveX might be disabled");

		}
	}else
	if (navigator.userAgent.indexOf("Mozilla")>=0)
	{
		objTransport=new XMLHttpRequest()
	//	objTransport.onload=handler
	//	objTransport.onerror=handler

	}

	/*get signle result using sync method ,the result is a string value*/
	ajax.prototype.getSingleResult = function ( url){

		objTransport.open("GET",url,false);

		objTransport.send();

		return objTransport.responseText ;
	}
	//return an array object
	ajax.prototype.getMultiResult = function ( url){
	}

	ajax.prototype.callService = function( url, onComplete, onError)
	{
		try
		{
			objTransport.open("GET",url,true);
			var result = objTransport.send(null);
			objTransport.onreadystatechange=onComplete;
			//onComplete(result);
		}catch(e)
		{
			onError(e);
		}
	}
	ajax.prototype.responseText = function(){
		return objTransport.responseText;
	}
	ajax.prototype.readyState=function(){
		return objTransport.readyState;
	}
	ajax.prototype.status = function(){
		return objTransport.status;
	}
}
/*test*/
/*var obj;
obj = new ajax();
obj.callService("www.goole.com",null,null);*/


function contentListOpen(path){
	window.open(path,"","width=800,height=550,scrollbars=yes,menubar=no,resizable=yes");
	return false;
}
function columnListOpen(path){
	window.open(path,"contentListWin");
}
function fixedListOpen(path){
	window.open(path,"contentListWin");
}

//vote
function v_chk_radio(qid,q){
	var qs= document.getElementsByName(qid);
	for(var i =0;i<qs.length;i++){
		if(qs[i].checked){ //选中了
			return true;
		}
	}

	return false;
}

//检测复选项oids 问题列表
function v_chk_checkBox(oids,q){
	var ods = oids.split(';');
	for(var i =0;i<ods.length;i++){
		var v = document.getElementById("o"+ods[i]);

		if(v.checked)
			return true;
	}
	return false;
}
function setNav(idx,count)
	{
		var i;
		for (i = 0 ;i < count ;i++)
		{
			if(i < idx)
			{
				if(i != 0)
					if( i == count-1)
						document.getElementById('last').firstChild.className='navLow';
					else
					{
						document.getElementById("navt" +String(i)).firstChild.setAttribute('class','navLow');
						document.getElementById("navt" +String(i)).firstChild.setAttribute('className','navLow');

					}
				else
					document.getElementById('first').firstChild.className='navLow';
			}
			else if(i == idx)
			{
				if(i != 0)
					if( i ==count -1){
						document.getElementById('last').firstChild.className='navHigh';
						document.getElementById('last').firstChild.style.color='#fff';
						}
					else{
						document.getElementById("navt" +String(i)).firstChild.className='navHigh';
						document.getElementById("navt" +String(i)).firstChild.style.color="#fff";
					}
				else{				
					document.getElementById('first').firstChild.className='navHigh1';
					document.getElementById('first').firstChild.style.color="#fff";
				}
			}
			else
			{
				if(i != 0)
					if(i != count-1)
						document.getElementById("navt" +String(i)).firstChild.className='navRight';
					else
						document.getElementById('last').firstChild.className='navRight';
				else
					document.getElementById('first').firstChild.className='navRight';
			}
		}
	}

function sayHello(mt)
{
	todayDate = new Date();
	todayDate.setTime(mt);
	date = todayDate.getDate();
	month= todayDate.getMonth() +1;
	year= todayDate.getYear();
	if (todayDate.getHours() < 12) {
		document.write("上午好！");
	}
	else
	{
		document.write("下午好！");
	}
	document.write("今天是");
	if(navigator.appName == "Netscape")
	{
	    document.write(1900+year);
	    document.write("年");
	    document.write(month);
	    document.write("月");
	    document.write(date);
	    document.write("日");
	}
	if(navigator.appVersion.indexOf("MSIE") != -1)
	{
		document.write(year);
		document.write("年");
		document.write(month);
		document.write("月");
		document.write(date);
		document.write("日");
	}
	document.write("，");
	if (todayDate.getDay() == 5) document.write("星期五");
	if (todayDate.getDay() == 6) document.write("星期六");
	if (todayDate.getDay() == 0) document.write("星期日");
	if (todayDate.getDay() == 1) document.write("星期一");
	if (todayDate.getDay() == 2) document.write("星期二");
	if (todayDate.getDay() == 3) document.write("星期三");
	if (todayDate.getDay() == 4) document.write("星期四");
}

//身份证检查函数
function validateid(certid)
{
	var sErrMsg = "";
	var reg_15 = /^\d{15}$/;
	var reg_18 = /^\d{17}([0-9]{1}|x|X)$/;
	var monthPerDays = new Array("31","28","31","30","31","30","31","31","30","31","30","31");
	certid = certid.toLowerCase();
	if(certid == "" || certid=="111111111111111")
	{
		return false;
	}
	var ret = certid.length == 15?reg_15.test(certid):reg_18.test(certid);
	if(!ret)
	{
		return false ;
	}
	birthDate = certid.length == 15?"19" + certid.substr(6,6):certid.substr(6,8);
	year = birthDate.substr(0,4);
	if(birthDate.substr(4,1) == '0')
		month = birthDate.substr(5,1);
	else
		month = birthDate.substr(4,2);
	if(birthDate.substr(6,1) == '0')
		day = birthDate.substr(7,1);
	else
		day = birthDate.substr(6,2);
	dd = parseInt(day);
	mm = parseInt(month);
	yy = parseInt(year);
	days = new Date();
	gdate = days.getDate();
	gmonth = days.getMonth();
	gyear18 = days.getFullYear()-18;
	if(mm>12 || mm<1 ||dd>31 || dd<1)
	{
		return false ;
	}
	if(year % 100 != 0)
	{
		if(year % 4 ==0)
		monthPerDays[1] = 29;
	}
	else
	{
		if(year % 400 == 0)
		monthPerDays[1] = 29;
	}
	if(monthPerDays[mm - 1] < dd)
	{
		return false ;
	}
	if(certid.length == 18)
	{
		var arTemp = new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2);
		var num = 0;
		var proof;
		for(var i=0; i < 17; i ++)
		{
			num = num + certid.substr(i,1) * arTemp[i];
		}
		num = num % 11;
		switch(num)
		{
			case 0:proof='1';break;
			case 1:proof='0';break;
			case 2:proof='x';break;
			case 3:proof='9';break;
			case 4:proof='8';break;
			case 5:proof='7';break;
			case 6:proof='6';break;
			case 7:proof='5';break;
			case 8:proof='4';break;
			case 9:proof='3';break;
			case 10:proof='2';break;
		}
		if(certid.substr(17, 1) != proof)
		{
			return false ;
		}
	}
	return true;
}

//检查身份证的性别 true 男 false 女
function checkSexByPapernum(id)
{
	var obj = document.getElementById(id) ;
	var value = obj.value ;
	var sex = 0 ;
	if(value!=undefined&&value.length==15)
	{
		
		sex = value.substr(14,1) ; //15位身份证性别代码
	}
	else if(value!=undefined&&value.length==18)
	{
		sex = value.substr(16,1) ; //18位身份证性别代码
	}
	if(parseInt(sex)%2==0)
	{
		return false ;
	}	
	else
	{
		return true ;
	}
}

function vIDCard(so,to,nullable) 
{
	var so = document.getElementById(so) ;
	var result = validateid(so.value);
	if(result){
		setTip(to,'');
	}else{
		setTip(to,'身份证不正确！');
	}
	return result;
}
function IsNumeric(oNum) 
{ 
  if(!oNum) return false; 
  var i=Number(oNum);
  if(isNaN(i)){
  	return false;
  }
  return true; 
}
  /**
  *检查中文字符start
  */
	function isCharsInBag (s, bag)
	{ 
	var i,c;
	for (i = 0; i < s.length; i++)
	{ 
	c = s.charAt(i);//字符串s中的字符
	if (bag.indexOf(c) > -1) 
	return c;
	}
	return "";
	}
	//检查函数:
	function ischinese(s)
	{
	var errorChar;
	var badChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789><,[]{}?/+=|\\'\":;~!#$%()`";
	errorChar = isCharsInBag( s, badChar)
	if (errorChar != "" )
	{
	return false;
	} 
	return true;
	}
	/**
	*检查中文字符end
	*/
	
/**
*检查浏览器版本
* 传入浏览器版本字符串 例：'ie6' 'ie7' 'firefox3'
*/
function vNavigator(v){
var nt = '';
var nv = '';
window["MzBrowser"]={};
(function()
{
 if(MzBrowser.platform) return;

 var ua = window.navigator.userAgent;

 MzBrowser.platform = window.navigator.platform;

 MzBrowser.firefox = ua.indexOf("Firefox")>0;
 //MzBrowser.opera = typeof(window.opera)=="object";
 MzBrowser.ie = !MzBrowser.opera && ua.indexOf("MSIE")>0;
 //MzBrowser.mozilla = window.navigator.product == "Gecko";
 //MzBrowser.netscape= window.navigator.vendor=="Netscape";
 //MzBrowser.safari= ua.indexOf("Safari")>-1;

 if(MzBrowser.firefox) var re = /Firefox(\s|\/)(\d+(\.\d+)?)/;
 else if(MzBrowser.ie) var re = /MSIE( )(\d+(\.\d+)?)/;
 //else if(MzBrowser.opera) var re = /Opera(\s|\/)(\d+(\.\d+)?)/;
 //else if(MzBrowser.netscape) var re = /Netscape(\s|\/)(\d+(\.\d+)?)/;
 //else if(MzBrowser.safari) var re = /Version(\/)(\d+(\.\d+)?)/;
 //else if(MzBrowser.mozilla) var re = /rv(\:)(\d+(\.\d+)?)/;

 if("undefined"!=typeof(re)&&re.test(ua))
  MzBrowser.version = parseFloat(RegExp.$2);
 })();

  nv = MzBrowser.version;
  if(MzBrowser.ie)
  {
	nt = 'ie';
  }

  if(MzBrowser.firefox)
  {
    nt = 'firefox';
  }

  return (nt+nv)==v;
}
/**
 * 验证正整数
 */
function plusIntegerCheck(so,nullable) 
{ 
	v = $(so).value;
	var reg = /^\d+$/g;
	if(nullable){
		reg = /^\d*$/g;
	}
	return reg.test(v) ;
 } 
 /**
 *比较日期方法yyyy-MM-dd
 */
 function compareDate(startDate,endDate)
 {
 	var d1 = new Date($(startDate).value.replace(/-/g, "/"));
 	var d2 = new Date($(endDate).value.replace(/-/g, "/"));
 	if(Date.parse(d1) - Date.parse(d2) > 0) {
 		return false;
 	}else{
 		return true;
 	}
 }
 
 //根据身份证号码提取获取生日
function returnBirthday(value)
{
	//加入身份证检查函数
	if(!validateid(value))
	{
		return "" ;
	}
	//判断身份证是否是15位
	if(value.length==15)
	{				
		return "19"+value.slice(6,8)+"-"+value.slice(8,10)+"-"+value.slice(10,12);
	}
	if(value.length==18)
	{
		return value.slice(6,10)+"-"+value.slice(10,12)+"-"+value.slice(12,14);
	}
}
//格式化日期
function formatDate(id)
{
	var obj = document.getElementById(id) ;
	if(obj==undefined)
	{
		return ;
	}
	var reg = /^[1-9]{1}[0-9]{1}[0-9]{1}[0-9]{1}([0]{1}[1-9]{1}|[1]{1}[0-9]{1})([0]{1}[1-9]{1}|[1-3]{1}[0-9]{1})$/ ;
	var v = obj.value ;
	if(reg.test(v))
	{
		var y = v.substring(0,4) ;
		var m = v.substring(4,6) ;
		var d = v.substring(6) ;
		obj.value = y + "-" + m + "-" + d ;
	}
}

//移动select项目到目标select中
function moveTOselect(srid,tgid,ismultiple)
{
	if(srid==undefined||tgid==undefined)
	{	
		return ;
	}
	var src_obj = document.getElementById(srid) ;
	if(src_obj==undefined)
	{
		return ;
	}
	var tag_obj = document.getElementById(tgid) ;
	if(tag_obj==undefined)
	{
		return ;
	}
	if(ismultiple==undefined)
	{
		ismultiple= false ;
	}
	var src_sl_index = src_obj.selectedIndex ;
	if(src_sl_index!=-1)
	{
		var node = src_obj.options[src_sl_index] ;
		var rm_node = src_obj.removeChild(node) ;
		tag_obj.appendChild(rm_node) ;
		if(ismultiple)
		{
			moveTOselect(srid,tgid,ismultiple) ;
		}
	}
}

//全选或全不选多选列表方法
function selectAll(srid,b)
{
	if(srid==undefined)
	{	
		return ;
	}
	var src_obj = document.getElementById(srid) ;
	if(src_obj==undefined)
	{
		return ;
	}
	var len = src_obj.options.length ;
	for(var i=0;i!=len;++i)
	{
		var tmp = src_obj.options[i] ;
		tmp.selected = b ;
	}
}
//多选列表设值
function setSelected(srid,value)
{
	if(srid==undefined)
	{	
		return ;
	}
	var src_obj = document.getElementById(srid) ;
	if(src_obj==undefined)
	{
		return ;
	}
	var len = src_obj.options.length ;
	for(var i=0;i!=len;++i)
	{
		var tmp = src_obj.options[i] ;
		if(tmp.value==value)
		{
			tmp.selected = true ;
			break;
		}
	}
}