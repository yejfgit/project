function onlyNumber(id){
	document.getElementById(id).value = document.getElementById(id).value.replace(/[^0-9]/g,'');
}