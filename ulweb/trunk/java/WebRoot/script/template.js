	function subForm(){
		document.getElementById("idform1").action = "admin/template.do?method=changePic";
		document.getElementById("idform1").submit();	
	}
	
	function view(){
		document.getElementById("idform1").action = "admin/template.do?method=view";
		document.getElementById("idform1").submit();	
	}