package com.cmad.blog.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class KeywordServiceDao {

	/**
	 * Get the keyword object for the keyId provided.
	 * 
	 * @param keyId for the keyword that needs to be fetched.
	 * @return KeywordSearch object that matches the provided keyword
	 * @throws IllegalArgumentException in case the keyword provided for search is <code>Null</code>
	 */
	
	public KeywordSearch getKeywordDao (Integer keyId){
		if (keyId == null) throw new IllegalArgumentException("Invalid keyId passed, expected value, passed Null");
		Session ses = HibernateUtil.currentSession();
		try {
			Criteria crit =  ses.createCriteria(KeywordSearch.class);
			crit.add(Restrictions.idEq(keyId));
			KeywordSearch k = (KeywordSearch)crit.uniqueResult();
			return k;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	/**
	 * Get the complete list of all the keywords in the database
	 *
	 * @return List of all KeywordSearch objects in the database
	 */
	
	public List<KeywordSearch> getKeywordsDao() {
		Session ses = HibernateUtil.currentSession();
		try {
			return ses.createCriteria(KeywordSearch.class).list();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	/**
	 * Get keyId from the searchKey that is passed as parameter 
	 * 
	 * @param searchKey
	 * @return keyId of the searchKey string which is passed as the parameter
	 * @throws IllegalArgumentException in case the searchKey provided is <code>Null</code>
	 */
	
	public Integer getKeyId (String searchKey){
		if (searchKey == null) throw new IllegalArgumentException("Invalid searchKey passed, expected value, actual null");
		Session ses = HibernateUtil.currentSession();
		
			Criteria crit =  ses.createCriteria(SearchStrings.class);	
			crit.add(Restrictions.eq("searchKey",searchKey).ignoreCase());
			SearchStrings s = (SearchStrings)crit.uniqueResult();
			return s.getKeyId();
		 
	}
	
	/**
	 * Get the keyword object for the Search Keystring provided.
	 * 
	 * @param searchKey for the keyword object that needs to be fetched.
	 * @return KeywordSearch object that matches the provided keyword
	 * @throws IllegalArgumentException in case the keyword provided for search is <code>Null</code>
	 */
	
	public SearchStrings getKeywordDao (String searchKey){
		if (searchKey == null) throw new IllegalArgumentException("Invalid searchKey passed, expected value, passed Null");
		int keyId = getKeyId(searchKey);
		Session ses = HibernateUtil.currentSession();
		try {
			Criteria crit =  ses.createCriteria(KeywordSearch.class);
			crit.add(Restrictions.idEq(keyId));
			SearchStrings k = (SearchStrings)crit.uniqueResult();
			return k;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	/**
	 * Post / create a new a keyword. The keyword Id is auto-generated. Parameters even if provided will be ignored / overridden.
	 *  
	 * @param Keyword object
	 * @return keyId of the entry that is made is returned
	 */
	
	public Integer createKeyword (SearchStrings s) {
		int id = 0;
		System.out.println("Creating keyword entry: "+s.getSearchKey());
		Session ses = HibernateUtil.currentSession();
		if (getKeyId(s.getSearchKey()) == null){
			try {
			Transaction tx = ses.beginTransaction();
			ses.save(s);
			id = s.getKeyId();
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}
		return id;
		}
		id = getKeyId(s.getSearchKey());
		return id;
		
	}
	
	public Integer createKeyword (KeywordSearch k) {
		int id = 0;
		System.out.println("Creating keyword entry: "+k.getKeyId()+" and it is associated to "+k.getBlogId());
		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.save(k);
			id = k.getKeyId();
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}
		return id;
	}
	
}
