package com.cmad.blog.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cmad.blog.dao.*;

@Path("/keyword")

public class KeywordService {
	
	private KeywordServiceDao keywordDao;
	
	public KeywordService() {
		keywordDao = new KeywordServiceDao();
	}
	
	/**
	 * Get the keyword object for the keyId provided.
	 * 
	 * @param keyId for the keyword that needs to be fetched.
	 * @return KeywordSearch object that matches the provided keyword
	 * @throws IllegalArgumentException in case the keyword provided for search is <code>Null</code>
	 */
	
	@GET
	@Path("/{param}")
	@Produces({MediaType.APPLICATION_JSON})
	public KeywordSearch getKeyword(@PathParam("param") Integer keyId) {
		if (keyId == null) throw new IllegalArgumentException("Invalid keyId passed, expected value, passed Null");
		KeywordSearch k = keywordDao.getKeywordDao(keyId);
		return k;
	}
	
	/**
	 * Get the complete list of all the keywords in the database
	 *
	 * @return List of all KeywordSearch objects in the database
	 */
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<KeywordSearch> getKeywords() {
		List<KeywordSearch> keywords = keywordDao.getKeywordsDao();
		return keywords;
	}
	
	/**
	 * Get the keyword object for the Search Keystring provided.
	 * 
	 * @param searchKey for the keyword object that needs to be fetched.
	 * @return KeywordSearch object that matches the provided keyword
	 * @throws IllegalArgumentException in case the keyword provided for search is <code>Null</code>
	 */
	
	@GET
	@Path("/keyword/{param}")
	@Produces({MediaType.APPLICATION_JSON})
	public SearchStrings getKeyword(@PathParam("param") String searchKey) {
		if (searchKey == null) throw new IllegalArgumentException("Invalid searchKey passed, expected value, passed Null");
		SearchStrings k = keywordDao.getKeywordDao(searchKey);
		return k;
	}
	
	/**
	 * Post / create a new a keyword. The keyword Id is auto-generated. Parameters even if provided will be ignored / overridden.
	 *  
	 * @param Keyword object
	 * @return keyId of the entry that is made is returned
	 */
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Integer createKeyword (SearchStrings s) {
		int id = 0;
		keywordDao.createKeyword(s);
		return id;
	}
	
	public Integer createKeyword (KeywordSearch k) {
		int id = 0;
		keywordDao.createKeyword(k);
		return id;
	}

}
