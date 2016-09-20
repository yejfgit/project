package com.survey.web.action;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import org.apache.struts.upload.MultipartRequestHandler;

import com.survey.util.ContextUtil;
import com.survey.util.StringUtil;
import com.survey.vo.LOption;
import com.survey.vo.LQuestion;
import com.survey.vo.Library;


/**
 * 批量导入
 * @author zhangch
 *
 */
public class ImportAction extends BaseAction {
	
	
	/**
	 * 打开批量导入页面
	 */
	public ActionForward toImport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm af = (DynaActionForm) form;
		int libraryId = StringUtil.parseInt(request.getParameter("libraryId"));
		
		request.setAttribute("libraryId", libraryId);
		return mapping.findForward("toImport");
	}

	
	/**
	 * 下载模板
	 */
	public ActionForward getTemplate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm af = (DynaActionForm) form;

		// 设置输出的格式
		response.reset();
		response.setContentType("application/x-msdownload");
		response.addHeader("Content-Disposition",
					"attachment; filename=\""
							+ new String("试题导入模板.xls".getBytes("GBK"),
									"ISO8859-1") + "\"");
		
		WritableWorkbook book = Workbook.createWorkbook(response.getOutputStream());
		WritableSheet sheet = book.createSheet("试题文件", 0);
		
		// 指定列名
		sheet.addCell(new Label(0, 0, "题目"));
		sheet.addCell(new Label(1, 0, "分类"));
		sheet.addCell(new Label(2, 0, "题型（包括：单选题、多选题和问答题）"));
		sheet.addCell(new Label(3, 0, "选项1"));
		sheet.addCell(new Label(4, 0, "选项2"));
		sheet.addCell(new Label(5, 0, "选项3"));
		sheet.addCell(new Label(6, 0, "选项4"));
	
		book.write();
		book.close();
		return null;

	}

	
	
	/**
	 * 上传并预览文件列表
	 */
	public ActionForward preview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm af = (DynaActionForm) form;
		
		int libraryId = StringUtil.parseInt(request.getParameter("libraryId"));
		
		Library l;
		List queList = new ArrayList();
		if(libraryId==0){
			l = new Library();
			l.setName("新建题库");
			ls.saveLibrary(l);

		}else{
			l = ls.getLibraryInfo(libraryId);
		}
		
		
		
		// 上传文件
		MultipartRequestHandler mrh = form.getMultipartRequestHandler();
		if (mrh == null) {
			throw new Exception("文件不存在");
		}
		Hashtable files = mrh.getFileElements();
		FormFile file = (FormFile) files.get("uploadFile");
		
		
		// 导入excel文件并解析
		Workbook book = Workbook.getWorkbook(file.getInputStream());
		Sheet sheet = book.getSheet(0);
		
		
		int j = 0;
		for (int i = 1; i < sheet.getRows(); i++) {
			if(sheet.getCell(0, i).getContents()!=null&&sheet.getCell(0, i).getContents().length()!=0){
				//题型
				String qType = sheet.getCell(2, i).getContents().trim().replaceAll(" ","");
				int queType = 0;
				if("单选题".equals(qType)){
					queType = 1;
				}else if("多选题".equals(qType)){
					queType = 2;
				}else if("问答题".equals(qType)){
					queType = 3;
				}else{
					queType = 1;
				}
				
				LQuestion lq = new LQuestion(libraryId,sheet.getCell(0, i).getContents().replaceAll("\\s", ""),sheet.getCell(1, i).getContents().replaceAll("\\s", ""),queType);
				lq.setId(i);				
				if(sheet.getCell(3, i).getContents()!=null&&sheet.getCell(3, i).getContents().length()!=0){
					LOption lo = new LOption();
					lo.setQuestionId(lq.getId());
					lo.setName(sheet.getCell(3, i).getContents().trim().replaceAll(" ","").replaceAll("\\s", ""));
					lo.setSeq(1);
					lo.setId(++j);
					lq.addOpt(lo);
				}
				if(sheet.getCell(4, i).getContents()!=null&&sheet.getCell(4, i).getContents().length()!=0){
					LOption lo = new LOption();
					lo.setQuestionId(lq.getId());
					lo.setName(sheet.getCell(4, i).getContents().trim().replaceAll(" ","").replaceAll("\\s", ""));
					lo.setSeq(2);
					lo.setId(++j);
					lq.addOpt(lo);
				}
				if(sheet.getCell(5, i).getContents()!=null&&sheet.getCell(5, i).getContents().length()!=0){
					LOption lo = new LOption();
					lo.setQuestionId(lq.getId());
					lo.setName(sheet.getCell(5, i).getContents().trim().replaceAll(" ","").replaceAll("\\s", ""));
					lo.setSeq(3);
					lo.setId(++j);
					lq.addOpt(lo);
				}
				if(sheet.getCell(6, i).getContents()!=null&&sheet.getCell(6, i).getContents().length()!=0){
					LOption lo = new LOption();
					lo.setQuestionId(lq.getId());
					lo.setName(sheet.getCell(6, i).getContents().trim().replaceAll(" ","").replaceAll("\\s", ""));
					lo.setSeq(4);
					lo.setId(++j);
					lq.addOpt(lo);
				}
				
				queList.add(lq);
			}
		}
		l.setQuestionList(queList);
		
		request.setAttribute("library", l);
		request.setAttribute("ownerId", ContextUtil.getCurrentUserId());
		return mapping.findForward("preview");
	}
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm af = (DynaActionForm) form;
		
		int libraryId = StringUtil.parseInt(request.getParameter("libraryId"));
		
		Library l;
		List queList = new ArrayList();
		if(libraryId==0){
			l = new Library();
			l.setName("新建题库");
			l.setOwnerId(ContextUtil.getCurrentUserId());
			l.setCreateTime(new Date());
			
			ls.saveLibrary(l);
		}else{
			l = ls.getLibraryInfo(libraryId);
		}
		
		
		
		// 上传文件
		MultipartRequestHandler mrh = form.getMultipartRequestHandler();
		if (mrh == null) {
			throw new Exception("文件不存在");
		}
		Hashtable files = mrh.getFileElements();
		FormFile file = (FormFile) files.get("uploadFile");
		
		
		// 导入excel文件并解析
		Workbook book = Workbook.getWorkbook(file.getInputStream());
		Sheet sheet = book.getSheet(0);
		
		int j = 0;
		for (int i = 1; i < sheet.getRows(); i++) {
			if(sheet.getCell(0, i).getContents()!=null&&sheet.getCell(0, i).getContents().length()!=0){
				//题型
				String qType = sheet.getCell(2, i).getContents().trim().replaceAll(" ","");
				int queType = 0;
				if("单选题".equals(qType)){
					queType = 1;
				}else if("多选题".equals(qType)){
					queType = 2;
				}else if("问答题".equals(qType)){
					queType = 3;
				}else{
					queType = 1;
				}
				LQuestion lq = new LQuestion(l.getId(),sheet.getCell(0, i).getContents().replaceAll("\\s", ""),sheet.getCell(1, i).getContents().replaceAll("\\s", ""),queType);
				lq.setSeq(++j);
				ls.saveLq(lq);
				
				if(sheet.getCell(3, i).getContents()!=null&&sheet.getCell(3, i).getContents().length()!=0){
					LOption lo = new LOption();
					lo.setQuestionId(lq.getId());
					lo.setName(sheet.getCell(3, i).getContents().trim().replaceAll(" ","").replaceAll("\\s", ""));
					lo.setSeq(1);
					lq.addOpt(lo);
				}
				if(sheet.getCell(4, i).getContents()!=null&&sheet.getCell(4, i).getContents().length()!=0){
					LOption lo = new LOption();
					lo.setQuestionId(lq.getId());
					lo.setName(sheet.getCell(4, i).getContents().trim().replaceAll(" ","").replaceAll("\\s", ""));
					lo.setSeq(2);
					
					lq.addOpt(lo);
				}
				if(sheet.getCell(5, i).getContents()!=null&&sheet.getCell(5, i).getContents().length()!=0){
					LOption lo = new LOption();
					lo.setQuestionId(lq.getId());
					lo.setName(sheet.getCell(5, i).getContents().trim().replaceAll(" ","").replaceAll("\\s", ""));
					lo.setSeq(3);
					
					lq.addOpt(lo);
				}
				if(sheet.getCell(6, i).getContents()!=null&&sheet.getCell(6, i).getContents().length()!=0){
					LOption lo = new LOption();
					lo.setQuestionId(lq.getId());
					lo.setName(sheet.getCell(6, i).getContents().trim().replaceAll(" ","").replaceAll("\\s", ""));
					lo.setSeq(4);
				
					lq.addOpt(lo);
		
				}
				
				queList.add(lq);
			}
		}
		l.setQuestionList(queList);
		
		ls.savelqo(queList);
		
		String url = "library.do?method=list";
		return new ActionForward(url,true);
//		request.setAttribute("info", "导入成功！");
//		return mapping.findForward("info");
	}

}
