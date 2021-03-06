package edu.marshall.cs651.servlet;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.thymeleaf.TemplateEngine;


import edu.marshall.cs651.dao.CommentDao;
import edu.marshall.cs651.dao.QueryDao;
@WebServlet(urlPatterns= {"/reply"})
public class ReplyCommentServlet extends HttpServlet{
	private TemplateEngine t;
	private QueryDao dao;
	private CommentDao cDao;
	@Override
	public void init(ServletConfig config) throws ServletException {
		t=(TemplateEngine) config.getServletContext().getAttribute("template");
		dao=new QueryDao();
		cDao=new CommentDao();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		cDao.reply(new RequestParamWrapper(req.getParameterMap()).getStandardParam());
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doPost(req, resp);
	}
}
