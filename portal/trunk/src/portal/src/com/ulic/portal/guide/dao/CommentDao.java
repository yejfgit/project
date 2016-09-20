package com.ulic.portal.guide.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ulic.portal.guide.entity.Comment;
import com.ulic.portal.guide.entity.Guide;
import com.ulic.portal.guide.vo.CommentVo;
import com.ulic.portal.pub.dao.BaseDao;
import com.ulic.portal.pub.vo.PageSupport;

/**
 * 评论dao
 * @author yejf001
 * */

@Repository
public class CommentDao extends BaseDao{

	public void delComment(int commentId) {
		this.deleteById("table", commentId);
	}

	/**
	 * 分页取comment列表
	 * @param ps
	 * @return
	 */
	public PageSupport getCommentList(PageSupport ps,int guideId) {
		return this.findPageBySql(
				" select t.id,t.comment_desc commentDesc,t.guide_id guideId,t.user_id userId,t.comment_date commentDate,  v.real_name userName " +
				" from t_portal_comment t ,t_um_user v "+
				" where  t.user_id=v.um_user_id and t.guide_id = "+guideId, 
				CommentVo.class, 
				ps, 
				new ArrayList()
				);
	}
	
	
	/**
	 * 最新评论
	 * @param ps
	 * @return
	 */
	public List getNewCommentList() {
		String sql = "select a.id,a.comment_desc commentDesc,a.guide_id guideId,a.user_id userId,a.comment_date commentDate "+ 
			"from ( " +
			"select t.* "+
			"from t_portal_comment t "+
			"order by id desc,t.comment_date desc "+
			")a "+
			"where rownum<3 ";
	    return this.getList(sql, Comment.class);
	}
	
	
	public Comment getComment(int commentId) {
		return (Comment) this.getHibernateTemplate().get(Comment.class, commentId);
	}
	
	public Comment saveComment(Comment g) {
		this.save(g);
		return null;
	}

	public Comment updateComment(Comment g) {
		this.update(g);
		return null;
	}
	
}
