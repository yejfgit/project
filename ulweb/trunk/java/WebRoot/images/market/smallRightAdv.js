<!--
var smallrightshowad = true;
var smallrightToppx = 450;   //�϶�λ��
var smallrightAdDivW = 90;  //���
var smallrightAdDivH = 90;  //�߶�
var smallrightPageWidth = 800; //ҳ����ٿ�����������ò��������ҹ�����
var smallrightMinScreenW = 1024; //��ʾ������С��Ļ������� 

var AdRightHtml = '<div align="center" style="color:green;font-size:23pt;font-family:����;"><iframe id="RightSmallAdvlr" name="showWnd" marginWidth="0" marginHeight="0" src="http://www.cmbchina.com/main/adv/smalladvlr/right.htm" frameBorder="no" width="90" scrolling="no" height="90"></iframe></div>';
var ClosebuttonHtml = '<div align="right" style="position: absolute;top:90px;right:0px;padding:4px;z-index:2000;width:90px;background-color:#f6f6f6"><a href="javascript:;" onclick="hidesmallrightad()" style="color:black;text-decoration:none;font-size:12px;">�ر�</a></div>';
document.write ('<div id="smallRightDiv" style="position: absolute;background-color:white;z-index:1000;width:'+smallrightAdDivW+'px;height:'+smallrightAdDivH+'px;top:-1000px;word-break:break-all;display:none;">'+AdRightHtml+ClosebuttonHtml+'</div>');

function smallrightscall(){
 if(!smallrightshowad){return;}
 
 if (window.screen.width<smallrightMinScreenW){
  //alert("��ʱ��ʾ��\n\n��ʾ���ֱ��ʿ��С��"+MinScreenW+",����ʾ���");
  smallrightshowad = false;  
  document.getElementById("smallRightDiv").style.display="none";
  return;
 } 
  
 var Borderpx = ((window.screen.width-smallrightPageWidth)/2-smallrightAdDivW)/2; 
 
 document.getElementById("smallRightDiv").style.display="";
 document.getElementById("smallRightDiv").style.top=document.body.scrollTop+smallrightToppx;
 document.getElementById("smallRightDiv").style.left=document.body.scrollLeft+document.body.clientWidth-document.getElementById("smallRightDiv").offsetWidth-Borderpx; 
 setTimeout("smallrightscall();",20);
  
}

function hidesmallrightad()
{
 smallrightshowad = false; 
 document.getElementById("smallRightDiv").style.display="none";
}
//window.onscroll=smallrightscall;
//window.onload=scall;
smallrightscall();
//-->
