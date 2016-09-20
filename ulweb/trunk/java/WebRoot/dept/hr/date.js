// JavaScript Document
function getToday(color){
clientdate = new Date();
clientyear = clientdate.getYear();
if(clientyear < 300)clientyear = 1900 + clientyear;
clientmonth = clientdate.getMonth()+1;
clientday = clientdate.getDate();
weekday = clientdate.getDay();
if (weekday==0)
{
weekday="天"
}
if (weekday==1){
weekday="一"
}
if (weekday==2)
{
weekday="二"
}
if (weekday==3)
{
weekday="三"
}
if (weekday==4)
{
weekday="四"
}
if (weekday==5)
{
weekday="五"
}
if (weekday==6)
{
weekday="六"
}
document.write("<font color="+color+">"+clientyear+"年"+clientmonth+"月"+clientday+"日"+" 星期"+weekday+"</font>");
}