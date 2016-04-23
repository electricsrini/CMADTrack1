package com.cmad.blog.dao;

public class KeywordSearch {
	
	private Integer Id;
	private Integer keyId;
	private Integer blogId;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getKeyId() {
		return keyId;
	}
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	
	@Override
	public String toString() {
		return "KeywordSearch [Id=" + Id + ", keyId=" + keyId + ", blogId=" + blogId + "]";
	}
	

}
