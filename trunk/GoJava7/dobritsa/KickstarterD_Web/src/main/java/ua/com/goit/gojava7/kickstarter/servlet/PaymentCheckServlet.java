package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.config.Validator;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@WebServlet("/paymentCheck")
public class PaymentCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int amount = Integer.parseInt(request.getParameter("amount"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));
		request.setAttribute("project", projectDao.get(projectId));
		request.setAttribute("amount", amount);

		//if (validateName(request.getParameter("name")) & validateCard(request.getParameter("card"))) {
		if (Validator.validateName(request.getParameter("name")) & Validator.validateCard(request.getParameter("card"))) {
			String name = request.getParameter("name");
			String card = request.getParameter("card");

			int pledgedOld = projectDao.get(projectId).getPledged();
			projectDao.updatePledged(projectDao.get(projectId), amount);
			int pledgedNew = projectDao.get(projectId).getPledged();			
			
			request.setAttribute("name", name);		
			request.setAttribute("pledgedOld", pledgedOld);
			request.setAttribute("pledgedNew", pledgedNew);	
			request.getRequestDispatcher("/WEB-INF/jsp/paymentOk.jsp").forward(request, response);

		} else {			
			request.setAttribute("message", "-----Wrong data-----");			
			request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);		
		}		
	}

	//public boolean validateCard(String card) {
	//	Pattern p = Pattern.compile("^[0-9]{16,16}$");
	//	Matcher m = p.matcher(card);
	//	return m.matches();
	//}

	//public boolean validateName(String name) {
	//	Pattern p = Pattern.compile("^[a-zA-Z][a-z]{2,20}$");
	//	Matcher m = p.matcher(name);
	//	return m.matches();
	//}

	//public boolean validateAmount(int amount) {
	//	if (amount > 0)
	//		return true;
	//	else
	//		return false;
	//}
	
	//TODO check, controler, annotations, string in init
}