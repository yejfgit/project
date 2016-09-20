
var adNum=0;
var buttonShow=1;//��ʾ��Ť���� 1:��ʾ 0:����ʾ
if(imgUrl.length>2) buttonShow=1; else buttonShow=0; //�Զ��ж��Ƿ���ʾ��Ť
//var buttonPos=2;//��Ť��ʾλ�� 1:���� 2:���� 3:���� 4:����
var buttonX;
var buttonY;
var imgPre=new Array();
var dakularCode="";//����ɰ�ŤHTML����
var adNum=0;

for (i=1;i<8;i++){
	imgPre[i]=new Image();
	imgPre[i].src=imgUrl[i];
}

function setTransition(){
	if (document.all){
		imgUrlrotator.filters.revealTrans.Transition=23;//Math.floor(Math.random()*23)
		imgUrlrotator.filters.revealTrans.apply();
	}
}

function playTransition(){
	if (document.all)
	imgUrlrotator.filters.revealTrans.play();
}

function nextAd(toNum){
	if(adNum<imgUrl.length-1)
	adNum++ ;
	else
	adNum=1;
	if(toNum!=null) adNum=toNum;
	setTransition();
	
	document.images.imgUrlrotator.src=imgUrl[adNum];
	document.images.imgUrlrotator.alt=text[adNum];
	//���Ҫ��ʾ���ֱ��⣬ȡ�������ע��
	//document.getElementById('linktext').innerHTML="<a href="+imgLink[adNum]+" target=_blank class=px14-lh20>"+text[adNum]+"</a>"; 
	playTransition();
	if(buttonShow==1){checkButton();}
	if(toNum!=null) toNum=null;
	theTimer=setTimeout("nextAd()", 6000);
}

function jump2url(){
	jumpUrl=imgLink[adNum];jumpTarget='_blank';
	if (jumpUrl != ''){
		if (jumpTarget != '')
		window.open("pic.htm?url=" + jumpUrl,jumpTarget,"width=" + (screen.width - 20) + ",height=" + (screen.height - 90) + ",left=3,top=3,scrollbars=yes,resizable=yes");
		else location.href=jumpUrl;
	}
}

function displayStatusMsg(){
	status=imgLink[adNum];
	document.returnValue = true;
}

function checkButton(){
	for(i=1;i<=imgUrl.length-1;i++){if(i==adNum)
		//document.getElementById('bt'+i).style.backgroundColor='#00FF00';
		eval("bt"+i+".style.backgroundColor='#4DAC26';bt"+i+".style.color='#FFFFFF';");
		else
		eval("bt"+i+".style.backgroundColor='#EFEFEF';bt"+i+".style.color='#000000';");
	}
}	//#9B0000 #CCCCCC

function dakularButtons(){if(buttonShow==1){
	document.getElementById('newsTable').style.position="relative";
	document.getElementById('newsTable').style.top="-8px";
	switch(buttonPos){
		case 1:{buttonX=282-imgUrl.length*20;buttonY=16;break;}
		case 2:{buttonX=500-imgUrl.length*20;buttonY=370;break;}
		case 3:{buttonX=imgUrl.length*20-100;buttonY=16;break;}
		case 4:{buttonX=imgUrl.length*20-100;buttonY=182;break;}
		default:{buttonX=282-imgUrl.length*20;buttonY=16;break;}
	}

	for(i=1;i<=imgUrl.length-1;i++){
		dakularCode=dakularCode+"<div id='bt"+i+"' style='display:inline; height=20px; width:20px; border:1px solid #000000; background-color:#CCCCCC; color:#000000; font-size:12px; line-height:14px; filter: Alpha(Opacity=100);' align='center' onMouseOver=this.style.backgroundColor='#FFFFFF';this.style.color='#000000';this.style.cursor='hand' onMouseOut=checkButton(); onClick='clearTimeout(theTimer);nextAd("+i+");'>&nbsp;"+i+"&nbsp;</div>";
	}
	dakularCode="<div style='display:inline; position:relative;left:"+buttonX+"px; top:"+buttonY+"px; z-index:1;'>"+dakularCode+"</div>"
	document.write(dakularCode);
	}
}