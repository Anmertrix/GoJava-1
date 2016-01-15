package com.kickstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.kickstarter.dao.Impl.PaymentDaoImpl;
import com.kickstarter.dao.Impl.ProjectDaoImpl;
import com.kickstarter.dao.Impl.QuestionDaoImpl;
import com.kickstarter.model.Project;
import com.kickstarter.model.Question;

@Controller
public class projectController {

	@Autowired
	QuestionDaoImpl questionDao;

	@Autowired
	ProjectDaoImpl projectDao;

	@Autowired
	PaymentDaoImpl paymentDao;

	@RequestMapping("/projectsOfCategory")// FIXME /list
	public ModelAndView getAllProjectsOfCategory(@RequestParam(name = "categoryId") int categoryId) {
		ModelAndView modelAndView = new ModelAndView("SelectedCategoryProjects");
		List<Project> projectList = projectDao.getAllProjectsForCategory(categoryId);
		for (Project p : projectList) {
			p.setGainedSum(paymentDao.getAll(p.getId()));
		}
		modelAndView.addObject("projectList", projectList); // FIXME
		return modelAndView;
	}

	@RequestMapping("/project")// FIXME getOne
	public ModelAndView singleProject(@RequestParam(name = "projectId") int projectId) {
		ModelAndView modelAndView = new ModelAndView("SingleProject");

		Project project = projectDao.getOneProject(projectId);
		project.setGainedSum(paymentDao.getAll(projectId));
		List<Question> list = questionDao.getProjectQuestions(projectId);// FIXME

		modelAndView.addObject("project", project);
		modelAndView.addObject("questions", list);

		return modelAndView;
	}

}
