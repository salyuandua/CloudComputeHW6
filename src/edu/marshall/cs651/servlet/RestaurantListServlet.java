package edu.marshall.cs651.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.alibaba.fastjson.JSON;

import edu.marshall.cs651.dao.QueryDao;
@WebServlet(urlPatterns= {"/list"})
public class RestaurantListServlet extends HttpServlet{
	private TemplateEngine t;
	private QueryDao dao;
	@Override
	public void init(ServletConfig config) throws ServletException {
		t=(TemplateEngine) config.getServletContext().getAttribute("template");
		dao=new QueryDao();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		List<Document> docs=dao.queryRestaurants4List(new RequestParamWrapper(req.getParameterMap()).getStandardParam());
		//System.out.println(JSON.toJSONString(docs));
		
		WebContext webContext=new WebContext(req, resp, req.getServletContext());
		webContext.setVariable("list", docs);
		t.process("resList", webContext, resp.getWriter());
		
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doPost(req, resp);
	}
}
