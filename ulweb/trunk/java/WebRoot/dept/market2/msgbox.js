	/*
	本Js代码用于创建一个自定义的确认窗口,
	具体功能包括:自定义窗口标题,自定义窗口内容,是否显示取消按钮,焦点位置设定
	*/
	function get_width(){
		return (document.documentElement.clientWidth+document.body.scrollLeft);
	}
	function get_height(){
		return (document.documentElement.clientHeight+document.body.scrollTop);
	}
	function get_left(w){
		var bw=document.documentElement.clientWidth;
		w=parseFloat(w);
		return (bw/2-w/2+document.body.scrollLeft);
	}
	function get_top(h){
		var bh=document.documentElement.clientHeight;
		h=parseFloat(h);
		return (bh/2-h/2+document.body.scrollTop);
	}
	function create_mask(){//创建遮罩层的函数
		var mask=document.createElement("div");
		mask.id="mask";
		mask.style.position="absolute";
		mask.style.filter="alpha(opacity=0)";//IE的不透明设置
		mask.style.opacity=0;//Mozilla的不透明设置
		mask.style.backgroundColor="#444844";
		mask.style.top="0px";
		mask.style.left="0px";
		mask.style.width='100%';
		mask.style.height='100%';
		mask.style.zIndex=5;
		document.body.appendChild(mask);
	}
	function create_msgbox(w, h, t) {//创建弹出对话框的函数
		var box=document.getElementById("msgbox");
		if (box) {
			return false;
		}
		var box=document.createElement("div");
		box.id="msgbox";
		box.style.position='absolute';
		box.style.width=w;
		box.style.height=h;
		box.style.overflow='visible';
		box.innerHTML=t;
		box.style.zIndex=1001;
		document.body.appendChild(box);
		re_pos();
	}
	function re_mask(){
		/*
		更改遮罩层的大小,确保在滚动以及窗口大小改变时还可以覆盖所有的内容
		*/
		var mask=document.getElementById("mask");
		if(null==mask)return;
		mask.style.width=get_width()+"px";
		mask.style.height=get_height()+"px";
	}
	function re_pos(){
		/*
		更改弹出对话框层的位置,确保在滚动以及窗口大小改变时一直保持在网页的最中间
		*/
		var box=document.getElementById("msgbox");
		if(box != null){
			var w=box.style.width;
			var h=box.style.height;
			box.style.left=get_left(w)+"px";
			box.style.top=get_top(h)+"px";
		}
	}
	function remove(){
		/*
		清除遮罩层以及弹出的对话框
		*/
		var mask=document.getElementById("mask");
		var msgbox=document.getElementById("msgbox");
		if(null==mask&&null==msgbox)return;
		document.body.removeChild(mask);
		document.body.removeChild(msgbox);
	}
	function remove_mask(){
		/*
		清除遮罩层
		*/
		var mask=document.getElementById("mask");
		if(null==mask)return;
		document.body.removeChild(mask);
	}	
	function msgbox(title,text,func,cancel,focus){
		/*		
		参数列表说明:
		title :弹出对话框的标题,标题内容最好在25个字符内,否则会导致显示图片的异常															
		text  :弹出对话框的内容,可以使用HTML代码,例如<font color='red'>删除么?</font>,如果直接带入函数,注意转义
		func  :弹出对话框点击确认后执行的函数,需要写全函数的引用,例如add(),如果直接带入函数,注意转义。
		cancel:弹出对话框是否显示取消按钮,为空的话不显示,为1时显示
		focus :弹出对话框焦点的位置,0焦点在确认按钮上,1在取消按钮上,为空时默认在确认按钮上
		
		*/
		create_mask();
		var temp="<table width=\"355\" height=\"127\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"font:14px Arial, Helvetica, sans-serif\">";
		temp+="<tr><td background=\"images/alert_01.gif\" width=\"355\" height=\"22\" style=\"padding-left:8px;padding-top:2px;font-weight: bold;color:white;\">"+title+"</td></tr>";
		temp+="<tr><td background=\"images/alert_02.gif\" width=\"355\" height=\"75\" style=\"padding-left:6px;padding-right:2px;padding-bottom:10px;\">&nbsp;<img src=\"images/alert_mark.gif\">&nbsp;"+text+"</td>";
		temp+="</tr><tr><td width=\"355\" height=\"22\" align=\"center\" background=\"images/alert_03.gif\"><input name=\"msgconfirmb\" type=\"button\" class=\"btn-01\" id=\"msgconfirmb\" value=\"确认\" onclick=\"remove();"+func+";\">";
		if(null!=cancel){temp+="&nbsp;&nbsp;<input name=\"msgcancelb\" type=\"button\" class=\"btn-01\" id=\"msgcancelb\" value=\"取消\" onclick=\"remove();\"></td>";}
		temp+="</tr><tr><td background=\"images/alert_04.gif\" width=\"355\" height=\"8\"></td></tr></table>";
		create_msgbox(400,200,temp);
		if(focus==0||focus=="0"||null==focus){document.getElementById("msgconfirmb").focus();}
		else if(focus==1||focus=="1"){document.getElementById("msgcancelb").focus();}		
	}
	function re_show(){
		/*
		重新显示遮罩层以及弹出窗口元素
		*/
		re_pos();
		re_mask();
	}
	function load_func(){
		/*
		加载函数,覆盖window的onresize和onscroll函数
		*/
		window.onresize=re_show;
		window.onscroll=re_show;	
	}