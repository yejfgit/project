<!--
var showad = true;
var Toppx = 100;   //上端位置
var AdDivW = 90;  //宽度
var AdDivH = 300;  //高度
var PageWidth = 800; //页面多少宽度象素下正好不出现左右滚动条
var MinScreenW = 1024; //显示广告的最小屏幕宽度象素 

var AdLeftHtml = '<div align="center" style="color:green;font-size:23pt;font-family:黑体;"><iframe id="MainWeatherForecast" name="showWnd" marginWidth="0" marginHeight="0" src="http://www.cmbchina.com/main/adv/advlr/left.htm" frameBorder="no" width="90" scrolling="no" height="300"></iframe></div>';
var AdRightHtml = '<div align="center" style="color:green;font-size:23pt;font-family:黑体;"><iframe id="MainWeatherForecast" name="showWnd" marginWidth="0" marginHeight="0" src="http://www.cmbchina.com/main/adv/advlr/right.htm" frameBorder="no" width="90" scrolling="no" height="300"></iframe></div>';
document.write ('<div id="Javascript.LeftDiv" style="position: absolute;background-color:#cccccc;z-index:1000;width:'+AdDivW+'px;height:'+AdDivH+'px;top:-1000px;word-break:break-all;display:none;">'+AdLeftHtml+'</div>');
document.write ('<div id="Javascript.RightDiv" style="position: absolute;background-color:#cccccc;z-index:1000;width:'+AdDivW+'px;height:'+AdDivH+'px;top:-1000px;word-break:break-all;display:none;">'+AdRightHtml+'</div>');

function scall(){
 if(!showad){return;}
 
 if (window.screen.width<MinScreenW){
  //alert("临时提示：\n\n显示器分辨率宽度小于"+MinScreenW+",不显示广告");
  showad = false;
  document.getElementById("Javascript.LeftDiv").style.display="none";
  document.getElementById("Javascript.RightDiv").style.display="none";
  return;
 }
 var Borderpx = ((window.screen.width-PageWidth)/2-AdDivW)/2;

 document.getElementById("Javascript.LeftDiv").style.display="";
 document.getElementById("Javascript.LeftDiv").style.top=Toppx;
 document.getElementById("Javascript.LeftDiv").style.left=Borderpx;
 document.getElementById("Javascript.RightDiv").style.display="";
 document.getElementById("Javascript.RightDiv").style.top=Toppx;
 document.getElementById("Javascript.RightDiv").style.left=document.body.clientWidth-document.getElementById("Javascript.RightDiv").offsetWidth-Borderpx;
}

function hidead()
{
 showad = false;
 document.getElementById("Javascript.LeftDiv").style.display="none";
 document.getElementById("Javascript.RightDiv").style.display="none";
}
//window.onscroll=scall;
window.onresize=scall;
window.onload=scall;
//-->