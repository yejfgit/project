package com.ulic.portal.guide.web.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.ulic.portal.guide.entity.Comment;
import com.ulic.portal.guide.entity.Guide;
import com.ulic.portal.guide.entity.GuideType;
import com.ulic.portal.guide.service.CommentService;
import com.ulic.portal.guide.service.GuideRelationService;
import com.ulic.portal.guide.service.GuideService;
import com.ulic.portal.guide.service.GuideTypeService;
import com.ulic.portal.guide.vo.CommentVo;
import com.ulic.portal.pub.vo.PageSupport;
import com.ulic.portal.pub.web.action.BaseAction;


/**
 * 服务向导Action
 * @author yejf
 * 2013-6-18
 */
// 基础路径
//@Controller(value = "/guide")
public class GuideAction extends BaseAction{
	
private static final long serialVersionUID = 1L;
//private HttpServletRequest request = ServletActionContext.getRequest();
	
	/**
	 * 自动注入服务向导Service
	 */
	@Autowired
	private GuideService guideService;
	
	/**
	 * 自动注入评论Service
	 */
	@Autowired
	private CommentService commentService;
	
	/**
	 * 自动注入服务相关Service
	 */
	@Autowired
	private GuideRelationService guideRelationService;
	
	/**
	 * 自动注入服务类型Service
	 */
	@Autowired
	private GuideTypeService guideTypeService;
	
	/**
	 * 绑定服务指引实体
	 */
	private Guide guide;
	
	/**
	 * 绑定服务类型实体
	 */
	private GuideType guideType;
	
	
	/**
	 * 绑定服务指引实体列表
	 */
	private List guideList;
	
	/**
	 * 绑定评论列表
	 */
	private List commentList;
	
	/**
	 * 绑定服务指引列表
	 */
	private List sameGuideList;
	
	/**
	 * 绑定服务指引列表
	 */
	private List newGuideList;
	
	/**
	 * 绑定服务指引列表
	 */
	private List guideRelationList;
	
	/**
	 * 绑定服务类型父类型列表
	 */
	private List guideParentTypeList;
	
	/**
	 * 绑定服务类型子类型列表
	 */
	private List guideTypeList;
	
	/**
	 * 绑定服务类型父类型和子类型列表
	 */
	private List allGuideTypeList;
	
	
	public List getAllGuideTypeList() {
		return allGuideTypeList;
	}

	public void setAllGuideTypeList(List allGuideTypeList) {
		this.allGuideTypeList = allGuideTypeList;
	}

	public List getGuideTypeList() {
		return guideTypeList;
	}

	public void setGuideTypeList(List guideTypeList) {
		this.guideTypeList = guideTypeList;
	}


	public Guide getGuide() {
		return guide;
	}
	
	public void setGuide(Guide guide) {
		this.guide = guide;
	}


	public List getCommentList() {
		return commentList;
	}


	public void setCommentList(List commentList) {
		this.commentList = commentList;
	}


	public List getGuideRelationList() {
		return guideRelationList;
	}


	public void setGuideRelationList(List guideRelationList) {
		this.guideRelationList = guideRelationList;
	}

	public List getGuideParentTypeList() {
		return guideParentTypeList;
	}

	public void setGuideParentTypeList(List guideParentTypeList) {
		this.guideParentTypeList = guideParentTypeList;
	}
	
	public List getGuideList() {
		return guideList;
	}

	public void setGuideList(List guideList) {
		this.guideList = guideList;
	}

	public List getSameGuideList() {
		return sameGuideList;
	}

	public void setSameGuideList(List sameGuideList) {
		this.sameGuideList = sameGuideList;
	}
	
	public List getNewGuideList() {
		return newGuideList;
	}

	public void setNewGuideList(List newGuideList) {
		this.newGuideList = newGuideList;
	}
	
	public GuideType getGuideType() {
		return guideType;
	}

