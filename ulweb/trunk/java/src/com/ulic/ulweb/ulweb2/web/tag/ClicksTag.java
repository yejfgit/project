package com.ulic.ulweb.ulweb2.web.tag;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: ������</p>
 * @author liubaojun
 * @version 1.0
 */

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.service.IContentService;



public class ClicksTag extends BodyTagSupport
{


	private Object contentId = null;

	public Object getContentId() {
		return contentId;
	}

	public void setContentId(Object contentId) {
		this.contentId = contentId;
	}

	public ClicksTag() {
		super();
	}

	public int doStartTag() throws JspException {
		try {
			String selectHTML = null;
			IContentService cons = (IContentService) ServiceLocator
			.getService("contentAdminService");
			
			/*if( "80".equals(items) ) {// umOrganId to organName
//				name = getUmOrganName(id);
			}
//			else if( "90".equals(type) ) {// umOrganId to organAbbrName
//				name = getUmOrganAbbrName(id);
//			}
//			else if( "85".equals(type) ) {// umUserId to organName
//				name = getUmOrganNameByUserId(id);
//			}
			else if( "70".equals(items) ) {// umUserId to userName
//				name = getUmUserName(id);
			}
			else if( "60".equals(items) ) {// umUserId to userName
//				name = getBudgetOrganName(id);
			}
			else {
				selectHTML = getForSelect(name,value,items ,disabled,onChange); //码表id to name
			}
			
			if( selectHTML == null || selectHTML.length() == 0) {
				selectHTML = name;
			}*/
			pageContext.getOut().write(String.valueOf(cons.getContentClicks((Integer)contentId)));
		}
		catch (Exception ex) {
			Log log = LogFactory.getLog(ClicksTag.class);
			log.debug(ex);
		}
		return (SKIP_BODY);
	}
	

	public void release() {
		super.release();
		contentId = null;

	}
	
	/**
	 * id to name
	 * @author zhangwei009
	 * @throws GenericException 
	 * @2012-9-29
	 */
	private static String getForSelect(String name,String value,String items,String disabled,String onChange ) {

		if( "0".equals(name) ) {
			return " ";
		}
		
		items = items.replace("{","");
		items = items.replace("}",""); 

		if(disabled==null||"".equals(disabled)){
			disabled = "";
		}else{
			disabled = "disabled = '"+disabled+"'";
		}
		
		
		if(onChange==null||"".equals(onChange)){
			onChange = "";
		}else{
			onChange = "onChange = '"+onChange+"'";
		}
		
		String selectHTML = "<select name='"+name.substring(name.lastIndexOf(".")+1)+"' id='"+name.substring(name.lastIndexOf(".")+1)+"' value = '"+value+"'"+disabled+onChange+">";
/*			      <option value="0">0</option>
			      <option value="1">1</option>
			      <option value="2">2</option>
			      <option value="3" selected="selected">3</option>
			      <option value="4">4</option>
			      <option value="5">5</option>
			      <option value="6">6</option>
			      <option value="7">7</option>
			      <option value="8">8</option>
			      <option value="9">9</option>
			      <option value="10">10</option>
			  </select>";
*/		
		
		String[] options = items.split(",");
		for(int i=0;i<options.length;i++){
			String val = options[i].substring(options[i].lastIndexOf("=")+1);
			String optionVal = options[i].substring(0,options[i].lastIndexOf("=")).trim();
			if(value.equals(optionVal)){
				selectHTML+="<option value='"+optionVal+"' selected>"+val+"</option>";
			}else{
				selectHTML+="<option value='"+optionVal+"'>"+val+"</option>";
			}
		}
		selectHTML+="</select>";
       /* name = CacheInfoManage.getMenubarName(name);
		
		if( name == null ) {
			CacheInfoManage.loadMenubarMap();
			name = CacheInfoManage.getMenubarName(name);
		}*/
		return selectHTML;
		

		
	}

	
}
