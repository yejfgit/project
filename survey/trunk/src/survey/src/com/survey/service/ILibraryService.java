package com.survey.service;

import java.util.List;
import java.util.Map;

import com.survey.vo.LQuestion;
import com.survey.vo.Library;
import com.survey.vo.PageVO;
import com.survey.vo.Survey;

public interface ILibraryService {

	public Library saveLibraryInfo(String surveyInfo);

	public Library getLibraryInfo(int libraryId);

	public Library updateLibraryInfo(String libraryInfo, int libraryId);

	public void deleteLibrary(int libraryId);

	public PageVO getLibraryListPvo(PageVO pvo, String libraryName);

	public Survey createSurvey(int type, String sids);

	public Survey createSurveyRandom(int type, String cts,int libraryId);

	public Library getLibrary(int libraryId);

	public void saveLibrary(Library l);

	public void savelqo(List queList);

	public void saveLq(LQuestion lq);

	public LQuestion getLQuetion(int lquetionId);

	public void updateQue(String queInfo, int lquetionId);

	public Map getLibraryInfoPvo(PageVO pvo, int libraryId);
	
	//分页修改问卷
	public Library updateLibraryInfo(String libraryInfo, int libraryId, String queIds,int seq);

}
