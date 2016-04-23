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

@Path("/comment")

public class CommentService {
	
	private CommentServiceDao commentDao;
	
	public CommentService() {
		commentDao = new CommentServiceDao();
	}
	
	@GET
	@Path("/{param}")
	@Produces({MediaType.APPLICATION_JSON})
	public Comments getComment(@PathParam("param") Integer commentId) {
		Comments c = commentDao.getCommentDao(commentId);
		return c;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Comments> getComments() {
		List<Comments> comments = commentDao.getCommentsDao();
		return comments;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void createComment (Comments c) {
		commentDao.createComment(c);
	}

}
