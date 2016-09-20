
var adNum1=0;
var buttonShow1=1;//��ʾ��Ť���� 1:��ʾ 0:����ʾ
if(imgUrl1.length>2) buttonShow1=1; else buttonShow1=0; //�Զ��ж��Ƿ���ʾ��Ť
//var buttonPos1=2;//��Ť��ʾλ�� 1:���� 2:���� 3:���� 4:����
var buttonX1;
var buttonY1;
var imgPre1=new Array();
var dakularCode1="";//����ɰ�ŤHTML����
var adNum1=0;

for (i=1;i<8;i++){
	imgPre1[i]=new Image();
	imgPre1[i].src=imgUrl1[i];
}

function setTransition1(){
	if (document.all){
		imgUrl1rotator.filters.revealTrans.Transition=23;//Math.floor(Math.random()*23)
		imgUrl1rotator.filters.revealTrans.apply();
	}
}

function playTransition1(){
	if (document.all)
	imgUrl1rotator.filters.revealTrans.play();
}

function nextAd1(toNum){
	if(adNum1<imgUrl1.length-1)
	adNum1++ ;
	else
	adNum1=1;
	if(toNum!=null) adNum1=toNum;
	setTransition1();
	
	document.images.imgUrl1rotator.src=imgUrl1[adNum1];
	document.images.imgUrl1rotator.alt=text1[adNum1];
	//���Ҫ��ʾ���ֱ��⣬ȡ�������ע��
	//document.getElementById('linktext1').innerHTML="<a href="+imgLink1[adNum1]+" target=_blank class=px14-lh20>"+text1[adNum1]+"</a>"; 
	playTransition1();
	if(buttonShow1==1){checkButton1();}
	if(toNum!=null) toNum=null;
	theTimer=setTimeout("nextAd1()", 6000);
}

function jump2url1(){
	jumpUrl=imgLink1[adNum1];jumpTarget1='_blank';
	if (jumpUrl != ''){
		if (jumpTarget1 != '')
		window.open(jumpUrl,jumpTarget1);
		else location.href=jumpUrl;
	}
}

function displayStatusMsg1(){
	status=imgLink1[adNum1];
	document.returnValue = true;
}

function checkButton1(){
	for(i=1;i<=imgUrl1.length-1;i++){if(i==adNum1)
		//document.getElementById('bt'+i).style.backgroundColor='#00FF00';
		eval("bt1"+i+".style.backgroundColor='#4DAC26';bt1"+i+".style.color='#FFFFFF';");
		else
		eval("bt1"+i+".style.backgroundColor='#EFEFEF';bt1"+i+".style.color='#000000';");
	}
}	//#9B0000 #CCCCCC

function dakularButtons1(){if(buttonShow1==1){
	document.getElementById('newsTable1').style.position="relative";
	document.getElementById('newsTable1').style.top="-8px";
	switch(buttonPos1){
		case 1:{buttonX1=282-imgUrl1.length*20;buttonY1=16;break;}
		case 2:{buttonX1=240-imgUrl1.length*20;buttonY1=160;break;}
		case 3:{buttonX1=imgUrl1.length*20-100;buttonY1=16;break;}
		case 4:{buttonX1=imgUrl1.length*20-100;buttonY1=182;break;}
		default:{button1X=282-imgUrl1.length*20;buttonY1=16;break;}
	}

	for(i=1;i<=imgUrl1.length-1;i++){
		dakularCode1=dakularCode1+"<div id='bt1"+i+"' style='display:inline; height=24px; width:20px; border:1px solid #000000; background-color:#CCCCCC; color:#000000; font-size:12px; line-height:14px; filter: Alpha(Opacity=100);' align='center' onMouseOver=this.style.backgroundColor='#FFFFFF';this.style.color='#000000';this.style.cursor='hand' onMouseOut=checkButton1(); onClick='clearTimeout(theTimer);nextAd1("+i+");'>&nbsp;"+i+"&nbsp;</div>";
	}
	dakularCode1="<div style='display:inline; position:relative;left:"+buttonX1+"px; top:"+buttonY1+"px; z-index:1;'>"+dakularCode1+"</div>"
	document.write(dakularCode1);
	}
}