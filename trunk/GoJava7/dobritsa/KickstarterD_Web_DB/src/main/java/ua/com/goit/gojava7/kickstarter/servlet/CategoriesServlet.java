package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@WebServlet("/")
public class CategoriesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	
	private static final Logger log = LoggerFactory.getLogger(CategoriesServlet.class);	 
	
	@Autowired
	private QuoteDao quoteDao;
	
	@Autowired
	private ProjectDao projectDao;	
	@Autowired
	private CategoryDao categoryDao;	
		
	protected WebApplicationContext applicationContext;

	@Override
	public void init() throws ServletException {		
		log.info("Starting spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);	
		log.info("Ended spring autowiring...");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		log.info("doGet()...");		
		
		request.setAttribute("quote", quoteDao.get(1));		
		request.setAttribute("categories", categoryDao.getAll());
		
		//TODO fix projectDao.get(1) to top5
	//	request.setAttribute("projects", projectDao.get(1));
		request.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(request, response);			
	}
}
