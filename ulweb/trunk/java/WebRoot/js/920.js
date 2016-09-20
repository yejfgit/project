// JavaScript Document

		var swf_width=473
		var swf_height=216
		
		var config='5|0xffffff|0x0A3B4C|80|0xffffff|0xCC9900|0x990000'
		
		var files='images/pid.jpg|images/img1.jpg'
		var links='#|#'
		var texts=''
		
		document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ swf_width +'" height="'+ swf_height +'">');
		document.write('<param name="movie" value="images/bcastr.swf"><param name="quality" value="high">');
		document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
		document.write('<param name="FlashVars" value="config='+config+'&bcastr_flie='+files+'&bcastr_link='+links+'&bcastr_title='+texts+'">');
		document.write('<embed src="images/bcastr.swf" wmode="opaque" FlashVars="config='+config+'&bcastr_flie='+files+'&bcastr_link='+links+'&bcastr_title='+texts+'& menu="false" quality="high" width="'+ swf_width +'" height="'+ swf_height +'" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />'); document.write('</object>'); 
		
		
		
		
		
		
		
		
		
		
		
