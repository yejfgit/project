(function Ajax() {
	
	var xmlhttp;
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	} else {
		// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}

	this.getXmlhttp = function() {
		return xmlhttp;
	}

	this.sendPost = function(url, param, target) {

		xmlhttp.open('post', url, true);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
	    		document.getElementById(target).innerHTML=xmlhttp.responseText;
	    	}
	    }
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send(param);
	
	}
	
	this.sendPostFunc = function(url, param, func) {

		xmlhttp.open('post', url, true);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
	    		func(xmlhttp.responseText)
	    	}
	    }
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send(param);
	
	}
	
	this.sendGet = function(url, target) {

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
	    		document.getElementById(target).innerHTML=xmlhttp.responseText;
	    	}
	    }
		xmlhttp.open('get', url, true);
		xmlhttp.send();
		
	}
	
})();

var overIndex = -1;
  function doUpAndDown() {

	//alert(event.keyCode);
	
	// up
	if (event.keyCode == 40) {
		//alert(overIndex + ',' + hintArray.length);
		if (overIndex >= hintArray.length - 1 || hintArray.length < 1) {
			return false;
		} else {
			overIndex++;
		}
		document.getElementById('hint' + overIndex).className = 'hint-over';
		showQueryStr(document.getElementById('hint' + overIndex));
		if (overIndex > 0) {
			document.getElementById('hint' + (overIndex - 1)).className = 'hint-out';
		}

	}
	
	// down
	if (event.keyCode == 38) {
		if (overIndex < 1) {
			return false;
		} else {
			overIndex--;
		}
		document.getElementById('hint' + overIndex).className = 'hint-over';
		showQueryStr(document.getElementById('hint' + overIndex));
		if (overIndex < hintArray.length) {
			document.getElementById('hint' + (overIndex + 1)).className = 'hint-out';
		}
		
	}
	
	// enter
	if (event.keyCode == 13) {
		if (overIndex != -1) {
			doSelect(document.getElementById('hint' + overIndex));
		}

	}
}

var hintArray;
function doSubmit1() {
	if (event.keyCode >= 37 && event.keyCode <= 40 || event.keyCode == 13) {
		return false;
	}


	var func = function(text) {
		
		hintArray = eval(text);
		var r = '';
		for (var i in hintArray) {
			r += '<div id=hint' + i + ' onclick="doSelect(this)" onmouseover="showQueryStr(this);" onmouseout=this.className="hint-out">' + hintArray[i] + '</div>';
		}
		document.getElementById('myDiv1').innerHTML = r;
		if(hintArray!=''){
			document.getElementById('myDiv1').style.display='block';	
		}else{
			document.getElementById('myDiv1').style.display='none';	
		}    
	}
	
	var name = document.getElementsByName('queryString')[0].value.replace(/(^\s+|\s+$)/g, '');
	if (name != '') {
		sendPostFunc(
		'search/footprint?',
		'queryString='+name+'&rnd=' + Math.random(), 
		func);
	} else {
		document.getElementById('myDiv1').innerHTML = '';
		document.getElementById('myDiv1').style.display='none';
	}
	doReset()
}


function doSelect(o) {
	var s = o.innerHTML;
	
	document.getElementsByName('queryString')[0].value = s;
	//o.parentNode.innerHTML = '';
	doReset()
	f1.submit();
}

function doReset() {
	overIndex = -1;
	hintArray = [];
}


//切换搜索资源
function goColumn(column){
	if(column=='ulweb2'){
		document.getElementById("source").value=column;
		f1.action = "search/searchUlweb2";
	}else if(column=='all'){
		document.getElementById("source").value=column;
		f1.action = "search/search";
	}

	f1.submit();
}

function showQueryStr(o){
	var s = o.innerHTML;
	
	document.getElementsByName('queryString')[0].value = s;
	o.className="hint-over";
}

