package com.cmad.blog.dao;


import java.util.Date;


public class Comments {

	private Integer commentId;
	private Integer blogId;
	private Integer userId;
	private Date entryDate=new Date();
	private String content="";
	private Integer parentId;
	private Integer rank;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", blogId=" + blogId + ", userId=" + userId + ", entryDate="
				+ entryDate + ", content=" + content + ", parentId=" + parentId + ", rank=" + rank + "]";
	}

	
	
	

}
