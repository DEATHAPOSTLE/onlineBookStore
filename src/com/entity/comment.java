package com.entity;

public class comment {
	
	// 评论ID(主键自增长)
    private int commentId;

    // 商品ID    private int commodityId;

    // 用户ID    private int userID;

    // 评论文字内容    private String commentContent;

    // 评论时间    private String commentDTime;
    public int getCommentId(){
        return this.commentId;
    }
    public void setCommentId(int commentId){
        this.commentId = commentId;
    }
    public int getCommodityId(){
        return this.commodityId;
    }
    public void setCommodityId(int commodityId){
        this.commodityId = commodityId;
    }
    public int getUserID(){
        return this.userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    public String getCommentContent(){
        return this.commentContent;
    }
    public void setCommentContent(String commentContent){
        this.commentContent = commentContent;
    }
    public String getCommentDTime(){
        return this.commentDTime;
    }
    public void setCommentDTime(String commentDTime){
        this.commentDTime = commentDTime;
    }
}
