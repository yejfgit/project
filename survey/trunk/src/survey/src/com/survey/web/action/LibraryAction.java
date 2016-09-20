package com.survey.web.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;


import com.survey.util.ContextUtil;
import com.survey.util.StringUtil;
import com.survey.vo.LQuestion;
import com.survey.vo.Library;
import com.survey.vo.PageVO;
import com.survey.vo.Survey;





public class LibraryAction extends BaseAction {

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int currentUserId = ContextUtil.getCurrentUserId();
		request.setAttribute("ownerId", currentUserId);
		return mapping.findForward("add");
	}
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String surveyInfo = request.getParameter("surveyInfo");

		Library library = ls.saveLibraryInfo(surveyInfo);
		
		String url = "library.do?method=list";
		return new ActionForward(url, true);
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int libraryId = this.getIntValue(request, "libraryId");
//		Library library = ls.getLibraryInfo(libraryId);
		
		PageVO pvo = new PageVO();
		pvo.setPageSize(10);
		int pageNum = 0;
		if (request.getParameter("pageNum") != null) {
			pageNum = StringUtil.parseInt(request.getParameter("pageNum"));
		}
		pvo.setPageNum(pageNum);
		HashMap map = (HashMap) ls.getLibraryInfoPvo(pvo,libraryId);
		
		pvo = (PageVO) map.get("pvo");
		Library library = (Library) map.get("library");
		
		request.setAttribute("pagevo", pvo);	
		request.setAttribute("ownerId", ContextUtil.getCurrentUserId());
		request.setAttribute("library", library);
		request.setAttribute("queIds", map.get("queIds"));
		request.setAttribute("firstSeq", map.get("firstSeq"));
		
		return mapping.findForward("edit");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		String libraryInfo = request.getParameter("surveyInfo");
		String queIds = request.getParameter("queIds");
		int libraryId = this.getIntValue(request, "libraryId");
		int seq = this.getIntValue(request, "seq");
		String pageNum = request.getParameter("pageNum");
	
		System.out.println(libraryInfo);
		Library library = ls.updateLibraryInfo(libraryInfo,libraryId,queIds,seq);

		String url = "library.do?method=edit&pageNum="+pageNum+"&libraryId="+libraryId;
		return new ActionForward(url, true);

	}
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int libraryId = this.getIntValue(request, "libraryId");
		Library library = ls.getLibraryInfo(libraryId);
		

		request.setAttribute("ownerId", ContextUtil.getCurrentUserId());
		request.setAttribute("library", library);
		return mapping.findForward("view");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int libraryId = StringUtil.parseInt(request.getParameter("libraryId"));
		ls.deleteLibrary(libraryId);
		
		String url = "library.do?method=list";
		return new ActionForward(url, true);
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        
		//搜索题库
		String libraryName = request.getParameter("libraryName");
		if(libraryName!=null){
			libraryName = StringUtil.decodeStr(libraryName);
			request.setAttribute("libraryName", libraryName);
		}
		
		PageVO pvo = new PageVO();
		pvo.setPageSize(10);
		int pageNum = 0;
		if (request.getParameter("pageNum") != null) {
			pageNum = StringUtil.parseInt(request.getParameter("pageNum"));
		}
		pvo.setPageNum(pageNum);
		pvo = ls.getLibraryListPvo(pvo,libraryName);
		
		
		request.setAttribute("pagevo", pvo);
		
		return mapping.findForward("list");

	}
	
	public ActionForward createSurvey(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String sids = request.getParameter("sids");
		int type = StringUtil.parseInt(request.getParameter("type"));
		
		Survey s = ls.createSurvey(type,sids);
		
		String url = "survey.do?method=edit&surveyId="+s.getId();
		return new ActionForward(url, true);
	}
	
	public ActionForward createSurveyRandom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm df = (DynaActionForm) form;
		Library library = (Library) df.get("library");
		int type = StringUtil.parseInt(request.getParameter("type"));

		Survey s = ls.createSurveyRandom(type,library.getPolicy(),library.getId());
		
		String url = "survey.do?method=edit&surveyId="+s.getId();
		return new ActionForward(url, true);
	}

	public ActionForward editQue(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int lquetionId = this.getIntValue(request, "lquestionId");
		LQuestion lq = ls.getLQuetion(lquetionId);
			
		request.setAttribute("ownerId", ContextUtil.getCurrentUserId());
		request.setAttribute("lquestion", lq);
		
		return mapping.findForward("editQue");
	}
	
	public ActionForward updateQue(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		String queInfo = request.getParameter("surveyInfo");
		int lquetionId = this.getIntValue(request, "lquestionId");
	
		System.out.println(queInfo);
		ls.updateQue(queInfo,lquetionId);

		return mapping.findForward("done");
	}

}
