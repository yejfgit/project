package com.ulic.portal.guide.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ulic.portal.guide.dao.CommentDao;
import com.ulic.portal.guide.entity.Comment;
import com.ulic.portal.pub.vo.PageSupport;

/**
 * 评论Service
 * @author wengxf
 * 2013-6-18
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CommentService {
	
	/**
	 * 自动注入Dao
	 */
	@Resource
	private CommentDao commentDao;


	/**
	 * 分页查询评论列表
	 * @param ps
	 * @return
	 */
	public PageSupport getCommentList(PageSupport ps,int guideId) {
		return commentDao.getCommentList(ps,guideId);
	}

	public Comment saveComment(Comment g) {
		return commentDao.saveComment(g);
	}

	/**
	 * 根据ID得到评论
	 * @param id
	 * @return
	 */
	public Comment getComment(int id) {
		return commentDao.getComment(id);
	}
	
	/**
	 * 最新评论
	 * @param id
	 * @return
	 */
	public List getNewCommentList() {
		return commentDao.getNewCommentList();
	}
	
	public Comment updateComment(Comment g) {
		return commentDao.updateComment(g);
	}


	public void delComment(int id) {
		commentDao.delComment(id);
	}
}
