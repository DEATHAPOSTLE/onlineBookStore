package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Comment;
import com.uitl.content.Const;
import com.util.dbTools.DBTools;

public class CommentService {

	/*
	 * 获取评论
	 */
	public List<Comment> getComments(int commodityId) {
		DBTools dbTools = new DBTools();

		ResultSet rSet = dbTools.conditionalSearch(Const.TABLE_COMMENT, Const.COLUNM_COMMODITY_ID, commodityId);
		List<Comment> comments = new ArrayList<Comment>();
		try {
			while (rSet.next()) {
				Comment comment = new Comment();
				comment.setUserID(rSet.getInt(Const.COLUNM_USER_ID));
				comment.setCommentContent(rSet.getString(Const.COLUNM_COMMENT_CONTENT));
				comment.setCommentDTime(rSet.getString(Const.COLUNM_COMMENT_DTIME));
				comments.add(comment);
			}
			dbTools.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}

	/*
	 * 插入评论
	 */
	public int setComments(Comment comment) {
		DBTools dbTools = new DBTools();

		int result = dbTools.insertAll(comment);
		dbTools.closeDB();
		return result;
	}

}
