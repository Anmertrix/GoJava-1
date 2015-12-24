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
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDbDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDbDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDbDao;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProjectServlet.class);	 
	
	@Autowired
	private ProjectDbDao projectDao;
	
	@Autowired
	private QuestionDbDao questionDao;
	
	@Autowired
	private CategoryDbDao categoryDao;

	@Override
	public void init() throws ServletException {
		log.info("Starting spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.info("Ended spring autowiring...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.info("doGet()...");		
		int projectId = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));	
		request.setAttribute("project", projectDao.get(projectId));
		request.setAttribute("questions", questionDao.getByProject(projectId));
		request.getRequestDispatcher("/WEB-INF/jsp/project.jsp").forward(request, response);
	}	
}