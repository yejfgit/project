// JavaScript Document
/*QQ:380608331 */
old = 6
function updateTabChange(vid,group)
{
	if(old==vid)
		return;
	var o = document.getElementById('tabHead'+vid);
	var oc = document.getElementById('tabContent'+vid);
	o.className="hotTab";
	oc.style.display = "";
	var o = document.getElementById('tabHead'+old);
	var oc = document.getElementById('tabContent'+old);
	o.className="";
	oc.style.display = "none";
	old = vid;
}

function sellay0(num){
 for(var id = 1;id<=3;id++)
 {
  var ss="tlist"+id;
  if(id==num)
  document.getElementById(ss).style.display="block";
  else
  document.getElementById(ss).style.display="none";
 }
 
 for(var id = 1;id<=3;id++)
 {
  var bb="ltitle"+id;
  if(id==num)
  document.getElementById(bb).className="active";
  else
  document.getElementById(bb).className="";
 } 
}


function MM_reloadPage(init) {  //reloads the window if Nav4 resized

  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {

    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}

  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();

}

MM_reloadPage(true);



function MM_openBrWindow(theURL,winName,features) { //v2.0

  window.open(theURL,winName,features);

}

















































document.write(unescape("%3Cstyle%3E%0D%0A%3C%21--%0D%0A.bank10%20%7Bclear%3A%20both%3Bheight%3A%2010px%3Boverflow%3A%20hidden%3B%7D%0D%0A.bank5%20%7Bclear%3Aboth%3Bheight%3A%205px%3Boverflow%3A%20hidden%3B%7D.bank%20%7Bclear%3A%20both%3Bheight%3A%201px%3Boverflow%3A%20hidden%3B%7D%0D%0A.bank17%20%7Bclear%3A%20both%3Bheight%3A%2017px%3Boverflow%3A%20hidden%3B%7D.fle%7B%20float%3Aleft%7D%20.fri%7Bfloat%3Aright%7D%0D%0A--%3E%0D%0A%3C/style%3E"))
