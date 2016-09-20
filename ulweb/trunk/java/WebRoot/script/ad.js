/*
	漂浮广告代码
*/
/*
var imagepath=""
var imagewidth=0 //这两行写图片的大小
var imageheight=0
var imageclick="" //这里写点击图片连接到的地址
*/
var speed=3;

var hideafter=0;
var isie=0;
if(window.navigator.appName=="Microsoft Internet Explorer"&&window.navigator.appVersion.substring(window.navigator.appVersion.indexOf("MSIE")+5,window.navigator.appVersion.indexOf("MSIE")+8)>=5.5) {
	isie=1;
}
else {
	isie=0;
}
if(isie){
//	var preloadit=new Image();
//	preloadit.src=imagepath;
}
function pop() {
	if(isie) {
		x=x+dx;y=y+dy;
		//oPopup.show(x, y, imagewidth, imageheight);
		oPopup.style.left=x;
		oPopup.style.top=y;
		oPopup.style.display='block';
		if(x+imagewidth+5>document.body.scrollWidth ) dx=-dx;
		if(y+imageheight+5>document.body.scrollHeight) dy=-dy;
//		alert(document.body.scrollHeight+":"+document.body.scrollWidth);
		if(x<0) dx=-dx;
		if(y<0) dy=-dy;
		oPopup.style.position='absolute';
		startani=setTimeout("pop();",50);
	}
}
function dismisspopup(){
	clearTimeout(startani);
	oPopup.style.display='none';
//	oPopup.hide();
}
function dowhat(){
	if (imageclick=="dismiss")
		dismisspopup();
	else if(imageclick == ""){
		
	}else{
		
		window.open(imageclick);

	}
}
if(isie) {

	var x=0,y=0,dx=speed,dy=speed;
	var oPopup = document.createElement();
	oPopup.innerHTML = '<div id="fguanggao" style="position:absolute"><IMG SRC="'+imagepath+'"></div>';

//	document.getElementById("cntContainer").innerHTML += oPopup.innerHTML;
	function showoPopup() 
    { 
    document.body.innerHTML += oPopup.innerHTML;
	oPopup = document.getElementById("fguanggao");
	oPopup.style.cursor="hand";
	oPopup.style.width=imagewidth;
	oPopup.style.zIndex=8000;
	oPopup.style.height=imageheight;
	oPopup.onmouseover=new Function("clearTimeout(startani)");
	oPopup.onmouseout=pop;
	oPopup.onclick=dowhat;
     } 
	window.onload = showoPopup;


	/*
	var oPopup =window.createPopup();
	var oPopupBody = oPopup.document.body;
	oPopupBody.style.cursor="hand";
	oPopupBody.innerHTML = '<IMG SRC="'+preloadit.src+'">';
	oPopup.document.body.onmouseover=new Function("clearTimeout(startani)");
	oPopup.document.body.onmouseout=pop;
	oPopup.document.body.onclick=dowhat;
	*/
	pop();
	if (hideafter>0)
		setTimeout("dismisspopup()",hideafter*1000);

}