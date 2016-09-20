
var adNumWeihua=0;
var buttonShowWeihua=1;//��ʾ��Ť���� 1:��ʾ 0:����ʾ
if(imgUrlWeihua.length>2) buttonShowWeihua=1; else buttonShowWeihua=0; //�Զ��ж��Ƿ���ʾ��Ť
//var buttonPos=2;//��Ť��ʾλ�� 1:���� 2:���� 3:���� 4:����
var buttonXWeihua;
var buttonYWeihua;
var imgPreWeihua=new Array();
var dakularCodeWeihua="";//����ɰ�ŤHTML����
var adNumWeihua=0;

for (i=1;i<8;i++){
	imgPreWeihua[i]=new Image();
	imgPreWeihua[i].src=imgUrlWeihua[i];
}

function setTransitionWeihua(){
	if (document.all){
		imgUrl1rotatorWeihua.filters.revealTrans.Transition=23;//Math.floor(Math.random()*23)
		imgUrl1rotatorWeihua.filters.revealTrans.apply();
	}
}

function playTransitionWeihua(){
	if (document.all)
	imgUrl1rotatorWeihua.filters.revealTrans.play();
}

function nextAdWeihua(toNum){
	if(adNumWeihua<imgUrlWeihua.length-1)
	adNumWeihua++ ;
	else
	adNumWeihua=1;
	if(toNum!=null) adNumWeihua=toNum;
	setTransitionWeihua();
	
	document.images.imgUrl1rotatorWeihua.src=imgUrlWeihua[adNumWeihua];
	document.images.imgUrl1rotatorWeihua.alt=textWeihua[adNumWeihua];
	//���Ҫ��ʾ���ֱ��⣬ȡ�������ע��
	//document.getElementById('linktext').innerHTML="<a href="+imgLink[adNum]+" target=_blank class=px14-lh20>"+text[adNum]+"</a>"; 
	playTransitionWeihua();
	if(buttonShowWeihua==1){checkButtonWeihua();}
	if(toNum!=null) toNum=null;
	theTimer=setTimeout("nextAdWeihua()", 6000);
}

function jump2urlWeihua(){
	jumpUrl=imgLinkWeihua[adNumWeihua];jumpTarget='_blank';
	if (jumpUrl != ''){
		if (jumpTarget != '')
		window.open(jumpUrl,jumpTarget);
		else location.href=jumpUrl;
	}
}

function displayStatusMsgWeihua(){
	status=imgLinkWeihua[adNumWeihua];
	document.returnValue = true;
}

function checkButtonWeihua(){
	for(i=1;i<=imgUrlWeihua.length-1;i++){if(i==adNumWeihua)
		//document.getElementById('bt'+i).style.backgroundColor='#00FF00';
		eval("btWeihua"+i+".style.backgroundColor='#4DAC26';btWeihua"+i+".style.color='#FFFFFF';");
		else
		eval("btWeihua"+i+".style.backgroundColor='#EFEFEF';btWeihua"+i+".style.color='#000000';");
	}
}	//#9B0000 #CCCCCC

function dakularButtonsWeihua(){if(buttonShowWeihua==1){
	document.getElementById('newsTableWeihua').style.position="relative";
	document.getElementById('newsTableWeihua').style.top="-8px";
	switch(buttonPosWeihua){
		case 1:{buttonXWeihua=282-imgUrlWeihua.length*20;buttonYWeihua=16;break;}
		case 2:{buttonXWeihua=485-imgUrlWeihua.length*20;buttonYWeihua=145;break;}
		case 3:{buttonXWeihua=imgUrlWeihua.length*20-100;buttonYWeihua=16;break;}
		case 4:{buttonXWeihua=imgUrlWeihua.length*20-100;buttonYWeihua=182;break;}
		default:{buttonXWeihua=282-imgUrlWeihua.length*20;buttonYWeihua=16;break;}
	}

	for(i=1;i<=imgUrlWeihua.length-1;i++){
		dakularCodeWeihua=dakularCodeWeihua+"<div id='btWeihua"+i+"' style='display:inline; height=24px; width:20px; border:1px solid #000000; background-color:#CCCCCC; color:#000000; font-size:12px; line-height:14px; filter: Alpha(Opacity=100);' align='center' onMouseOver=this.style.backgroundColor='#FFFFFF';this.style.color='#000000';this.style.cursor='hand' onMouseOut=checkButtonWeihua(); onClick='clearTimeout(theTimer);nextAdWeihua("+i+");'>&nbsp;"+i+"&nbsp;</div>";
	}
	dakularCodeWeihua="<div style='display:inline; position:relative;left:"+buttonXWeihua+"px; top:"+buttonYWeihua+"px; z-index:1;'>"+dakularCodeWeihua+"</div>"
	document.write(dakularCodeWeihua);
	}
}