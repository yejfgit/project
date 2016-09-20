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