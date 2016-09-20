<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  	<link href="<%=basePath%>jsp/upload/default.css" rel="stylesheet" type="text/css" />
   	<script type="text/javascript" src="<%=basePath%>jsp/upload/swfupload.js"></script>
   	<script type="text/javascript" src="<%=basePath%>jsp/upload/swfupload.queue.js"></script>
    <script type="text/javascript" src="<%=basePath%>jsp/upload/fileprogress.js"></script>
    <script type="text/javascript" src="<%=basePath%>jsp/upload/handlers.js"></script>
   	<!-- 初始化swfupload 对象-->
   <script type="text/javascript">
		var upload1, upload2;

		window.onload = function() {
			upload1 = new SWFUpload({

				//提交路径
				upload_url: "<%=basePath%>upload.action",
				//向后台传递额外的参数
				post_params: {"name" : "kaobian"},
				//上传文件的名称
				file_post_name: "file",
				
				// 下面自己按照字面意思理解
				file_size_limit : "1024000",	// 1000MB
				file_types : "*.*",
				file_types_description : "All Files",
				file_upload_limit : "100",
				file_queue_limit : "100",

				// 事件处理
				file_dialog_start_handler : fileDialogStart,
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,

				// 按钮的处理
				button_image_url : "XPButtonUploadText_61x22.png",
				button_placeholder_id : "spanButtonPlaceholder1",
				button_width: 61,
				button_height: 22,
				
				// Flash Settings
				flash_url : "swfupload.swf",
				

				custom_settings : {
					progressTarget : "fsUploadProgress1",
					cancelButtonId : "btnCancel1"
				},
				
				// Debug Settings
				debug: false
			});
	     }
	    
	</script>
  </head>
  
  <body>
  <div id="content">
    <form action="upload.action" method="post" name="thisform" enctype="multipart/form-data">
		<table>
			<tr valign="top">
				<td>
					<div>
						<div class="fieldset flash" id="fsUploadProgress1">
							<span class="legend">文件上传</span>
						</div>
						<div style="padding-left: 5px;">
							<span id="spanButtonPlaceholder1"></span>
							<input id="btnCancel1" type="button" value="Cancel Uploads" onclick="cancelQueue(upload1);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" />
							<br />
						</div>
					</div>
				</td>
			</tr>
		</table>
    </form>
    </div>
  </body>
</html>
