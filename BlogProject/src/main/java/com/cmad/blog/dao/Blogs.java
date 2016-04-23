package com.cmad.blog.dao;

import java.util.Date;

public class Blogs {

	private Integer blogId;
	private String title;
	private Integer userId;
	private Date entryDate=new Date();
	private String content="";
	private Integer rank;

	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
		
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
		
	@Override
	public String toString() {
		return "Blog ID [id=" + blogId + ", Title=" + title + ", Content=" + content + ", Entry Date="
				+ entryDate + ", User ID=" + userId + ", Rank=" + rank + "]";
	}
	
	

}
