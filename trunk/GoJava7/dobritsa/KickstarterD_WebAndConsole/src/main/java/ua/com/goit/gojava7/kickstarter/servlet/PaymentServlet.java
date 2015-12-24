package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

	private DaoFactory daoFactory;
	private ProjectDao projectDao;
	private RewardDao rewardDao;
	private CategoryDao categoryDao;

	@Override
	public void init() {
		//MyDataSource dataType = (MyDataSource) getServletContext().getAttribute("mode");
		//daoFactory = new DaoFactory(dataType);
		daoFactory = new DaoFactory(MyDataSource.DB);
		projectDao = daoFactory.getProjectDAO();
		rewardDao = daoFactory.getRewardDAO();
		categoryDao = daoFactory.getCategoryDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int rewardId = Integer.parseInt(request.getParameter("id"));
		int amount;
		int projectId;

		if (rewardId != 0) {
			projectId = rewardDao.get(rewardId).getProjectId();
			amount = rewardDao.get(rewardId).getAmount();
			request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));
			request.setAttribute("project", projectDao.get(projectId));
			request.setAttribute("amount", amount);
			request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);

		} else {
			projectId = Integer.parseInt(request.getParameter("projectId"));

			if (validateAmount(request.getParameter("amount"))) {
				amount = Integer.parseInt(request.getParameter("amount"));
				request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));
				request.setAttribute("project", projectDao.get(projectId));
				request.setAttribute("amount", amount);
				request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "-----Wrong amount-----");
				request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));
				request.setAttribute("project", projectDao.get(projectId));
				request.setAttribute("rewards", rewardDao.getByProject(projectId));
				request.getRequestDispatcher("/WEB-INF/jsp/rewards.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean validateAmount(String amount) {
		Pattern p = Pattern.compile("^[0-9]{1,10}$");
		Matcher m = p.matcher(amount);
		return m.matches();
	}

}