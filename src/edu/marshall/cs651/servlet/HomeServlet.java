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


@WebServlet(urlPatterns= {"/home"})
public class HomeServlet extends HttpServlet{
	private TemplateEngine t;

	@Override
	public void init(ServletConfig config) throws ServletException {
		t=(TemplateEngine) config.getServletContext().getAttribute("template");

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			
		WebContext webContext=new WebContext(req, resp, req.getServletContext());
		t.process("home", webContext, resp.getWriter());
		
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doPost(req, resp);
	}
}
