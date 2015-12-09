package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {

	private DaoFactory daoFactory;
	private Project project;
	private ProjectDao projectDao;
	private QuestionDao questionDao;
	private RewardDao rewardDao;

	@Override
	public void init() throws ServletException {		
		MyDataSource dataType = (MyDataSource) getServletContext().getAttribute("mode");
		daoFactory = new DaoFactory(dataType);
		questionDao = daoFactory.getQuestionDAO();
		rewardDao = daoFactory.getRewardDAO();
		projectDao = daoFactory.getProjectDAO();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int projectId = Integer.parseInt(request.getParameter("id"));	
		
		request.setAttribute("project", projectDao.get(projectId));

		//List<Question> questions = new ArrayList<>();		
		
		request.setAttribute("questions", questionDao.getByProject(projectId));

		//stringBuilder.append("<form action=\"question\"  method=\"post\">");
		//stringBuilder.append("</br></br>Ask a question:<br>");
		//stringBuilder.append(" <input type=\"text\" name=\"question\">");
		//stringBuilder.append(" <input type=\"hidden\" name=\"projectId\" value =" + "\"" + projectId + "\"/>");
		//stringBuilder.append("<input type=\"submit\" value=\"Submit\">");
		//stringBuilder.append("</form>");

		request.getRequestDispatcher("/WEB-INF/jsp/project.jsp").forward(request, response);			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
