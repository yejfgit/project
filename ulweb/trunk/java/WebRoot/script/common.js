
var timeIndex = 0;

function openwin(url,winname)
{   
    window.open(url,"","width=600,height=500,scrollbars=yes,resizable=yes");    //开多个窗口
}
function openwint(url,winname)
{
    window.open(url,winname,"scrollbars=yes,menubar=no,resizable=yes");    //共用一个窗口 
}
function openwinn(url)
{
    window.open(url,'',"scrollbars=yes,resizable=yes,menubar=yes,location=yes,toolbar=yes,status=yes");   

}

function tableDisplayTd(tdName){
	
		document.getElementById(tdName).style.display = "";

}

function tableHiddenTd(tdName){
	
		document.getElementById(tdName).style.display = "none";

}

function slowDisplayTd(tdName, outTime, startTdNum, endTdNum){
		timeIndex = 1;
		window.setTimeout("displayOnTime('" + tdName + "'," + outTime + "," +  startTdNum + "," + endTdNum + ")",500);
}

function slowHiddenTd(tdName, outTime, startTdNum, endTdNum){
		timeIndex = 0;
		window.setTimeout("hiddenOnTime('" + tdName + "'," + outTime + "," +  startTdNum  + "," + endTdNum  + ")",500);
		
}

function displayOnTime(tdName, outTime, startTdNum, endTdNum){
	
	if(startTdNum <= endTdNum && timeIndex == 1){
			window.setTimeout("displayOnTime('" + tdName + "'," + outTime + "," +  (startTdNum + 1) + "," + endTdNum + ")",outTime);
			document.getElementById(tdName + startTdNum).style.display = "";
		}
}

function hiddenOnTime(tdName, outTime, startTdNum, endTdNum){
	if(startTdNum <= endTdNum && timeIndex == 0){
		window.setTimeout("hiddenOnTime('" + tdName + "'," + outTime + "," +  startTdNum  + "," + (endTdNum - 1 ) + ")",outTime);
		document.getElementById(tdName + endTdNum).style.display = "none";
	}
}