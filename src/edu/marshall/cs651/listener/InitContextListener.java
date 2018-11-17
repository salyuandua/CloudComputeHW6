package edu.marshall.cs651.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
@WebListener
public class InitContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext=sce.getServletContext();
		//init template engine
		System.out.println("Init template engine...");
		TemplateEngine templateEngine=new TemplateEngine();
		ServletContextTemplateResolver resolver=new ServletContextTemplateResolver(servletContext);
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setPrefix("WEB-INF/resources/");
		resolver.setSuffix(".html");
		resolver.setCacheable(false);		
		templateEngine.setTemplateResolver(resolver);
		servletContext.setAttribute("template", templateEngine);
		System.out.println("Init template engine end");
		
		
	}

}
