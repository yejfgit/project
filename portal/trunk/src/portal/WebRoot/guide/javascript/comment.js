function comment(){
	var comment=$("#comment").val();
	if(comment==""){
		alert("没有评论");
	    return false;
	}
	var guideId=$("#guideId").val();
	var userId="11974";
	$.ajax({
		url : "guide/comment",
		type : "post",
		data : {
			"comment" : comment,
			"guideId" : guideId,
			"userId" : userId
		},
		dataType : "html",
		success : function(showResult) {
			//$("#comment").val(showResult)
			$("#show1").html(showResult);
		},
		error: function(XMLHttpRequest,textStatus,errorThrown){},
		complete:function(msg){}
	});
}