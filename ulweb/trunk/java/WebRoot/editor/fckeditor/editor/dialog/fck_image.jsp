<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
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
		<title>Image Properties</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="robots" content="noindex, nofollow"> 
		<script src="<%=path%>/editor/fckeditor/editor/dialog/common/fck_dialog_common.js" type="text/javascript"></script>
	</head>
	<body style="OVERFLOW: hidden">
		<div id="divInfo">
			<table cellspacing="1" cellpadding="1" border="0" width="100%" height="100%">
				<tr>
					<td>
						<table cellspacing="0" cellpadding="0" width="100%" border="0">
							<tr>
								<td width="100%">
									<span fckLang="DlgImgURL">URL</span>
								</td>
								<td id="tdBrowse" style="DISPLAY: none" nowrap rowspan="2">
									&nbsp; 
								</td>
							</tr>
							<tr>
								<td valign="top">
									<input id="txtUrl" value="<%=filePath%>" style="WIDTH: 100%" type="text" onblur="UpdatePreview();">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<span fckLang="DlgImgAlt">Short Description</span><br />
						<input id="txtAlt" style="WIDTH: 100%" type="text"><br />
					</td>
				</tr>
				<tr height="100%">
					<td valign="top">
						<table cellspacing="0" cellpadding="0" width="100%" border="0" height="100%">
							<tr>
								<td valign="top">
									<br />
									<table cellspacing="0" cellpadding="0" border="0">
										<tr>
											<td nowrap><span fckLang="DlgImgWidth">Width</span>&nbsp;</td>
											<td>
												<input type="text" size="3" id="txtWidth" onkeyup="OnSizeChanged('Width',this.value);"></td>
											<td nowrap rowspan="2">
												<div id="btnLockSizes" class="BtnLocked" onmouseover="this.className = (bLockRatio ? 'BtnLocked' : 'BtnUnlocked' ) + ' BtnOver';"
													onmouseout="this.className = (bLockRatio ? 'BtnLocked' : 'BtnUnlocked' );" title="Lock Sizes"
													onclick="SwitchLock(this);"></div>
												<div id="btnResetSize" class="BtnReset" onmouseover="this.className='BtnReset BtnOver';"
													onmouseout="this.className='BtnReset';" title="Reset Size" onclick="ResetSizes();"></div>
											</td>
										</tr>
										<tr>
											<td nowrap><span fckLang="DlgImgHeight">Height</span>&nbsp;</td>
											<td>
												<input type="text" size="3" id="txtHeight" onkeyup="OnSizeChanged('Height',this.value);"></td>
										</tr>
									</table>
									<br />
									<table cellspacing="0" cellpadding="0" border="0">
										<tr>
											<td nowrap><span fckLang="DlgImgBorder">Border</span>&nbsp;</td>
											<td>
												<input type="text" size="2" value="" id="txtBorder" onkeyup="UpdatePreview();"></td>
										</tr>
										<tr>
											<td nowrap><span fckLang="DlgImgHSpace">HSpace</span>&nbsp;</td>
											<td>
												<input type="text" size="2" id="txtHSpace" onkeyup="UpdatePreview();"></td>
										</tr>
										<tr>
											<td nowrap><span fckLang="DlgImgVSpace">VSpace</span>&nbsp;</td>
											<td>
												<input type="text" size="2" id="txtVSpace" onkeyup="UpdatePreview();"></td>
										</tr>
										<tr>
											<td nowrap><span fckLang="DlgImgAlign">Align</span>&nbsp;</td>
											<td>
												<select id="cmbAlign" onchange="UpdatePreview();">
													<option value="" selected></option>
													<option fckLang="DlgImgAlignLeft" value="left">Left</option>
													<option fckLang="DlgImgAlignAbsBottom" value="absBottom">Abs Bottom</option>
													<option fckLang="DlgImgAlignAbsMiddle" value="absMiddle">Abs Middle</option>
													<option fckLang="DlgImgAlignBaseline" value="baseline">Baseline</option>
													<option fckLang="DlgImgAlignBottom" value="bottom">Bottom</option>
													<option fckLang="DlgImgAlignMiddle" value="middle">Middle</option>
													<option fckLang="DlgImgAlignRight" value="right">Right</option>
													<option fckLang="DlgImgAlignTextTop" value="textTop">Text Top</option>
													<option fckLang="DlgImgAlignTop" value="top">Top</option>
												</select>
											</td>
										</tr>
									</table>
								</td>
								<td>&nbsp;&nbsp;&nbsp;</td>
								<td width="100%" valign="top">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
<script language="javascript">
	var oEditor		= window.parent.InnerDialogLoaded() ;
	var FCK			= oEditor.FCK ;
	var bImageButton = ( document.location.search.length > 0 && document.location.search.substr(1) == 'ImageButton' ) ;
	var oImage = FCK.Selection.GetSelectedElement() ;
	function Ok(){
		var bHasImage = ( oImage != null ) ;
		if ( !bHasImage ){
			if ( bImageButton ){
				oImage = FCK.EditorDocument.createElement( 'INPUT' ) ;
				oImage.type = 'image' ;
				oImage = FCK.InsertElementAndGetIt( oImage ) ;
			}
			else
				oImage = FCK.CreateElement( 'IMG' ) ;
		}
		else
			oEditor.FCKUndo.SaveUndoStep() ;
		UpdateImage( oImage ) ;
	}
	function UpdateImage( e ){
		e.src = GetE('txtUrl').value ;
		SetAttribute( e, "_fcksavedurl", GetE('txtUrl').value ) ;
	}
	Ok();
	window.close();
</script>
	</body>
</html>