package com.survey.web.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.LabelValueBean;

import com.survey.service.IDeptService;
import com.survey.service.IReportService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.ContextUtil;
import com.survey.util.DateUtil;
import com.survey.util.ResourceUtil;
import com.survey.util.ServiceLocator;
import com.survey.util.StringUtil;
import com.survey.vo.Dept;
import com.survey.vo.ReportTimesVO;
import com.survey.vo.RequestDetailVO;
import com.survey.vo.Survey;
import com.survey.vo.SurveyVO;


public class ReportAction extends BaseAction {
	
	private ISurveyService surveyService = (ISurveyService) ServiceLocator.getService("surveyService");
	private IReportService reportService = (IReportService) ServiceLocator.getService("reportService");
	private IDeptService deptService = (IDeptService) ServiceLocator.getService("deptService");
	
	/**
	 * 进入分数统计报表
	 */
	public ActionForward times(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String endDate = sdf.format(now);
		Date dt = now;
		dt.setMonth(dt.getMonth() - 1);
		String startDate = sdf.format(dt);
		int userId = ContextUtil.getCurrentUserId();
		List surveyList = surveyService.getSurveyListByAdminUserId(userId);
		List surveyLabelList = new ArrayList();
		for (Iterator it = surveyList.iterator(); it.hasNext();) {
			Survey survey = (Survey) it.next();
			int ss = survey.getId();
			LabelValueBean typeOption = new LabelValueBean(survey.getName(),String.valueOf(survey.getId()));
			surveyLabelList.add(typeOption);
		}
		request.setAttribute("surveyLabelList", surveyLabelList);	
		
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		
		return mapping.findForward("times");
	}

	/**
	 * 查詢机构统计报表
	 */
	public ActionForward timeReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int deptId = Integer.parseInt(request.getParameter("applyDeptId"));
		int surveyId = Integer.parseInt(request.getParameter("name2"));
		String deptName = deptService.getDeptById(deptId).getDeptFullName();
		List reportList = reportService.getSealTimesReport(startDate, endDate,deptId,surveyId);
		

		// 导出excel
		if (request.getParameter("export") != null && request.getParameter("export").equals("xls")) {
			// 设置输出的格式
 			response.reset();
 			response.setContentType("application/x-msdownload");
 			response.addHeader("Content-Disposition",
 					"attachment; filename=\""
 							+ new String("分数汇总表.xls".getBytes("GBK"),
 									"ISO8859-1") + "\"");
			
			WritableWorkbook book = Workbook.createWorkbook(response.getOutputStream());
			WritableSheet sheet = book.createSheet("report", 0);
			sheet.addCell(new Label(0, 0, "机构"));
			sheet.addCell(new Label(1, 0, "姓名"));
			sheet.addCell(new Label(2, 0, "分数"));
			
			for (int i = 0; i < reportList.size(); i++) {
				ReportTimesVO rt = (ReportTimesVO) reportList.get(i);
				sheet.addCell(new Label(0, (i + 1), rt.getDeptFullName()));
				sheet.addCell(new Label(1, (i + 1), rt.getUserRealName()));
				sheet.addCell(new Number(2, (i + 1), rt.getTotalScore().doubleValue()));
			}
			
			book.write();
			book.close();
			return null;
		}
		
		
		
		int userId = ContextUtil.getCurrentUserId();
		List surveyList = surveyService.getSurveyListByAdminUserId(userId);
		List surveyLabelList = new ArrayList();
		for (Iterator it = surveyList.iterator(); it.hasNext();) {
			Survey survey = (Survey) it.next();
			int ss = survey.getId();
			LabelValueBean typeOption = new LabelValueBean(survey.getName(),String.valueOf(survey.getId()));
			surveyLabelList.add(typeOption);
		}
		
		request.setAttribute("surveyLabelList", surveyLabelList);
		request.setAttribute("reportList", reportList);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("applyDeptId", deptId);
		request.setAttribute("deptName", deptName);
		return mapping.findForward("times");

	}
	/**
	 * 进入详细统计报表
	 */
	
	public ActionForward times2(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String endDate = sdf.format(now);
		Date dt = now;
		dt.setMonth(dt.getMonth() - 1);
		String startDate = sdf.format(dt);
		//显示問卷下来框
		int userId = ContextUtil.getCurrentUserId();
		List surveyList = surveyService.getSurveyListByAdminUserId(userId);
		List surveyLabelList = new ArrayList();
		for (Iterator it = surveyList.iterator(); it.hasNext();) {
			Survey survey = (Survey) it.next();
			int ss = survey.getId();
			LabelValueBean typeOption = new LabelValueBean(survey.getName(),String.valueOf(survey.getId()));
			surveyLabelList.add(typeOption);
		}
		request.setAttribute("surveyLabelList", surveyLabelList);	
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		return mapping.findForward("report2");
	}

	/**
	 * 查询详细统计报表
	 */
	
	public ActionForward report2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
