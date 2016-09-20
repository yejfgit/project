$(document).ready(function(){
	
	$("ul.sidenav li").hover(function() {
		$(this).find("div").stop().animate({left: "200", opacity:1}, "fast").css("display","block");
		$(this).find(">a").addClass("current");
	},function(){
		$(this).find("div").stop().animate({left: "0", opacity: 0}, "fast");
		$(this).find(">a").removeClass("current");
	});
	
});
(function($){
	$.fn.hoverForIE6=function(option){
		var s=$.extend({current:"hover",delay:10},option||{});
		$.each(this,function(){
			var timer1=null,timer2=null,flag=false;
			$(this).bind("mouseover",function(){
				if (flag){
					clearTimeout(timer2);
				}else{
					var _this=$(this);
					timer1=setTimeout(function(){
						_this.addClass(s.current);
						flag=true;
					},s.delay);
				}
			}).bind("mouseout",function(){
				if (flag){
					var _this=$(this);timer2=setTimeout(function(){
						_this.removeClass(s.current);
						flag=false;
					},s.delay);
				}else{
					clearTimeout(timer1);
				}
			})
		})
	}
})(jQuery);