<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<%
	String path=request.getContextPath();
	String filePath=request.getParameter("filePath");
	if(filePath==null){
		filePath="";
	}
%>
	<head>
		<title>Flash Properties</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta content="noindex, nofollow" name="robots">
		<script src="<%=path%>/editor/fckeditor/editor/dialog/common/fck_dialog_common.js" type="text/javascript"></script>
		<link href="<%=path%>/editor/fckeditor/editor/dialog/common/fck_dialog_common.css" type="text/css" rel="stylesheet">
	</head>
	<body scroll="no" style="OVERFLOW: hidden">
		<div id="divInfo">
			<table cellSpacing="1" cellPadding="1" width="100%" border="0">
				<tr>
					<td>
						<table cellSpacing="0" cellPadding="0" width="100%" border="0">
							<tr>
								<td width="100%"><span fckLang="DlgImgURL">URL</span></td>
								<td id="tdBrowse" style="DISPLAY: none" noWrap rowSpan="2">&nbsp;</td>
							</tr>
							<tr>
								<td vAlign="top"><input id="txtUrl" value="<%=filePath%>"  onblur="UpdatePreview();" style="WIDTH: 100%" type="text"></td>
							</tr>
						</table>
					</td>
				</tr>
				<TR>
					<TD>
						<table cellSpacing="0" cellPadding="0" border="0">
							<TR>
								<TD nowrap>
									<span fckLang="DlgImgWidth">Width</span><br>
									<input id="txtWidth" class="FCK__FieldNumeric" type="text" size="3">
								</TD>
								<TD>&nbsp;</TD>
								<TD>
									<span fckLang="DlgImgHeight">Height</span><br>
									<input id="txtHeight" class="FCK__FieldNumeric" type="text" size="3">
								</TD>
							</TR>
						</table>
					</TD>
				</TR>
				<tr>
					<td vAlign="top">
						<table cellSpacing="0" cellPadding="0" width="100%" border="0">
							<tr>
								<td valign="top" width="100%">
									<table cellSpacing="0" cellPadding="0" width="100%">
										<tr>
											<td><span fckLang="DlgImgPreview">Preview</span></td>
										</tr>
										<tr>
											<td id="ePreviewCell" valign="top" class="FlashPreviewArea">&nbsp;</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div id="divUpload" style="DISPLAY: none">
			<form id="frmUpload" method="post" enctype="multipart/form-data" action="" onsubmit="return CheckUpload();">
				<span fckLang="DlgLnkUpload">Upload</span><br />
				<input id="txtUploadFile" style="WIDTH: 100%" type="file" size="40" name="NewFile" /><br />
				<br />
				<input id="btnUpload" type="submit" value="上传到服务器"/>
			</form>
		</div>
		<div id="divAdvanced" style="DISPLAY: none">
			<TABLE cellSpacing="0" cellPadding="0" border="0">
				<TR>
					<TD nowrap>
						<span fckLang="DlgFlashScale">Scale</span><BR>
						<select id="cmbScale">
							<option value="" selected></option>
							<option value="showall" fckLang="DlgFlashScaleAll">Show all</option>
							<option value="noborder" fckLang="DlgFlashScaleNoBorder">No Border</option>
							<option value="exactfit" fckLang="DlgFlashScaleFit">Exact Fit</option>
						</select></TD>
					<TD>&nbsp;&nbsp;&nbsp; &nbsp;
					</TD>
					<td valign="bottom">
						<table>
							<tr>
								<td><input id="chkAutoPlay" type="checkbox" checked></td>
								<td><label for="chkAutoPlay" nowrap fckLang="DlgFlashChkPlay">Auto Play</label>&nbsp;&nbsp;</td>
								<td><input id="chkLoop" type="checkbox" checked></td>
								<td><label for="chkLoop" nowrap fckLang="DlgFlashChkLoop">Loop</label>&nbsp;&nbsp;</td>
								<td><input id="chkMenu" type="checkbox" checked></td>
								<td><label for="chkMenu" nowrap fckLang="DlgFlashChkMenu">Enable Flash Menu</label></td>
							</tr>
						</table>
					</td>
				</TR>
			</TABLE>
			<br>
			&nbsp;
			<table cellSpacing="0" cellPadding="0" width="100%" align="center" border="0">
				<tr>
					<td vAlign="top" width="50%"><span fckLang="DlgGenId">Id</span><br>
						<input id="txtAttId" style="WIDTH: 100%" type="text">
					</td>
					<td>&nbsp;&nbsp;</td>
					<td vAlign="top" nowrap><span fckLang="DlgGenClass">Stylesheet Classes</span><br>
						<input id="txtAttClasses" style="WIDTH: 100%" type="text">
					</td>
					<td>&nbsp;&nbsp;</td>
					<td vAlign="top" nowrap width="50%">&nbsp;<span fckLang="DlgGenTitle">Advisory Title</span><br>
						<input id="txtAttTitle" style="WIDTH: 100%" type="text">
					</td>
				</tr>
			</table>
			<span fckLang="DlgGenStyle">Style</span><br>
			<input id="txtAttStyle" style="WIDTH: 100%" type="text">
		</div>
<script language="javascript">
	var oEditor		= window.parent.InnerDialogLoaded() ;
	var FCK			= oEditor.FCK ;
	var FCKLang		= oEditor.FCKLang ;
	var FCKConfig	= oEditor.FCKConfig ;
	// Get the selected flash embed (if available).
	var oFakeImage = FCK.Selection.GetSelectedElement() ;
	var oEmbed ;
	if ( oFakeImage ){
		if ( oFakeImage.tagName == 'IMG' && oFakeImage.getAttribute('_fckflash') )
			oEmbed = FCK.GetRealElement( oFakeImage ) ;
		else
			oFakeImage = null ;
	}
//#### The OK button was hit.
function Ok(){
	if ( GetE('txtUrl').value.length == 0 ){
		window.parent.SetSelectedTab( 'Info' ) ;
		GetE('txtUrl').focus() ;
		alert( oEditor.FCKLang.DlgAlertUrl ) ;
		return false ;
	}
	if ( !oEmbed ){
		oEmbed		= FCK.EditorDocument.createElement( 'EMBED' ) ;
		oFakeImage  = null ;
	}
	UpdateEmbed( oEmbed ) ;
	oFakeImage	= oEditor.FCKDocumentProcessor_CreateFakeImage( 'FCK__Flash', oEmbed ) ;
	oFakeImage.setAttribute( '_fckflash', 'true', 0 ) ;
	oFakeImage	= FCK.InsertElementAndGetIt( oFakeImage ) ;
	return true ;
}
function UpdateEmbed( e ){
	SetAttribute( e, 'type'			, 'application/x-shockwave-flash' ) ;
	SetAttribute( e, 'pluginspage'	, 'http://www.macromedia.com/go/getflashplayer' ) ;
	e.src = GetE('txtUrl').value ;
	SetAttribute( e, "width" , GetE('txtWidth').value ) ;
	SetAttribute( e, "height", GetE('txtHeight').value ) ;
}
	Ok();
	window.close();
</script>
	</body>
</html>