package edu.marshall.cs651.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import edu.marshall.cs651.dao.QueryDao;
@WebServlet(urlPatterns= {"/delete"})
public class DeleteReServlet extends HttpServlet{
	private TemplateEngine t;
	QueryDao qDao;
	@Override
	public void init(ServletConfig config) throws ServletException {
		t=(TemplateEngine) config.getServletContext().getAttribute("template");
		qDao=new QueryDao();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		String action=req.getParameter("action");
		if(action.equals("checkId")) {
			boolean b=qDao.isExisting(req.getParameter("id"));
			String result=ProjectUtils.getMessage(b, "Are you sure delete?", "This is is not existing any more.");
			resp.getWriter().write(result);
			resp.getWriter().flush();
			resp.getWriter().close();
			
		}else if(action.equals("doDelete")) {
			
		}
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doPost(req, resp);
	}
}
