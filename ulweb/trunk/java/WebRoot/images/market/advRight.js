<!--
var showad = true;
var Toppx = 100;   //�϶�λ��
var AdDivW = 90;  //���
var AdDivH = 300;  //�߶�
var PageWidth = 800; //ҳ����ٿ�����������ò��������ҹ�����
var MinScreenW = 1024; //��ʾ������С��Ļ������� 

var AdLeftHtml = '<div align="center" style="color:green;font-size:23pt;font-family:����;"><iframe id="MainWeatherForecast" name="showWnd" marginWidth="0" marginHeight="0" src="http://www.cmbchina.com/main/adv/advlr/left.htm" frameBorder="no" width="90" scrolling="no" height="300"></iframe></div>';
var AdRightHtml = '<div align="center" style="color:green;font-size:23pt;font-family:����;"><iframe id="MainWeatherForecast" name="showWnd" marginWidth="0" marginHeight="0" src="http://www.cmbchina.com/main/adv/advlr/right.htm" frameBorder="no" width="90" scrolling="no" height="300"></iframe></div>';
document.write ('<div id="Javascript.LeftDiv" style="position: absolute;background-color:#cccccc;z-index:1000;width:'+AdDivW+'px;height:'+AdDivH+'px;top:-1000px;word-break:break-all;display:none;">'+AdLeftHtml+'</div>');
document.write ('<div id="Javascript.RightDiv" style="position: absolute;background-color:#cccccc;z-index:1000;width:'+AdDivW+'px;height:'+AdDivH+'px;top:-1000px;word-break:break-all;display:none;">'+AdRightHtml+'</div>');

function scall(){
 if(!showad){return;}
 
 if (window.screen.width<MinScreenW){
  //alert("��ʱ��ʾ��\n\n��ʾ���ֱ��ʿ��С��"+MinScreenW+",����ʾ���");
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