//		int surveyId = Integer.parseInt(request.getParameter("surveyId"));
		int surveyId = Integer.parseInt(request.getParameter("name2"));
		int deptId = Integer.parseInt(request.getParameter("applyDeptId"));
		String deptName = deptService.getDeptById(deptId).getDeptFullName();
		
		String optionNameY = "是" ;
		String optionNameN = "否" ;
		List qList = surveyService.getQusetionsBySurveyId(surveyId);
		List ttList = new ArrayList();
		List ytList = surveyService.getTotalAnswerById(surveyId, optionNameY, startDate, endDate, deptId);
		List ntList = surveyService.getTotalAnswerById(surveyId, optionNameN, startDate, endDate, deptId);
		int ytNum = ytList.size();
		int ynNum = ntList.size();
		SurveyVO tt = new SurveyVO();
		tt.setTotalYes(ytNum);
		tt.setTotalNo(ynNum);
		ttList.add(tt);
		List answerList = new ArrayList();
		for(int i=0;i<qList.size();i++){
			SurveyVO sq = (SurveyVO) qList.get(i);
			int seq = sq.getQuestionSeq();
			System.out.println(seq);

			List yList = surveyService.getAnswersById(surveyId, seq, optionNameY, startDate, endDate, deptId);
			List nList = surveyService.getAnswersById(surveyId, seq, optionNameN, startDate, endDate, deptId); 
			int yNum = yList.size();
			int nNum = nList.size();
			
			sq.setIsYes(yNum);
			sq.setIsNo(nNum);
			answerList.add(sq);
       
		}
		
		
		
		// 导出excel
		if (request.getParameter("export") != null && request.getParameter("export").equals("xls")) {
			// 设置输出的格式
 			response.reset();
 			response.setContentType("application/x-msdownload");
 			response.addHeader("Content-Disposition",
 					"attachment; filename=\""
 							+ new String("调查明细表.xls".getBytes("GBK"),
 									"ISO8859-1") + "\"");
			
			WritableWorkbook book = Workbook.createWorkbook(response.getOutputStream());
			WritableSheet sheet = book.createSheet("report", 0);
			sheet.addCell(new Label(0, 0, "问题结果"));
			sheet.addCell(new Label(1, 0, "是"));
			sheet.addCell(new Label(2, 0, "否"));
			
			for (int i = 0; i < answerList.size(); i++) {
				SurveyVO s = (SurveyVO) answerList.get(i);
				sheet.addCell(new Label(0, (i + 1), "题目号：" + s.getQuestionSeq()));
				sheet.addCell(new Number(1, (i + 1), s.getIsYes()));
				sheet.addCell(new Number(2, (i + 1), s.getIsNo()));
			}
			
			sheet.addCell(new Label(0, answerList.size() + 1, "总计"));
			sheet.addCell(new Number(1, answerList.size() + 1, tt.getTotalYes()));
			sheet.addCell(new Number(2, answerList.size() + 1, tt.getTotalYes()));
			
			book.write();
			book.close();
			return null;
		}
		
		
		
		
		
		int userId = ContextUtil.getCurrentUserId();
		List surveyList = surveyService.getSurveyListByAdminUserId(userId);
		List surveyLabelList = new ArrayList();
		for (Iterator it = surveyList.iterator(); it.hasNext();) {
			Survey survey = (Survey) it.next();
			int ss = survey.getId();
			LabelValueBean typeOption = new LabelValueBean(survey.getName(),String.valueOf(survey.getId()));
			surveyLabelList.add(typeOption);
		}
		request.setAttribute("surveyLabelList", surveyLabelList);	
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("qList", answerList);
		request.setAttribute("tList", ttList);
		request.setAttribute("applyDeptId", deptId);
		request.setAttribute("deptName", deptName);
		return mapping.findForward("report2");
	}

	
	/**
	 * 下发明细报表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward requestDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// 查询条件参数
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date lastMonth = new Date(); 
		lastMonth.setMonth(lastMonth.getMonth() - 1);
		if (startDate == null) {
			startDate = DateUtil.getDateStringByDate(lastMonth);
		}
		if (endDate == null) {
			endDate = DateUtil.getDateStringByDate(new Date());
		}
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		int deptId = 0;
		if (request.getParameter("applyDeptId") != null) {
			deptId = StringUtil.parseInt(request.getParameter("applyDeptId"));
		}
		Dept d = deptService.getDeptById(deptId);
		String deptName = d == null ? null : d.getDeptFullName();
		request.setAttribute("applyDeptId", deptId);
		request.setAttribute("deptName", deptName);
		int surveyId = 0;
		if (request.getParameter("surveyId") != null) {
			surveyId = StringUtil.parseInt(request.getParameter("surveyId"));
		}
		int surveyStatus = 0;
		if (request.getParameter("surveyStatus") != null) {
			surveyStatus = StringUtil.parseInt(request.getParameter("surveyStatus"));
		}
		
		
		// 主查询
		List list = reportService.getRequestDetailList(startDate, endDate, deptId, surveyId, surveyStatus);
		request.setAttribute("reportList", list);
		
		
		// 计算总计
		RequestDetailVO total = new RequestDetailVO();
		for (int i = 0; i < list.size(); i++) {
			RequestDetailVO rd = (RequestDetailVO) list.get(i);
			total.setTotal(total.getTotal() + rd.getTotal());
			total.setDone(total.getDone() + rd.getDone());
			total.setTodo(total.getTodo() + rd.getTodo());
			total.setClosed(total.getClosed() + rd.getClosed());
			total.setInvalid(total.getInvalid() + rd.getInvalid());
		}
		request.setAttribute("total", total);
		
		
		
		// 导出excel
		if (request.getParameter("export") != null && request.getParameter("export").equals("xls")) {
			// 设置输出的格式
 			response.reset();
 			response.setContentType("application/x-msdownload");
 			response.addHeader("Content-Disposition",
 					"attachment; filename=\""
 							+ new String("下发明细表.xls".getBytes("GBK"),
 									"ISO8859-1") + "\"");
			
			WritableWorkbook book = Workbook.createWorkbook(response.getOutputStream());
			WritableSheet sheet = book.createSheet("report", 0);
			sheet.addCell(new Label(0, 0, "机构"));
			sheet.addCell(new Label(1, 0, "下发时间"));
			sheet.addCell(new Label(2, 0, "下发对象姓名"));
			sheet.addCell(new Label(3, 0, "下发数量"));
			sheet.addCell(new Label(4, 0, "已答数量"));
			sheet.addCell(new Label(5, 0, "未答数量"));
			sheet.addCell(new Label(6, 0, "关闭数量"));
			sheet.addCell(new Label(7, 0, "无效数量"));
			
			for (int i = 0; i < list.size(); i++) {
				RequestDetailVO rd = (RequestDetailVO) list.get(i);
				sheet.addCell(new Label(0, (i + 1), rd.getDeptName()));
				sheet.addCell(new Label(1, (i + 1), rd.getReqDate()));
				sheet.addCell(new Label(2, (i + 1), rd.getUserName()));
				sheet.addCell(new Number(3, (i + 1), rd.getTotal()));
				sheet.addCell(new Number(4, (i + 1), rd.getDone()));
				sheet.addCell(new Number(5, (i + 1), rd.getTodo()));
				sheet.addCell(new Number(6, (i + 1), rd.getClosed()));
				sheet.addCell(new Number(7, (i + 1), rd.getInvalid()));
				
			}
			
			sheet.addCell(new Label(0, (list.size() + 1), "总计"));
			sheet.addCell(new Label(1, (list.size() + 1), ""));
			sheet.addCell(new Label(2, (list.size() + 1), ""));
			sheet.addCell(new Number(3, (list.size() + 1), total.getTotal()));
			sheet.addCell(new Number(4, (list.size() + 1), total.getDone()));
			sheet.addCell(new Number(5, (list.size() + 1), total.getTodo()));
			sheet.addCell(new Number(6, (list.size() + 1), total.getClosed()));
			sheet.addCell(new Number(7, (list.size() + 1), total.getInvalid()));
			
			book.write();
			book.close();
			return null;
		}
		
		
		
		
		// 问卷下拉框
		int userId = ContextUtil.getCurrentUserId();
		List surveyList = surveyService.getSurveyListByAdminUserId(userId);
		List surveyLabelList = new ArrayList();
		for (Iterator it = surveyList.iterator(); it.hasNext();) {
			Survey survey = (Survey) it.next();
			int ss = survey.getId();
			LabelValueBean typeOption = new LabelValueBean(survey.getName(),String.valueOf(survey.getId()));
			surveyLabelList.add(typeOption);
		}
		request.setAttribute("surveyLabelList", surveyLabelList);	
		
		
		// 问卷状态下拉框
		List surveyStatusLabelList = new ArrayList();
		surveyStatusLabelList.add(new LabelValueBean("全部", "-1"));
		surveyStatusLabelList.add(new LabelValueBean("已下发", "0"));
		surveyStatusLabelList.add(new LabelValueBean("已开始", "1"));
		surveyStatusLabelList.add(new LabelValueBean("已完成", "2"));
		surveyStatusLabelList.add(new LabelValueBean("已关闭", "3"));
		request.setAttribute("surveyStatusLabelList", surveyStatusLabelList);
		
		
		return mapping.findForward("requestDetail");
	}

}
