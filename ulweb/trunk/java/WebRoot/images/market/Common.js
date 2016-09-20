

	var g_element = window.document.all;
	function OpenSub (name)
	{
		if (g_element[name].style.display == "none")
		{
			g_element[name].style.display = "";
			g_element[name+"_img"].src = "../../images/hbw_minus_0.gif";
		}
		else
		{
			g_element[name].style.display = "none";
			g_element[name+"_img"].src = "../../images/hbw_adding_0.gif";
		}
	}
//ICS 
var icsWnd = null;
	var switchWnd = null;
	function fLoginICS(){
		var nWinLeft = (screen.width-600)/2;
		var nWinTop = (screen.height-400)/2;
		if ( icsWnd != null )
			icsWnd.close();
		icsWnd = window.open('https://forum.cmbchina.com/cmu/icslogin.aspx?from=B&logincmu=0', 'icslogin', 'width=600,height=400,status=yes,left='+nWinLeft+',top='+nWinTop);
	}
function Login(type)
{
	var date = new Date();
	var str = date.toString();
	var str2 = '0';
	len = str.length;
	for (i=0;i<len;i++){
		ch = str.substring(i,i+1);
		if ((ch!=' ')&&(ch!=':')){
			str2 = str2+ch;
		}
	}
	//window.open("https://app.cmbchina.com/pension/pension.dll?LoadLoginPage?date=" + str2 + "&type=" + type,"","width=800,height=550,scrollbars=yes,resizable=yes,status=yes,left=0,top=0");
	window.open("https://app.cmbchina.com/pension/pension.dll?LoadLoginPage?date=" + str2 + "&type=" + type,"","width=800,height=560,scrollbars=yes,resizable=yes,status=yes,left=0,top=0");
}



	    
	    function cmbrate(url,w,h)
		{
 			open(url,'cmbrate','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width='+w+',height='+h+',top=50,left=50');
		}
		
		function branchlogin(url,w,h)
		{
 			open(url,'cmbrate','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width='+w+',height='+h+',top=50,left=50');
		}

		function cmbcal(url,w,h)
		{
 			open(url,'cmbcalculator','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width='+w+',height='+h+',top=50,left=130');
		}

		function cmbbranch(url)
		{
 			open(url,'cmbjibao','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=600,height=400,top=50,left=50');
		}
		//cmb stock base info
		 function cmbstockinfo(url)
		{
 			open(url,'cmbstockbaseinfo','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=610,height=500,top=50,left=50');
		}

		function onlineQA_search(url)
		{
 			open(url,'cmbjibao','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=600,height=500,top=50,left=50');
		}

		function leaveMessage()
		{
 			open('/Cmb2005web/cmbaspxbin/common/cmbcustomer.aspx','cmbjibao','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=634,height=450,top=100,left=40');
		}

		function DemoWinScroll(url,w,h)
		{
 			open(url,'','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=yes,scrollbars=yes,width='+w+',height='+h+',top=0,left=0');
		}

		function ColAdvWin(url,w,h)
		{
 			open(url,'','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,width='+w+',height='+h+',top=50,left=50');
		}	

		function ColAdvWinScroll(url,w,h)
		{
 			open(url,'','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=yes,scrollbars=yes,width='+w+',height='+h+',top=50,left=50');
		}

		function ColAdvFullWin(url)
		{
 			open(url,'','');
		}

		function scrollAdv(url,param)
		{
 			open(url,'',param);
		}
//从个人业务取网点信息
		function getBranchInfo(pname)
		{
 			open('/Cmb2005web/cmbaspxbin/cmbbranch/'+pname+'_list.aspx?city='+document.branchInfo.city.options[document.branchInfo.city.selectedIndex].value,'cmbjibao','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=634,height=450,top=50,left=50');
		}
		//取Lady网点信息
		function getLcShopInfo(pname)
		{
 			open('/Cmb2005web/cmbaspxbin/cmbbranch/'+pname+'_list.aspx?city='+document.LadyCard.ladyCardCity1_lccityDropDownList.options[document.LadyCard.ladyCardCity1_lccityDropDownList.selectedIndex].value,'cmblcshop','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=634,height=450,top=50,left=50');
		}
