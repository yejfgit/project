package com.survey.util.file;

public interface IFileHandler {
	
	/**
	 * 针对每一个文件进行业务处理，并返回存储的路径名
	 * 如生成日期、转换业务数据、将文件记录保存到数据库等
	 * @param fileName
	 * @param fileSize
	 * @return
	 */
	public String getFilePath(String fileName, int fileSize);
	
}
