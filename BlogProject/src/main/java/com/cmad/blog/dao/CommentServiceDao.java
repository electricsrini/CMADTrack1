package com.cmad.blog.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CommentServiceDao {
	
	public Comments getCommentDao (Integer commentId){
		Session ses = HibernateUtil.currentSession();
		try {
			Criteria crit =  ses.createCriteria(Users.class);
			crit.add(Restrictions.idEq(commentId));
			Comments c = (Comments)crit.uniqueResult();
			return c;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public List<Comments> getCommentsDao() {
		Session ses = HibernateUtil.currentSession();
		try {
			return ses.createCriteria(Comments.class).list();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public void createComment (Comments c) {
		System.out.println("Creating comment: "+c.getContent()+" for "+c.getBlogId()+" created by "+c.getUserId()+" and entered on "+c.getEntryDate());
		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.save(c);
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}
	}

}
