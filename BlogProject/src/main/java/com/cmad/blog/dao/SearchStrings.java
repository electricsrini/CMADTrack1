package com.cmad.blog.dao;

public class SearchStrings {
	
	private Integer keyId;
	private String searchKey;
	
	public Integer getKeyId() {
		return keyId;
	}
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	
	@Override
	public String toString() {
		return "SearchStrings [keyId=" + keyId + ", searchKey=" + searchKey + "]";
	}
	
		

}