	public void setGuideType(GuideType guideType) {
		this.guideType = guideType;
	}
	
	/**
	 * 服务指引详细信息
	 * @return
	 */
	@Action(value = "/guide/showGuide", results = { @Result(name = SUCCESS, location = "/guide/jsp/showGuide.jsp") })
	public String showGuide(){
		
		
		//得到服务指引具体实例
		//HttpServletRequest request=ServletActionContext.getRequest();
		int guideId =Integer.parseInt(request.getParameter("guide.id"));
		//int guideId=guide.getId();
		this.guide=guideService.getGuide(guideId);
		
		//取得评论分页列表
		PageSupport ps = new PageSupport();
		ps=commentService.getCommentList(ps,guideId);
		this.commentList=ps.getItems();
		
		
		//根据guideId得到服务类型
		this.guideType=guideTypeService.getGuideTypeByGuideId(guideId);
		
		//得到相关服务
		this.guideRelationList=guideRelationService.getGuideRelationList(guideId);
		
		//得到父节点服务类型列表
		this.guideParentTypeList=guideTypeService.getParentGuideTypeList();
		
		return SUCCESS;
	}
	
	/**
	 * 服务指引首页
	 * @return
	 */
	@Action(value = "/guide/guide", results = { @Result(name = SUCCESS, location = "/guide/jsp/guide.jsp") })
	public String guide(){
		
        //得到父节点服务类型列表
		this.guideParentTypeList=guideTypeService.getParentGuideTypeList();
		
       //服务列表
		List list=new ArrayList();
		GuideType gt=new GuideType();
		for(int i=0;i<this.guideParentTypeList.size();i++){
			gt=(GuideType)this.guideParentTypeList.get(i);
			this.sameGuideList=guideService.getSameGuideList(gt.getId());
		}
		
		
		//最新服务
		this.newGuideList=guideService.getNewGuideList();
		
        //最新评论
		this.commentList=commentService.getNewCommentList();
		
		return SUCCESS;
	}
	
	
	/**
	 * 服务指引首页
	 * @return
	 */
	@Action(value = "/guide/search", results = { @Result(name = SUCCESS, location = "/guide/jsp/search.jsp") })
	public String search(){
		
		
		String str=this.request.getParameter("guideSearch");//搜索框内信息
        
        //搜索列表
        PageSupport ps = new PageSupport();
		ps=guideService.getSearchGuideList(ps,str);
		this.guideList=ps.getItems();
		
		return SUCCESS;
	}
	
	
	/**
	 * 发表评论
	 * @return
	 * @throws IOException 
	 */
	@Action(value = "/guide/comment")
	public String comment() throws IOException{
        
		String commentDesc=request.getParameter("comment");
		int guideId=Integer.parseInt(request.getParameter("guideId"));
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		//save评论
		Comment c=new Comment();
		c.setUserId(userId);
		c.setGuideId(guideId);
		c.setCommentDesc(commentDesc);
		Date d=new Date();
		c.setCommentDate(d);
		this.commentService.saveComment(c);
		

       //取得评论分页列表
		PageSupport ps = new PageSupport();
		ps=commentService.getCommentList(ps,guideId);
		List comList=new ArrayList();
		comList=ps.getItems();
	
		//页面显示
		PrintWriter prt=response.getWriter();
		prt.print("<table>");
		CommentVo cv=new CommentVo();
		for(int i=0;i<comList.size();i++){
		    cv=(CommentVo)comList.get(i);
		    prt.print("<tr>");
		    prt.print("<td>"+cv.getId()+"<td>");
		    prt.print("<td>"+cv.getCommentDesc()+"<td>");
		    prt.print("<td>"+cv.getUserName()+"<td>");
		    prt.print("<td>"+cv.getCommentDate()+"<td>");
		    prt.print("</tr>");
		}
		prt.print("</table>");
		response.getWriter().close();
		
		return null;
	}


	
}
