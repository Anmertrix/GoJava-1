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

import ua.com.goit.gojava7.kickstarter.dao.QuestionDbDao;
import ua.com.goit.gojava7.kickstarter.models.Question;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(QuestionServlet.class);	 
	
	@Autowired
	private QuestionDbDao questionDao;

	@Override
	public void init() {
		log.info("Starting spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);	
		log.info("Ended spring autowiring...");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.info("doPost()...");		
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		String textQuestin = request.getParameter("question");

		if (!request.getParameter("question").isEmpty()) {
			Question question = new Question();
			question.setQuestion(textQuestin);
			question.setProjectId(projectId);
			questionDao.add(question);
		}
		response.sendRedirect("project?id=" + projectId);
	}
	
}