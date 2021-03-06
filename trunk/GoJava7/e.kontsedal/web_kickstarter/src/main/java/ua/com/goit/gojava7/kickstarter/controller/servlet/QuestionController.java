package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.QuestionDbStorage;
import ua.com.goit.gojava7.kickstarter.model.Question;

@WebServlet("/question")
public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	QuestionDbStorage questionStorage;
	
	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String questionString = request.getParameter("inputQuestion");
		System.out.println(request.getHeader("referer"));
		Question question = new Question();			//
		question.setIdParentProject(1);				//DO IT NORMAL!
		question.setQuestionText(questionString);	//
		questionStorage.add(question);				//
		response.sendRedirect("./project?id=" + 1);	//
	}

}
