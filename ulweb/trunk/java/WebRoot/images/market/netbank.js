//Credit Card Apply Window
function CCApply()
{
window.open('https://ccclub.Cmbchina.com/creditcard/Apply/apply.asp','newwin','height=550,width=760,top=10,left=30,scrollbars=no,toolbar=no,location=no,status=no,menubar=no,resizable=no,dependent=no');
}


function PBDemo()
{
 	open('http://www.cmbchina.com/cmbpb/v36/gb/demo/PBDemo1.htm','PBDemo','menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=yes,width=760,height=480,top=20,left=20');
}


function PDA_download()
{
 	open('http://www.cmbchina.com/PDAbank/PDADownload.htm','PDAWin','menubar=no,toolbar=no,location=no,directories=no,scrollbars=no,status=no,resizable=no,top=0,left=100,width=266,height=441');
}


function hbwindows()
{
 	open('https://pbnj.ebank.cmbchina.com/CmbBank_GenShell/UI/GenShellPC/Login/Login.aspx','newhb','menubar=no,toolbar=no,location=no,directories=no,scrollbars=yes,status=yes,resizable=yes');
}

function creditcardlogin()
{
 	open('https://pbsz.ebank.cmbchina.com/CmbBank_GenShell/UI/GenShellPC/Login/Login.aspx?LoginType=C','creditcard','menubar=no,toolbar=no,location=no,directories=no,scrollbars=yes,status=yes,resizable=yes');
}

function oldhbwindows()
{
 	open('https://www.sz1.cmbchina.com/script/hbyktlogin.htm','NewWindow','menubar=no,toolbar=no,location=no,directories=no,scrollbars=no,status=yes,resizable=yes,width=400,height=245');
}


function jkhhbwindows()
{
 	open('https://www.sz1.cmbchina.com/script/hbjkhlogin.htm','NewWindow','menubar=no,toolbar=no,location=no,directories=no,scrollbars=no,status=yes,resizable=yes,width=400,height=245');
}

function EWallet()
{
 	open('http://www.cmbchina.com/cmbpb/v36/pb.htm','EWallet','menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=no,width=600,height=400,top=60,left=100');
}

function OpenFirm()
{
    open('https://www.cmbchina.com/netpayment/basehttp.dll?FirmPreLogPage?',
        '', 'menubar=no,toolbar=no,location=no,directories=no,status=yes,scrollbars=1,resizable=1,top=100,left=100');
}

function yktapply()
{
 	open('https://www.nj1.cmbchina.com/script/yktapply.htm','yktapply','menubar=no,toolbar=no,location=no,directories=no,scrollbars=yes,status=yes,resizable=yes,width=430,height=255');
}

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

function zfkapply()
{
	open('https://www.nj1.cmbchina.com/script/PaymentApply_all.htm','zfkapply','menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=yes,width=530,height=520,top=1,left=1')
}

function zfkapplyOld()
{
	var date = new Date();
	var str = date.toString();
	var str2 = ':';
	len = str.length;
	for (i=0;i<len;i++){
		ch = str.substring(i,i+1);
		if (ch!=' '){
			str2 = str2+ch;
		}
	}
	open('https://www.sz1.cmbchina.com/script/BaseHttp.dll?HbLoadApplyZFKIfAgreePage?date='+str2,'zfkapply','menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=yes,width=730,height=520,top=1,left=1')
}

function OpenFbDemoWnd()
{
	open('/cmbchina2003/webpages/corporate/FbDemo/FbdemoIndex.htm','FbDemo','menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=yes,width=780,height=540,top=1,left=1');
}

function fbOpenWnd()
{
	open('/cmbchina2003/webpages/corporate/fb_download.htm','Fb','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,width=496,height=290,top=100,left=180');
}

function fbDownloadWnd()
{
	open('/cmbchina2003/webpages/corporate/fb_logon.htm','Fb','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,width=496,height=290,top=100,left=180');
}

function stkTradeWin()
{
	var date = new Date();
	var str = date.toString();
	var str2 = ':';
	len = str.length;
	for (i=0;i<len;i++)
	{
		ch = str.substring(i,i+1);
		if (ch!=' ')
		{
			str2 = str2+ch;
		}
	}
	open('https://www.nj1.cmbchina.com/stktrans/StockHttp.dll?LoadLogPage?date='+str2,'TransWindow','menubar=no,toolbar=no,location=no,directories=no,status=yes,scrollbars=auto,resizable=1,left=100,top=100,width=500,height=300');
}
var FbOpened=1;
function OpenWnd(Flag)
{
 if (Flag == 1 && FbOpened ==1)
 {
open('/cmb2005web/webpages/corporate/download/FbCommon38.htm','FbCommon38','menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=no,width=630,height=405,top=60,left=80');
  }
  else if(Flag == 2 && FbOpened ==1)
  {
open('/cmb2005web/webpages/corporate/download/Big5FbCommon38.htm','Big5FbCommon38','menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=no,width=630,height=405,top=60,left=80');
   }else alert("企业银行运行网页已经打开！");
}


function OpenHelp(iflag)
{
    if(iflag == 1)
    open('../v40/GB/PB_ApplyDirectory.htm','PBApply','menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=yes,width=610,height=550,top=0,left=0');
    else if(iflag == 2)
    open('../v42/GB/FL40.htm','FL','scrollbars=yes,width=610,height=550,top=0,left=0');
    else if(iflag == 3)
     open('http://szdl.cmbchina.com/flash/v42/pt.html','','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=800,height=550,top=0,left=0');
    else if(iflag == 4)
    open('../v42/GB/PB_ApplyDirectory_USB.htm','PBApply','menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=yes,width=610,height=550,top=0,left=0');      
    else if(iflag == 5)
    open('../v42/GB/PB_USBKey.htm','','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=610,height=460,top=0,left=0');
    else if(iflag == 6)
    open('../v45/GB/FL40.htm','FL','scrollbars=yes,width=610,height=550,top=0,left=0');    
}


function tip(url)
{
	open(url,'tip','menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,width=634,height=400,top=75,left=75');
}


var yjtWnd = null;
function yjtLogin()
{
	var nWinLeft = (screen.width-528)/2;
	var nWinTop = (screen.height-349)/2;
	if ( yjtWnd != null )
		yjtWnd.close();
	yjtWnd = window.open('http://www.cmbchina.com/cmb2005web/yjt/index.htm', 'yjtlogin', 'width=528,height=349,status=no,resizable=no,scrollbars=no,left='+nWinLeft+',top='+nWinTop);
}

var yztWnd = null;
function yztLogin()
{
	var nWinLeft = (screen.width-528)/2;
	var nWinTop = (screen.height-349)/2;
	if ( yztWnd != null )
		yztWnd.close();
	yztWnd = window.open('http://www.cmbchina.com/cmb2005web/webpages/yzt/yzt.htm', 'yztlogin', 'width=528,height=349,status=no,resizable=no,scrollbars=no,left='+nWinLeft+',top='+nWinTop);
}