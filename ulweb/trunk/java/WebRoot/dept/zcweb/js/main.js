// JavaScript Document
function time()
{
	var oTime=new Date();
	var oSpa=document.getElementById('toptimr');
	var oFs=document.getElementById('toptim1');
	var oYear=oTime.getFullYear();
	var oMonth=oTime.getMonth()+1;
	var oDate=oTime.getDate();
	var newArr=["星期一","星期二","星期三","星期四","星期五","星期六","星期日"]
	var oDay=oTime.getDay();
	var oHours=oTime.getHours();
	var h=["早上好!","中午好!","下午好!","晚上好!"]
	if(oHours>=1&&oHours<11)
	{
		oFs.innerHTML=h[0];
		}
	else if(oHours>=11&&oHours<13)
	{
		oFs.innerHTML=h[1];
		}
	else if(oHours>=13&&oHours<18)
	{
		oFs.innerHTML=h[2];
		}
	else{
		oFs.innerHTML=h[3];
		}
	oSpa.innerHTML="&nbsp;今天是"+oYear+"年"+oMonth+"月"+oDate+"日&nbsp;"+newArr[oDay];
	}
	
function hd(){
	var i=0;
	hdtab();
	function hdtab(){	
		var x=document.getElementById('tabpic').getElementsByTagName('img');
		var y=document.getElementById('tabpic').getElementsByTagName('li');
		var z=document.getElementById('tabpic').getElementsByTagName('span')[0];
		var m;
		pictab();
		function pictab()									
		{
			if(i>=x.length){
				i=0;
				}
			for(m=0;m<x.length;m++){
				x[m].style.display="none";
				y[m].className="";
				}
			x[i].style.display="block";
			y[i].className="tabin";
			z.innerHTML=x[i].alt;
			i++;
			}
		st=setInterval(pictab,3000);
		for(m=0;m<x.length;m++){					
			y[m].index=m;										
			y[m].onclick=function(){
				clearInterval(st);
				i=this.index;
				for(m=0;m<x.length;m++){
					x[m].style.display="none";
					y[m].className="";
					}
				x[i].style.display="block";
				y[i].className="tabin";
				z.innerHTML=x[i].alt;
				setTimeout(hdtab,2000)
				}
			}
		}
	}
	
//切换合众资产播报
/*function qh()
{
	var otab1=document.getElementById('tab1');
	var otab2=document.getElementById('tab2');
	var onr1=document.getElementById('nr1');
	var onr2=document.getElementById('nr2');
	otab1.onmouseover=function ()
	{
		onr2.style.display="none";
		otab2.style.borderBottom="0";
		onr1.style.display="block";
		otab1.style.borderBottom="1px solid #eefaf6";
		}
	otab2.onmouseover=function ()
	{
		onr1.style.display="none";
		otab1.style.borderBottom="0";
		onr2.style.display="block";
		otab2.style.borderBottom="1px solid #eefaf6";
		}
	}*/

function xs()
{
	var omr=document.getElementById('mr');
	var opo=document.getElementById('mr_po');
	var timer;
	omr.onmouseout=opo.onmouseout=function()
	{
		timer=setTimeout(function ()
		{
			opo.style.display="none";
			},1000)
		}
	omr.onmouseover=opo.onmouseover=function ()
	{
		clearTimeout(timer);
		opo.style.display="block";
		}
	}