//从分行主页取网点信息
		function BranchInfoList(typename,cityname)
		{
 			open('/Cmb2005web/cmbaspxbin/cmbbranch/'+typename+'_list.aspx?city='+cityname,'cmbBranch','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=634,height=450,top=50,left=50');
		}
		function onlineQASearch()
		{
 			open('/cmbchina2003/cmbaspxbin/onlineqa/Fb_onlineQASR.aspx?type='+document.fbonlineQA.inputType.options[document.fbonlineQA.inputType.selectedIndex].value+'&keyword='+document.fbonlineQA.custInput.value,'cmbjibao','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=620,height=440,top=50,left=50');
		}

	  function openCont(URL)
	 {
 		open(URL,'','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=634,height=450,top=100,left=40');
	  }
	 
	  function popWin(URL)
	 {
 		open(URL,'高管人员简历','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=390,height=260,top=200,left=300');
	  }
	  
	function WMzybDownload()
	{
 		open('http://99.1.101.64/personalbank/pb50/wa/index.htm','WMzyb','menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=no,width=580,height=360,top=60,left=100');
	}

	function WMAzybInstall()
	{
		open('http://wma.cmbchina.com/cmbinvestcenter/wmazyb/wmzybinstall.htm','wmzybinstall','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=590,height=400,top=60,left=80');
	}

    function OpenNewsWnd(newsid)
          {
           open('/Cmb2005web/cmbaspxbin/information/ForexDetailDisplay.aspx?curNewsID='+newsid,'新闻详细内容','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=yes,scrollbars=yes,width=640,height=400,top=100,left=40');    
          }
    function OpenSJXRNewsWnd(newsid)
          {
           open('/Cmb2005web/cmbaspxbin/information/ForexDetailDisplay.aspx?provider=SJXR&&curNewsID='+newsid,'新闻详细内容','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=yes,scrollbars=yes,width=640,height=400,top=100,left=40');    
          }
	function popupwin(url,l,t,w,h)
	{
		open(url,'','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=yes,scrollbars=yes,width='+w+',height='+h+',top='+l+',left='+t);
	}
	
	function popprintwin(url)
	{
		open(url,'','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=yes,scrollbars=yes,width=620,height=500,top=40,left=40');
	}   
 
 	function cmbrate(url,w,h)
		{
 			open(url,'cmbrate','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width='+w+',height='+h+',top=50,left=50');
		}
        
	function webSearch()
	{
		
		var keyword=document.getElementById("searchStr").value;
		if (document.getElementById("searchStr").value == "")
			document.getElementById("searchStr").value="请输入关键字"
		else
			open('http://search.cmbchina.com/cgi-bin/wstsearch?tn=wst&ch_id=0&query='+keyword,'cmbwebsearch','');
	}

    // 添加股票代码为空提示
function Alert_Empty()
 { 
      var curStockIdName=document.MyStockModify.stockidTextBox.value  
      if (curStockIdName=="")
      { 
         alert("请输入股票代码!") 
         document.MyStockModify.stockidTextBox.focus() 
         window.event.returnValue = false; 
         return
      }
    } 
    //删除股票代码前提示
function confirmDelete(code) 
{
    if (confirm("\r\n您确实要删除吗？\r\n代码："+code)) {
       window.event.returnValue = true;
    }
    else
    {
	  window.event.returnValue = false;
	}
}
    //删除收藏标题前提示
function confirmDeleteInfo(title) 
{
    if (confirm("\r\n您确实要删除此条信息吗？\r\n标题："+title+"")) {
       window.event.returnValue = true;
    }
     else
    {
	  window.event.returnValue = false;
	}
}
// Industry Category tree
<!--
	var divInnerHtml = "";
	function change(){
		if(!document.all)
			return
		if (event.srcElement.id=="folder") {
			var srcIndex = event.srcElement.sourceIndex
			var nested = document.all[srcIndex+2]
			if (nested.style.display=="none") {
				nested.style.display='block'
				event.srcElement.src = "../../images/open.gif";
			}
			else {
				nested.style.display="none"
				event.srcElement.src = "../../images/fold.gif";
			}
		}
	}
	
	//获取焦点
	
	function GetFocus()
	{
	  document.getElementById("TextBox1").focus();
	}
	
function scrollAdv(url,param)
{
 open(url,'cmbscrolladv',param);
}

//-->
//去掉空格
function Trim(str){
 if(str.charAt(0) == " "){
  str = str.slice(1);
  str = Trim(str); 
 }
 return str;
}
//===================日期/时间选择
function ChooseDateTime(obj)
{
	var retVal = window.showModalDialog("/cmbInvestCenter/InvestAspxBin/service/calendarWin.aspx?type=dateTime&date="+obj.value ,null, "dialogHeight:250px;dialogWidth:285px;scroll:no;status:no;help:no");
	if(retVal != null && retVal != "")
	{
		obj.value = retVal;
	}
	//window.event.returnValue = false;
}
function ChooseDate(obj)
{
	var retVal = window.showModalDialog("/cmbInvestCenter/InvestAspxBin/service/calendarWin.aspx?type=date&date="+obj.value ,null, "dialogHeight:250px;dialogWidth:285px;scroll:no;status:no;help:no");
	if(retVal != null && retVal != "")
	{
		obj.value = retVal;
	}
	//window.event.returnValue = false;
}
//open new page of dropdownlist
function opennew(selectname){
	var myindex=selectname.selectedIndex;
	if (myindex == 0){return;}
	window.open(selectname.options[myindex].value,null,"",true);
}
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
//Set cookies
function setCookie(name, value) {
   expiryday=new Date();
   expiryday.setTime(expiryday.getTime()+30*30*24*60*60*1*1000);
   //保存设置三十个月
   document.cookie = name + "=" + escape(value)
   + "; expires=" + expiryday.toGMTString() + "; domain=cmbchina.com; path=/";
}
function getCookie(Name) {
   var search = Name + "="
   if (document.cookie.length > 0) { // if there are any cookies
      offset = document.cookie.indexOf(search) 
      if (offset != -1) { // if cookie exists 
         offset += search.length 
         end = document.cookie.indexOf(";", offset) 
         if (end == -1) 
            end = document.cookie.length
         return unescape(document.cookie.substring(offset, end))
      } 
   }
   return 0;
}
//Credit Card Promotion Query
  function CCProm()
	 {	open("http://ccclub.cmbchina.com/CreditCardProm/CustomerQuery.aspx",'','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=634,height=450,top=100,left=40');
	  }
	  
	  function gettime(str)
 { var a=window.showModalDialog("/cmb2005web/cmbaspxbin/cmbreview/1.aspx",1,"dialogWidth=320px;dialogHeight=270px;scroll=no;status=no"); 
	if(a!=null)
		{document.getElementById(str).innerText=a;} }