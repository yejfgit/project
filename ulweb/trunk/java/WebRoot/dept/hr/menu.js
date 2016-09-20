// JavaScript Document
function expand(s)
{
  var td = s;
  var d = td.getElementsByTagName("div").item(0);
  td.className = "menuHover";
  d.className = "menuHover";
}

function changeBackColor(s)
{
  var td = s;
  td.className = "menuHover"
}

function collapse(s)
{
  var td = s;
  var d = td.getElementsByTagName("div").item(0);
  td.className = "menuNormal";
  d.className = "menuNormal";
}

function recoverBackColor(s)
{
  var td = s;
  td.className = "menuNormal";
}


